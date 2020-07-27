package com.fleboulch.bowling.domain;

public class Game {

    private int score;

    public int run(Frame[] frames) {
        for (Frame frame : frames) {
            score += frame.score();
        }
        return score;
    }

}
