package in.omkar.test;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class TestApp6 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			{
			if (session != null) {
				Query<Student> query = session.createQuery("from in.omkar.modal.Student where id = :sid ");

				
				query.setParameter("sid", 2);
				
				List<Student> list = query.list();
				
				if (list != null) {
					Student student = list.get(0);
					System.out.println(student);
					
				}else {
					System.out.println("student not found");
				}
				
			}
			}		
			/////////////////////////////////////////////////////
			{
				if (session != null) {
					Query<Student> query = session.createQuery("from in.omkar.modal.Student where id = :sid ");

					
					query.setParameter("sid", 2);
					
					List<Student> list = query.getResultList();
					
					if (list != null) {
						Student student = list.get(0);
						System.out.println(student);
						
					}else {
						System.out.println("student not found");
					}
					
				}
			}
			
			////////////////////////////////////////////////////////
			{
				if (session != null) {
					Query<Student> query = session.createQuery("from in.omkar.modal.Student where id = :sid ");

					
					query.setParameter("sid", 2);
					
					 Student student = query.uniqueResult();
					
					if (student != null) {
						System.out.println(student);
						
					}else {
						System.out.println("student not found");
					}
					
				}
			}
			///////////////////////////////////////////////////
			{
				if (session != null) {
					Query<Student> query = session.createQuery("from in.omkar.modal.Student where id = :sid ");

					
					query.setParameter("sid", 2);
					
					   Optional<Student> uniqueResultOptional = query.uniqueResultOptional();
					
					if (uniqueResultOptional.isPresent()) {
						System.out.println(uniqueResultOptional.get());
						
					}else {
						System.out.println("student not found");
					}
					
				}
			}

			

			///////////////////////////// ----------------------/////////////////////////

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();

			HibernateUtil.closeSessionFactory();
		}

	}

}
