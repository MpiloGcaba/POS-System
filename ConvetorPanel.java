package com.company;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;

/*
*This is the class responsible for the converter panel.
* Here the user will get to convert they totals or any other amount to they native currency.
*
 */
class ConvetorPanel extends JPanel {

    // Create textfield variable
    private JTextField new_converted_total;
    private JTextField converting;
    
    ConvetorPanel(){

        converting = new JTextField();

        new_converted_total = new JTextField();

        JComboBox<String> countries = new JComboBox<>();
        countries.setModel(new DefaultComboBoxModel<String>(new String[] { "Canada", "USA", "London"}));

        JButton close = new  JButton("Close");
        close.addActionListener((ActionEvent evt)->{
            new_converted_total.setText(" R 0.0");
        });

        JButton convert = new  JButton("Convert");
        convert.addActionListener((ActionEvent evt)->{
            convert(countries);
        });
        //--------------------------------Layout and border----------------------------------------
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(convert)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(close))
                    .addComponent(new_converted_total, GroupLayout.Alignment.TRAILING)
                    .addComponent(converting, GroupLayout.Alignment.TRAILING)
                    .addComponent(countries, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(countries, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(converting, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(new_converted_total, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(convert)
                    .addComponent(close))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    //This method takes a checkbox as input
    // get the string from textbox and and converts it to new selected currency from the comboBox
    private void  convert(JComboBox comboBox){

        String total = converting.getText();
        double value = Double.parseDouble(total);

        String new_total;

        switch(comboBox.getSelectedItem().toString()){
            case "Canada":
                new_total = String.valueOf((value/10.86));
                new_converted_total.setText(String.format("C$ %.2s", new_total));
                break;

            case "USA" :
                new_total = String.valueOf((value/14.34));
                new_converted_total.setText(String.format("$ %.2s", new_total));
                break;

            case "London":
                new_total = String.valueOf((value/17.43));
                new_converted_total.setText(String.format("£ %.2s", new_total));
                break;
        }
    }
}