package com.company;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

//Defines a tabbed panel that displays a receipt
class ReceiptPanel extends JPanel{

    JTextArea textArea = new JTextArea();

    ReceiptPanel() {

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel receipt_panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        JPanel calc_panel = new JPanel();

        this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));

        tabbedPane.setName(""); // NOI18N

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        //------------------------Layout and border---------------------------------------------------------------------
        GroupLayout jPanel2Layout = new GroupLayout(receipt_panel);
        receipt_panel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Receipt", receipt_panel);
        tabbedPane.getAccessibleContext().setAccessibleName("Receipt");

        GroupLayout jPanel3Layout = new GroupLayout(calc_panel);
        calc_panel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 221, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Calculator", calc_panel);

        GroupLayout jPanel1Layout = new GroupLayout(this);
        this.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabbedPane)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tabbedPane)
                                .addContainerGap())
        );
    }
}