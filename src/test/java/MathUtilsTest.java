import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static utility.MathUtils.getDigitAt;
import static utility.MathUtils.getDigitCount;

/**
 * Created by nickwph on 12/6/15.
 */
public class MathUtilsTest {

    @Test
    public void testGetDigitCount() throws Exception {
        assertEquals(2, getDigitCount(91));
        assertEquals(5, getDigitCount(12345));
        assertEquals(0, getDigitCount(0));
    }

    @Test
    public void testGetDigitAt() throws Exception {
        int value = 1234;
        assertEquals(0, getDigitAt(value, 5, 0));
        assertEquals(1, getDigitAt(value, 5, 1));
        assertEquals(2, getDigitAt(value, 5, 2));
        assertEquals(3, getDigitAt(value, 5, 3));
        assertEquals(4, getDigitAt(value, 5, 4));
    }
}