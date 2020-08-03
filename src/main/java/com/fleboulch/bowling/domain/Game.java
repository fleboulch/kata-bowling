package com.fleboulch.bowling.domain;

public class Game {

    public int run(Frames frames) {
        return frames.getFrames().stream()
                .mapToInt(frame -> frame.score(
                        nextFrame(frames, frame.getNumber() + 1),
                        nextFrame(frames, frame.getNumber() + 2))
                )
                .sum();

    }

    private Frame nextFrame(Frames frames, int frameNumber) {
        return frames.getFrameByNumero(frameNumber)
                .orElse(Frame.gutterFrame());
    }

}
