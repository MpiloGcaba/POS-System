package com.company;

import java.util.EventListener;

//interface that Listens to all event that happened in the input panel

public interface InputListener extends EventListener{

    public void InputEventOccurred(InputEvents evt);
}