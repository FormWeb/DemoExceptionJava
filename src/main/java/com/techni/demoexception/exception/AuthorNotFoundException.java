package com.techni.demoexception.exception;

import lombok.Getter;

@Getter
public class AuthorNotFoundException extends RuntimeException {
    private Long id;

    public AuthorNotFoundException(long id) {
        super("Cannor found author with id " + id);
        this.id = id;
    }
}
