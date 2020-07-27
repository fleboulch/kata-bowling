package com.fleboulch.bowling.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Frames {

    private static final int VALID_NUMBER_OF_FRAMES = 10;
    private final List<Frame> frames;

    public Frames(List<Frame> frames) {
        this.frames = frames;
        checkValidNumberOfFrames();
    }

    private void checkValidNumberOfFrames() {
        if (frames.size() != VALID_NUMBER_OF_FRAMES) {
            throw new InvalidNumberOfFramesException();
        }
    }

    public Frame getFrameByIndex(int index) {
        if (index < 0 || index >= VALID_NUMBER_OF_FRAMES) {
            throw new UnknownFrameIndexException(index);
        }
        return frames.get(index);
    }
}
