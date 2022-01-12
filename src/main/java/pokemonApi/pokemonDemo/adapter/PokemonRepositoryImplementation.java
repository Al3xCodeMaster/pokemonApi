package pokemonApi.pokemonDemo.adapter;

import org.springframework.stereotype.Repository;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonList;
import pokemonApi.pokemonDemo.port.PokemonRepository;

@Repository
public class PokemonRepositoryImplementation implements PokemonRepository {

    @Override
    public PokemonList getAllPokemons(int limit, int offset) {
        //ToDo
    }

    @Override
    public Pokemon getPokemon(int id) {
        return null;
    }
}
