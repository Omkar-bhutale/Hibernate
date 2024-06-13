package in.omkar.modal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

//Collection ==> List<>,Set<>,Map<k,v>
@Entity
@Table(name = "Employee_Collection")
public class Employee implements Serializable {

	private static final long serialVersionUID = -6338788397112702310L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private String eaddress;
	
	
	@ElementCollection
	@CollectionTable(name = "Emp_friends" ,joinColumns = @JoinColumn( name ="emp_id" ,referencedColumnName = "eid"))
	@Column(name = "Friends_Name")
	@OrderColumn(name = "Friends_no")
	@ListIndexBase(value = 1)
	private List<String> friendsList;
	
	
	@ElementCollection
	@CollectionTable(name = "Emp_Names" ,joinColumns = @JoinColumn(name = "emp_id",referencedColumnName = "eid"))
	@Column(name = "Mobile_No")
	private Set<Long> phones;
	
	@ElementCollection
	@CollectionTable(name ="Emp_Account",joinColumns = @JoinColumn(name = "emp_id",referencedColumnName = "eid"))
	@Column(name = "Account_number")//coumn for values
	@MapKeyColumn(name = "bankName" ,length = 10)
	private Map<String, Long> bankAccount;
	
	
	
	public Integer getEid() {
		return eid;
	}

	public List<String> getFriendsList() {
		return friendsList;
	}

	
	public void setFriendsList(List<String> friendsList) {
		this.friendsList = friendsList;
	}

	
	public Set<Long> getPhones() {
		return phones;
	}

	
	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}

	public Map<String, Long> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Map<String, Long> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", friendsList=" + friendsList
				+ ", phones=" + phones + ", bankAccount=" + bankAccount + "]";
	}
	
	

}
