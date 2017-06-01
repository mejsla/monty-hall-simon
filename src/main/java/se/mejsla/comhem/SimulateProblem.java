package se.mejsla.comhem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 */
public class SimulateProblem {
    public static void main(String[] args) {
        int timesToSimulate = 1000;
        int wins = 0;
        List<Long> originalDoors = Arrays.asList(0L, 1L, 2L);
        for (int i = 0; i < timesToSimulate; i++) {
            long carDoor =  ThreadLocalRandom.current().nextLong(0, 3);
            long chooseDoor = ThreadLocalRandom.current().nextLong(0, 3);

            List<Long> doorSelector = new ArrayList<>(originalDoors);
            doorSelector.remove(chooseDoor);
            doorSelector.remove(carDoor);
            if (doorSelector.size() > 1) {
                doorSelector.remove(ThreadLocalRandom.current().nextInt(0, 2));
            }
            long opensDoor = doorSelector.get(0);

            List<Long> doorToPick = new ArrayList<>(originalDoors);
            doorToPick.remove(chooseDoor);
            doorToPick.remove(opensDoor);


            if (doorToPick.get(0) == carDoor) {
                wins++;
            }

            System.out.println(String.format("car: '%s', first: '%s', second: '%s'", carDoor, chooseDoor, doorToPick.get(0)));
        }

        System.out.println("Result: " + ((double) wins / timesToSimulate));
    }
}
