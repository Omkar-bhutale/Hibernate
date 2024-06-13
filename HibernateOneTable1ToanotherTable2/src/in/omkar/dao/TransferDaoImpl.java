package in.omkar.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil_t1;
import in.omkar.util.HibernateUtil_t2;

public class TransferDaoImpl implements ITransferDao {

	@Override
	public String doTransferStudentByID(Integer id) {
		Session session_t1 = null;
		Session session_t2 = null;
		Transaction transaction_t2 = null;
		Student student = null;
		boolean flag = true;
		try {
			//getting the data from table1
			session_t1 = HibernateUtil_t1.getSession();
			System.out.println("session_1 object created");
			if (session_t1 != null) {
				
				student = session_t1.get(Student.class, id);				
				System.out.println("student object retrived from table one");
			}
			
			if (student != null) {
				if (session_t2 == null) {
					System.out.println("session_2 object created");
					session_t2 = HibernateUtil_t2.getSession();
				}
				if (session_t2 != null) {
					transaction_t2 = session_t2.beginTransaction();
					session_t2.save(student);
					flag = true;
				}
				
			}
			
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction_t2.commit();
				return "student object is saved";
			}else {
				transaction_t2.rollback();
			}
			if (session_t2 != null) {
				HibernateUtil_t2.closeSession();
				HibernateUtil_t2.closeSessionFactory();				
			}
			if (session_t1 != null) {				
				HibernateUtil_t1.closeSession();
				HibernateUtil_t1.closeSessionFactory();
			}
			
		}
		
		return "Insertion of student object is failed";
	}

}
