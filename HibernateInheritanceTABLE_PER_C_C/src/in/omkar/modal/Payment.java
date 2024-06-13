package in.omkar.modal;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_TBSC")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "payment_mode",discriminatorType = DiscriminatorType.STRING)//optional
public abstract class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Integer pid;
	private Float amount;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float f) {
		this.amount = f;
	}

	
}
