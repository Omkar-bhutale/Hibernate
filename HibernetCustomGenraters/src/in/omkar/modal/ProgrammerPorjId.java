package in.omkar.modal;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProgrammerPorjId implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer projId;
	private Integer pid;
	@Override
	public String toString() {
		return "ProgrammerPorjId [projId=" + projId + ", pid=" + pid + "]";
	}
	/**
	 * @return the projId
	 */
	public Integer getProjId() {
		return projId;
	}
	/**
	 * @param projId the projId to set
	 */
	public void setProjId(Integer projId) {
		this.projId = projId;
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
	

}
