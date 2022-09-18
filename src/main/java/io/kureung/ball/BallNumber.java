package io.kureung.ball;

import java.util.Arrays;

public enum BallNumber {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int numberValue;

    BallNumber(int numberValue) {
        this.numberValue = numberValue;
    }

    public static BallNumber from(int numberValue) {
        return Arrays.stream(values())
                .filter(ballNumber -> ballNumber.numberValue == numberValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("공의_숫자는 1 이상 9이하이어야 합니다."));
    }

    public int numberValue() {
        return numberValue;
    }
}
