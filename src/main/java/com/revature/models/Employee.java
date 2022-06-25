package com.revature.models;

import java.io.Serializable;

import java.util.Objects;

public class Employee implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
    private String email;
    private String password;
    private String title;




    public Employee() {
    }

    public Employee(int employeeId, String email, String password, String title) {
        this.employeeId = employeeId;
        this.email = email;
        this.password = password;
        this.title = title;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Objects.equals(email, employee.email) && Objects.equals(password, employee.password) && Objects.equals(title, employee.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, email, password, title);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employeeId +
                ", email='" + email + '\'' +
                ", pass_word='" + password + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

