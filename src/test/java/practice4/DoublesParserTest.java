package practice4;

import org.junit.Assert;
import org.junit.Test;
import practice4_adv.DoublesParser;

import static org.hamcrest.core.Is.is;

public class DoublesParserTest {
    @Test
    public void checkNumbers() {
        Double actual = new DoublesParser().parse("67");
        Assert.assertThat(actual, is(67.0));
    }

    @Test
    public void checkSignNumbers() {
        Double actual = new DoublesParser().parse("-67");
        Assert.assertThat(actual, is(-67.0));
    }

    @Test
    public void checkPositiveSignNumbers() {
        Double actual = new DoublesParser().parse("+67.");
        Assert.assertThat(actual, is(67.0));
    }

    @Test
    public void checkDecimalPart() {
        Double actual = new DoublesParser().parse("67.129");
        Assert.assertThat(actual, is(67.129));
    }

    @Test
    public void checkWithOutIntPart() {
        Double actual = new DoublesParser().parse(".129");
        Assert.assertThat(actual, is(0.129));
    }

    @Test
    public void checkOnlyDotInput() {
        Double actual = new DoublesParser().parse(".");
        Assert.assertNull(actual);
    }

    @Test
    public void checkExpPart() {
        Double actual = new DoublesParser().parse("2.e2");
        Assert.assertThat(actual, is(2.e2));
    }

    @Test
    public void checkComplexNumber() {
        Double actual = new DoublesParser().parse("-.56e-2");
        Assert.assertThat(actual, is(-0.56e-2));
    }

    @Test
    public void checkNegativeZeroWithDot() {
        Double actual = new DoublesParser().parse("-0.");
        Assert.assertThat(actual, is(0.0));
    }
}