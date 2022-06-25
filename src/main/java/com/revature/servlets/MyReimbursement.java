package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImp;
import com.revature.models.Reimbursement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns="/my-reimbursements")
public class MyReimbursement extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReimbursementDao reimbursementDao = new ReimbursementDaoImp();
    private ObjectMapper om = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("employee_id");
        List<Reimbursement> reimbursementList;
        String reimbursementListJSON = "";
        if (idParam != null) {
            reimbursementList = reimbursementDao.getReimbursementsByStatus(idParam);
            reimbursementListJSON = om.writeValueAsString(reimbursementList);
        }
        resp.setHeader("Content-Type", "application/json");
        // write the JSON string to the response body
        try (PrintWriter pw = resp.getWriter()) {
            pw.write(reimbursementListJSON);
        }
    }
}