package pokemonApi.pokemonDemo.port.outbound;

import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResPokemon;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResponse;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonEvolution;


public interface PokemonRepository {
    ApiResponse getApiResponse(int limit, int offset);
    Pokemon getPokemonBasicInfo(String url);
    ApiResPokemon getApiResPokemon(int id);
    PokemonEvolution getEvolution(String url);
}
