package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private static final int NB_FRAMES = 10;
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

    private List<Frame> buildScoreFrame(int first, int second) {
        List<Frame> frames = new ArrayList<>();
        for (int frameNumber = 0; frameNumber < NB_FRAMES; frameNumber++) {
            frames.add(new Frame(first, second));
        }
        return frames;
    }

}
