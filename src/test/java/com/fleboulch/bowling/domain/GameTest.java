package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void when_player_hits_no_pin_his_score_his_zero() {
        int score = game.run(buildScoreFrame(0, 0));

        assertThat(score).isZero();
    }

    @Test
    void when_player_hits_1_pin_per_frame_his_score_his_ten() {
        int score = game.run(buildScoreFrame(1, 0));

        assertThat(score).isEqualTo(10);
    }

    @Test
    void when_player_do_one_spare_score_should_be_correct() {

    }

    private Frame[] buildScoreFrame(int first, int second) {
        Frame[] result = new Frame[10];
        for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
            result[frameNumber] = new Frame(first, second);
        }
        return result;
    }

}
