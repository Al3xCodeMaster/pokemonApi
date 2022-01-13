package pokemonApi.pokemonDemo.domain.model;

public class PokemonAbility {
    private boolean isHidden;
    private int slot;
    private NamedApiResource ability;

    public PokemonAbility(){
        super();
    }

    public PokemonAbility(boolean isHidden, int slot, NamedApiResource ability) {
        this.isHidden = isHidden;
        this.slot = slot;
        this.ability = ability;
    }

    public NamedApiResource getAbility() {
        return ability;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getSlot() {
        return slot;
    }
}
