package pokemonApi.pokemonDemo.adapter.pokemonDto;

import pokemonApi.pokemonDemo.domain.model.PokemonAbility;
import pokemonApi.pokemonDemo.domain.model.PokemonDescription;
import pokemonApi.pokemonDemo.domain.model.PokemonStat;
import pokemonApi.pokemonDemo.domain.model.PokemonType;

import java.util.ArrayList;

public class ApiDetailedResponse {
    private int id;
    private int height;
    private int weight;
    private String name;
    private ArrayList<PokemonAbility> abilities;
    private ArrayList<PokemonType> types;
    private ArrayList<PokemonStat> stats;
    private PokemonSpritesApi sprites;
    private ArrayList<PokemonDescription> descriptions;

}
