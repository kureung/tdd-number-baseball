package io.kureung;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallIndexTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void 공_인덱스는_1이상_3이하를_벗어나면_예외가_발생한다(int indexValue) {
        assertThatThrownBy(() -> BallIndex.from(indexValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공 인덱스는 1 이상 3 이하 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void 공_인덱스는_1이상_3이하인_정수를_기반으로_생성된다(int indexValue) {
        assertThatCode(() -> BallIndex.from(indexValue))
                .doesNotThrowAnyException();
    }

}
