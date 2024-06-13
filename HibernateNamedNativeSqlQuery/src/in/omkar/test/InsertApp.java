package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class InsertApp {


	public static void main(String[] args) {
		 Integer executeUpdate =null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				transaction = session.beginTransaction();
				
				NativeQuery sqlQuery = session.createSQLQuery("Insert into student(sid,sname,sage,saddress,smarks) values (?,?,?,?,?)");
//					 NativeQuery<Student> sqlQuery = session.createSQLQuery("select * from student where sid>?");
				

				sqlQuery.setParameter(1, 11);
				sqlQuery.setParameter(2, "omakar");
				sqlQuery.setParameter(3, 23);
				sqlQuery.setParameter(4, "bhutten hipparga");
				sqlQuery.setParameter(5, 130);

				executeUpdate = sqlQuery.executeUpdate();
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object saved");
			}else {
				transaction.rollback();
				System.out.println("object not saved");
			}
			HibernateUtil.closeSessionFactory();
		}
	}

}
