package in.omkar.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@FilterDef(name = "FILTER_ACCOUNTS_BY_STATUS" ,parameters = {
        @ParamDef(type="string" ,name ="status_type1"),
        @ParamDef(type="string" ,name ="status_type2")
})

@Filter(name = "FILTER_ACCOUNTS_BY_STATUS", condition = "status not in(:status_type1,:status_type2)")
public class BankAccount {
    @Id
    private int accno;
    private String holderName;
    private Float balance;
    private String status;

    public BankAccount() {
        System.out.println("Hibernate uses no-arg constructor");
    }

    public BankAccount(int accno, String holderName, Float balance, String status) {
        this.accno = accno;
        this.holderName = holderName;
        this.balance = balance;
        this.status = status;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankAccount [accno=" + accno + ", holderName=" + holderName + ", balance=" + balance + ", status=" + status + "]";
    }
}
