import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class StringUtilsTest {

    @Test
    public void joinArray() {
        String[] argument = {"T", "E", "S", "T"};
        String actual = StringUtils.joinArray(argument, (char) 50);
        String expected = "T2E2S2T";
        assertThat(expected, Matchers.hasToString(actual));
    }

    @Test
    public void testToArray() {
        String[] actual1 = StringUtils.toArray("T:E:S:T", ':');
        String[] actual2 = StringUtils.toArray(null, ':');
        String[] expected = {"T", "E", "S", "T"};
        String[] expected2 = {};
        assertThat(expected, Matchers.arrayContainingInAnyOrder(actual1));
        assertThat(expected2, Matchers.arrayContainingInAnyOrder(actual2));
    }

    @Test
    public void testIsEmpty() {
        boolean actual = StringUtils.isEmpty("TEST");
        boolean actual2 = StringUtils.isEmpty("");
        boolean actual3 = StringUtils.isEmpty(" ");
        assertThat(false, Matchers.equalTo(actual));
        assertThat(true, Matchers.equalTo(actual2));
        assertThat(true, Matchers.equalTo(actual3));
    }

    @Test
    public void testToDouble() {
        double expected = 3.145;
        double expected2 = Double.NaN;
        double actual = StringUtils.toDouble("3.145");
        double actual2 = StringUtils.toDouble(null);
        assertThat(expected, Matchers.is(actual));
        assertThat(expected2, Matchers.is(actual2));
    }

    @Test
    public void testFromDouble() {
        double argument = 3.1415;
        String expected ="3.1415";
        String actual = StringUtils.fromDouble(argument);
        assertThat(expected, Matchers.hasToString(actual));
    }
}
