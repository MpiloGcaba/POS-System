package com.company;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.EventListenerList;
/*
*This class is created to hold the input panel
* data is manipulated
*
 */
class InputPanel extends JPanel  {

    //define  the  widgets that are going to show on the panel window
    JTextField chicken_burger_input;
    JTextField chicken_burger_meal_input;
    JTextField bacon_and_cheese_burger_input;

    JCheckBox tax;
    JCheckBox chicken_burger;
    JCheckBox bacon_and_cheese_burger;
    JCheckBox chicken_burger_meal;
    JCheckBox home_delivery;

    JComboBox<String> drinks;

    // Define the variable with they getters and setters
    //for data manipulation
    private  double meal_total;
    private double sub_total ;
    private double total ;

    public void setMeal_total(double meal_total) { this.meal_total = meal_total; }

    public void setSub_total(double sub_total) { this.sub_total = sub_total; }

    public void setTotal(double total) { this.total = total; }

    double getMealTotal(){
        return meal_total;
    }

    double getSubTotal() {
        return sub_total;
    }

    double getTotal() {
        return total;
    }

    List<Object> selectedItems = new ArrayList<>();// this is a array that holds checked check boxes for they to show on the receipt

    private EventListenerList listenerList = new EventListenerList(); //create and instantiate event listener

