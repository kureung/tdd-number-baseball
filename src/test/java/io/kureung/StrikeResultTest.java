package io.kureung;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StrikeResultTest {

    @Test
    void 스트라이크_결과를_더할_수있다() {
        StrikeResult oneStrike = new StrikeResult(1);
        StrikeResult twoStrike = new StrikeResult(2);
        StrikeResult threeStrike = oneStrike.addedStrike(twoStrike);
        Assertions.assertThat(threeStrike).isEqualTo(new StrikeResult(3));
    }

}