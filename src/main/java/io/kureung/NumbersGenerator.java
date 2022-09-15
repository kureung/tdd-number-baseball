package io.kureung;

import java.util.List;
import java.util.Random;

public interface NumbersGenerator {

    List<Integer> numbers();

    class RandomNumbersGenerator implements NumbersGenerator {

        private static final int NUMBER_OF_BALLS = 3;

        private static final Random RANDOM = new Random();

        private static final int SMALLEST_NUMBER_OF_BALL = 1;

        private static final int BIGGEST_NUMBER_OF_BALL = 9;

        @Override
        public List<Integer> numbers() {
            return RANDOM.ints(SMALLEST_NUMBER_OF_BALL, BIGGEST_NUMBER_OF_BALL + SMALLEST_NUMBER_OF_BALL)
                    .distinct()
                    .limit(NUMBER_OF_BALLS)
                    .boxed()
                    .toList();
        }

    }

}
