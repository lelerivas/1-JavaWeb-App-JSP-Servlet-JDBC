package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Position;
import entity.Staff;
import persistence.PositionDAO;
import persistence.StaffDAO;


@WebServlet({"/staffcontrolcad","/staffcontrolcons","/staffcontroldel","/staffcontroledit"})
public class StaffControl  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verifyURL(request,response);		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verifyURL(request,response);		
	}
	
	protected void verifyURL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url= request.getServletPath();
		switch(url){
		case "/staffcontrolcad":
			registerStaff(request,response);
			break;
		case "/staffcontrolcons":
			consultStaff(request,response);	
			break;
		case "/staffcontroldel":
			deleteStaff(request,response);
			break;
		case "/staffcontroledit":
			consultStaff(request,response);
			break;
		default:
			break;
		}
	}
	
	protected void registerStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Staff st = new Staff();
			st.setName(request.getParameter("name"));
			st.setRegcod(request.getParameter("regcod"));
			st.setGender(request.getParameter("gender"));
			
			String maritalst = request.getParameter("maritalst");
			
			if(!maritalst.equals("")){
				st.setMaritalst(maritalst);
			}else{
				st.setMaritalst(request.getParameter("maritalst"));	
			}
			
			String idposition = request.getParameter("idposition");
			
			if(!idposition.equals("")){
				st.setPosition(new Position());
				st.getPosition().setIdposition(Integer.parseInt(request.getParameter("idposition")));
			}			
			
			StaffDAO stdao = new StaffDAO();
			String idstaff = request.getParameter("codstaff");
			if(idstaff==null){
				stdao.insert(st);
				request.setAttribute("message", "Staff has Inserted");
				consultStaff(request,response);
			}else{
				st.setIdstaff(Integer.parseInt(idstaff));
				stdao.edit(st);
				request.setAttribute("message", "Staff has edited");
				consultStaff(request,response);
			}
						
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "Problem: "+e.getMessage());
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	               
	protected void consultStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page;
		try{
			StaffDAO stdao = new StaffDAO();
			String cod = request.getParameter("id");
			if(cod==null){
				List<Staff> staff = stdao.search();
				request.setAttribute("liststaff", staff);
				page = "consult.jsp";				
			}else{
				request.setAttribute("staff", stdao.search(Integer.parseInt(cod)));
				PositionDAO posdao = new PositionDAO();
				List<Position> posi = posdao.search();
				request.setAttribute("listposition", posi);
				page = "edit.jsp";				
			}

		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "Problem: "+e.getMessage());
			page="index.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
	
	protected void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	//		Integer cod = Integer.parseInt(request.getParameter("cod"));
			
			String cod = request.getParameter("id");

			new StaffDAO().delete(Integer.parseInt(cod));
			request.setAttribute("message", "Staff has deleted.");
			consultStaff(request,response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "Problem: "+e.getMessage());
		}
	}
	
}
