package com.techni.demoexception.exception;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class WrongBirthDateException extends RuntimeException {
    private final LocalDate date;

    public WrongBirthDateException(LocalDate date) {
        super("Wrong date : " + date.toString());
        this.date = date;
    }
}
