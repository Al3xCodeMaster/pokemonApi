package pokemonApi.pokemonDemo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Service;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResponse;
import pokemonApi.pokemonDemo.domain.model.NamedApiResource;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonList;
import pokemonApi.pokemonDemo.exception.ApiExternalError;
import pokemonApi.pokemonDemo.port.outbound.PokemonRepository;
import pokemonApi.pokemonDemo.port.inbound.PokemonService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImplementation implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    private final AsyncFetch pool = new AsyncFetch();
    @Autowired
    private AsyncTaskExecutor executor;

    @Override
    public PokemonList getAllPokemons(int limit, int offset) {
        ApiResponse result = pokemonRepository.getApiResponse(limit,offset);
        PokemonList list = new PokemonList(result.getCount(),result.getNext(),result.getPrevious());
            ArrayList<Pokemon> pokemonList = pool.executeAsyncCalls(result.getResults());
            list.setResults(pokemonList);
            return list;
    }

    @Override
    public Pokemon getPokemon(int id) {
        return pokemonRepository.getPokemon(id);
    }

    private class AsyncFetch {

        public ArrayList<Pokemon> executeAsyncCalls(ArrayList<NamedApiResource> resources) {

            List<Future<Pokemon>> tasks = new ArrayList<>();
            for(NamedApiResource task: resources){

                tasks.add(executor.submit(() -> pokemonRepository.getPokemonBasicInfo(task.getUrl())));
            };
            // Next collect results from Future
            List<Pokemon> results = tasks.stream()
                    .map(pokemonFuture -> {
                        try {
                            return pokemonFuture.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new ApiExternalError(e.toString());
                        }
                    })
                    .collect(Collectors.toList());

            return new ArrayList<>(results);
        }

    }

}
