package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ReimbursementDaoImp implements ReimbursementDao{

    /*
        required user stories
     */
    @Override
    public List<Reimbursement> getAllReimbursements() {
            // create a connection to the database (using try with resources bc connection is Autocloseable)
            try (Connection connection = ConnectionUtil.getConnection();
                 // create a statement (set params if we need to)
                 // select * from customer
                 Statement statement = connection.createStatement()){

                // execute statement, get a resultset in return
                ResultSet resultSet = statement.executeQuery("select * from reimbursement");

                // creating list to store my customers when I get them from the db
                List<Reimbursement> reimbursement = new ArrayList<>();

                // create customer objects with what we get from the database (resultset)
                // get all of the fields from the records in our db and use them to populate a customer object
                while(resultSet.next()){
                    // get all data from the row
                    int expenseId = resultSet.getInt("expense_id");
                    double expenseAmount = resultSet.getDouble("expense_amount");
                    String pendingStatus = resultSet.getString("pending_status");
                    String description = resultSet.getString("description");
                    //int employeeId = resultSet.getInt("employee_id");
                    Reimbursement c = new Reimbursement(expenseId, expenseAmount, pendingStatus, description);

                    // add customer objects to a list
                    reimbursement.add(c);
                }

                // return list
                return reimbursement;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;

    };

    /**
     *
     * @param expenseAmount
     * @param description
     * @param employeeId
     * @return
     */
    @Override
    public boolean createReimbursement(String expenseAmount,String description ,String employeeId ){
        // if(reimbursement.getExpense_amount()== 0|| reimbursement.getExpense_id()==0);
        // return false;
        try(Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into reimbursement (expense_amount,description,employee_id) values (?, ?,?)")) {
            ps.setDouble(1,parseFloat(expenseAmount));
            ps.setString(2, description);
            ps.setInt(3, parseInt(employeeId));
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected==1){
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };

    /**
     *
     * @param pending_status
     * @return reimbursements
     */
    @Override
    // these can be replaced with a single "getReimbursementsByStatus" method
    public List<Reimbursement>getReimbursementsByStatus(String pending_status){
        // create a connection to the database (using try with resources bc connection is Autocloseable)
        String sql = "select * from reimbursement where pending_status = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             // we want to use a prepared statement so that we can parameterize the ?
             PreparedStatement ps = connection.prepareStatement(sql)){
             ps.setString(1, pending_status.toLowerCase());
             ResultSet rs = ps.executeQuery();
            // creating list to store my customers when I get them from the db
            List<Reimbursement> reimbursements= new ArrayList<>();
            // create reimbursement objects with what we get from the database (resultset)
            // get all of the fields from the records in our db and use them to populate a reimbursement object
            while(rs.next()){
                // get all data from the row
                int expense_id = rs.getInt("expense_id");
                double expense_amount = rs.getDouble("expense_amount");
                String status = rs.getString("pending_status");
                String description = rs.getString("description");

                Reimbursement reimbursement = new Reimbursement(expense_id, expense_amount, status, description);

                // add reimbursement objects to a list
                reimbursements.add(reimbursement);
            }
            // return list
            return reimbursements;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
        bonus user stories
     */
    @Override
    public List<Reimbursement> getReimbursementsByEmployee(String employeeId) throws SQLException {
        String sql = "select * from reimbursement where employee_id = ?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, parseInt(employeeId));
            ResultSet rs = ps.executeQuery();
            List<Reimbursement> reimbursements= new ArrayList<>();
            while(rs.next()){
                // get all data from the row
                int expense_id = rs.getInt("expense_id");
                double expense_amount = rs.getDouble("expense_amount");
                String status = rs.getString("pending_status");
                String description = rs.getString("description");
                Reimbursement myReimbursement = new Reimbursement(expense_id, expense_amount, status, description);
                // add customer objects to a list
                reimbursements.add(myReimbursement);
            }
            // return list
            return reimbursements;
    };

    @Override
    public boolean updateReimbursement(String expenseId, String status){

        try(Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("update reimbursement set pending_status = ? where expense_id = ?")) {
            ps.setString(1, status);
            ps.setInt(2, parseInt(expenseId));
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };

}
