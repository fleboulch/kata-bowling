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

    public static Frame gutterFrame() {
        return new Frame(0, 0);
    }

    public boolean isStrike() {
        return nbPinHitOnFirstThrow == NB_PINS;
    }

    public boolean isSpare() {
        return !isStrike() && (sumTwoBalls(this) == NB_PINS);
    }

    public int score(Frame nextFrame, Frame secondNextFrame) {
        int scoreCurrentFrame = sumTwoBalls(this);
        if (isSpare()) {
            return scoreCurrentFrame + nextFrame.nbPinHitOnFirstThrow;
        } else if (isStrike()) {
            if (nextFrame.isStrike()) {
                return scoreCurrentFrame + sumTwoBalls(nextFrame) + secondNextFrame.nbPinHitOnFirstThrow;
            }
            return scoreCurrentFrame + sumTwoBalls(nextFrame);
        }
        return scoreCurrentFrame;
    }

    private int sumTwoBalls(Frame frame) {
        return frame.nbPinHitOnFirstThrow + frame.nbPinHitOnSecondThrow;
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
