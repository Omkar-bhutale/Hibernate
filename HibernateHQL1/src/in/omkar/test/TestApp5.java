package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class TestApp5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSession();

			{
				if (session != null) {
					@SuppressWarnings("unchecked")
					Query<Student> query = session
							.createQuery(" FROM in.omkar.modal.Student WHERE sid IN(:id1,:id2,:id3)");
					@SuppressWarnings("unchecked")
					Query<Student> query1 = session.createQuery(" FROM in.omkar.modal.Student WHERE sid =:id");
					query1.setParameter("id", "5");
					// set values for named parameter
					query.setParameter("id1", "5");
					query.setParameter("id2", "6");
					query.setParameter("id3", "7");
					// query.setParameter("id1", "8");
					List<Student> students = query1.list();
//				for (Student student : list) {
//					System.out.println(student);
//				}
//				students.forEach(row->{
//					
//						System.out.print(row + "\t");
//					
//					System.out.println();
//				});
					students.forEach(System.out::println);
				}
			}
			{
				if (session != null) {
					@SuppressWarnings("unchecked")
					Query<Student> query1 = session.createQuery(" FROM in.omkar.modal.Student WHERE sid =:id");
					query1.setParameter("id", "15");
					// set values for named parameter
					// query.setParameter("id1", "8");
					Student student = query1.uniqueResult();
//					for (Student student : list) {
//						System.out.println(student);
//					}
//					students.forEach(row->{
//						
//							System.out.print(row + "\t");
//						
//						System.out.println();
//					});
					if (student != null) {
						System.out.println(student);
					}
					else {
						System.out.println("obj not found");
					}
					}

			}

			///////////////////////////// ----------------------/////////////////////////

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
		}

	}

}
