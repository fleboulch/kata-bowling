package com.fleboulch.bowling.domain;

public class Game {

    public int run(Frames frames) {
        return frames.getFrames().stream()
                .mapToInt(frame -> frame.score(frames.getFrameByIndex(1)))
                .sum();

    }

}
