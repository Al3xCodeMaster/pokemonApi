package pokemonApi.pokemonDemo.domain.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonEvolution {
    @JsonAlias("is_baby")
    private boolean isBaby;
    @JsonAlias("species")
    private NamedApiResource species;
    @JsonAlias("evolves_to")
    private ArrayList<PokemonEvolution> evolvesTo; //Tree like structure

    public PokemonEvolution() {
        super();
    }

    public PokemonEvolution(boolean isBaby, NamedApiResource species, ArrayList<PokemonEvolution> evolvesTo) {
        this.isBaby = isBaby;
        this.species = species;
        this.evolvesTo = evolvesTo;
    }

    public boolean isBaby() {
        return isBaby;
    }

    public void setBaby(boolean baby) {
        isBaby = baby;
    }

    public NamedApiResource getSpecies() {
        return species;
    }

    public void setSpecies(NamedApiResource species) {
        this.species = species;
    }

    public ArrayList<PokemonEvolution> getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(ArrayList<PokemonEvolution> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }
}
