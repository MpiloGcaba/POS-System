package com.company;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
import javax.swing.event.EventListenerList;

/*
*This class hold the bottom buttons panel of the program
* it extends JPanel
* All the method and actions of the panel are defined here
 */

class BottomButtonPanel extends JPanel {

    private EventListenerList listenerList = new EventListenerList(); // An array of event listeners

    //Create JButton variables
    JButton reset;
    JButton receipt;
    JButton total;

    BottomButtonPanel(){ // Contructor when all data is initialized

        //declare and initializes the exit button
        //when this button is clicked it closes the application
        final JButton exit = new JButton("Exit");
        exit.addActionListener(
            (ActionEvent evt)-> {
                System.exit(0);
        });

        // initialize the reset button
        //fires ButtonListener method
        reset = new JButton("Reset");
        reset.addActionListener(
            (ActionEvent evt )-> { fireButtonEvent(new ButtonEvents(reset)); }
        );

        // initialize the receipt button
        //fires ButtonListener method
        receipt = new JButton("Receipt");
        receipt.addActionListener(
            (ActionEvent evt)->{ fireButtonEvent( new ButtonEvents(receipt) ); }
        );

        // initialize the reset button
        //fires ButtonListener method
        total = new JButton("Total");
        total.addActionListener(
            (ActionEvent evt)->{ fireButtonEvent(new ButtonEvents(total)); }
        );

        // Sets a black border around the panel
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));

        //Define the layout type
        //Define the horizontal and vertical laying out of components
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(total)
                .addGap(69, 69, 69)
                .addComponent(receipt)
                .addGap(71, 71, 71)
                .addComponent(reset)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(44, 44, 44)));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(reset)
                    .addComponent(receipt)
                    .addComponent(total))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }

    //This method take a Button event argument
    //loops through all the listener list at 2 step  to find the the corresponding class to fire event to the main thread
    private void fireButtonEvent(ButtonEvents event){
        Object[] lisObjects = listenerList.getListenerList();

        for(int i = 0 ; i < lisObjects.length; i +=2){
            if(lisObjects[i] == ButtonListener.class){
                ((ButtonListener)lisObjects[i+1]).ButtonEventOccurred(event);
            }
        }
    }

    //Use to add Listener class to list
    //Take Button Listener as argument
    void addButtonListener(ButtonListener listen_event){

        listenerList.add(ButtonListener.class, listen_event);
    }
}