package controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Staff;
import persistence.StaffDAO;

@WebServlet("/Staffcontrol")
public class StaffControl extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String page;
	try{
		StaffDAO daost = new StaffDAO();
		List<Staff> staff = daost.search();
		request.setAttribute("liststaff", staff);
		page = "consult.jsp";
	}catch(Exception e){
		e.printStackTrace();
		request.getAttribute("message"+" Problem: "+e.getMessage());
		page = "index.jsp";
	}
	request.getRequestDispatcher(page).forward(request, response);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			Staff staff = new Staff();
			staff.setName(request.getParameter("name"));
			staff.setRegcod(request.getParameter("regcod"));
			staff.setGender(request.getParameter("gender"));
			staff.setMaritalst(request.getParameter("maritalst"));
			staff.setSalary(Double.parseDouble(request.getParameter("salary")));
			StaffDAO daost = new StaffDAO();
			daost.insert(staff);
			
			request.setAttribute("message", "Staff has registered.");	
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "Problem: "+e.getMessage());
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
