package pokemonApi.pokemonDemo.adapter.pokemonDto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PokemonSpritesApi {
    @JsonAlias("front_shiny")
    private String frontShiny;
    @JsonAlias("front_default")
    private String frontDefault;
    private ApiOther other;

    public PokemonSpritesApi(){
        super();
    }

    public PokemonSpritesApi(String frontShiny, String frontDefault, ApiOther other){
        this.frontShiny = frontShiny;
        this.frontDefault = frontDefault;
        this.other = other;
    }


    public void setFrontShiny(String value){
        this.frontShiny = value;
    }

    public void setFrontDefault(String value){
        this.frontDefault = value;
    }

    public void setOther(ApiOther value){
        this.other = value;
    }

    public String getFrontShiny(){
        return this.frontShiny;
    }
    public String getFrontDefault(){
        return this.frontDefault;
    }

    public ApiOther getOther(){
        return this.other;
    }
}
