package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class SelectApp {


	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			if (session != null) {
				 transaction = session.beginTransaction();
				 NativeQuery<Student> sqlQuery = session.getNamedNativeQuery("GET_ALL_STUDENTS");


				 sqlQuery.addEntity(Student.class);
				 
				 List<Student> list = sqlQuery.getResultList();
				
				 
				 list.forEach(System.out::println);
				}
			
		
/////////////////------------------------////////////////////////
		
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

		
			HibernateUtil.closeSessionFactory();
		}
	}

}

