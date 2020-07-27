package com.fleboulch.bowling.domain;

public class Game {

    private int score;

    public int run(int[] framesScore) {
        for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
            score += scorePerFrame(framesScore[frameNumber]);
        }
        return score;
    }

    private int scorePerFrame(int nbPinHit) {
        return nbPinHit;
    }
}
