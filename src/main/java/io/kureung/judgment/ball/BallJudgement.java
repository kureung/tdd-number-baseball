package io.kureung.judgment.ball;

import io.kureung.ball.Ball;
import io.kureung.ball.Balls;
import java.util.Arrays;

public class BallJudgement {

    private final Balls computerBalls;
    private final Balls userBalls;

    public BallJudgement(Balls computerBalls, Balls userBalls) {
        this.computerBalls = computerBalls;
        this.userBalls = userBalls;
    }

    public BallResult judgmentResult() {
        return firstComparedResult().addedBall(secondCompareResult())
                .addedBall(thirdCompareResult());
    }

    private BallResult firstComparedResult() {
        return comparedBallResult(computerBalls.firstBall(), userBalls.secondBall(), userBalls.thirdBall());
    }

    private BallResult secondCompareResult() {
        return comparedBallResult(computerBalls.secondBall(), userBalls.firstBall(), userBalls.thirdBall());
    }

    private BallResult thirdCompareResult() {
        return comparedBallResult(computerBalls.thirdBall(), userBalls.firstBall(), userBalls.secondBall());
    }

    private BallResult comparedBallResult(Ball standardTarget, Ball... comparisonTargets) {
        return Arrays.asList(comparisonTargets).contains(standardTarget)
                ? new BallResult(1)
                : new BallResult(0);
    }

}
