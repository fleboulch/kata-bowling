package com.fleboulch.bowling.domain;

public class Game {

    public int run(Frames frames) {
        return frames.getFrames().stream()
                .mapToInt(frame -> frame.score(nextFrame(frames, frame)))
                .sum();

    }

    private Frame nextFrame(Frames frames, Frame frame) {
        return frames.getFrameByNumero(frame.getNumber() + 1)
                .orElse(new Frame(0, 0, 0)); // TODO: TO FIX
    }

}
