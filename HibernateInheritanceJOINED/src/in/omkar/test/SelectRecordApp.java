package in.omkar.test;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.modal.CardPayment;
import in.omkar.modal.ChequePayment;
import in.omkar.modal.Payment;
import in.omkar.util.HibernateUtil;

public class SelectRecordApp {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			{
				if (session == null) {
					session = HibernateUtil.getSession();
				}

				Query<Payment> query = session.createQuery("from in.omkar.modal.Payment");
				List<Payment> list = query.list();
				list.forEach(System.out::println);
			}
			/*
			 * Hibernate: 
    select
        payment0_.pid as pid1_2_,
        payment0_.amount as amount2_2_,
        payment0_.cardNo as cardno1_0_,
        payment0_.cardType as cardtype2_0_,
        payment0_.paymentGateWay as paymentg3_0_,
        payment0_.chequeNo as chequeno1_1_,
        payment0_.chequeType as chequety2_1_,
        payment0_.expDate as expdate3_1_,
        payment0_.clazz_ as clazz_ 
    from
        ( select
            pid,
            amount,
            cardNo,
            cardType,
            paymentGateWay,
            null as chequeNo,
            null as chequeType,
            null as expDate,
            1 as clazz_ 
        from
            CARDPAYMENT_TBCC 
        union
        all select
            pid,
            amount,
            null as cardNo,
            null as cardType,
            null as paymentGateWay,
            chequeNo,
            chequeType,
            expDate,
            2 as clazz_ 
        from
            CHEQUEPAYMENT_TBCC 
    ) payment0_
CardPayment [cardNo=45678, cardType=Debit, paymentGateWay=visa]
ChequePayment [chequeNo=54634, chequeType=self, expDate=2024-06-11]
			 */
			
			System.out.println("////////////////////////////////////////////////////");
			{

				Query<CardPayment> query = session.createQuery("from in.omkar.modal.CardPayment");
				List<CardPayment> list = query.list();
				list.forEach(System.out::println);
			}
			/*
			 * Hibernate: 
    select
        cardpaymen0_.pid as pid1_2_,
        cardpaymen0_.amount as amount2_2_,
        cardpaymen0_.cardNo as cardno1_0_,
        cardpaymen0_.cardType as cardtype2_0_,
        cardpaymen0_.paymentGateWay as paymentg3_0_ 
    from
        CARDPAYMENT_TBCC cardpaymen0_
CardPayment [cardNo=45678, cardType=Debit, paymentGateWay=visa]
			 */
			System.out.println("////////////////////////////////////////////////////");
			{

				Query<ChequePayment> query = session.createQuery("from in.omkar.modal.ChequePayment");
				List<ChequePayment> list = query.list();
				list.forEach(System.out::println);

			}
			/*Hibernate: 
    select
        chequepaym0_.pid as pid1_2_,
        chequepaym0_.amount as amount2_2_,
        chequepaym0_.chequeNo as chequeno1_1_,
        chequepaym0_.chequeType as chequety2_1_,
        chequepaym0_.expDate as expdate3_1_ 
    from
        CHEQUEPAYMENT_TBCC chequepaym0_
ChequePayment [chequeNo=54634, chequeType=self, expDate=2024-06-11]
			 * 
			 */
			

		} catch (

		HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
		}
	}

}
