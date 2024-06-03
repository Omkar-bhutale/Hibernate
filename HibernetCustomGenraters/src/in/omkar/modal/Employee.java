package in.omkar.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



@Entity

public class Employee {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "gen1" , strategy = "in.omkar.idgenerator.EmployeeIdGenrater")
	@GeneratedValue(generator = "gen1")
	private Integer eid;
	private String ename;
	private Integer esalary;


	/**
	 * @return the eid
	 */
	public Integer getEid() {
		return eid;
	}
	/**
	 * @param eid the eid to set
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the esalary
	 */
	public Integer getEsalary() {
		return esalary;
	}
	/**
	 * @param esalary the esalary to set
	 */
	public void setEsalary(Integer esalary) {
		this.esalary = esalary;
	}
	
	

	
}
