package com.company;

/**
 * This class is built for Data that doesn't change through out the app
 * these are all the prices.
 */

public class StaticData{

    static final double  CHICKEN_BURGER = 35.0;
    static final double  CHICKEN_BURGER_MEAL = 50.0;
    static final double  BACON_AND_CHEESE = 50.0;

    private static final double COKE = 12.0;
     static double getCoke() {
        return COKE;
    }

    private static final double PEPSI = 10.0;
    static double getPepsi() {
        return PEPSI;
    }

    private static final double COO_EE = 8.0;
     static double getCooEe() {
        return COO_EE;
    }

    private static final double BLAST = 5.0;
     static double getBlast() {
            return BLAST;
    }

    private static final double DELIVERY_COST = 10.0;
     public static double getDeliveryCost() {
        return DELIVERY_COST;
    }


}