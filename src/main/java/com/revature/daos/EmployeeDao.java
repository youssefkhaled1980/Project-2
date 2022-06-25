package com.revature.daos;

import com.revature.models.Employee;

import java.util.List;

public interface EmployeeDao {

    /*
        required user stories
     */
    public Employee getEmployeeByUsernameAndPassword(String email, String password) ;



   public List<Employee> getAllEmployees();
    public List<Employee> getGeneralEmployees();
    public List<Employee> getManagerEmployees();

}
