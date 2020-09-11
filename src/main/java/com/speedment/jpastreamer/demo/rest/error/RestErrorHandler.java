package com.speedment.jpastreamer.demo.rest.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.speedment.jpastreamer.demo.exception.ActorNotFoundException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(ActorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handler(ActorNotFoundException e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @Getter
    private static final class ExceptionResponse {
        private final HttpStatus status;
        private final String message;

        @JsonCreator
        private ExceptionResponse(
            @JsonProperty("status") final HttpStatus status,
            @JsonProperty("message") final String message
        ) {
            this.status = status;
            this.message = message;
        }
    }
}
