package pokemonApi.pokemonDemo.adapter.pokemonDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pokemonApi.pokemonDemo.domain.model.PokemonEvolution;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonChain {
    private PokemonEvolution chain;

    public PokemonChain(){
        super();
    }

    public PokemonChain(PokemonEvolution chain) {
        this.chain = chain;
    }

    public PokemonEvolution getChain() {
        return chain;
    }

    public void setChain(PokemonEvolution chain) {
        this.chain = chain;
    }
}
