package practice3;

import org.junit.Assert;
import org.junit.Test;
import practice3_adv.RectangleSquare;

import static org.hamcrest.core.Is.is;

public class RectangleSquareTest {

    @Test
    public void testMeasure() throws Exception {
        int actual = new RectangleSquare().measure(new int[]{0, 0}, new int[]{20, 10}, new int[]{10, 20});
        Assert.assertThat(actual, is(300));
    }
}