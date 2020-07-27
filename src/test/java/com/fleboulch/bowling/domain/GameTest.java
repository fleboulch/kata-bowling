package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int score = game.run(new Frames(buildScoreFrame(new Frame(0, 0))));

        assertThat(score).isZero();
    }

    @Test
    void when_player_hits_1_pin_per_frame_his_score_his_ten() {
        int score = game.run(new Frames(buildScoreFrame(new Frame(1, 0))));

        assertThat(score).isEqualTo(10);
    }

    @Test
    void when_player_do_one_spare_and_first_ball_after_0_spare_should_have_no_effect() {
        Frame zeroFrame = new Frame(0, 0);
        Frame spare = new Frame(9, 1);
        Frames framesWithOneSpareAtTheBeginning = buildScoreWithOneSpareAtTheBeginning(spare, zeroFrame);

        int score = game.run(framesWithOneSpareAtTheBeginning);

        assertThat(score).isEqualTo(10);
    }

    private Frames buildScoreWithOneSpareAtTheBeginning(Frame spare, Frame otherFrames) {
        List<Frame> frames = buildScoreFrame(otherFrames);
        frames.add(0, spare);
        frames.remove(10);
        return new Frames(frames);
    }

    private List<Frame> buildScoreFrame(Frame frame) {
        List<Frame> frames = new ArrayList<>();
        for (int frameNumber = 0; frameNumber < NB_FRAMES; frameNumber++) {
            frames.add(frame);
        }
        return frames;
    }

}
