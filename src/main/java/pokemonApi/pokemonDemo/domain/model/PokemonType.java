package pokemonApi.pokemonDemo.domain.model;

public class PokemonType {

    private int slot;
    private NamedApiResource type;

    public PokemonType(){
        super();
    }

    public PokemonType(int slot, NamedApiResource type) {
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public NamedApiResource getType() {
        return type;
    }
}
