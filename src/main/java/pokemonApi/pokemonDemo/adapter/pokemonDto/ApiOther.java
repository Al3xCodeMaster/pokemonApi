package pokemonApi.pokemonDemo.adapter.pokemonDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiOther {
    @JsonAlias("dream_world")
    private PokemonPhotoApi dreamWorld;
    @JsonProperty("official-artwork")
    private PokemonPhotoApi officialArtwork;


    public ApiOther(){
        super();
    }

    public ApiOther(PokemonPhotoApi dreamWorld, PokemonPhotoApi officialArtwork){
        this.dreamWorld = dreamWorld;
        this.officialArtwork = officialArtwork;
    }

    public void setDreamWorld(PokemonPhotoApi value){
        this.dreamWorld = value;
    }

    public void setOfficialArtWork(PokemonPhotoApi value){
        this.officialArtwork = value;
    }

    public PokemonPhotoApi getDreamWorld(){
        return this.dreamWorld;
    }

    public PokemonPhotoApi getOfficialArtWork(){
        return this.officialArtwork;
    }
}
