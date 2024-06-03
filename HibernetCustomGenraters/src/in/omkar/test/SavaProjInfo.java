package in.omkar.test;



import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.Employee;
import in.omkar.modal.ProgrammerPorjId;
import in.omkar.modal.ProgrammerProjectInfo;
import in.omkar.util.HibernateUtil;



public class SavaProjInfo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			
			System.out.println("hii");
			if (session == null) 
				session =HibernateUtil.getSession();
				
			if (transaction == null) {
				transaction = session.beginTransaction();				
			}
			ProgrammerPorjId id = new ProgrammerPorjId();
			id.setPid(100);
			id.setProjId(101);
			System.out.println("id created");
			ProgrammerProjectInfo obj = new ProgrammerProjectInfo();
			System.out.println("id injected");
			obj.setId(id);
			obj.setDeptNo(1);
			obj.setPname("navin");
			obj.setProjName("candy crush");
			System.out.println("going to save in session");
			session.save(obj);
			System.out.println(" saved in session");

			flag = true;
			
			
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
//				System.out.println("id is ::" + id);
				System.out.println("saved");
				
			}
			else {
				transaction.rollback();
				System.out.println("not saved");
			}

			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	
		
	}

}
