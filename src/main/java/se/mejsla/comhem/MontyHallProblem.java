package se.mejsla.comhem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static se.mejsla.comhem.MontyHallProblem.Box.*;

/**
 * Assume that you are attending a TV show where you can win money by picking the right box.
 * The game show host shows you three boxes explaining that the money is in one of the boxes.
 * He asks you to pick one of them without opening it.
 * After you have picked one of the boxes he opens one of the other two boxes which is empty.
 * Now he turns to you and asks, do you want to change your mind, picking the remaining box?
 * <p>
 * Write a program in Java randomly simulating this event over and over again
 * in the quest of answering following question. Do I stand a better chance to win if I change my mind?
 */
public class MontyHallProblem {
    enum Box {FIRST, SECOND, THIRD}

    private static final List<Box> originalBoxes = Arrays.asList(FIRST, SECOND, THIRD);

    private int numberOfSimulations = 0;
    private int numberOfWins = 0;

    public static void main(String[] args) {
        int timesToSimulate = 10000;
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        for (int i = 0; i < timesToSimulate; i++) {
            montyHallProblem.simulate();
        }
        if (montyHallProblem.getWinPercentage() > 1 / 3) {
            System.out.println("You had a higher success of winning");
        }
        System.out.println(String.format("Your estimated win percentage is: %s%%", montyHallProblem.getWinPercentage()));
    }

    /**
     * Simulates a round of the Monty Hall Problem
     * Randomized moneyBox and first choice box
     */
    public void simulate() {
        Box moneyBox = originalBoxes.get(ThreadLocalRandom.current().nextInt(0, 3));
        Box firstChoiceBox = originalBoxes.get(ThreadLocalRandom.current().nextInt(0, 3));
        switchBox(moneyBox, firstChoiceBox);
    }

    /**
     * Simulates a round of the Monty Hall Problem
     *
     * @param moneyBox       position of moneyBox
     * @param firstChoiceBox position of first choice
     */
    protected void switchBox(Box moneyBox, Box firstChoiceBox) {
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
        numberOfSimulations++;
        numberOfWins += boxToPick.get(0) == moneyBox ? 1 : 0;
    }

    public double getWinPercentage() {
        return ((double) numberOfWins / numberOfSimulations) * 100;
    }

    public int getNumberOfSimulations() {
        return numberOfSimulations;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }
}
