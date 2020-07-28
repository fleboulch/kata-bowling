package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FrameTest {

    private static final Frame SPARE_FRAME = new Frame(8, 2);

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

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "1, 8, 9",
            "3, 4, 7"
    })
    void when_simple_frame_score_is_a_sum(int firstThrow, int secondThrow, int expectedScore) {
        Frame frame = buildFrame(firstThrow, secondThrow);
        Frame nextFrame = buildFrame(3, 4);
        assertThat(frame.score(nextFrame)).isEqualTo(expectedScore);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 11",
            "3, 13",
            "8, 18"
    })
    void when_frame_is_a_spare_next_first_ball_is_counted_twice(int nextFirstThrow, int expectedScore) {
        Frame nextFrame = buildFrame(nextFirstThrow, 4);
        assertThat(SPARE_FRAME.score(nextFrame)).isEqualTo(expectedScore);
    }

    private Frame buildFrame(int firstThrow, int secondThrow) {
        return new Frame(firstThrow, secondThrow);
    }

}
