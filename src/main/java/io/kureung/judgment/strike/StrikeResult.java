package io.kureung.judgment.strike;

import java.util.Objects;

public class StrikeResult {

    private final int strike;

    public StrikeResult(int strike) {
        this.strike = strike;
    }

    public StrikeResult addedStrike(StrikeResult twoStrike) {
        return new StrikeResult(this.strike + twoStrike.strike);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StrikeResult that = (StrikeResult) o;
        return strike == that.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike);
    }

    public int strike() {
        return strike;
    }

}
