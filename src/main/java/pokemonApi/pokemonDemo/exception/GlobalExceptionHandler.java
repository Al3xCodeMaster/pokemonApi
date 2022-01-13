package pokemonApi.pokemonDemo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pokemonApi.pokemonDemo.adapter.pokemonDto.ErrorDTO;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiExternalNotFound.class)
    public ResponseEntity<ErrorDTO> generateNotFoundException(ApiExternalNotFound ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<>(errorDTO,ex.getStatus());
    }

    @ExceptionHandler(ApiExternalError.class)
    public ResponseEntity<ErrorDTO> generateExternalException(ApiExternalError ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<>(errorDTO,ex.getStatus());
    }

}
