package com.fleboulch.bowling.domain;

public class Game {

    public int run(Frames frames) {
        return frames.getFrames().stream()
                .mapToInt(Frame::score)
                .sum();

    }

}
