package io.kureung.judgment.ball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BallResultTest {

    @Test
    void 볼_결과는_더할_수_있다() {
        BallResult oneBall = new BallResult(1);
        BallResult twoBall = new BallResult(2);

        BallResult threeBall = oneBall.addedBall(twoBall);
        assertThat(threeBall).isEqualTo(new BallResult(3));
    }

}