package com.fleboulch.bowling.domain;

import java.util.List;

public class Game {

    public int run(List<Frame> frames) {
        return frames.stream()
                .mapToInt(Frame::score)
                .sum();

    }

}
