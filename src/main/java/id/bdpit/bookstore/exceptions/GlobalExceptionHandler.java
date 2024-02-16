package id.bdpit.bookstore.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import id.bdpit.bookstore.payloads.ResponseError;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> globalEx(Exception e) {
        log.info("Global exception handler invoked!", e.getMessage());
        ResponseError responseError = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
        return ResponseEntity.status(responseError.getStatus()).body(responseError);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<?> nullEx(NoSuchElementException e) {
        log.info("Null exception invoked!", e.getMessage());
        ResponseError resError = new ResponseError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(),
                e.getMessage());
        return ResponseEntity.status(resError.getStatus()).body(resError);
    }
}
