package se.mejsla.comhem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple MontyHallProblem.
 */
public class MontyHallProblemTest {

    @Test
    public void selectedMoneyBoxFirst() {
        boolean result = new MontyHallProblem().switchBox(0, 0);
        assertThat(result, is(false));
    }

    @Test
    public void didNotSelectMoneyBoxFirst1() {
        boolean result = new MontyHallProblem().switchBox(0, 1);
        assertThat(result, is(true));
    }

    @Test
    public void didNotSelectMoneyBoxFirst2() {
        boolean result = new MontyHallProblem().switchBox(0, 2);
        assertThat(result, is(true));
    }

    @Test
    public void massTest() {
        MontyHallProblem montyHallProblem = new MontyHallProblem();
        for (int i = 0; i < 10000; i++) {
            boolean result = montyHallProblem.switchBox(0, 2);
            assertThat(result, is(true));
        }

    }
}
