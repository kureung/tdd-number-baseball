package io.kureung.judgment;

import io.kureung.judgment.ball.BallResult;
import io.kureung.judgment.strike.StrikeResult;

public class JudgmentResult {

    private final StrikeResult strikeResult;
    private final BallResult ballResult;

    public JudgmentResult(StrikeResult strikeResult, BallResult ballResult) {
        this.strikeResult = strikeResult;
        this.ballResult = ballResult;
    }

    public int strike() {
        return strikeResult.strike();
    }

    public int ball() {
        return ballResult.ball();
    }

}