    InputPanel() {

        final JLabel drinksLabel = new JLabel("Drinks :");

        chicken_burger_input= new JTextField("0");
        chicken_burger_meal_input= new JTextField("0");
        bacon_and_cheese_burger_input= new JTextField("0");

        chicken_burger = new JCheckBox("Chicken Burger");
        chicken_burger.addActionListener((ActionEvent evt)->{
            isSelected(chicken_burger.isSelected(), chicken_burger_input);
            changeTotal(chicken_burger, chicken_burger_input);
        }); 
        
        chicken_burger_meal = new JCheckBox("Chicken burger meal");
        chicken_burger_meal.addActionListener((ActionEvent evt)->{
            isSelected(chicken_burger_meal.isSelected(), chicken_burger_meal_input);
            changeTotal(chicken_burger_meal, chicken_burger_meal_input);
        });

        bacon_and_cheese_burger = new JCheckBox("Bacon and cheese burger");
        bacon_and_cheese_burger.addActionListener((ActionEvent evt)->{
            isSelected(bacon_and_cheese_burger.isSelected(), bacon_and_cheese_burger_input);
            changeTotal(bacon_and_cheese_burger, bacon_and_cheese_burger_input);
        });
        
        tax = new JCheckBox("Tax");
        tax.addActionListener((ActionEvent evt)->{
            double taxValue = (15.0/100)*sub_total;
            if(tax.isSelected()){
                total+=(taxValue + sub_total);
                fireInputEvent(new InputEvents(tax,taxValue));
                selectedItems.add(selectedItems.size(),tax);
            }else{
                total-=taxValue;
                fireInputEvent(new InputEvents(tax, 0.0));
                selectedItems.remove(tax);}

        });

        home_delivery = new JCheckBox("Home delivery");
        home_delivery.addActionListener((ActionEvent evt)->{
            if(home_delivery.isSelected()){
                sub_total += StaticData.getDeliveryCost();
                total += sub_total;
                fireInputEvent(new InputEvents(home_delivery, StaticData.getDeliveryCost()));
                selectedItems.add(selectedItems.size(),home_delivery);

            }else{
                total -= sub_total;
                sub_total-=StaticData.getDeliveryCost();
                fireInputEvent(new InputEvents(home_delivery, 0.0));
                selectedItems.remove(home_delivery);}
        });

        //gets the selected item in a check box
        //fires an eventlistener for GUI updates
        drinks = new JComboBox<String>();
        drinks.setModel(new DefaultComboBoxModel<String>(new String[] {"Coke", "Coo-ee", "Blast", "Pepsi" }));
        drinks.addActionListener((ActionEvent evt)->{

            int chicken_burger_amount = Integer.parseInt(chicken_burger_input.getText());
            int chicken_burger_meal_amount = Integer.parseInt(chicken_burger_meal_input.getText());
            int  bacon_and_cheese_meal_amount = Integer.parseInt(bacon_and_cheese_burger_input.getText());

            double  value = chicken_burger_amount + chicken_burger_meal_amount + bacon_and_cheese_meal_amount ;

            switch(drinks.getSelectedItem().toString()){
                case "Coke":
                    value *= StaticData.getCoke();
                    fireInputEvent(new InputEvents(drinks, value));
                    break;

                case "Coo-ee":
                    value *= StaticData.getCooEe();
                    fireInputEvent(new InputEvents(drinks, value));
                    break;

                case "Blast":
                    value *= StaticData.getBlast();
                    fireInputEvent(new InputEvents(drinks, value));
                    break;

                case "Pepsi":
                    value *= StaticData.getPepsi();
                    fireInputEvent(new InputEvents(drinks, value));
                    break;
            }
            sub_total+=value;
        });
//---------------------------Layout and border --------------------------------------------------------------------------
        this.setBorder((Border) new LineBorder(new Color(0, 0, 0), 3, true));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tax)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home_delivery))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(drinksLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                    .addComponent(drinks, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(chicken_burger)
                        .addComponent(chicken_burger_meal)
                        .addComponent(bacon_and_cheese_burger))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(bacon_and_cheese_burger_input, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addComponent(chicken_burger_meal_input)
                        .addComponent(chicken_burger_input)
                    )))
            .addContainerGap())
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(chicken_burger)
                .addComponent(chicken_burger_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(chicken_burger_meal)
                .addComponent(chicken_burger_meal_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(bacon_and_cheese_burger)
                .addComponent(bacon_and_cheese_burger_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(drinksLabel)
                .addComponent(drinks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(home_delivery)
                .addComponent(tax))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
//----------------------------------------------------------------------------------------------------------------------
    // used to fire inputevent to save data
     private void fireInputEvent(InputEvents event){
         Object[] lisObjects = listenerList.getListenerList();

         for(int i = 0 ; i < lisObjects.length; i +=2){
             if(lisObjects[i] == InputListener.class){
               ((InputListener)lisObjects[i+1]).InputEventOccurred(event); 
             }
         }
     }

     //adds an input listener to notify observers
     void addInputListener(InputListener listen_event){
        listenerList.add(InputListener.class, listen_event);
    }

    // This method takes 2 arguments
    // one to is to get the source of the input
    //second is to get text from corresponding text field
    // this method manipulates the total value
    private void changeTotal(JCheckBox check_box, JTextField textField ){

        String amount = textField.getText();
        double amount_number = Double.parseDouble(amount); // get the string amount and changes it to double
        if(check_box.isSelected()){
            if(textField == chicken_burger_input){
                meal_total += (StaticData.CHICKEN_BURGER * amount_number);
                fireInputEvent(new InputEvents(chicken_burger,meal_total));
            }

            if(textField == chicken_burger_meal_input){
                meal_total += (StaticData.CHICKEN_BURGER_MEAL * amount_number);
                fireInputEvent(new InputEvents(chicken_burger_meal,meal_total));
            }

            if(textField == bacon_and_cheese_burger_input){
                meal_total += (StaticData.BACON_AND_CHEESE * amount_number);
                fireInputEvent(new InputEvents(bacon_and_cheese_burger,meal_total));
            }

        } sub_total = meal_total;

        if(!check_box.isSelected()) {
            sub_total -= meal_total;

            if (textField == chicken_burger_input) {
                meal_total -= (StaticData.CHICKEN_BURGER * amount_number);
                fireInputEvent(new InputEvents(chicken_burger, meal_total));
            }

            if (textField == chicken_burger_meal_input) {
                meal_total -= (StaticData.CHICKEN_BURGER_MEAL * amount_number);
                fireInputEvent(new InputEvents(chicken_burger_meal, meal_total));
            }

            if (textField == bacon_and_cheese_burger_input) {
                meal_total -= (StaticData.BACON_AND_CHEESE * amount_number);
                fireInputEvent(new InputEvents(bacon_and_cheese_burger, meal_total));
            }
        }
    }

    // This method checks if the textfield is selected or not and enables or disables if the corresponding checkbox is
    // is selected
    private void isSelected(boolean isSelected , JTextField textField){
        int value = Integer.parseInt(textField.getText());
        if(isSelected){
            textField.setEditable(false);
            if(value > 0 ){
                selectedItems.add(0,textField);
            }
        }else{
            textField.setEditable(true);
            selectedItems.remove(textField);
        }
    }
}