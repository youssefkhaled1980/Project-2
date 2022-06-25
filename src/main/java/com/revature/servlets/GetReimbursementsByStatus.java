package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImp;
import com.revature.models.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns="/all_reimbursements")
public class GetReimbursementsByStatus extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectMapper om = new ObjectMapper();
    private ReimbursementDao reimbursementDao = new ReimbursementDaoImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("in the Reimbursement servlet doPost method");

       // Getting params from request object
        String pendingStatusParam = req.getParameter("status");

        //
        List<Reimbursement> reimbursementList;
        String reimbursementListJSON = "";
//customer.getEmail()==null || customer.getEmail().isEmpty()
        if (pendingStatusParam != null && !pendingStatusParam.isEmpty()) {
            reimbursementList = reimbursementDao.getReimbursementsByStatus(pendingStatusParam);
            reimbursementListJSON = om.writeValueAsString(reimbursementList);
        } else {
            reimbursementList = reimbursementDao.getAllReimbursements();
            // System.out.println("reimbursementList"+reimbursementList);
            // convert Java objects -> JSON
            reimbursementListJSON = om.writeValueAsString(reimbursementList);
            //System.out.println("reimbursementListJSON"+reimbursementListJSON);
        }
        // setting the content type header in our HTTP response
        resp.setHeader("Content-Type", "application/json");
        // write the JSON string to the response body
        try (PrintWriter pw = resp.getWriter()) {
            pw.write(reimbursementListJSON);
        }

    }
}