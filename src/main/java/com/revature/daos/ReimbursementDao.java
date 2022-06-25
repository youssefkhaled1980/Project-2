package com.revature.daos;

import com.revature.models.Reimbursement;

import java.sql.SQLException;
import java.util.List;

public interface ReimbursementDao {

    public List<Reimbursement> getAllReimbursements();
    public boolean createReimbursement(String expenseAmount,String description ,String employeeId);


    public List<Reimbursement>getReimbursementsByStatus(String pending_status);
   // public List<Reimbursement>getReimbursementsByStatus();
    // these can be replaced with a single "getReimbursementsByStatus" method
  //  public List<Reimbursement> getPendingReimbursements();
    //public List<Reimbursement> getApprovedReimbursements();
    //public List<Reimbursement> getDeniedReimbursements();

    /*
        bonus user stories
     */
    public List<Reimbursement> getReimbursementsByEmployee(String employeeId) throws SQLException;

    public boolean updateReimbursement(String expenseId, String status);

}
