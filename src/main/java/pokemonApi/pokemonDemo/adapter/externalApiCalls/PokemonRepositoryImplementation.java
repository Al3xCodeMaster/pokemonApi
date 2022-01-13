package pokemonApi.pokemonDemo.adapter.externalApiCalls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiBasicInfoResponse;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResponse;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.exception.ApiExternalError;
import pokemonApi.pokemonDemo.exception.ApiExternalNotFound;
import pokemonApi.pokemonDemo.port.outbound.PokemonRepository;


@Repository
public class PokemonRepositoryImplementation implements PokemonRepository {

    @Value("${spring.custom.url}")
    String baseUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ApiResponse getApiResponse(int limit, int offset) {
        String url = String.format("%s%s%s%d%s%d", baseUrl, "/pokemon?","limit=",limit,"&offset=",offset);

        try{
            ApiResponse result = restTemplate.getForObject(url, ApiResponse.class);
            return result;
        }catch (HttpClientErrorException e){
            System.out.println(e.toString());
            throw new ApiExternalNotFound(e.toString());
        }catch (Exception e) {
            System.out.println(e.toString());
            throw new ApiExternalError(e.toString());
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
            throw new ApiExternalError(e.toString());
        }
    }

    @Override
    public Pokemon getPokemon(int id) {
        return null;
    }

}
