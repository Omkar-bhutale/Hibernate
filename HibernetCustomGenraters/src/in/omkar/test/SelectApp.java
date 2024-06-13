package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.omkar.modal.ProgrammerPorjId;
import in.omkar.modal.ProgrammerProjectInfo;
import in.omkar.util.HibernateUtil;

public class SelectApp {
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			ProgrammerPorjId id = new ProgrammerPorjId();
			id.setPid(100);
			id.setProjId(101);
			ProgrammerProjectInfo obj = session.get(ProgrammerProjectInfo.class, id);
			System.out.println(obj);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory(); 
		}
	}
	
	

}
