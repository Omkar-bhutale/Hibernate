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
			 * Hibernate: select payment0_.pid as pid2_2_, payment0_.amount as amount3_2_,
			 * payment0_1_.cardNo as cardno1_0_, payment0_1_.cardType as cardtype2_0_,
			 * payment0_1_.paymentGateWay as paymentg3_0_, payment0_2_.chequeNo as
			 * chequeno1_1_, payment0_2_.chequeType as chequety2_1_, payment0_2_.expDate as
			 * expdate3_1_, payment0_.payment_mode as payment_1_2_ from PAYMENT_TBSC
			 * payment0_ left outer join CARDPAYMENT_TBSC payment0_1_ on
			 * payment0_.pid=payment0_1_.payment_id left outer join CHEQUEPAYMENT_TBSC
			 * payment0_2_ on payment0_.pid=payment0_2_.payment_id
			 */
			System.out.println("////////////////////////////////////////////////////");
			{

				Query<CardPayment> query = session.createQuery("from in.omkar.modal.CardPayment");
				List<CardPayment> list = query.list();
				list.forEach(System.out::println);
			}
			/*
			 * Hibernate: select cardpaymen0_.payment_id as pid2_2_, cardpaymen0_1_.amount
			 * as amount3_2_, cardpaymen0_.cardNo as cardno1_0_, cardpaymen0_.cardType as
			 * cardtype2_0_, cardpaymen0_.paymentGateWay as paymentg3_0_ from
			 * CARDPAYMENT_TBSC cardpaymen0_ inner join PAYMENT_TBSC cardpaymen0_1_ on
			 * cardpaymen0_.payment_id=cardpaymen0_1_.pid CardPayment [cardNo=45678,
			 * cardType=Debit, paymentGateWay=visa]
			 */
			System.out.println("////////////////////////////////////////////////////");
			{

				Query<ChequePayment> query = session.createQuery("from in.omkar.modal.ChequePayment");
				List<ChequePayment> list = query.list();
				list.forEach(System.out::println);

			}
			/*
			 * Hibernate: select chequepaym0_.payment_id as pid2_2_, chequepaym0_1_.amount
			 * as amount3_2_, chequepaym0_.chequeNo as chequeno1_1_, chequepaym0_.chequeType
			 * as chequety2_1_, chequepaym0_.expDate as expdate3_1_ from CHEQUEPAYMENT_TBSC
			 * chequepaym0_ inner join PAYMENT_TBSC chequepaym0_1_ on
			 * chequepaym0_.payment_id=chequepaym0_1_.pid ChequePayment [chequeNo=54634,
			 * chequeType=self, expDate=2024-06-10]
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
