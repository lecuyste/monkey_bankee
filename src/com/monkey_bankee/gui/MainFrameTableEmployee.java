package com.monkey_bankee.gui;


import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.model.Employee;
import com.monkey_bankee.model.EmployeeTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrameTableEmployee extends JFrame {

    private ArrayList<Employee> employees;
    private JPanel panel;
    private JTable table;
    private EmployeeTable model;
    private JButton returnbutton;
    private JPanel rootPanel;
    private JPanel pane;
    private JButton retourAccueilButton;
    private JButton ajouterEmployeButton;
    private javax.swing.JScrollPane JScrollPane;


    public MainFrameTableEmployee() {
        setTitle("MonkeyBankee | Employées");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.employees = employees;
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
        ajouterEmployeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddEmployee addEmployee = new MainFrameAddEmployee();
                addEmployee.setVisible(true);
            }
        });
    }


    private void initComponent() throws SQLException {
        Color vert = new Color(50,181,55);
        //this.panel = new JPanel(new BorderLayout());
        employees = FactoryDAO.getEmployeeDAO().getAllEmployee();
        model = new EmployeeTable();
        table.setModel(model);
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

    /*public MainFrameTableEmployee getThis() {
        return this;
    }*/


}
