package com.company;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;


/*
*This is the cost panel
* its used to display the all the cost calculations
 */
class CostPanel extends JPanel{

    JTextField cost_of_delivery_input ;
    JTextField cost_of_drinks_input ;
    JTextField cost_of_meal_input;

    CostPanel(){

        //Defined all the labels and initialized them
        JLabel cost_of_delivery = new JLabel("Cost of delivery");
        JLabel cost_of_drinks = new JLabel("Cost of Drinks");
        JLabel cost_of_meal = new JLabel("Cost of meal");

        //Set all they display text to 0.0 on the textfields at program start
        // and set them not to be editable by user
        cost_of_delivery_input = new JTextField(" R 0.0");
        cost_of_delivery_input.setEditable(false);

        cost_of_drinks_input = new JTextField(" R 0.0");
        cost_of_drinks_input.setEditable(false);

        cost_of_meal_input = new JTextField(" R 0.0");
        cost_of_meal_input.setEditable(false);

//-------------------------Layout and border --------------------------------------------------------------------
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        GroupLayout cost_panelLayout = new GroupLayout(this);
        this.setLayout(cost_panelLayout);
        cost_panelLayout.setHorizontalGroup(
            cost_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(cost_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cost_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cost_of_drinks)
                    .addComponent(cost_of_meal)
                    .addComponent(cost_of_delivery))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cost_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(cost_of_delivery_input, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addGroup(cost_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(cost_of_meal_input, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(cost_of_drinks_input)))
                .addContainerGap())
        );
        cost_panelLayout.setVerticalGroup(
            cost_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(cost_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cost_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cost_of_drinks)
                    .addComponent(cost_of_drinks_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cost_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cost_of_meal)
                    .addComponent(cost_of_meal_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cost_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cost_of_delivery)
                    .addComponent(cost_of_delivery_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}