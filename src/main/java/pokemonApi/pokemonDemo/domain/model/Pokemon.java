package pokemonApi.pokemonDemo.domain.model;

import java.util.ArrayList;

public class Pokemon {
    //Internal state
    private int id;
    private String name;
    private String photo;
    private int weight;

    private ArrayList<PokemonAbility> abilities;
    private ArrayList<PokemonType> types;
    private ArrayList<PokemonDescription> descriptions;
    private PokemonEvolution evolutions;

    public Pokemon() {
        super();
    }

    public Pokemon(int id, String name, String photo, int weight,
                   ArrayList<PokemonAbility> abilities,
                   ArrayList<PokemonType> types,
                   ArrayList<PokemonDescription> descriptions,
                   PokemonEvolution evolutions) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.weight = weight;
        this.abilities = abilities;
        this.types = types;
        this.descriptions = descriptions;
        this.evolutions = evolutions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAbilities(ArrayList<PokemonAbility> abilities) {
        this.abilities = abilities;
    }

    public void setTypes(ArrayList<PokemonType> types) {
        this.types = types;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public int getWeight() {
        return weight;
    }

    public ArrayList<PokemonAbility> getAbilities() {
        return abilities;
    }

    public ArrayList<PokemonType> getTypes() {
        return types;
    }

    public ArrayList<PokemonDescription> getDescriptions() {
        return descriptions;
    }

    public PokemonEvolution getEvolutions() {
        return evolutions;
    }
}
