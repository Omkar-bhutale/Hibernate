package in.omkar.test;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.CardPayment;
import in.omkar.modal.ChequePayment;
import in.omkar.util.HibernateUtil;

public class InsertRecordApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			System.out.println(session);
			if (session != null) {

				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				CardPayment cardPayment = new CardPayment();
				cardPayment.setPid(1234);
				cardPayment.setAmount(8000.5f);

				cardPayment.setCardNo(45678L);
				cardPayment.setCardType("Debit");
				cardPayment.setPaymentGateWay("visa");

				ChequePayment chequePayment = new ChequePayment();
				chequePayment.setPid(12345);
				chequePayment.setAmount(4500.56f);

				chequePayment.setChequeType("self");
				chequePayment.setChequeNo(54634L);
				chequePayment.setExpDate(LocalDate.now());
				System.out.println("HI");
				session.save(cardPayment);
				System.out.println(1);
				session.save(chequePayment);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object saved to database");
			} else {

				transaction.rollback();
				System.out.println("object is not saved to data base");
			}

			HibernateUtil.closeSessionFactory();
		}
	}

}
/*
 * Hibernate:
 * 
 * create table CARDPAYMENT_TBCC ( pid integer not null, amount float, cardNo
 * bigint, cardType varchar(255), paymentGateWay varchar(255), primary key (pid)
 * ) engine=InnoDB Hibernate:
 * 
 * create table CHEQUEPAYMENT_TBCC ( pid integer not null, amount float,
 * chequeNo bigint, chequeType varchar(255), expDate date, primary key (pid) )
 * engine=InnoDB
 */
/*
 *HibernateUtil --> SessionFactory object is created
SessionImpl(844264574<open>)
HI
1
Hibernate: 
    insert 
    into
        CARDPAYMENT_TBCC
        (amount, cardNo, cardType, paymentGateWay, pid) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        CHEQUEPAYMENT_TBCC
        (amount, chequeNo, chequeType, expDate, pid) 
    values
        (?, ?, ?, ?, ?)
object saved to database */
