package in.omkar.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class MobileCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	private String cname;
	private Long monNo;
	private String callerTune;
	
	@Version
	private Integer versionCount;
	
	public Integer getVersionCount() {
		return versionCount;
	}
	
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	/**
	 * @return the cno
	 */
	public Integer getCno() {
		return cno;
	}
	
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the monNo
	 */
	public Long getMonNo() {
		return monNo;
	}
	/**
	 * @param monNo the monNo to set
	 */
	public void setMonNo(Long monNo) {
		this.monNo = monNo;
	}
	/**
	 * @return the callerTune
	 */
	public String getCallerTune() {
		return callerTune;
	}
	/**
	 * @param callerTune the callerTune to set
	 */
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	@Override
	public String toString() {
		return "MobileCustomer [cno=" + cno + ", cname=" + cname + ", monNo=" + monNo + ", callerTune=" + callerTune
				+ ", versionCount=" + versionCount + "]";
	}
	
	

}
