package de.mytoys.reader.exception;

import de.mytoys.reader.exception.custom.ErrorResponse;
import de.mytoys.reader.exception.custom.FileParserError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@Slf4j
@ControllerAdvice
public class ProductReaderExceptionHandler {

    @ExceptionHandler(FileParserError.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(FileParserError ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(),
                Instant.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
