package io.kureung.judgment.ball;

import java.util.Objects;

public class BallResult {

    private final int ball;

    public BallResult(int ball) {
        this.ball = ball;
    }

    public int ball() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallResult that = (BallResult) o;
        return ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }

    public BallResult addedBall(BallResult twoBall) {
        return new BallResult(this.ball + twoBall.ball);
    }

}
