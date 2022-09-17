package io.kureung;

import java.util.List;
import java.util.stream.IntStream;

public class Balls {

    private static final int BALLS_INDEX_ZERO = 0;
    private static final int BALLS_INDEX_ONE = 1;
    private static final int BALLS_INDEX_TWO = 2;

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls from(NumbersGenerator numbersGenerator) {
        List<Integer> numbers = numbersGenerator.numbers();
        return new Balls(balls(numbers));
    }

    private static List<Ball> balls(List<Integer> numbers) {
        return IntStream.rangeClosed(BallIndex.ONE.indexValue(), BallIndex.THREE.indexValue())
                .boxed()
                .map(ballIndex -> new Ball(BallIndex.from(ballIndex), BallNumber.from(numbers.get(ballIndex - BALLS_INDEX_ONE))))
                .toList();
    }

    public Ball firstBall() {
        return balls.get(BALLS_INDEX_ZERO);
    }

    public Ball secondBall() {
        return balls.get(BALLS_INDEX_ONE);
    }

    public Ball thirdBall() {
        return balls.get(BALLS_INDEX_TWO);
    }

}
