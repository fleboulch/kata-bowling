package com.fleboulch.bowling.domain;

public class UnknownFrameIndexException extends RuntimeException {

    public UnknownFrameIndexException(int index) {
        super(String.format("The index '%s' is unknown", index));
    }
}
