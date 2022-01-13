package pokemonApi.pokemonDemo.port.outbound;

import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResponse;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonList;

import java.util.ArrayList;

public interface PokemonRepository {
    ApiResponse getApiResponse(int limit, int offset);
    Pokemon getPokemonBasicInfo(String url);
    Pokemon getPokemon(int id);
}
