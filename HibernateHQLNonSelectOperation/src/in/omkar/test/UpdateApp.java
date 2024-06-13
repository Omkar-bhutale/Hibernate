package in.omkar.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.util.HibernateUtil;

public class UpdateApp {

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			if (session != null && transaction!=null) {
				//Query query = session.createQuery("UPDATE in.omkar.modal.Student set address = :addr WHERE id =:sid ");
				//Query query = session.createQuery("UPDATE in.omkar.modal.Student set address = :addr WHERE id =:id ");
				Query query = session.createQuery("UPDATE in.omkar.modal.Student set address = :addr WHERE name like :name ");

				query.setParameter("addr", "rajur");
				//query.setParameter("id", 1);
				query.setParameter("name", "j%");
				int rowAffected = query.executeUpdate();
				
				flag = true;
			}
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
				System.out.println(":Record updated");
			}else {
				System.out.println("updation failed");
			}
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

