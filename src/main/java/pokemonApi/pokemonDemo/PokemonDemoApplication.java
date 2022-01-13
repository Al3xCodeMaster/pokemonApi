package pokemonApi.pokemonDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PokemonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonDemoApplication.class, args);
	}

}
