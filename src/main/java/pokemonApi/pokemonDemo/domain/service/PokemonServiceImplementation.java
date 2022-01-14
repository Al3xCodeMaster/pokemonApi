package pokemonApi.pokemonDemo.domain.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Service;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResPokemon;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResponse;
import pokemonApi.pokemonDemo.domain.model.NamedApiResource;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonEvolution;
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
    Logger logger;
    @Autowired
    private PokemonRepository pokemonRepository;
    private final AsyncFetch pool = new AsyncFetch();
    @Autowired
    private AsyncTaskExecutor executor;

    @Override
    public PokemonList getAllPokemons(int limit, int offset) {
        ApiResponse result = pokemonRepository.getApiResponse(limit,offset);
        String next = result.getNext();
        String previous = result.getPrevious();
        if(next!=null){
            result.setNext(next.substring(next.lastIndexOf("?")+ 1));
        }
        if(previous!=null){
            result.setPrevious(previous.substring(previous.lastIndexOf("?")+ 1));
        }
        PokemonList list = new PokemonList(result.getCount(),result.getNext(),result.getPrevious());
            ArrayList<Pokemon> pokemonList = pool.executeAsyncCalls(result.getResults());
            list.setResults(pokemonList);
            return list;
    }

    @Override
    public Pokemon getPokemon(int id) {
        ApiResPokemon result = pokemonRepository.getApiResPokemon(id);
        return new Pokemon(result.getId(),result.getName(),
                result.getSprites().getOther().getOfficialArtWork().getFrontDefault(),
                result.getWeight(),result.getAbilities(),result.getTypes(),null,
                getPokemonEvolution(result.getSpecies().getUrl()));
    }

    private PokemonEvolution getPokemonEvolution(String urlSpecie){
        return pokemonRepository.getEvolution(urlSpecie);
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
                            logger.error(e.toString());
                            throw new ApiExternalError("Internal Server Error: Trying to fetch all resources failed");
                        }
                    })
                    .collect(Collectors.toList());

            return new ArrayList<>(results);
        }

    }

}
