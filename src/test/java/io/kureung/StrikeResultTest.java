package io.kureung;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StrikeResultTest {

    @Test
    void 스트라이크_결과를_더할_수있다() {
        StrikeResult oneStrike = new StrikeResult(1);
        StrikeResult twoStrike = new StrikeResult(2);
        StrikeResult threeStrike = oneStrike.addedStrike(twoStrike);
        assertThat(threeStrike).isEqualTo(new StrikeResult(3));
    }

}