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
        boolean result = new MontyHallProblem().switchBox(FIRST, FIRST);
        assertThat(result, is(false));
    }

    @Test
    public void didNotSelectMoneyBoxFirst1() {
        boolean result = new MontyHallProblem().switchBox(FIRST, SECOND);
        assertThat(result, is(true));
    }

    @Test
    public void didNotSelectMoneyBoxFirst2() {
        boolean result = new MontyHallProblem().switchBox(FIRST, THIRD);
        assertThat(result, is(true));
    }

    @Test
    public void massTest() {
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        for (int i = 0; i < 10000; i++) {
            boolean result = montyHallProblem.switchBox(FIRST, SECOND);
            assertThat(result, is(true));
        }

    }
}
