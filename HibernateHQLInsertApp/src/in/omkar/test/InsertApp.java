package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.util.HibernateUtil;

public class InsertApp {

	private static final String HQL_TRANSFER_PASSED_STUDENTS = "INSERT INTO in.omkar.modal.StudentPassed(id,name,age,address,marks) "
			+ "SELECT i.id,i.name,i.age,i.address,i.marks FROM in.omkar.modal.Student as i " + "WHERE marks >:marks ";
	private static int rowsTRansfferd;

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			if (session != null && transaction != null) {
				Query query = session.createQuery(HQL_TRANSFER_PASSED_STUDENTS);
				query.setParameter("marks", 50);
				rowsTRansfferd = query.executeUpdate();
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("rows transfferd are ::" + rowsTRansfferd);
			} else {
				transaction.rollback();
				System.out.println("failed to transfer");
			}
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}
