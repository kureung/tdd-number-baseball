package io.kureung.judgment.ball;

import static org.assertj.core.api.Assertions.assertThat;

import io.kureung.NumbersGenerator;
import io.kureung.NumbersGenerator.FakeNumbersGenerator;
import io.kureung.ball.Balls;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallJudgementTest {

    @MethodSource
    @ParameterizedTest
    void 볼_판단(NumbersGenerator computerNumber, NumbersGenerator userNumber, BallResult expectedResult) {
        Balls computerBalls = Balls.from(computerNumber);
        Balls userBalls = Balls.from(userNumber);

        BallJudgement ballJudgement = new BallJudgement(computerBalls, userBalls);
        BallResult ballResult = ballJudgement.judgmentResult();
        assertThat(ballResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> 볼_판단() {
        return Stream.of(
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(4, 5, 6)), new BallResult(0)),
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(2, 4, 5)), new BallResult(1)),
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(2, 3, 4)), new BallResult(2)),
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(2, 3, 1)), new BallResult(3))
        );
    }

    private static FakeNumbersGenerator numbers(List<Integer> numbers) {
        return new FakeNumbersGenerator(numbers);
    }

}
