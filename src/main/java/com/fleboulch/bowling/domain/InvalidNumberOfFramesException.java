package com.fleboulch.bowling.domain;

public class InvalidNumberOfFramesException extends RuntimeException {

    public InvalidNumberOfFramesException() {
        super("The number of frames is invalid. It should be 10");
    }
}
