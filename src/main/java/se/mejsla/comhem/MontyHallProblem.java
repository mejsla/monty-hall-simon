package se.mejsla.comhem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static se.mejsla.comhem.MontyHallProblem.Box.*;

/**
 * Hello world!
 */
public class MontyHallProblem {
    enum Box {FIRST, SECOND, THIRD}

    private static final List<Box> originalBoxes = Arrays.asList(FIRST, SECOND, THIRD);

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
        Box moneyBox = originalBoxes.get(ThreadLocalRandom.current().nextInt(0, 3));
        Box firstChoiceBox = originalBoxes.get(ThreadLocalRandom.current().nextInt(0, 3));
        return switchBox(moneyBox, firstChoiceBox);
    }

    /**
     * Simulates a round of the Monty Hall Problem
     *
     * @param moneyBox       position 0..2 of moneyBox
     * @param firstChoiceBox position 0..2 of first choice
     * @return true if win
     */
    public boolean switchBox(Box moneyBox, Box firstChoiceBox) {
        List<Box> boxSelector = new ArrayList<>(originalBoxes);
        boxSelector.remove(firstChoiceBox);
        boxSelector.remove(moneyBox);
        if (boxSelector.size() > 1) {
            boxSelector.remove(originalBoxes.get(ThreadLocalRandom.current().nextInt(0, 2)));
        }
        Box opensBox = boxSelector.get(0);

        List<Box> boxToPick = new ArrayList<>(originalBoxes);
        boxToPick.remove(firstChoiceBox);
        boxToPick.remove(opensBox);
        System.out.println(String.format("money: '%s', initialChoice: '%s', finalChoice: '%s'",
                moneyBox, firstChoiceBox, boxToPick.get(0)));
        return boxToPick.get(0) == moneyBox;
    }
}
