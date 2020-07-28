package com.fleboulch.bowling.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
public class Frame {

    private static final int NB_PINS = 10;
    private int nbPinHitOnFirstThrow;
    private int nbPinHitOnSecondThrow;
    private int number;

    public Frame(int nbPinHitOnFirstThrow, int nbPinHitOnSecondThrow) {
        this.nbPinHitOnFirstThrow = nbPinHitOnFirstThrow;
        this.nbPinHitOnSecondThrow = nbPinHitOnSecondThrow;
    }

    public boolean isStrike() {
        return nbPinHitOnFirstThrow == NB_PINS;
    }

    public boolean isSpare() {
        return !isStrike() && (nbPinHitOnFirstThrow + nbPinHitOnSecondThrow == NB_PINS);
    }

    public int score(Frame nextFrame) {
        if (isSpare()) {
            return  nbPinHitOnFirstThrow + nbPinHitOnSecondThrow + nextFrame.nbPinHitOnFirstThrow;
        }
        return nbPinHitOnFirstThrow + nbPinHitOnSecondThrow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return number == frame.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
