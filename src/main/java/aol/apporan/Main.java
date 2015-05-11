package aol.apporan;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by andrejs.olins on 2015.05.11..
 */
public class Main {

    public static final BigDecimal APPLE_PRICE = new BigDecimal(0.6).setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal ORANGE_PRICE = new BigDecimal(0.25).setScale(2, RoundingMode.HALF_UP);

    public static final String APPLE = "Apple";
    public static final String ORANGE = "Orange";


    public static void main(String[] args){
        System.out.println(calculatePrice(args));
    }

    public static BigDecimal calculatePrice(String[] list){

        if (list == null || list.length == 0) return new BigDecimal(0);
        BigDecimal sum = new BigDecimal(0);

        int apples = 0;
        int oranges = 0;

        for (String item: list){
            if (APPLE.equalsIgnoreCase(item)){
                apples++;
            }else if(ORANGE.equalsIgnoreCase(item)){
                oranges++;
            }
        }

        int applesOffer = apples / 2 + apples % 2;
        int orangesOffer = (oranges / 3) * 2 + oranges % 3;
        sum = APPLE_PRICE.multiply(new BigDecimal(applesOffer));
        sum = sum.add(ORANGE_PRICE.multiply(new BigDecimal(orangesOffer)));
        return sum.setScale(2, RoundingMode.HALF_UP);
    }
}
