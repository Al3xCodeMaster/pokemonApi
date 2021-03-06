package pokemonApi.pokemonDemo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class NamedApiResource {

    private String name;
    private String url;

    public NamedApiResource() {
        super();
    }

    public NamedApiResource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
