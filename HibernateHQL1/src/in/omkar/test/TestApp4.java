package in.omkar.test;

import java.util.List;
import java.util.function.Consumer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class TestApp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				@SuppressWarnings("unchecked")
				Query<Object[]> query = session.createQuery("Select name,address FROM in.omkar.modal.Student WHERE sid IN(:id1,:id2,:id3)");
				
				//set values for named parameter
				query.setParameter("id1", "5");
				query.setParameter("id2", "6");
				query.setParameter("id3", "7");
				//query.setParameter("id1", "8");
				List<Object[]> students = query.list();
//				for (Student student : list) {
//					System.out.println(student);
//				}
				students.forEach(row->{
					for (Object object : row) {
						System.out.print(object + "\t");
					}
					System.out.println();
				});
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
