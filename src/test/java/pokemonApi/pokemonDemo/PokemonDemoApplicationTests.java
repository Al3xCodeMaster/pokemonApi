package pokemonApi.pokemonDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ApiResponse;
import pokemonApi.pokemonDemo.domain.model.*;
import pokemonApi.pokemonDemo.port.outbound.PokemonRepository;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PokemonDemoApplicationTests {

	@Autowired
	PokemonRepository repository;

	@Test
	public void getAllPokemonsTest(){

		ApiResponse result = repository.getApiResponse(20, 20);
		String expectedNext = "https://pokeapi.co/api/v2/pokemon?offset=40&limit=20";
		String expectedPrevious = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=20";
		assertTrue(result.getResults().size() == 20 &&
				expectedNext.equals(result.getNext()) &&
				expectedPrevious.equals(result.getPrevious()));
	}

	@Test
	public void getPokemonBasicInfoTest(){

		Pokemon result = repository.getPokemonBasicInfo("https://pokeapi.co/api/v2/pokemon/74/");

		assertTrue(result.getName().equals("geodude") &&
				200 == result.getWeight());
	}

	@Test
	public void PokemonApiChainEvolutionTest(){
		//Evolution chain test: https://pokeapi.co/api/v2/evolution-chain/3 --> especie squirtle id:7
		PokemonEvolution result = repository.getEvolution("https://pokeapi.co/api/v2/pokemon-species/7/");

		String basicForm = "squirtle";
		String evolution1 = "wartortle";
		String evolution2 = "blastoise";

		assertTrue(basicForm.equals(result.getSpecies().getName()) &&
				evolution1.equals(result.getEvolvesTo().get(0).getSpecies().getName()) &&
				evolution2.equals(result.getEvolvesTo().get(0).getEvolvesTo().get(0).getSpecies().getName()));
	}

	@Test
	public void getDescriptionInSpanishTest(){
		ArrayList<PokemonDescription> result = repository.getDescription(65,6);
		String description = "Likes to run";
		assertTrue(description.equals(result.get(7).getDescription()));
	}

}
