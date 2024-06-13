package in.omkar.modal;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CARDPAYMENT_TBCC")
public class CardPayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long cardNo;
	private String cardType;
	private String paymentGateWay;

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateWay=" + paymentGateWay + "]";
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGateWay() {
		return paymentGateWay;
	}
	public void setPaymentGateWay(String paymentGateWay) {
		this.paymentGateWay = paymentGateWay;
	}



}
