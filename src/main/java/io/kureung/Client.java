package io.kureung;

import io.kureung.NumbersGenerator.RandomNumbersGenerator;
import io.kureung.ball.Balls;
import io.kureung.judgment.Judgment;
import io.kureung.judgment.JudgmentResult;
import io.kureung.player.ComputerPlayer;
import io.kureung.player.Player;
import io.kureung.player.UserPlayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Balls computerBalls = Balls.from(new RandomNumbersGenerator());
        Player computer = new ComputerPlayer(computerBalls);

        do {
            System.out.print("숫자를 입력해 주세요 : ");
            RandomNumbersGenerator numbersGenerator = new RandomNumbersGenerator();
            System.out.println(numbersGenerator.numbers());

            Balls userBalls = Balls.from(numbersGenerator);
            Player user = new UserPlayer(userBalls);

            Judgment judgment = new Judgment(computer, user);
            JudgmentResult result = judgment.result();
            int strike = result.strike();
            int ball = result.ball();

            String view = "";

            if (ball == 0 && strike == 0) {
                view = "낫싱";
            }

            if (ball == 0 && strike != 0) {
                view = String.format("%d스트라이크", strike);
            }

            if (ball != 0 && strike == 0) {
                view = String.format("%d볼", ball);
            }

            if (ball != 0 && strike != 0) {
                view = String.format("%d볼 %d스트라이크", ball, strike);
            }

            System.out.println(view);

            if (strike == 3) {
                break;
            }
        } while (true);

        br.close();
    }

}
