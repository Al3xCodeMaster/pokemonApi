package pokemonApi.pokemonDemo.domain.model;

public class PokemonAbility {
    private boolean isHidden;
    private int slot;

    public PokemonAbility(){
        super();
    }

    public PokemonAbility(boolean isHidden, int slot) {
        this.isHidden = isHidden;
        this.slot = slot;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getSlot() {
        return slot;
    }
}
