package io.kureung;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 공_숫자는_1_이상_9_이하가_아닌_정수를_주입_받을_경우_에외가_발생한다(int numberValue) {
        assertThatThrownBy(() -> BallNumber.from(numberValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의_숫자는 1 이상 9이하이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 공_숫자는_1이상_9이하의_정수를_주입_받아_생성한다(int numberValue) {
        assertThatCode(() -> BallNumber.from(numberValue))
                .doesNotThrowAnyException();
    }

}