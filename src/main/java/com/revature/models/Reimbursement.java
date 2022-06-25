package com.revature.models;

import java.util.Objects;

public class Reimbursement {
    private int expenseId;
    private double expenseAmount;
    private String pendingStatus;
    private String description;
    private int employeeId;

    public Reimbursement(){
    }

    public Reimbursement(int expenseId, double expenseAmount, String pendingStatus, String description) {
        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.pendingStatus = pendingStatus;
        this.description = description;
    }

    public int getEmployeeId() {
    	return employeeId;}

    public void setEmployeeId(int employeeId) {
    	this.employeeId = employeeId;}

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getPendingStatus() {
        return pendingStatus;
    }

    public void setPendingStatus(String pendingStatus) {
        this.pendingStatus = pendingStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return expenseId == that.expenseId && Double.compare(that.expenseAmount, expenseAmount) == 0 && Objects.equals(pendingStatus, that.pendingStatus) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, expenseAmount, pendingStatus, description);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "expense_id=" + expenseId +
                ", expense_amount=" + expenseAmount +
                ", pending_status='" + pendingStatus + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
