package pokemonApi.pokemonDemo.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonList;
import pokemonApi.pokemonDemo.port.inbound.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping
    @Cacheable(value="pokemons")
    public PokemonList getAllPokemons(@RequestParam(required = false) int limit, @RequestParam(required = false) int offset){
        limit = limit<=0?20:limit;
        offset = offset<0?0:offset;
        return pokemonService.getAllPokemons(limit, offset);
    }

    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable int id) {
        return pokemonService.getPokemon(id);
    }

}
