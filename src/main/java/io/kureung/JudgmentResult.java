package io.kureung;

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
