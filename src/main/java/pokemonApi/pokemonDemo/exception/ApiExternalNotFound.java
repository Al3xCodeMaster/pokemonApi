package pokemonApi.pokemonDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiExternalNotFound extends RuntimeException {
    public ApiExternalNotFound(String cause) {
        super(cause);
    }
}
