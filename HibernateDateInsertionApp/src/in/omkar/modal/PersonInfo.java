package in.omkar.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PersonInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private LocalDate dom;
	private LocalDateTime dob;
	private LocalTime doj;
	public PersonInfo() {
		System.out.println("PersonInfo.PersonInfo()");
		
	}
	/**
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * @return the dom
	 */
	public LocalDate getDom() {
		return dom;
	}
	/**
	 * @param dom the dom to set
	 */
	public void setDom(LocalDate dom) {
		this.dom = dom;
	}
	/**
	 * @return the dob
	 */
	public LocalDateTime getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	/**
	 * @return the doj
	 */
	public LocalTime getDoj() {
		return doj;
	}
	/**
	 * @param doj the doj to set
	 */
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", dom=" + dom + ", dob=" + dob + ", doj=" + doj + "]";
	}
	
	
	
}
