package com.monkey_bankee.model;

import com.monkey_bankee.dao.FactoryDAO;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable extends AbstractTableModel {
    //TEST TABLEAU


    private List<Employee> employees;
    private String[] Titres = {
            "ID",
            "Nom Employe",
            "Prenom Employe",
            "Ville Banque",
            "Adresse Mail",
            "N° Telephone",
            "Date Création"
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
    public boolean isCellEditable(int row, int col) {
        if (col == 1 || (col == 2))
            return false;
        return true;
    }

    @Override
    public void setValueAt(Object arg0, int row, int col) {
        // TODO Auto-generated method stub
        if (col == 1) {
            employees.get(row).setEmployee_nom((String) arg0);
        } else if (col == 3) {
            employees.get(row).setEmployee_ville((String) arg0);
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
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
                return employees.get(row).getCreated_at();
            default:
                return "";
        }
    }
}
