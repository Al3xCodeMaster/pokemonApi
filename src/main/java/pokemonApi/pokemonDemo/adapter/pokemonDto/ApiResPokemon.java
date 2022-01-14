package pokemonApi.pokemonDemo.adapter.pokemonDto;

import pokemonApi.pokemonDemo.domain.model.*;

import java.util.ArrayList;

public class ApiResPokemon {
    private int id;
    private int height;
    private int weight;
    private String name;
    private ArrayList<PokemonAbility> abilities;
    private ArrayList<PokemonType> types;
    private PokemonSpritesApi sprites;
    private NamedApiResource species;
    private ArrayList<PokemonStat> stats;

    public ApiResPokemon(){
        super();
    }

    public ApiResPokemon(int id, int height, int weight, String name,
                         ArrayList<PokemonAbility> abilities,
                         ArrayList<PokemonType> types,
                         PokemonSpritesApi sprites,
                         NamedApiResource species,
                         ArrayList<PokemonStat> stats) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.abilities = abilities;
        this.types = types;
        this.sprites = sprites;
        this.species = species;
        this.stats = stats;
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

    public void setWeight(int weight) {
        this.weight = weight;
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

    public PokemonSpritesApi getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSpritesApi sprites) {
        this.sprites = sprites;
    }

    public NamedApiResource getSpecies() {
        return species;
    }

    public void setSpecies(NamedApiResource species) {
        this.species = species;
    }

    public ArrayList<PokemonStat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<PokemonStat> stats) {
        this.stats = stats;
    }
}
