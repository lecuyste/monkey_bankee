package com.monkey_bankee.gui;

import com.monkey_bankee.model.ClientTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class MainFrameEmployeePanel extends JFrame {

    private JButton action1Button;
    private JButton action2Button;
    private JButton action3Button;
    private JButton action4Button;
    private JTextField search;
    private JButton actionsearch;
    private JPanel JPanelClient;
    private ClientTable model;
    private JTable table12;
    private JScrollPane JscrollPanel5;
    private JPanel monPanel;
    private JButton action5Button;
    private JPanel JPanel13;
    private JButton exit;


    public MainFrameEmployeePanel() {


        add(JPanelClient);
        setTitle("MonkeyBankee | Panel");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        //Show table our clients
        action1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        //Show table our clients
        action2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                MainFrameTableClient tableClient = new MainFrameTableClient();
                tableClient.setVisible(true);

            }

        });


/*
        //show all clients of the bank
        action2Button.addActionListener(new ActionListener() {
            private JPanel JPanelClient;
            public ArrayList<Client> clients;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    initComponent();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            private void initComponent() throws SQLException {

                this.JPanelClient = new JPanel();
                clients = FactoryDAO.getClientDAO().getAllClient();
                model = new ClientTable();
                JTable table12 = new JTable(model);
                table12.requestFocus();
                table12.setBackground(Color.yellow);

                //JPanel13.add(table12);
                JPanel13.repaint();
                monPanel.add(JPanel13);

                //repaint();
               //revalidate();



            }
        });
*/

        //Add client
        action3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddClient addClient = new MainFrameAddClient();
                addClient.setVisible(true);

            }
        });


        //Add employee
        action4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddEmployee addEmployee = new MainFrameAddEmployee();
                addEmployee.setVisible(true);

            }
        });

        //Add employee
        action5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameTableEmployee tableEmployee = new MainFrameTableEmployee();
                tableEmployee.setVisible(true);

            }
        });


        //Add employee
        actionsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddEmployee addEmployee = new MainFrameAddEmployee();
                addEmployee.setVisible(true);

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
