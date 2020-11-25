package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.dao.HashDAO;
import com.monkey_bankee.model.Client;
import com.monkey_bankee.model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class MainFrameAddClient extends JFrame {
    private JPanel JPanelAddClient;
    private JTextField Name;
    private JTextField firstName;
    private JTextField birthdayDate;
    private JTextField mail;
    private JTextField phoneNumber;
    private JTextField adressNumber;
    private JTextField adress;
    private JTextField adressAdd;
    private JTextField zip;
    private JTextField city;
    private JButton register;
    private JTextField situationFamily;
    private JLabel JLabelError;
    private JTextField currentAccount;
    private JTextField regularIncome;
    private JTextField regularSpending;
    private JTextField sub;
    private JButton retourButton;

    public MainFrameAddClient() {
        add(JPanelAddClient);
        setTitle("MonkeyBankee | Ajouter un client");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //retourn
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameEmployeePanel employeePanel = new MainFrameEmployeePanel();
                employeePanel.setVisible(true);

            }

        });

        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Client client = new Client();

                Date date_util = new Date();
                java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

                String name = Name.getText();
                String firstname = firstName.getText();
                String birthday = birthdayDate.getText();
                String email = mail.getText();
                String mobile = phoneNumber.getText();
                String family = situationFamily.getText();
                String account = currentAccount.getText();
                String regin = regularIncome.getText();
                String regsp = regularSpending.getText();
                String subs = sub.getText();
                String numberAdress = adressNumber.getText();
                String adresss = adress.getText();
                String adressad = adressAdd.getText();
                String nzip = zip.getText();
                String cty = city.getText();




                if (name.isEmpty() || firstname.isEmpty() || birthday.isEmpty() || email.isEmpty() || mobile.isEmpty() || family.isEmpty() || account.isEmpty() || regin.isEmpty() || regsp.isEmpty() || subs.isEmpty() || numberAdress.isEmpty() || adresss.isEmpty() || adressad.isEmpty() || nzip.isEmpty() || cty.isEmpty() ){
                    JLabelError.setText("Veuillez remplir tous les champs");
                    setVisible(true);

                } else {
                    client.setName(name);
                    client.setFirstname(firstname);
                    client.setBirthdate(birthday);
                    client.setEmail(email);
                    client.setTel(mobile);
                    client.setFamily_situation(family);
                    client.setCurrent_account(account);
                    client.setRegular_income(regin);
                    client.setRegular_spending(regsp);
                    client.setSubscription(subs);
                    client.setAddress_number(numberAdress);
                    client.setStreet_address(adresss);
                    client.setAdditional_address(adressad);
                    client.setPostal_code(nzip);
                    client.setCity_address(cty);
                    client.setCreated_at(new java.sql.Timestamp(new java.util.Date().getTime()));


                        try {

                            FactoryDAO.getClientDAO().addClient(client);
                            JOptionPane.showMessageDialog(JPanelAddClient, "Client(e) ajouté(e)");
                            dispose();
                            MainFrameEmployeePanel employeePanel = new MainFrameEmployeePanel();
                            employeePanel.setVisible(true);


                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }



                    }
                }

        });
    }


}
