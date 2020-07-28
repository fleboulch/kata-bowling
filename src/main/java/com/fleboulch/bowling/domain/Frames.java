package com.fleboulch.bowling.domain;

import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class Frames {

    private static final int VALID_NUMBER_OF_FRAMES = 10;
    private final List<Frame> frames;

    public Frames(List<Frame> frames) {

        this.frames = frames;
        checkValidNumberOfFrames();

        for (int cpt = 1; cpt <= VALID_NUMBER_OF_FRAMES; cpt++) {
            Frame tempFrame = frames.get(cpt - 1);
            frames.set(cpt - 1, new Frame(tempFrame.getNbPinHitOnFirstThrow(), tempFrame.getNbPinHitOnSecondThrow(), cpt));
        }

    }

    private void checkValidNumberOfFrames() {
        if (frames.size() != VALID_NUMBER_OF_FRAMES) {
            throw new InvalidNumberOfFramesException();
        }
    }

    public Frame getFrameByNumero(int frameNumber) {
        if (frameNumber < 1 || frameNumber > VALID_NUMBER_OF_FRAMES) {
            throw new UnknownFrameIndexException(frameNumber);
        }
        return frames.get(frameNumber - 1);
    }

    public Optional<Frame> next(Frame frame) {
        if (isLast(frame)) {
            return Optional.empty();
        }
        return Optional.of(getFrameByNumero(frame.getNumber() +1));
    }

    private boolean isLast(Frame frame) {
        return frame.getNumber() == VALID_NUMBER_OF_FRAMES;
    }
}
