package com.monkey_bankee.model;

import com.monkey_bankee.dao.FactoryDAO;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable extends AbstractTableModel {
    //TEST TABLEAU


    private List<Employee> employees;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String[] Titres = {
            "ID",
            "Nom Employe",
            "Prenom Employe",
            "Ville Banque",
            "Adresse Mail",
            "N° Telephone",
            " "

    };

    public EmployeeTable() {
        employees = new ArrayList<Employee>();
        try {
            employees = FactoryDAO.getEmployeeDAO().getAllEmployee();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return employees.size();
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
            employees.get(row).setEmployee_nom((String) value);
        } else if (col == 3) {
            employees.get(row).setEmployee_ville((String) value);
        }
        fireTableCellUpdated(row, col);
    }

    @Override
    public Object getValueAt(int row, int col) {
        Employee employee = employees.get(row);
        switch (col) {
            case 0:
                return employees.get(row).getEmployee_id();
            case 1:
                return employees.get(row).getEmployee_nom();
            case 2:
                return employees.get(row).getEmployee_prenom();
            case 3:
                return employees.get(row).getEmployee_ville();
            case 4:
                return employees.get(row).getLogin();
            case 5:
                return employees.get(row).getEmployee_tel();
            case 6:
                return "Ici boutton" ;
            default:
                return "";
        }
    }
}

