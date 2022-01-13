package pokemonApi.pokemonDemo.exception;

import org.springframework.http.HttpStatus;

public class ApiExternalError extends RuntimeException {
    public ApiExternalError(String message) {
        super(message);
    }
    public HttpStatus getStatus(){
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
