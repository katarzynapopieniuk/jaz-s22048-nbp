package pl.pjatk.katpop.jazs22048nbp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> handleServerError(Exception e) {
        return ResponseEntity.status(502).body("Problem with connection to server, message: " + e.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleBadRequestError(Exception e) {
        return ResponseEntity.status(400).body("Bad request, message: " + e.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleClientError(Exception e) {
        return ResponseEntity.status(400).body("Problem with request, message: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(400).body("Unexpected exception happened, message: " + e.getMessage());
    }
}
