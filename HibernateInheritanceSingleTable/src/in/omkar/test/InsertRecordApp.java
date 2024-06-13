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
				System.out.println("transection obj created"+transaction);
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
				System.out.println(2);
				session.save(cardPayment);
				session.save(chequePayment);
				flag=true;
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
