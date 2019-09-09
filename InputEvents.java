package com.company;

import java.util.EventObject;
/*
 *This class is created for events that occur in the input panel
 * Constructor takes argument of event source and data produced by the source of type string
 *
 */
class InputEvents extends EventObject{

    private double value;

    public double getValue(){
        return value;
    }

    InputEvents(Object source, double value){
        super(source);
        this.value = value;
    }
}