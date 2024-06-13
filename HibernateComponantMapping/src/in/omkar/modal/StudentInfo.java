package in.omkar.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentInfo implements Serializable {
	private static final long serialVersionUID = -1969352989175310748L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	@Column(length = 20)
	private String sname;
	private Integer sage;
	@Embedded
	private AddressInfo addressInfo;

	public StudentInfo() {
		super();
	}

	public StudentInfo(Integer sid, String sname, Integer sage, AddressInfo addressInfo) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.addressInfo = addressInfo;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

}
