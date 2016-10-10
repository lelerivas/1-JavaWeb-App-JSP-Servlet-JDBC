package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Position;

public class PositionDAO extends DAO{
	public void insert(Position p) throws Exception{
		openConnection();
		stmt = conn.prepareStatement("INSERT INTO tbposition values (null, ?, ?)");
		
		stmt.setString(1, p.getTitle());
		stmt.setDouble(2, p.getSalary());
			
		stmt.execute();
		stmt.close();
		closeConnection();
		
	}
	
	public List<Position> search() throws Exception{
		openConnection();
		stmt = conn.prepareStatement("SELECT idposition, title, salary FROM tbposition ");
		rs = stmt.executeQuery();
		
		List<Position> list1 = new ArrayList<Position>();
		while(rs.next()){
			Position p  = new Position(
						rs.getInt("idposition"),
						rs.getString("title"),
						rs.getDouble("salary"));
			list1.add(p);					
		}
		rs.close();
		stmt.close();
		closeConnection();
		return list1;	
	}	
}
