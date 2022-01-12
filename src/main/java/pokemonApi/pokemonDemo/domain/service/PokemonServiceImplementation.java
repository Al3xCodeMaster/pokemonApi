package pokemonApi.pokemonDemo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonList;
import pokemonApi.pokemonDemo.port.PokemonRepository;
import pokemonApi.pokemonDemo.port.PokemonService;

@Service
public class PokemonServiceImplementation implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public PokemonList getAllPokemons(int limit, int offset) {
        return pokemonRepository.getAllPokemons(limit,offset);
    }

    @Override
    public Pokemon getPokemon(int id) {
        return pokemonRepository.getPokemon(id);
    }
}
