package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import resolvers.EachFrameConfig;
import resolvers.FrameConfig;
import resolvers.FramesResolver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(FramesResolver.class)
class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void when_player_hits_no_pin_his_score_his_zero(Frames frames) {
        int score = game.run(frames);

        assertThat(score).isZero();
    }

    @Test
    void when_player_hits_1_pin_per_frame_his_score_his_ten(
            @EachFrameConfig(firstBall = 1) Frames frames
    ) {
        int score = game.run(frames);

        assertThat(score).isEqualTo(10);
    }

    @Test
    void when_player_do_one_spare_and_first_ball_after_is_0_then_spare_should_have_no_effect(
            @FrameConfig(firstBall = 9, secondBall = 1) Frames framesWithOneSpareAtTheBeginning
    ) {
        int score = game.run(framesWithOneSpareAtTheBeginning);

        assertThat(score).isEqualTo(10);
    }

    @Test
    void when_player_do_one_spare_and_first_ball_after_hits_more_than_one_pin_spare_should_have_an_effect(
            @FrameConfig(firstBall = 9, secondBall = 1)
            @FrameConfig(firstBall = 2, number = 2) Frames framesWithOneSpareAtTheBeginning

    ) {
        int score = game.run(framesWithOneSpareAtTheBeginning);

        assertThat(score).isEqualTo(14);
    }

    @Test
    void when_player_do_two_spares(
            @FrameConfig(firstBall = 9, secondBall = 1)
            @FrameConfig(firstBall = 4, secondBall = 6, number = 2)
            @FrameConfig(firstBall = 2, secondBall = 2, number = 3) Frames framesWithTwoSpareAtTheBeginning
    ) {
        int score = game.run(framesWithTwoSpareAtTheBeginning);

        assertThat(score).isEqualTo(30);
    }

    @Test
    void when_player_do_one_strike(
            @FrameConfig(firstBall = 10)
            @FrameConfig(firstBall = 3, secondBall = 4, number = 2) Frames framesWithTwoSpareAtTheBeginning
    ) {
        int score = game.run(framesWithTwoSpareAtTheBeginning);

        assertThat(score).isEqualTo(24);
    }

    @Test
    void when_player_do_two_strikes(
            @FrameConfig(firstBall = 10)
            @FrameConfig(firstBall = 10, number = 2) Frames framesWithTwoSpareAtTheBeginning
    ) {
        int score = game.run(framesWithTwoSpareAtTheBeginning);

        assertThat(score).isEqualTo(30);
    }

    @Test
    void when_player_do_three_strikes_in_a_row(
            @FrameConfig(firstBall = 10)
            @FrameConfig(firstBall = 10, number = 2)
            @FrameConfig(firstBall = 10, number = 3) Frames framesWithTwoSpareAtTheBeginning
    ) {
        int score = game.run(framesWithTwoSpareAtTheBeginning);

        assertThat(score).isEqualTo(60);
    }

}
