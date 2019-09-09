package com.company;

import java.util.EventObject;

/*
*This class is created for events that occur in the button panel
* has two different constructor
* one for just passing the source of the event
* the other is for passing the source with data that is parsed by the source of event
 */
public class ButtonEvents extends EventObject {

    //private total variable of type string and its getter
    private String total;
    public String getTotal() {
        return total;
    }

    //private sub_total variable of type string and its getter
    private String sub_total;
    public String getSub_total() {
        return sub_total;
    }

    //Constructor
    ButtonEvents(Object source, String total, String sub_total){
        super(source);
        this.total = total;
        this.sub_total = sub_total;
    }

    //Constructor
    ButtonEvents(Object source ){
        super(source);
    }
}
