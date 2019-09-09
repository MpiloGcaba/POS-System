package com.company;

import java.util.EventListener;


//This is an interface for button events that have occurred
public interface ButtonListener extends EventListener {

    public void ButtonEventOccurred(ButtonEvents evt);
}
