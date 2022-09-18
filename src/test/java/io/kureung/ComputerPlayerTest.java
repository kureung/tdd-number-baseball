package io.kureung;

import io.kureung.NumbersGenerator.FakeNumbersGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerPlayerTest {

    @Test
    void 컴퓨터_플레이어는_공들을_반환할_수_있다() {
        Balls balls = balls();
        Player player = new ComputerPlayer(balls);
        Assertions.assertThat(player.balls()).isEqualTo(balls);
    }

    private Balls balls() {
        NumbersGenerator numbersGenerator = new FakeNumbersGenerator(List.of(1, 2, 3));
        return Balls.from(numbersGenerator);
    }

}
