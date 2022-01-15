package pokemonApi.pokemonDemo.adapter.pokemonDto;

import pokemonApi.pokemonDemo.domain.model.PokemonDescription;

import java.util.ArrayList;

public class PokemonCharacteristic {
    private ArrayList<PokemonDescription> descriptions;

    public PokemonCharacteristic(){
        super();
    }

    public PokemonCharacteristic(ArrayList<PokemonDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public ArrayList<PokemonDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(ArrayList<PokemonDescription> descriptions) {
        this.descriptions = descriptions;
    }
}
