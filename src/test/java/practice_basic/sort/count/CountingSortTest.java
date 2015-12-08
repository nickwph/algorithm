package practice_basic.sort.count;

import org.junit.Test;
import utility.ArrayUtils;

import static org.junit.Assert.assertTrue;
import static utility.ArrayUtils.createRandomArray;
import static utility.ArrayUtils.format;

/**
 * Created by nickwph on 12/6/15.
 */
@SuppressWarnings("Duplicates")
public class CountingSortTest {

    @Test
    public void testSort() throws Exception {
        int[] array = createRandomArray(20, 10000);
        System.out.println("Original: " + format(array));
        CountingSort.sort(array);
        System.out.println("Sorted:   " + format(array));
        assertTrue(ArrayUtils.isSorted(array));
    }
}