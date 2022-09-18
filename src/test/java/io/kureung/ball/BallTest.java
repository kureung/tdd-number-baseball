package io.kureung.ball;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
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

    @Test
    void 공_숫자가_일치할_경우_참이_나온다() {
        Ball ball = new Ball(BallIndex.ONE, BallNumber.ONE);
        Ball anotherBall = new Ball(BallIndex.TWO, BallNumber.ONE);
        assertTrue(ball.isSameNumber(anotherBall));
    }

    @Test
    void 공_숫자가_불일치할_경우_거짓이_나온다() {
        Ball ball = new Ball(BallIndex.ONE, BallNumber.ONE);
        Ball anotherBall = new Ball(BallIndex.ONE, BallNumber.TWO);
        assertFalse(ball.isSameNumber(anotherBall));
    }

}
