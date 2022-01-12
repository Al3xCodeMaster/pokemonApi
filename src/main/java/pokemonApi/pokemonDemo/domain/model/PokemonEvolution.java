package pokemonApi.pokemonDemo.domain.model;

import java.util.ArrayList;

public class PokemonEvolution {
    private boolean isBaby;
    private NamedApiResource specie;
    private ArrayList<PokemonEvolution> evolvesTo;

    public PokemonEvolution() {
        super();
    }

    public PokemonEvolution(boolean isBaby, NamedApiResource specie, ArrayList<PokemonEvolution> evolvesTo) {
        this.isBaby = isBaby;
        this.specie = specie;
        this.evolvesTo = evolvesTo;
    }

    public boolean isBaby() {
        return isBaby;
    }

    public NamedApiResource getSpecie() {
        return specie;
    }

    public ArrayList<PokemonEvolution> getEvolvesTo() {
        return evolvesTo;
    }
}
