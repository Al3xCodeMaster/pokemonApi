package pokemonApi.pokemonDemo.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import pokemonApi.pokemonDemo.domain.model.Pokemon;
import pokemonApi.pokemonDemo.domain.model.PokemonList;
import pokemonApi.pokemonDemo.port.inbound.PokemonService;

@RestController
@RequestMapping("/api/pokemon") // Base router path
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping
    @Cacheable(value="pokemons")
    public PokemonList getAllPokemons(@RequestParam(required = false) String limit, @RequestParam(required = false) String offset){
        //Handle the possible empty values of limit and offset
        int limitValue;
        int offsetValue;
        try{
            limitValue = Integer.parseInt(limit);
            offsetValue = Integer.parseInt(offset);
        }catch (NumberFormatException e){
            limitValue = 20;
            offsetValue = 0;
        }

        limitValue = limitValue<=0?20:limitValue;
        offsetValue = Math.max(offsetValue, 0);

        return pokemonService.getAllPokemons(limitValue, offsetValue);
    }

    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable int id) {
        return pokemonService.getPokemon(id);
    }

}
