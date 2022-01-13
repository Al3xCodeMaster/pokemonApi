package pokemonApi.pokemonDemo.domain.model;

public class PokemonStat {
    private int baseStat;
    private int effort;
    private NamedApiResource stat;

    public PokemonStat(){
        super();
    }

    public PokemonStat(int baseStat, int effort, NamedApiResource stat) {
        this.baseStat = baseStat;
        this.effort = effort;
        this.stat = stat;
    }

    public int getBaseStat() {
        return baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public NamedApiResource getStat() {
        return stat;
    }
}
