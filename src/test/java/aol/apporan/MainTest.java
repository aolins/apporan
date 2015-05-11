package aol.apporan;

import java.math.BigDecimal;

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

        assertEquals(calculatePrice(new String[]{"Apple"}), new BigDecimal(0.6)); //one Apple
        assertEquals(calculatePrice(new String[]{"Orange"}), new BigDecimal(0.25)); //one Orange


    }
}