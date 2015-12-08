package utility;

import static java.lang.Math.pow;

/**
 * Created by nickwph on 11/11/15.
 */
public class MathUtils {

    public static int getExponent(int value) {
        int exp;
        for (exp = 1; value / exp > 0; exp *= 10) ;
        return exp / 10;
    }

    public static int getNumberOfDigits(int value) {
        // (4235) -> 4
        // (13413) -> 5
        // (246243) -> 6
        int exp;
        for (exp = 1; value > 0; exp++) {
            value /= 10;
        }
        return exp - 1;
    }

    public static int getDigitAtPlace(int value, int place) {
        // (31415,4) -> 1
        // (31415,3) -> 4
        // (4,3) -> 0
        return (value / (int) pow(10, place)) % 10;
    }


    public static int getDigitAtExp(int value, int exp) {
        // (31415,1000) -> 1
        // (31415,100) -> 4
        // (4,1000) -> 0
        return (value / exp) % 10;
    }

    /**
     * https://en.wikipedia.org/wiki/Significant_figures#Significant_figures_rules_explained
     * 91    -> 2
     * 12345 -> 5
     */
    public static int getDigitCount(int value) {
        int count;
        for (count = 0; value > 0; count++) value /= 10;
        return count;
    }

    /**
     * 123,5,0 -> 0
     * 123,5,1 -> 0
     * 123,5,2 -> 1
     * 123,5,3 -> 2
     * 123,5,4 -> 3
     */
    public static int getDigitAt(int value, int max, int position) {
        int figure = (int) pow(10, max - position - 1);
        return (value / figure) % 10;
    }
}
