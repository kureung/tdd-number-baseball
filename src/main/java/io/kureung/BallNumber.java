package io.kureung;

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

    private final int number;

    BallNumber(int number) {
        this.number = number;
    }

    public static BallNumber from(int numberValue) {
        return Arrays.stream(values())
                .filter(ballNumber -> ballNumber.number == numberValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("공의_숫자는 1 이상 9이하이어야 합니다."));
    }

    public int number() {
        return number;
    }
}
