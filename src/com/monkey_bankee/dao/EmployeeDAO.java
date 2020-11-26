package com.monkey_bankee.dao;

import java.util.ArrayList;

import com.monkey_bankee.model.Employee;

public interface EmployeeDAO {

    public  void addEmployee(Employee employee);
    public  Employee getByIdEmployee(int id);
    public  int saveId(int id);
    public  boolean deleteEmployee(int id);
    public ArrayList<Employee> getAllEmployee();
    public  Employee getByLogin (String Login);

}
