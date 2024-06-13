package in.omkar.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@NamedQuery(name = "GET_POLICIES_COUNT", query = "select count(*) from in.omkar.modal.InsurancePolicy")
@NamedQuery(name = "GET_ALL_POLICIES", query = "from in.omkar.modal.InsurancePolicy")
public class InsurancePolicy implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer policyId;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenuare;
	/**
	 * @return the policyId
	 */
	public Integer getPolicyId() {
		return policyId;
	}
	/**
	 * @param policyId the policyId to set
	 */
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	/**
	 * @return the policyName
	 */
	public String getPolicyName() {
		return policyName;
	}
	/**
	 * @param policyName the policyName to set
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	/**
	 * @return the policyType
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * @param policyType the policyType to set
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the tenuare
	 */
	public Integer getTenuare() {
		return tenuare;
	}
	/**
	 * @param tenuare the tenuare to set
	 */
	public void setTenuare(Integer tenuare) {
		this.tenuare = tenuare;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "InsurcancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenuare=" + tenuare + "]";
	}
	

}
