package io.kureung.judgment.strike;

import io.kureung.ball.Ball;
import io.kureung.ball.Balls;

public class StrikeJudgment {

    private final Balls computerBalls;
    private final Balls userBalls;

    public StrikeJudgment(Balls computerBalls, Balls userBalls) {
        this.computerBalls = computerBalls;
        this.userBalls = userBalls;
    }

    public StrikeResult judgmentResult() {
        return firstStrikeJudgment().addedStrike(secondStrikeJudgment())
                .addedStrike(thirdStrikeJudgment());
    }

    private StrikeResult firstStrikeJudgment() {
        return judgmentResult(computerBalls.firstBall(), userBalls.firstBall());
    }

    private StrikeResult secondStrikeJudgment() {
        return judgmentResult(computerBalls.secondBall(), userBalls.secondBall());
    }

    private StrikeResult thirdStrikeJudgment() {
        return judgmentResult(computerBalls.thirdBall(), userBalls.thirdBall());
    }

    private StrikeResult judgmentResult(Ball standardTarget, Ball comparisonTarget) {
        return standardTarget.equals(comparisonTarget)
                ? new StrikeResult(1)
                : new StrikeResult(0);
    }

}
