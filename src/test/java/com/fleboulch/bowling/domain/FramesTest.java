package com.fleboulch.bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FramesTest {

    private static final Frame ZERO_FRAME = new Frame(0, 0, 1);
    private static final int VALID_NUMBER_OF_FRAMES = 10;
    private static final int INVALID_NUMBER_OF_FRAMES = 20;

    @Test
    void when_building_frames_it_should_have_valid_frame_number() {
        assertThatThrownBy(this::buildInvalidFrames)
                .isInstanceOf(InvalidNumberOfFramesException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void when_searching_unknown_frame_index_it_should_return_an_exception(int invalidFrameIndex) {
        Frames frames = buildFrames();
        assertThatThrownBy(() -> frames.getFrameByNumero(invalidFrameIndex))
                .isInstanceOf(UnknownFrameIndexException.class);
    }

    @Test
    void when_searching_first_frame_it_return_the_first_frame() {
        Frames frames = buildFrames();
        assertThat(frames.getFrameByNumero(1)).isEqualTo(ZERO_FRAME);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 7, 9})
    void frame_is_not_last(int frameNumber) {
        Frames frames = buildFrames();
        assertThat(frames.next(frames.getFrameByNumero(frameNumber))).isNotEmpty();
    }

    private Frames buildInvalidFrames() {
        List<Frame> frames = new ArrayList<>();
        IntStream.rangeClosed(0, INVALID_NUMBER_OF_FRAMES).forEach(t -> frames.add(ZERO_FRAME));

        return new Frames(frames);
    }

    private Frames buildFrames() {
        List<Frame> frames = new ArrayList<>();
        IntStream.rangeClosed(1, VALID_NUMBER_OF_FRAMES).forEach(t -> frames.add(ZERO_FRAME));

        return new Frames(frames);
    }

}
