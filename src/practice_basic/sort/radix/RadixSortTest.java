package practice_basic.sort.radix;

import org.junit.Test;
import utility.AssertUtils;

import static utility.ArrayUtils.createRandomArray;
import static utility.ArrayUtils.format;

/**
 * Created by nickwph on 12/6/15.
 */
@SuppressWarnings("Duplicates")
public class RadixSortTest {

    @Test
    public void testMSDRadixSort() throws Exception {
        int[] array = createRandomArray(20, 10000);
        System.out.println("Original: " + format(array));
        MSDRadixSort.sort(array);
        System.out.println("Sorted:   " + format(array));
        AssertUtils.assertSorted(array);
    }

    @Test
    public void testLSDRadixSort() throws Exception {
        int[] array = createRandomArray(20, 10000);
        System.out.println("Original: " + format(array));
        LSDRadixSort.sort(array);
        System.out.println("Sorted:   " + format(array));
        AssertUtils.assertSorted(array);
    }
}