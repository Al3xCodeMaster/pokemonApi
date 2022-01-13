package pokemonApi.pokemonDemo.adapter.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pokemonApi.pokemonDemo.domain.model.PokemonList;
import pokemonApi.pokemonDemo.port.inbound.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    @Cacheable(value="pokemons")
    public PokemonList getAllPokemons(@RequestParam(required = false) int limit, @RequestParam(required = false) int offset){
        return pokemonService.getAllPokemons(limit, offset);
    }
}
