package io.kureung.ball;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallTest {

    @MethodSource
    @ParameterizedTest
    void 공의_숫자와_인덱스값을_통해서_공이_예외없이_생성된다(BallIndex ballIndex, BallNumber ballNumber) {
        assertThatCode(() -> new Ball(ballIndex, ballNumber))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> 공의_숫자와_인덱스값을_통해서_공이_예외없이_생성된다() {
        return Stream.of(
                Arguments.of(BallIndex.ONE, BallNumber.ONE),
                Arguments.of(BallIndex.THREE, BallNumber.NINE)
        );
    }

}
