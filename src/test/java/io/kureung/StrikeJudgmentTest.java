package io.kureung;

import static org.assertj.core.api.Assertions.assertThat;

import io.kureung.NumbersGenerator.FakeNumbersGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StrikeJudgmentTest {

    @MethodSource
    @ParameterizedTest
    void 스트라이크_판단(NumbersGenerator computerNumber, NumbersGenerator userNumber, BallResult expectedResult) {
        Balls computerBalls = Balls.from(computerNumber);
        Balls userBalls = Balls.from(userNumber);

        StrikeJudgement strikeJudgement = new StrikeJudgement(computerBalls, userBalls);
        StrikeResult strikeResult = strikeJudgement.judgmentResult();
        assertThat(strikeResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> 스트라이크_판단() {
        return Stream.of(
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(4, 5, 6)), new StrikeResult(0)),
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(2, 4, 5)), new StrikeResult(1)),
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(2, 3, 4)), new StrikeResult(2)),
                Arguments.of(numbers(List.of(1, 2, 3)), numbers(List.of(2, 3, 1)), new StrikeResult(3))
        );
    }

    private static FakeNumbersGenerator numbers(List<Integer> numbers) {
        return new FakeNumbersGenerator(numbers);
    }

}
