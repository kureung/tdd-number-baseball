package io.kureung;

import static org.assertj.core.api.Assertions.assertThatCode;

import io.kureung.NumbersGenerator.RandomNumbersGenerator;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    void 공_리스트는_숫자_생성기를_주입_받아_생성된다() {
        NumbersGenerator numbersGenerator = new RandomNumbersGenerator();
        assertThatCode(() -> Balls.from(numbersGenerator))
                .doesNotThrowAnyException();
    }

}
