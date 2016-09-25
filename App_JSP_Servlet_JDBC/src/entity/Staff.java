package entity;

public class Staff {

	private Integer idstaff;
	private String name;
	private String regcod;
	private String maritalst;
	private String gender;
	private Double salary;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(Integer idstaff, String name, String regcod, String maritalst, String gender, Double salary) {
		super();
		this.idstaff = idstaff;
		this.name = name;
		this.regcod = regcod;
		this.maritalst = maritalst;
		this.gender = gender;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [idstaff=" + idstaff + ", name=" + name + ", regcod=" + regcod + ", maritalst=" + maritalst
	     	 + ", gender=" + gender + ", salary=" + salary + "]";
	}
	
	public Integer getIdstaff() {
		return idstaff;
	}

	public void setIdstaff(Integer idstaff) {
		this.idstaff = idstaff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegcod() {
		return regcod;
	}

	public void setRegcod(String regcod) {
		this.regcod = regcod;
	}

	public String getMaritalst() {
		return maritalst;
	}

	public void setMaritalst(String maritalst) {
		this.maritalst = maritalst;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
