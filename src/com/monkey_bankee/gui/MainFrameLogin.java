package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.dao.HashDAO;
import com.monkey_bankee.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainFrameLogin extends JFrame {
    private JPanel JPanelLogin;
    private JTextField LoginTextField;
    private JPasswordField passwordField;
    private JButton connectButton;
    private JButton exit;


    public MainFrameLogin() {

        add(JPanelLogin);
        setTitle("MonkeyBankee | Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("assets/img/monkeybankee.png"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Employee employee = new Employee();
                HashDAO hash = new HashDAO();
                int idLogin;


                String email = LoginTextField.getText();
                String password = String.valueOf(passwordField.getPassword());;

                try {
                    employee = FactoryDAO.getEmployeeDAO().getByLogin(email);
                    String hashPasswordInput = hash.hashPassword(password);
                    if (hashPasswordInput.equals(employee.getPassword())) {
                        idLogin = FactoryDAO.getEmployeeDAO().saveId(employee.getEmployee_id());
                        JOptionPane.showMessageDialog(JPanelLogin, " Bonjour " + employee.getEmployee_prenom() + " " + employee.getEmployee_nom());
                        dispose();
                        MainFrameEmployeePanel employeePanel = new MainFrameEmployeePanel();
                        employeePanel.setVisible(true);
                    } else {
                        System.out.println("Mot de passe ou Mail incorrecte");
                        JOptionPane.showMessageDialog(JPanelLogin, "Mot de passe ou Mail incorrecte");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

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