package io.kureung;

import java.util.Arrays;

public enum BallIndex {
    ONE(1),
    TWO(2),
    THREE(3);

    private final int indexValue;

    BallIndex(int indexValue) {
        this.indexValue = indexValue;
    }

    public static BallIndex from(int indexValue) {
        return Arrays.stream(values())
                .filter(ballIndex -> ballIndex.indexValue == indexValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("공 인덱스는 1 이상 3 이하 입니다."));
    }

    public int indexValue() {
        return indexValue;
    }
}
