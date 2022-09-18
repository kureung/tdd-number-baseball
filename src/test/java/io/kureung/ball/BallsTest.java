package io.kureung.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import io.kureung.NumbersGenerator;
import io.kureung.NumbersGenerator.FakeNumbersGenerator;
import io.kureung.NumbersGenerator.RandomNumbersGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    void 공_리스트는_숫자_생성기를_주입_받아_생성된다() {
        NumbersGenerator numbersGenerator = new RandomNumbersGenerator();
        assertThatCode(() -> Balls.from(numbersGenerator))
                .doesNotThrowAnyException();
    }

    @Test
    void 첫_번째_볼을_반환한다() {
        NumbersGenerator numbersGenerator = new FakeNumbersGenerator(List.of(1, 2, 3));
        Balls balls = Balls.from(numbersGenerator);
        assertThat(balls.firstBall()).isEqualTo(new Ball(BallIndex.ONE, BallNumber.ONE));
    }

    @Test
    void 두_번째_볼을_반환한다() {
        NumbersGenerator numbersGenerator = new FakeNumbersGenerator(List.of(1, 2, 3));
        Balls balls = Balls.from(numbersGenerator);
        assertThat(balls.secondBall()).isEqualTo(new Ball(BallIndex.TWO, BallNumber.TWO));
    }

    @Test
    void 세_번째_볼을_반환한다() {
        NumbersGenerator numbersGenerator = new FakeNumbersGenerator(List.of(1, 2, 3));
        Balls balls = Balls.from(numbersGenerator);
        assertThat(balls.thirdBall()).isEqualTo(new Ball(BallIndex.THREE, BallNumber.THREE));
    }

}
