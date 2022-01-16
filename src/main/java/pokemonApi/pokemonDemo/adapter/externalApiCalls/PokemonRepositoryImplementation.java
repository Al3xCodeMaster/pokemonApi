package pokemonApi.pokemonDemo.adapter.externalApiCalls;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pokemonApi.pokemonDemo.adapter.pokemonDto.*;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonDescription;
import pokemonApi.pokemonDemo.domain.model.PokemonEvolution;
import pokemonApi.pokemonDemo.exception.ApiExternalError;
import pokemonApi.pokemonDemo.exception.ApiExternalNotFound;
import pokemonApi.pokemonDemo.exception.GlobalExceptionHandler;
import pokemonApi.pokemonDemo.port.outbound.PokemonRepository;

import java.util.ArrayList;

// Adapter implementation (from outbound port contract interface)
@Repository
public class PokemonRepositoryImplementation implements PokemonRepository {

    // Dependency injection
    @Autowired
    Logger logger;
    private static final String baseUrl = "https://pokeapi.co/api/v2"; //Can be an Env Var
    @Autowired
    RestTemplate restTemplate; // Client for Mapping json response from external api

    @Override
    public ApiResponse getApiResponse(int limit, int offset) {
        String url = String.format("%s%s%s%d%s%d", baseUrl, "/pokemon?","limit=",limit,"&offset=",offset);

        try{
            return restTemplate.getForObject(url, ApiResponse.class);
        }catch (HttpClientErrorException e){
            throw new ApiExternalNotFound(GlobalExceptionHandler.printFormat(e.toString())); //Print format helper function
        }catch (Exception e) {
            logger.error(e.toString()); // Troubleshooting
            throw new ApiExternalError("I/O Internal Server Error: Get resources failed");
        }
    }

    @Override
    public Pokemon getPokemonBasicInfo(String url) {

        try{
            Pokemon pokemon = new Pokemon();
            ApiBasicInfoResponse result = restTemplate.getForObject(url, ApiBasicInfoResponse.class);
            pokemon.setId(result.getId());
            pokemon.setWeight(result.getWeight());
            pokemon.setName(result.getName());
            pokemon.setPhoto(result.getSprites().getOther().getOfficialArtWork().getFrontDefault());
            pokemon.setAbilities(result.getAbilities());
            pokemon.setTypes(result.getTypes());

            return pokemon;

        }catch (HttpClientErrorException e){
            throw new ApiExternalNotFound(e.toString());
        }catch (Exception e) {
            logger.error(e.toString());
            throw new ApiExternalError("Internal server error: Get pokemon basic info failed");
        }
    }

    @Override
    public ApiResPokemon getApiResPokemon(int id) {
        String url = String.format("%s%s%d%s", baseUrl, "/pokemon/",id,"/");
        try{
            return restTemplate.getForObject(url, ApiResPokemon.class);
        }catch (HttpClientErrorException e){
            throw new ApiExternalNotFound(GlobalExceptionHandler.printFormat(e.toString()));
        }catch (Exception e){
            logger.error(e.toString());
            throw new ApiExternalError("Internal server error: Get Pokemon info failed");
        }
    }

    @Override
    public PokemonEvolution getEvolution(String url) {

        try{
            PokemonEvolutionChain evolutionChain = restTemplate.getForObject(url, PokemonEvolutionChain.class);
            PokemonChain chain = restTemplate.getForObject(evolutionChain.getEvolutionChain().getUrl(), PokemonChain.class);
            return chain.getChain();
        }catch (HttpClientErrorException e){
            throw new ApiExternalNotFound(GlobalExceptionHandler.printFormat(e.toString()));
        }catch (Exception e){
            logger.error(e.toString());
            throw new ApiExternalError("Internal server error: Get evolution failed");
        }
    }

    /*. Method summary:
        The operation performed below correspond to view the list of characteristics
        in the bulbapedia as array of 30 positions start with "loves to eat" (#1) and with "Quick to flee" the last (#30).
    */
    public ArrayList<PokemonDescription> getDescription(int max, int statePos){
        int idCharacteristic = (((max % 5)* statePos)%30)+6;
        String url = String.format("%s%s%d%s",baseUrl,"/characteristic/",idCharacteristic,"/");
        try{
            PokemonCharacteristic characteristic = restTemplate.getForObject(url,PokemonCharacteristic.class);
            return characteristic.getDescriptions();
        }catch (HttpClientErrorException e){
            throw new ApiExternalNotFound(GlobalExceptionHandler.printFormat(e.toString()));
        }catch (Exception e){
            logger.error(e.toString());
            throw new ApiExternalError("Internal server error: Get characteristic failed");
        }
    }
}
