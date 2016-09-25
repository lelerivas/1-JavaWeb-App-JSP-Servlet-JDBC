package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Staff;

public class StaffDAO extends DAO {

	public void insert(Staff st) throws Exception{
		openConecction();
		stmt = conn.prepareStatement("INSERT INTO tbstaff VALUES(?,?,?,?,?,?)");  // id need to be autoincrement
		
		stmt.setString(1, null);
		stmt.setString(2, st.getName());
		stmt.setString(3, st.getRegcod());
		stmt.setString(4, st.getMaritalst());
		stmt.setString(5, st.getGender());
		stmt.setDouble(6, st.getSalary());
		
		stmt.execute();
		stmt.close();
		closeConecction();
		
	}

	public List<Staff> search() throws Exception{
		openConecction();
		stmt = conn.prepareStatement("SELECT idstaff,name,regcod,maritalst,gender,salary  FROM tbstaff");
		rs = stmt.executeQuery();
		
		List<Staff> list1 = new ArrayList<Staff>();
		while(rs.next()){
			Staff st = new Staff(
					rs.getInt("idstaff"),
					rs.getString("name"),
					rs.getString("regcod"),
					rs.getString("maritalst"),
					rs.getString("gender"),
					rs.getDouble("salary"));
			list1.add(st);
		}
		rs.close();
		stmt.close();
		closeConecction();
		return list1;		
	}
	
	
	
	
}
