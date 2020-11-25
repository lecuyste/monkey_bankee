package com.monkey_bankee.dao.impl;

import com.monkey_bankee.dao.HashDAO;
import com.monkey_bankee.model.Employee;
import com.monkey_bankee.dao.EmployeeDAO;
import com.monkey_bankee.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl extends DBUtil implements EmployeeDAO {

    public EmployeeDAOImpl() throws SQLException {
        super();
    }

    @Override
    public void addEmployee(Employee employee) {
        HashDAO hash = new HashDAO();
        String passwordHash = hash.hashPassword(employee.getPassword());

        try {
            String query = "INSERT INTO employee (name, firstname, city_bank, login, password, tel, created_at)" +
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?) ";

            // set all the preparedstatement parameters
            PreparedStatement st = getConnection().prepareStatement(query);
            st.setString(1, employee.getEmployee_nom());
            st.setString(2, employee.getEmployee_prenom());
            st.setString(3, employee.getEmployee_ville());
            st.setString(4, employee.getLogin());
            st.setString(5, passwordHash);
            st.setString(6, employee.getEmployee_tel());
            st.setTimestamp(7, new java.sql.Timestamp(new java.util.Date().getTime()));

            //st.executeUpdate();

            if (st.executeUpdate() == 1) {
                System.out.println("Employé(e) est créé..");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            String query = "SELECT * FROM employee";
            PreparedStatement st = getConnection().prepareCall(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                employees.add(transformSqlToEmployee(rs));
            }
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getByLogin(String Login) {
        Employee employee = new Employee();

        try {

            String sql = "SELECT * FROM public.employee WHERE login = ?";
            PreparedStatement pstmt = getConnection().prepareCall(sql);
            pstmt.setString(1, Login);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                employee = transformSqlToEmployee(rs);
            } else {
                System.out.println("Mail n'existe pas");
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return employee;
    }


    @Override
    public Employee getByIdEmployee(int id) {
        Employee employee = new Employee();
        try{
            String query = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement st = getConnection().prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                employee = transformSqlToEmployee(rs);
            }
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    public int saveId (int id){
        int idSave = id;
        return idSave;
    }


    @Override
    public boolean deleteEmployee(int id) {
        try{
            String query = "DELETE FROM employee  WHERE id = ?";
            PreparedStatement st = getConnection().prepareStatement(query);
            st.setInt(1, id);
            // ATTENTION PAS SELECT => executeUpdate();
            st.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private Employee transformSqlToEmployee(ResultSet rs) throws SQLException {

        Employee employee = new Employee();
        employee.setEmployee_id(rs.getInt("id"));
        employee.setEmployee_nom(rs.getString("name"));
        employee.setEmployee_prenom(rs.getString("firstname"));
        employee.setEmployee_ville(rs.getString("city_bank"));
        employee.setLogin(rs.getString("login"));
        employee.setPassword(rs.getString("password"));
        employee.setEmployee_tel(rs.getString("tel"));
        employee.setCreated_at(rs.getTimestamp("created_at"));

        return employee;
    }
}
