package com.revature.servlets;


import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/submitreimbursement")
public class SubmitReimbrsement extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReimbursementDao reimbursementDAO = new ReimbursementDaoImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //declaring the parameters we want
        String expenseAmount = req.getParameter("expenseAmount");
        String description = req.getParameter("description");
        String employeeId = req.getParameter("employeeId");

        boolean successfulCreation = false;
        successfulCreation = reimbursementDAO.createReimbursement(expenseAmount,description,employeeId);
        if (successfulCreation) {
            resp.sendRedirect("/views/landing/success.html");
        } else {
            resp.sendRedirect("/views/landing/submitreimbursement.html");
        }

    }
}

