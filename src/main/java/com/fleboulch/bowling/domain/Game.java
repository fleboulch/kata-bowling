package com.fleboulch.bowling.domain;

public class Game {

    private int score;

    public int run(int frameScore) {
        for (int i = 1; i <= 10; i++) {
            score += scorePerFrame(frameScore);
        }
        return score;
    }

    private int scorePerFrame(int nbPinHit) {
        return nbPinHit;
    }
}
