package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void when_player_hits_no_pin_his_score_his_zero() {
        int score = game.run(buildScoreFrame(0));

        assertThat(score).isZero();
    }

    @Test
    void when_player_hits_1_pin_per_frame_his_score_his_ten() {
        int score = game.run(buildScoreFrame(1));

        assertThat(score).isEqualTo(10);
    }

    @Test
    void when_player_hits_multiple_pin_per_frame_his_score_his_the_sum() {
        int score = game.run(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        assertThat(score).isEqualTo(55);
    }

    private int[] buildScoreFrame(int i) {
        int[] result = new int[10];
        for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
            result[frameNumber] = i;
        }
        return result;
    }

}
