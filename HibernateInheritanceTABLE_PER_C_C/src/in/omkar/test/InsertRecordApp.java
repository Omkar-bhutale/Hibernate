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
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("object saved to database");
			}else {
				
				transaction.rollback();
				System.out.println("object is not saved to data base");
			}
		
			HibernateUtil.closeSessionFactory();
		}
	}

}
/*
 * Hibernate: 
    
    create table CARDPAYMENT_TBSC (
       cardNo bigint,
        cardType varchar(255),
        paymentGateWay varchar(255),
        payment_id integer not null,
        primary key (payment_id)
    ) engine=InnoDB
Hibernate: 
    
    create table CHEQUEPAYMENT_TBSC (
       chequeNo bigint,
        chequeType varchar(255),
        expDate date,
        payment_id integer not null,
        primary key (payment_id)
    ) engine=InnoDB
Hibernate: 
    
    create table PAYMENT_TBSC (
       payment_mode varchar(31) not null,
        pid integer not null,
        amount float,
        primary key (pid)
    ) engine=InnoDB
Hibernate: 
    
    alter table CARDPAYMENT_TBSC 
       add constraint FK838tepgwlb8vred3wwo0gwmk0 
       foreign key (payment_id) 
       references PAYMENT_TBSC (pid)
Hibernate: 
    
    alter table CHEQUEPAYMENT_TBSC 
       add constraint FK45om4mwtw9lyr2celm1rgnt7a 
       foreign key (payment_id) 
       references PAYMENT_TBSC (pid)*/
/*
 * Hibernate: 
    insert 
    into
        PAYMENT_TBSC
        (amount, payment_mode, pid) 
    values
        (?, 'CARD', ?)
Hibernate: 
    insert 
    into
        CARDPAYMENT_TBSC
        (cardNo, cardType, paymentGateWay, payment_id) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        PAYMENT_TBSC
        (amount, payment_mode, pid) 
    values
        (?, 'CHEQUE', ?)
Hibernate: 
    insert 
    into
        CHEQUEPAYMENT_TBSC
        (chequeNo, chequeType, expDate, payment_id) 
    values
        (?, ?, ?, ?)
object saved to database */
