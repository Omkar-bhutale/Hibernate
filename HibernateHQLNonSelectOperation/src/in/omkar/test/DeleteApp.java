package in.omkar.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.util.HibernateUtil;

public class DeleteApp {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			if (session != null && transaction!=null) {
				Query<Integer> selectQuery  = session.createQuery("SELECT MAX(id) FROM in.omkar.modal.Student");
				Integer id = selectQuery.uniqueResult();
				Query query = session.createQuery("DELETE FROM in.omkar.modal.Student WHERE id = :id ");
				query.setParameter("id",id);
			
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
				System.out.println(":Record deleted");
			}else {
				System.out.println("deletion failed");
			}
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

