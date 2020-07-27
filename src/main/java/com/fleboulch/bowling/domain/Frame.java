package com.fleboulch.bowling.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Frame {

    private static final int NB_PINS = 10;
    private int nbPinHitOnFirstThrow;
    private int nbPinHitOnSecondThrow;

    public boolean isStrike() {
        return nbPinHitOnFirstThrow == 10;
    }

    public boolean isSpare() {
        return !isStrike() && (nbPinHitOnFirstThrow + nbPinHitOnSecondThrow == NB_PINS);
    }

    public int score() {
        return nbPinHitOnFirstThrow + nbPinHitOnSecondThrow;
    }
}
