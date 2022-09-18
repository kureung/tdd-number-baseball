package io.kureung.judgment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import io.kureung.Balls;
import io.kureung.ComputerPlayer;
import io.kureung.NumbersGenerator;
import io.kureung.NumbersGenerator.FakeNumbersGenerator;
import io.kureung.Player;
import io.kureung.UserPlayer;
import java.util.List;
import org.junit.jupiter.api.Test;

class JudgmentTest {

    @Test
    void 숫자_야구_통합_판별() {
        Balls computerBalls = balls(List.of(1, 2, 3));
        Balls userBalls = balls(List.of(3, 2, 1));

        Player computer = new ComputerPlayer(computerBalls);
        Player user = new UserPlayer(userBalls);

        Judgment judgment = new Judgment(computer, user);
        JudgmentResult judgmentResult = judgment.result();

        assertAll(
                () -> assertThat(judgmentResult.strike()).isEqualTo(1),
                () -> assertThat(judgmentResult.ball()).isEqualTo(2)
        );
    }

    private Balls balls(List<Integer> numbers) {
        NumbersGenerator computerNumbers = new FakeNumbersGenerator(numbers);
        return Balls.from(computerNumbers);
    }

}
