package io.kureung;

import java.util.List;
import java.util.stream.IntStream;

public class Balls {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls from(NumbersGenerator numbersGenerator) {
        List<Integer> numbers = numbersGenerator.numbers();
        List<Ball> balls = IntStream.rangeClosed(BallIndex.ONE.indexValue(), BallIndex.THREE.indexValue())
                .boxed()
                .map(ballIndex -> new Ball(BallIndex.from(ballIndex), BallNumber.from(numbers.get(ballIndex - ONE))))
                .toList();
        return new Balls(balls);
    }

    public Ball firstBall() {
        return balls.get(ZERO);
    }

    public Ball secondBall() {
        return balls.get(ONE);
    }

    public Ball thirdBall() {
        return balls.get(TWO);
    }

}
