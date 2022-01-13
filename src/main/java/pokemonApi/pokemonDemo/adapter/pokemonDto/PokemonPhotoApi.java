package pokemonApi.pokemonDemo.adapter.pokemonDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonPhotoApi {
    //variables
    @JsonAlias("front_default")
    private String frontDefault;

    //empty constructor
    public PokemonPhotoApi(){

    }
    //constructor
    public PokemonPhotoApi(String frontDefault){
        this.frontDefault = frontDefault;
    }

    //setters
    public void setFrontDefault(String value){
        this.frontDefault = value;
    }


    //getters
    public String getFrontDefault(){
        return frontDefault;
    }
}
