package in.omkar.modal;

import java.io.Serializable;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CHEQUE")
public class ChequePayment extends Payment implements Serializable {


	private static final long serialVersionUID = 1L;
	private Long chequeNo;
	private String chequeType;
	private LocalDate expDate;

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	public LocalDate getExpDate() {
		return expDate;
	}
  
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expDate=" + expDate + "]";
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
}
