package pokemonApi.pokemonDemo.adapter.pokemonDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pokemonApi.pokemonDemo.domain.model.NamedApiResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonEvolutionChain {

    @JsonAlias("evolution_chain")
    private NamedApiResource evolutionChain;

    public PokemonEvolutionChain(){
        super();
    }

    public PokemonEvolutionChain(NamedApiResource evolutionChain) {
        this.evolutionChain = evolutionChain;
    }

    public NamedApiResource getEvolutionChain() {
        return evolutionChain;
    }

    public void setChain(NamedApiResource evolutionChain) {
        this.evolutionChain = evolutionChain;
    }
}
