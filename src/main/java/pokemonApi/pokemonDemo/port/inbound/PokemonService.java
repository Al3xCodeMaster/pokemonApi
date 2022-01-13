package pokemonApi.pokemonDemo.port.inbound;

import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonList;

public interface PokemonService {
    PokemonList getAllPokemons(int limit, int offset);
    Pokemon getPokemon(int id);
}
