package in.omkar.dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {



//	private static final CriteriaUpdate HQL_TRANSFER_PASSED_STUDENTS = null;

	@SuppressWarnings("rawtypes")
	@Override
	public String trnsferStudent(int marks) {

		 Integer rowsTRansfferd=null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String result =null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			if (session != null && transaction != null) {
				//Query query = session.createQuery(HQL_TRANSFER_PASSED_STUDENTS);
				Query query = session.getNamedQuery("HQL_TRANSFER_PASSED_STUDENTS");
				query.setParameter("marks", marks);
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
				result = "rows transfferd are ::" + rowsTRansfferd;
			} else {
				transaction.rollback();
				result = "failed to transfer";
			}
			session.close();
			HibernateUtil.closeSessionFactory();
		}
		return result;
	}

}
