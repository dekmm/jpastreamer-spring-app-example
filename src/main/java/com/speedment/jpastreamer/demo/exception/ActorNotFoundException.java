package com.speedment.jpastreamer.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public final class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(int id) {
        super("Actor with id '" + id + "' not found");
    }
}
