package pl.pjatk.katpop.jazs22048nbp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Void> handleServerError() {
        return ResponseEntity.status(502).build();
    }
}
