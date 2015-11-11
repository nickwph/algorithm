package utility;

/**
 * Created by nickwph on 11/11/15.
 */
public class MathUtils {

    public static int getExponent(int value) {
        int exp;
        for (exp = 1; value / exp > 0; exp *= 10) ;
        return exp / 10;
    }
}
