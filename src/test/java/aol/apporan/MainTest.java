package aol.apporan;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;
import static aol.apporan.Main.calculatePrice;

/**
 * Created by andrejs.olins on 2015.05.11..
 */
public class MainTest {

    @org.junit.Test
    public void testCalculatePrice() throws Exception {
        assertEquals(calculatePrice(null), new BigDecimal(0)); //nothing provided
        assertEquals(calculatePrice(new String[]{}), new BigDecimal(0)); //empty array provided

        assertEquals(calculatePrice(new String[]{"Apple"}), Main.APPLE_PRICE); //one Apple
        assertEquals(calculatePrice(new String[]{"Orange"}), Main.ORANGE_PRICE); //one Orange




        assertEquals(calculatePrice(generate(10,10)),
                new BigDecimal(10 * 0.6 + 0.25 * 10).setScale(2, RoundingMode.HALF_UP)); //10 apples, 10 oranges);

        assertEquals(calculatePrice(generate(100,100)),
                new BigDecimal(100 * 0.6 + 0.25 * 100).setScale(2, RoundingMode.HALF_UP)); //10 apples, 10 oranges);


        assertEquals(calculatePrice(generate(12345,54321)),
                new BigDecimal(12345 * 0.6 + 0.25 * 54321).setScale(2, RoundingMode.HALF_UP)); //10 apples, 10 oranges);

    }

    private static String[] generate(int apples, int oranges){
        String[] result = new String[apples+oranges];
        for (int i = 0; i < apples; i++) {
            result[i]= Main.APPLE;
        }
        for (int i = 0; i < oranges; i++) {
            result [i+apples] = Main.ORANGE;
        }
        return result;
    }
}