package in.omkar.dto;

import java.io.Serializable
;
 public class InsurancePolicyDTO implements Serializable {

	private static final long serialVersionUID = 1L;
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
