package io.kureung;

import java.util.Objects;

public class Ball {

    private final BallIndex ballIndex;
    private final BallNumber ballNumber;

    public Ball(BallIndex ballIndex, BallNumber ballNumber) {
        this.ballIndex = ballIndex;
        this.ballNumber = ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballIndex == ball.ballIndex && ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballIndex, ballNumber);
    }

}
