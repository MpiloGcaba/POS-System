package com.company;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;


/*
* Main panel that runs all the panel events in EDT
* listeners change values here from whatever calculation that happen in the different panels

 */
public class Main extends JFrame{

    private Main(){
        initState();
    }

    private void initState(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InputPanel inputPanel = new InputPanel();
        ConvetorPanel convetor_panel = new ConvetorPanel();
        CostPanel cost_panel = new CostPanel();
        TotalsPanel totals_panel = new TotalsPanel();
        BottomButtonPanel button_panel = new BottomButtonPanel();
        ReceiptPanel receipt_panel = new ReceiptPanel();

        inputPanel.addInputListener(new InputListener(){
            @Override
            public void InputEventOccurred(InputEvents evt ) {
                
                double txt = evt.getValue();

                if(evt.getSource() == inputPanel.chicken_burger ||
                    evt.getSource() == inputPanel.chicken_burger_meal ||
                    evt.getSource() == inputPanel.bacon_and_cheese_burger) {

                    cost_panel.cost_of_meal_input.setText("R " + txt);
                }

                else if(evt.getSource() == inputPanel.drinks){
                    cost_panel.cost_of_drinks_input.setText("R " + txt); }

                else if(evt.getSource() == inputPanel.home_delivery ) {
                    cost_panel.cost_of_delivery_input.setText("R " + txt); }

                else if(evt.getSource() == inputPanel.tax) {
                    totals_panel.tax_input.setText("R " + txt); }

            }
        });

        button_panel.addButtonListener(new ButtonListener() {

            @Override
            public void ButtonEventOccurred(ButtonEvents evt) {

               if(evt.getSource() == button_panel.total){
                    String txt = evt.getTotal();
                    String value = evt.getSub_total();

                    totals_panel.sub_total_input.setText(value);
                    totals_panel.total_input.setText(txt);
               }

               if(evt.getSource() == button_panel.reset){

                   totals_panel.sub_total_input.setText("R 0.0");
                   totals_panel.total_input.setText("R 0.0");
                   totals_panel.tax_input.setText("R 0.0");

                   cost_panel.cost_of_drinks_input.setText("R 0.0");
                   cost_panel.cost_of_delivery_input.setText("R 0.0");
                   cost_panel.cost_of_meal_input.setText("R 0.0");

                   receipt_panel.textArea.setText(" ");

                   inputPanel.chicken_burger.setSelected(false);
                   inputPanel.chicken_burger_meal.setSelected(false);
                   inputPanel.bacon_and_cheese_burger.setSelected(false);
                   inputPanel.tax.setSelected(false);
                   inputPanel.home_delivery.setSelected(false);

                   inputPanel.chicken_burger_input.setText("0");
                   inputPanel.chicken_burger_meal_input.setText("0");
                   inputPanel.bacon_and_cheese_burger_input.setText("0");

                   inputPanel.chicken_burger_input.setEditable(true);
                   inputPanel.chicken_burger_meal_input.setEditable(true);
                   inputPanel.bacon_and_cheese_burger_input.setEditable(true);

                   inputPanel.setMeal_total(0.0);
                   inputPanel.setSub_total(0.0);
                   inputPanel.setTotal(0.0);

               }

               if(evt.getSource() == button_panel.receipt){
                   receipt_panel.textArea.setText(
                           "======== FOOD CITY========="+"\n\n\n"
                   );
                   for(int i=0 ; i<=inputPanel.selectedItems.size()-1; i++){
                       if(inputPanel.selectedItems.get(i) == inputPanel.chicken_burger_input){
                           receipt_panel.textArea.append("Chicken Burger   " + inputPanel.chicken_burger_input.getText() +"\t"+StaticData.CHICKEN_BURGER+ "\n\n\n");
                       }
                       else if(inputPanel.selectedItems.get(i) == inputPanel.chicken_burger_meal_input){
                           receipt_panel.textArea.append("Chicken Burger Meal   " + inputPanel.chicken_burger_meal_input.getText() +"\t"+StaticData.CHICKEN_BURGER_MEAL + "\n\n\n");
                       }
                       else if(inputPanel.selectedItems.get(i) == inputPanel.bacon_and_cheese_burger_input){
                           receipt_panel.textArea.append("Bacon Cheese Burger  "+ inputPanel.bacon_and_cheese_burger_input.getText() +"\t"+StaticData.BACON_AND_CHEESE+ "\n\n\n");
                       }
                       else if(inputPanel.selectedItems.get(i) == inputPanel.home_delivery){
                           receipt_panel.textArea.append("Delivery Cost  "+ inputPanel.chicken_burger_input.getText() +"\t"+StaticData.getDeliveryCost()+ "\n\n\n");
                       }

                   }
                   receipt_panel.textArea.append("Total" +"\t"+ (inputPanel.getTotal()-inputPanel.getSubTotal()));
               }

               if(evt.getSource() == button_panel.total){
                   String sub_total = String.valueOf(inputPanel.getSubTotal());
                   String total = String.valueOf(inputPanel.getTotal());
                   totals_panel.sub_total_input.setText(sub_total);
                   totals_panel.total_input.setText(total);
               }
            }
        });

        JLabel title = new JLabel();
        title.setText("Restuarent Management System");
        title.setFont(new Font("Tahoma", 1, 36));

        GroupLayout layout = new GroupLayout(this.getContentPane());
        getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cost_panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(convetor_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totals_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(button_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(receipt_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(title)
                ))
            .addContainerGap(22, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(title, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputPanel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(convetor_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(cost_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totals_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addComponent(receipt_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(27, Short.MAX_VALUE)
        )
    );
        pack();
    }

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(() -> {
           new Main().setVisible(true);
       });
    }
}
