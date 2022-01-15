package pokemonApi.pokemonDemo.domain.model;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;

@ApiModel(description = "List of pokemons")
public class PokemonList {
    // Internal state
    private int count;
    private String next;
    private String previous;
    private ArrayList<Pokemon> results;

    public PokemonList(){
        super();
    }

    public PokemonList(int count, String next, String previous) {
        this.count = count;
        this.next = next;
        this.previous = previous;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
