package com.monkey_bankee.model;

import com.monkey_bankee.dao.FactoryDAO;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientTable extends AbstractTableModel {

    private List<Client> clients;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String[] Titres = {
            "ID",
            "Nom Client",
            "Prenom Client",
            "Date de naissance",
            "Adresse Mail",
            "N° Telephone",
            "Situation maritale",
            "Adresse postal",
            "Date Création"
    };

    public ClientTable() {
        clients = new ArrayList<Client>();
        try {
            clients = FactoryDAO.getClientDAO().getAllClient();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return Titres.length;
    }

    @Override
    public String getColumnName(int col) {
        return Titres[col];
    }


    @Override
    public void setValueAt(Object value, int row, int col) {
        // TODO Auto-generated method stub
        if (col == 1) {
            clients.get(row).setName((String) value);
        } else if (col == 3) {
            clients.get(row).setBirthdate((String) value);
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        Client client = clients.get(row);
        switch (col) {
            case 0:
                return clients.get(row).getId();
            case 1:
                return clients.get(row).getName();
            case 2:
                return clients.get(row).getFirstname();
            case 3:
                return clients.get(row).getBirthdate();
            case 4:
                return clients.get(row).getEmail();
            case 5:
                return clients.get(row).getTel();
            case 6:
                return clients.get(row).getFamily_situation();
            case 7:
                return clients.get(row).getAddress_number() + " " + clients.get(row).getStreet_address() + " " + clients.get(row).getPostal_code() + " " + clients.get(row).getCity_address();
            case 8:
                return clients.get(row).getCreated_at();
            default:
                return "";
        }
    }
}