package io.kureung;

public class Judgment {

    private final StrikeJudgment strikeJudgment;
    private final BallJudgement ballJudgement;

    public Judgment(Player computer, Player user) {
        this(strikeJudgment(computer, user), ballJudgement(computer, user));
    }

    private static StrikeJudgment strikeJudgment(Player computer, Player user) {
        return new StrikeJudgment(computer.balls(), user.balls());
    }

    private static BallJudgement ballJudgement(Player computer, Player user) {
        return new BallJudgement(computer.balls(), user.balls());
    }

    public Judgment(StrikeJudgment strikeJudgment, BallJudgement ballJudgement) {
        this.strikeJudgment = strikeJudgment;
        this.ballJudgement = ballJudgement;
    }

    public JudgmentResult result() {
        StrikeResult strikeResult = strikeJudgment.judgmentResult();
        BallResult ballResult = ballJudgement.judgmentResult();

        return new JudgmentResult(strikeResult, ballResult);
    }

}
