package io.kureung;

import java.util.List;
import java.util.Random;

public interface NumbersGenerator {

    List<Integer> numbers();

    class RandomNumbersGenerator implements NumbersGenerator {

        private static final int NUMBER_OF_BALLS = 3;

        private static final Random RANDOM = new Random();

        @Override
        public List<Integer> numbers() {
            return RANDOM.ints(BallNumber.ONE.numberValue(), BallNumber.NINE.numberValue() + BallNumber.ONE.numberValue())
                    .distinct()
                    .limit(NUMBER_OF_BALLS)
                    .boxed()
                    .toList();
        }

    }

    class FakeNumbersGenerator implements NumbersGenerator {

        private final List<Integer> numbers;

        public FakeNumbersGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> numbers() {
            return numbers;
        }

    }

}
