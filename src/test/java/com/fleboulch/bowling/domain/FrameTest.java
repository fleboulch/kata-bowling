package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FrameTest {

    @Test
    void its_a_strike() {
        Frame strike = buildFrame(10, 0);

        assertThat(strike.isStrike()).isTrue();
        assertThat(strike.isSpare()).isFalse();

    }

    @ParameterizedTest
    @CsvSource(value = {
            "9, 1",
            "8, 2",
            "7, 3",
            "6, 4",
            "5, 5",
            "4, 6",
            "3, 7",
            "2, 8",
            "1, 9",
            "0, 10"
    })
    void its_a_spare(int firstThrow, int secondThrow) {
        Frame strike = buildFrame(firstThrow, secondThrow);

        assertThat(strike.isStrike()).isFalse();
        assertThat(strike.isSpare()).isTrue();

    }

    private Frame buildFrame(int firstThrow, int secondeThrow) {
        return new Frame(firstThrow, secondeThrow);
    }

}
