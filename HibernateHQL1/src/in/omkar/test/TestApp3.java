package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.omkar.util.HibernateUtil;

public class TestApp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			{
			if (session != null) {
				@SuppressWarnings("unchecked")
				Query<String> query = session.createQuery("Select name FROM in.omkar.modal.Student WHERE sid IN(:id1,:id2,:id3)");
				
				//set values for named parameter
				query.setParameter("id1", "5");
				query.setParameter("id2", "6");
				query.setParameter("id3", "7");
				//query.setParameter("id1", "8");
				List<String> students = query.list();
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
			
			/////////////////////////////----------------------/////////////////////////
			{
			if (session != null) {
				@SuppressWarnings("unchecked")
				Query<Integer> query = session.createQuery("Select id FROM in.omkar.modal.Student WHERE sid IN(:id1,:id2,:id3)");
				
				//set values for named parameter
				query.setParameter("id1", "5");
				query.setParameter("id2", "6");
				query.setParameter("id3", "7");
				//query.setParameter("id1", "8");
//				List<Integer> students = query.list();
				List<Integer> students = query.getResultList();

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
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
		}

	}

}
