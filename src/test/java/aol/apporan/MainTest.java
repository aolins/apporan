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

        assertEquals(calculatePrice(generate(1,0)),Main.APPLE_PRICE); // 1 apple =1
        assertEquals(calculatePrice(generate(2, 0)),Main.APPLE_PRICE); // 2 apples=1
        assertEquals(calculatePrice(generate(3,0)),roundScale(1.2)); // 3 apples=2
        assertEquals(calculatePrice(generate(4,0)),roundScale(1.2)); // 4 apples=2
        assertEquals(calculatePrice(generate(5,0)),roundScale(1.8)); // 5 apples=3
        assertEquals(calculatePrice(generate(6,0)),roundScale(1.8)); // 6 apples=3

        assertEquals(calculatePrice(generate(0,1)),roundScale(0.25)); // 1 orange =1
        assertEquals(calculatePrice(generate(0,2)),roundScale(0.5)); // 2 oranges=2
        assertEquals(calculatePrice(generate(0,3)),roundScale(0.5)); // 3 oranges=2
        assertEquals(calculatePrice(generate(0,4)),roundScale(0.75)); // 4 oranges=3
        assertEquals(calculatePrice(generate(0,5)),roundScale(1)); // 5 oranges=4
        assertEquals(calculatePrice(generate(0,6)),roundScale(1)); // 6 oranges=4


        assertEquals(calculatePrice(generate(1,1)),roundScale(0.85)); // 1,1 = 1,1
        assertEquals(calculatePrice(generate(2,1)),roundScale(0.85)); // 2,1 = 1,1

        assertEquals(calculatePrice(generate(2,2)),roundScale(0.6 + 0.25*2)); // 2,2 = 1,2
        assertEquals(calculatePrice(generate(1,2)),roundScale(0.6 + 0.25*2)); // 1,2 = 1,2

        assertEquals(calculatePrice(generate(1,3)),roundScale(0.6 + 0.25 * 2)); // 1,3 = 1,2
        assertEquals(calculatePrice(generate(2,3)),roundScale(0.6 + 0.25 * 2)); // 2,3 = 1,2

        assertEquals(calculatePrice(generate(200,300)),roundScale(0.6 * 100 + 0.25 * 200)); // 200,300 = 100,200
        assertEquals(calculatePrice(generate(201,300)),roundScale(0.6 * 101 + 0.25 * 200)); // 200,300 = 100,200
        assertEquals(calculatePrice(generate(201,301)),roundScale(0.6 * 101 + 0.25 * 201)); // 200,300 = 100,200
        assertEquals(calculatePrice(generate(201,302)),roundScale(0.6 * 101 + 0.25 * 202)); // 200,300 = 100,200
        assertEquals(calculatePrice(generate(201,303)),roundScale(0.6 * 101 + 0.25 * 202)); // 200,300 = 100,200


        assertEquals(calculatePrice(generate(202,300)),roundScale(0.6 * 101 + 0.25 * 200)); // 200,300 = 100,200
        assertEquals(calculatePrice(generate(202,301)),roundScale(0.6 * 101 + 0.25 * 201)); // 200,300 = 100,200
        assertEquals(calculatePrice(generate(202,302)),roundScale(0.6 * 101 + 0.25 * 202)); // 200,300 = 100,200
        assertEquals(calculatePrice(generate(202,303)),roundScale(0.6 * 101 + 0.25 * 202)); // 200,300 = 100,200

    }

    private static BigDecimal roundScale(double input){
        return new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
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