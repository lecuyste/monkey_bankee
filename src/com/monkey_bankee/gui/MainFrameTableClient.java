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
    private JPanel rootPanel;
    private JTable table;
    private ClientTable model;
    private JButton returnbutton;
    private JButton retourAccueilButton;
    private JScrollPane scrollpane;
    private JPanel pane;
    private JButton ajouterUnClientButton;


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
        retourAccueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameEmployeePanel employeePanel = new MainFrameEmployeePanel();
                employeePanel.setVisible(true);
            }
        });
        ajouterUnClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddClient addClient = new MainFrameAddClient();
                addClient.setVisible(true);
            }
        });
    }



    private void initComponent() throws SQLException {
        Color vert = new Color(50,181,55);
//        this.pane = new JPanel(new BorderLayout());
        clients = FactoryDAO.getClientDAO().getAllClient();
        model = new ClientTable();
        table.setModel(model);
//        table = new JTable(model);
        table.setOpaque(false);
        table.getTableHeader().setBackground(vert);
        table.getTableHeader().setForeground(new Color(0,0,0));
        table.setBackground(vert);
        table.setForeground(Color.WHITE);
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);
        pane.add(scrollPane, BorderLayout.CENTER);


        getContentPane().add(rootPanel);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    /*public MainFrameTableClient getThis() {
        return this;
    }*/


}
