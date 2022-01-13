package pokemonApi.pokemonDemo.adapter.pokemonDto;

import pokemonApi.pokemonDemo.domain.model.PokemonAbility;
import pokemonApi.pokemonDemo.domain.model.PokemonStat;
import pokemonApi.pokemonDemo.domain.model.PokemonType;

import java.util.ArrayList;

public class ApiBasicInfoResponse {

    private int id;
    private int height;
    private int weight;
    private String name;
    private ArrayList<PokemonAbility> abilities;
    private ArrayList<PokemonType> types;
    private ArrayList<PokemonStat> stats;
    private PokemonSpritesApi sprites;

    public ApiBasicInfoResponse(){
        super();
    }

    public ApiBasicInfoResponse(int id, int height, int weight, String name,
                                ArrayList<PokemonAbility> abilities,
                                ArrayList<PokemonType> types,
                                ArrayList<PokemonStat> stats,
                                PokemonSpritesApi sprites) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.abilities = abilities;
        this.types = types;
        this.stats = stats;
        this.sprites = sprites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int wight) {
        this.weight = wight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PokemonAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<PokemonAbility> abilities) {
        this.abilities = abilities;
    }

    public ArrayList<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<PokemonType> types) {
        this.types = types;
    }

    public ArrayList<PokemonStat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<PokemonStat> stats) {
        this.stats = stats;
    }

    public PokemonSpritesApi getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSpritesApi sprites) {
        this.sprites = sprites;
    }
}
