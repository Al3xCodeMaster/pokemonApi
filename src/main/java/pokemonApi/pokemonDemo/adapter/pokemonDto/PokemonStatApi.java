package pokemonApi.pokemonDemo.adapter.pokemonDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import pokemonApi.pokemonDemo.domain.model.NamedApiResource;

public class PokemonStatApi {
    @JsonAlias("base_stat")
    private int baseStat;
    private int effort;
    private NamedApiResource stat;

    public PokemonStatApi(){
        super();
    }

    public PokemonStatApi(int baseStat, int effort, NamedApiResource stat) {
        this.baseStat = baseStat;
        this.effort = effort;
        this.stat = stat;
    }

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public NamedApiResource getStat() {
        return stat;
    }

    public void setStat(NamedApiResource stat) {
        this.stat = stat;
    }
}
