package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private static final int NB_FRAMES = 10;
    public static final Frame ZERO_FRAME = new Frame(0, 0);
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
    void when_player_do_one_spare_and_first_ball_after_is_0_then_spare_should_have_no_effect() {
        Frame spare = new Frame(9, 1);
        Frames framesWithOneSpareAtTheBeginning = buildScoreWithOneSpareAtTheBeginning(spare, ZERO_FRAME, ZERO_FRAME);

        int score = game.run(framesWithOneSpareAtTheBeginning);

        assertThat(score).isEqualTo(10);
    }

    @Test
    void when_player_do_one_spare_and_first_ball_after_hits_more_than_one_pin_spare_should_have_an_effect() {
        Frame twoFrame = new Frame(2, 0);
        Frame spare = new Frame(9, 1);
        Frames framesWithOneSpareAtTheBeginning = buildScoreWithOneSpareAtTheBeginning(spare, twoFrame, ZERO_FRAME);

        int score = game.run(framesWithOneSpareAtTheBeginning);

        assertThat(score).isEqualTo(14);
    }

    private Frames buildScoreWithOneSpareAtTheBeginning(Frame spare, Frame frameAfterSpare, Frame otherFrames) {
        List<Frame> frames = buildScoreFrame(otherFrames);
        frames.add(0, spare);
        frames.add(1, frameAfterSpare);
        frames.remove(10);
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
