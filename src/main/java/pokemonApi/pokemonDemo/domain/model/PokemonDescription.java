package pokemonApi.pokemonDemo.domain.model;

public class PokemonDescription {
    private String description;
    private NamedApiResource language;

    public PokemonDescription() {
        super();
    }

    public PokemonDescription(String description, NamedApiResource language) {
        this.description = description;
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public NamedApiResource getLanguage() {
        return language;
    }
}
