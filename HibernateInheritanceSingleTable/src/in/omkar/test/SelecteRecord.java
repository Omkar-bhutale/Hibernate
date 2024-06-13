package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.modal.CardPayment;
import in.omkar.modal.ChequePayment;
import in.omkar.modal.Payment;
import in.omkar.util.HibernateUtil;

public class SelecteRecord {
	@SuppressWarnings("unchecked")
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
			{
				Query<Payment> query = session.createQuery("from in.omkar.modal.Payment");

				List<Payment> resultList = query.getResultList();
				System.out.println(resultList.size());
				resultList.forEach(System.out::println);
			}
			{
				Query<CardPayment> query = session.createQuery("from in.omkar.modal.CardPayment");
				List<CardPayment> resultList = query.getResultList();
				System.out.println(resultList.size());
				resultList.forEach(System.out::println);
			}
			{
				Query<ChequePayment> query = session.createQuery("from in.omkar.modal.ChequePayment");
				List<ChequePayment> resultList = query.getResultList();
				System.out.println(resultList.size());
				resultList.forEach(System.out::println);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
		}
	}

}
