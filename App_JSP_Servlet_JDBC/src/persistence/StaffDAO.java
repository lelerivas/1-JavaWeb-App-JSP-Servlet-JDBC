package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Position;
import entity.Staff;

public class StaffDAO extends DAO{

	public void insert(Staff st) throws Exception{
		openConnection();
		stmt = conn.prepareStatement("INSERT INTO tbstaff values (null, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, st.getName());
		stmt.setString(2, st.getRegcod());
		stmt.setString(3, st.getMaritalst());
		stmt.setString(4, st.getGender());
		stmt.setInt(5,st.getPosition().getIdposition());
		
		stmt.execute();
		stmt.close();
		closeConnection();
	}
	
	public void delete(Integer cod) throws Exception{
		openConnection();
		stmt = conn.prepareStatement("DELETE FROM tbstaff WHERE idstaff = ? ");
		
		stmt.setInt(1,cod);
		
		stmt.execute();
		stmt.close();
		closeConnection();
	}
	
	public List<Staff> search() throws Exception{
		openConnection();
		stmt = conn.prepareStatement("SELECT idstaff, name, regcod, maritalst, gender, st.idposition, title, salary "
				+ "FROM tbstaff st INNER JOIN tbposition po ON st.idposition = po.idposition;");
		rs = stmt.executeQuery();
		
		List<Staff> list1 = new ArrayList<Staff>();
		while(rs.next()){
			Staff st  = new Staff(
						rs.getInt("idstaff"),
						rs.getString("name"),
						rs.getString("regcod"),
						rs.getString("maritalst"),
						rs.getString("gender"));
			
			Position po = new Position(
					null,
					rs.getString("title"),
					rs.getDouble("salary"));
			
			st.setPosition(po);
			list1.add(st);					
		}
		rs.close();
		stmt.close();
		closeConnection();
		return list1;	
	}	
	
	public Staff search(Integer cod) throws Exception{
		openConnection();
		stmt = conn.prepareStatement("SELECT idstaff, name, regcod, maritalst, gender, st.idposition, title, salary "
				+ "FROM tbstaff st INNER JOIN tbposition po ON st.idposition = po.idposition WHERE idstaff = ? ;");
		
		stmt.setInt(1,cod);

		rs = stmt.executeQuery();
		
		Staff st  = null;

		if(rs.next()){
			      st  = new Staff(
						rs.getInt("idstaff"),
						rs.getString("name"),
						rs.getString("regcod"),
						rs.getString("maritalst"),
						rs.getString("gender"));
			
			Position po = new Position(
					null,
					rs.getString("title"),
					rs.getDouble("salary"));
			st.setPosition(po);
		}
		rs.close();
		stmt.close();
		closeConnection();
		return st;	
	}	

	public void edit(Staff st) throws Exception{
		openConnection();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE tbstaff SET name = ?, regcod = ?, maritalst = ?, gender = ? ");
		
		if(st.getPosition()!=null){
			sb.append(", idposition = ? ");
		}
		
		sb.append(" Where idstaff = ? ");
		
		stmt = conn.prepareStatement(sb.toString());
		
		stmt.setString(1, st.getName());
		stmt.setString(2, st.getRegcod());
		stmt.setString(3, st.getMaritalst());
		stmt.setString(4, st.getGender());
		
		if(st.getPosition()!=null){
			stmt.setInt(5, st.getPosition().getIdposition());
			stmt.setInt(6, st.getIdstaff());
		}else{
			stmt.setInt(5, st.getIdstaff());
		}
		
		stmt.execute();
    	stmt.close();
		closeConnection();
	}		
	
}
