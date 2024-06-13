package in.omkar.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.omkar.modal.Employee;
import in.omkar.util.HibernateUtil;

public class SelectRecordApp {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		try {
			
				if (session == null) {
					session = HibernateUtil.getSession();
				}

				Query<Employee> query = session.createQuery("from in.omkar.modal.Employee");
				List<Employee> list = query.list();
				list.forEach(System.out::println);
			

      
			

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
