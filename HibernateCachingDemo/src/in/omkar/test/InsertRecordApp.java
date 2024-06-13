package in.omkar.test;


import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.InsurcancePolicy;
import in.omkar.util.HibernateUtil;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;


public class InsertRecordApp {
	public static void main(String[] args) {
		Session session =null;
		Transaction transaction = null;
		boolean flag = false;
		Long id = null;
		//boolean flag = false;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				InsurcancePolicy insurcancePolicy =new InsurcancePolicy();
				insurcancePolicy.setCompany("LIC");
				insurcancePolicy.setTenuare(5);
				insurcancePolicy.setPolicyName("jeevan bima");
				insurcancePolicy.setPolicyType("yearly");
				session.save(insurcancePolicy);
				flag = true;
			}
				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				
				System.out.println("saved");
			}else {
				if (transaction != null) {
					transaction.rollback();
					
				}else {
					System.out.println("transaction object is null");
				}
				System.out.println("unsaved");
			}
			if (session != null) {
				HibernateUtil.closeSession();
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
