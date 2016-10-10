package entity;

import java.util.List;

public class Position {
	
	private Integer idposition;
	private String title;
	private Double salary;
	
	private List<Staff> staff;
	
	public Position() {
		// TODO Auto-generated constructor stub
	}

	public Position(Integer idposition, String title, Double salary) {
		super();
		this.idposition = idposition;
		this.title = title;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Position [idposition=" + idposition + ", title=" + title + ", salary=" + salary + "]";
	}

	public Integer getIdposition() {
		return idposition;
	}

	public void setIdposition(Integer idposition) {
		this.idposition = idposition;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
}
