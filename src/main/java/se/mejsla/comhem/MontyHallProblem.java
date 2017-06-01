package se.mejsla.comhem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 */
public class MontyHallProblem {
    private static final List<Long> originalBoxes = Arrays.asList(0L, 1L, 2L);

    public static void main(String[] args) {
        int timesToSimulate = 1000;
        int wins = 0;
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        for (int i = 0; i < timesToSimulate; i++) {
            wins += montyHallProblem.simulateStart() ? 1 : 0;
        }
        System.out.println(String.format("Your win percentage is: %s%%", ((double) wins / timesToSimulate) * 100));
    }

    /**
     * Simulates a round of the Monty Hall Problem
     * Randomized choice of moneyBox and first choice box
     *
     * @return true if win
     */
    public boolean simulateStart() {
        long moneyBox = ThreadLocalRandom.current().nextLong(0, 3);
        long firstChoiceBox = ThreadLocalRandom.current().nextLong(0, 3);
        return switchBox(moneyBox, firstChoiceBox);
    }

    /**
     * Simulates a round of the Monty Hall Problem
     *
     * @param moneyBox       position 0..2 of moneyBox
     * @param firstChoiceBox position 0..2 of first choice
     * @return true if win
     */
    public boolean switchBox(long moneyBox, long firstChoiceBox) {
        List<Long> boxSelector = new ArrayList<>(originalBoxes);
        boxSelector.remove(firstChoiceBox);
        boxSelector.remove(moneyBox);
        if (boxSelector.size() > 1) {
            boxSelector.remove(ThreadLocalRandom.current().nextInt(0, 2));
        }
        long opensDoor = boxSelector.get(0);

        List<Long> boxToPick = new ArrayList<>(originalBoxes);
        boxToPick.remove(firstChoiceBox);
        boxToPick.remove(opensDoor);
        System.out.println(String.format("car: '%s', first: '%s', second: '%s'", moneyBox, firstChoiceBox, boxToPick.get(0)));
        return boxToPick.get(0) == moneyBox;
    }
}
