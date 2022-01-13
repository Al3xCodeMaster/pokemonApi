package pokemonApi.pokemonDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ApiExternalNotFound extends RuntimeException {
    public ApiExternalNotFound(String cause) {
        super(cause);
    }
    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }
}
