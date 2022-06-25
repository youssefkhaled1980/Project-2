package com.revature.daos;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDaoImp implements EmployeeDao{
     @Override
     public Employee getEmployeeByUsernameAndPassword(String email, String password) {
          String sql = "select * from employee where email = ? and password = ?";
          try (Connection c = ConnectionUtil.getConnection();
               PreparedStatement ps = c.prepareStatement(sql)){

               ps.setString(1, email);
               ps.setString(2, password);

               ResultSet rs = ps.executeQuery();
               Employee employee = new Employee();
               while(rs.next()) {
                    // iterate over each row of data, extracting the relevant fields
                    int employee_id = rs.getInt("employee_id");
                    String title = rs.getString("title");


                    // populate a customer object
                    employee = new Employee(employee_id, "", "", title);
               }
               return employee;

          } catch (SQLException e) {
               e.printStackTrace();
          }
          return null;
     }
     @Override
     public List<Employee> getAllEmployees(){return null;};
     @Override
     public List<Employee> getGeneralEmployees(){return null;};
     @Override
     public List<Employee> getManagerEmployees(){return null;};
}
