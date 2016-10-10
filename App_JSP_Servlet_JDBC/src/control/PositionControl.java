package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Position;
import persistence.PositionDAO;

	@WebServlet({"/positioncontrol","/newstaff"})
    public class PositionControl  extends HttpServlet{

		private static final long serialVersionUID = 1L;
		
		public PositionControl() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String page = null;
			try{
				PositionDAO pdao = new PositionDAO();
				List<Position> position = pdao.search();
				request.setAttribute("listposition", position);		
				
				String url = request.getServletPath();
				if(url.equals("/positioncontrol")){
				   page = "registrationposition.jsp";
				}else if(url.equals("/newstaff")){
				   page = "registrationstaff.jsp";
				}	   
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("message", "Problem: "+e.getMessage());
				page="index.jsp";
			}
			request.getRequestDispatcher(page).forward(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				Position p = new Position();
				p.setTitle(request.getParameter("title"));
				p.setSalary(Double.parseDouble(request.getParameter("salary")));
								
				PositionDAO pdao = new PositionDAO();
				pdao.insert(p);
				
				request.setAttribute("message", "Position has registrered");
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("message", "Problem: "+e.getMessage());
			}
			
			doGet(request, response);
				
		}
}
