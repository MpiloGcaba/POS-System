package com.company;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;

/*
* defines the totals panel
* all it does is just set the layout and set the values to 0.0 at program start
 */
class TotalsPanel extends JPanel {

    JTextField sub_total_input;
    JTextField tax_input;
    JTextField total_input ;

    TotalsPanel(){

        sub_total_input = new JTextField("0.0");
        sub_total_input.setEnabled(false);
        
        tax_input = new JTextField("0.0");
        tax_input.setEnabled(false);

        total_input = new JTextField("0.0");
        total_input.setEditable(false);

        JLabel sub_total = new JLabel("Sub Total :");
        JLabel tax = new JLabel("Tax :");
        JLabel total = new JLabel("Total :");

//-----------------------Layout and border-----------------------------------------------------------------
        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        GroupLayout totals_panelLayout = new GroupLayout(this);
        this.setLayout(totals_panelLayout);
        totals_panelLayout.setHorizontalGroup(
            totals_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(totals_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totals_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(totals_panelLayout.createSequentialGroup()
                        .addComponent(sub_total)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sub_total_input, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, totals_panelLayout.createSequentialGroup()
                        .addComponent(tax)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tax_input, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, totals_panelLayout.createSequentialGroup()
                        .addComponent(total)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total_input, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        totals_panelLayout.setVerticalGroup(
            totals_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(totals_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totals_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_total)
                    .addComponent(sub_total_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(totals_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tax_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tax))
                .addGap(18, 18, 18)
                .addGroup(totals_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(total_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(total))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}