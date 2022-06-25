package com.revature.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/updatereimbursementstatus")
public class UpdateReimbursementStatus extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectMapper om = new ObjectMapper();
    private ReimbursementDao reimbursementDAO = new ReimbursementDaoImp();
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String status = req.getParameter("status");
        String expenseId = req.getParameter("expenseId");
        // Create object Reimbursement
        // Reimbursement reimbursement = new Reimbursement();
        // update database table
         boolean result = reimbursementDAO.updateReimbursement(expenseId, status);
        if(result){
            System.out.println(" Success");
            resp.setStatus(201);
        } else {
            System.out.println(" failed");
            resp.setStatus(500);
        }

    }
	public ObjectMapper getOm() {
		return om;
	}
	public void setOm(ObjectMapper om) {
		this.om = om;
	}
}

