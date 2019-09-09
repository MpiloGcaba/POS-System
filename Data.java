package com.company.data;

import com.company.StaticData;

import java.util.Observable;

public class Data extends Observable {

    // meal total
    private double meal_total ;
    public void setMeal_total(double meal_total){
        this.meal_total = meal_total;
        setChanged();
        notifyObservers();
    }


    // tax total.
    double tax_amount ;

    double drinks_total ;

    double sub_total = meal_total + drinks_total + StaticData.getDeliveryCost();

    double total = sub_total + tax_amount;

    public Data(){}

    public Data(double meal_total, double tax_amount, double drinks_total){

        this.meal_total = meal_total;
        this.tax_amount = tax_amount;
        this.drinks_total = drinks_total;

        this.sub_total = meal_total + drinks_total;

        this.total = sub_total + tax_amount;

    }
}
