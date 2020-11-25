package com.monkey_bankee.gui;


import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.model.Client;
import com.monkey_bankee.model.ClientTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrameTableClient extends JFrame {

    private ArrayList<Client> clients;
    private JPanel panel;
    private JTable table;
    private ClientTable model;
    private JButton returnbutton;


    public MainFrameTableClient() {

        setTitle("MonkeyBankee | clients de la banque");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.clients = clients;
        try {
            initComponent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void initComponent() throws SQLException {
        this.panel = new JPanel(new BorderLayout());
        clients = FactoryDAO.getClientDAO().getAllClient();
        model = new ClientTable();
        table = new JTable(model);
        table.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.NORTH);
        this.returnbutton = new JButton("Retour");
        panel.add(this.returnbutton, BorderLayout.SOUTH);
        returnbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                MainFrameEmployeePanel employeePanel = new MainFrameEmployeePanel();
                employeePanel.setVisible(true);
            }
        });

        getContentPane().add(panel);
    }

    public MainFrameTableClient getThis() {
        return this;
    }


}
