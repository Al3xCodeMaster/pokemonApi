package pokemonApi.pokemonDemo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pokemonApi.pokemonDemo.adapter.pokemonDto.Error;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static String printFormat(String e){
        return e.substring(e.toString().indexOf(":")+1).trim().replace("\"","");
    }

    @ExceptionHandler(ApiExternalNotFound.class)
    public ResponseEntity<Error> generateNotFoundException(ApiExternalNotFound ex) {
        Error errorDTO = new Error();
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<>(errorDTO,ex.getStatus());
    }

    @ExceptionHandler(ApiExternalError.class)
    public ResponseEntity<Error> generateExternalException(ApiExternalError ex) {
        Error errorDTO = new Error();
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<>(errorDTO,ex.getStatus());
    }

}
