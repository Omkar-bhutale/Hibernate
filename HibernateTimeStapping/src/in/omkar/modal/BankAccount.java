package in.omkar.modal;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accNO;
	private String holderName;
	private Double balance;
	private String type;
	@CreationTimestamp
	private LocalDateTime creationDateTime;
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDateTime;
	@Version
	private Integer count;
	@Override
	public String toString() {
		return "BankAccount [accNO=" + accNO + ", holderName=" + holderName + ", balance=" + balance + ", type=" + type
				+ ", creationDateTime=" + creationDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + ", count="
				+ count + "]";
	}
	/**
	 * @return the accNO
	 */
	public Long getAccNO() {
		return accNO;
	}
	/**
	 * @param accNO the accNO to set
	 */
	public void setAccNO(Long accNO) {
		this.accNO = accNO;
	}
	/**
	 * @return the holderName
	 */
	public String getHolderName() {
		return holderName;
	}
	/**
	 * @param holderName the holderName to set
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the creationDateTime
	 */
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}
	/**
	 * @param creationDateTime the creationDateTime to set
	 */
	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	/**
	 * @return the lastUpdatedDateTime
	 */
	public LocalDateTime getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}
	/**
	 * @param lastUpdatedDateTime the lastUpdatedDateTime to set
	 */
	public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
