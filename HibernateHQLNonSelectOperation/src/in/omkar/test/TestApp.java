package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				 @SuppressWarnings({ "rawtypes" })
				Query query = session.createQuery("FROM in.omkar.modal.Student");
				 
				
				
			}
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

		
			HibernateUtil.closeSessionFactory();
		}
	}

}

