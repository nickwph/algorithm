package utility;

import static org.junit.Assert.assertTrue;

/**
 * Created by nickwph on 12/6/15.
 */
public class AssertUtils {

    public static void assertSorted(int array[]) {
        assertTrue(ArrayUtils.isSorted(array));
    }
}
