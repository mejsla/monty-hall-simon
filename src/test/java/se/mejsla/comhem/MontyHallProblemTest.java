package se.mejsla.comhem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static se.mejsla.comhem.MontyHallProblem.Box.FIRST;
import static se.mejsla.comhem.MontyHallProblem.Box.SECOND;
import static se.mejsla.comhem.MontyHallProblem.Box.THIRD;

/**
 * Unit test for simple MontyHallProblem.
 */
public class MontyHallProblemTest {

    @Test
    public void selectedMoneyBoxFirst() {
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        montyHallProblem.switchBox(FIRST, FIRST);
        assertThat(montyHallProblem.getNumberOfWins(), is(0));
    }

    @Test
    public void didNotSelectMoneyBoxFirst1() {
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        montyHallProblem.switchBox(FIRST, SECOND);
        assertThat(montyHallProblem.getNumberOfWins(), is(1));
    }

    @Test
    public void didNotSelectMoneyBoxFirst2() {
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        montyHallProblem.switchBox(FIRST, THIRD);
        assertThat(montyHallProblem.getNumberOfWins(), is(1));
    }

    @Test
    public void massTestWin() {
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        for (int i = 0; i < 10000; i++) {
            montyHallProblem.switchBox(FIRST, SECOND);
            montyHallProblem.switchBox(FIRST, THIRD);
        }
        assertThat(montyHallProblem.getNumberOfWins(), is(montyHallProblem.getNumberOfSimulations()));

    }

    @Test
    public void massTestLoose() {
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        for (int i = 0; i < 10000; i++) {
            montyHallProblem.switchBox(FIRST, FIRST);
        }
        assertThat(montyHallProblem.getNumberOfWins(), is(0));

    }
}
