package practice4;

import org.junit.Assert;
import org.junit.Test;
import practice4_adv.BreakLine;

import static org.hamcrest.core.Is.is;

public class BreakLineTest {

    @Test
    public void checkWith5Width() {
        String input = "\"abc ab c w\"";
        String actual = new BreakLine().format(input, 5);
        Assert.assertThat(actual, is("\"abc\nab c\nw\""));
    }

    @Test
    public void checkWith4Width() {
        String input = "\"a a b cdc w w q\"";
        String actual = new BreakLine().format(input, 4);
        Assert.assertThat(actual, is("\"a a\nb\ncdc\nw w\nq\""));
    }

}