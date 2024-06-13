package in.omkar.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.InsurcancePolicy;
import in.omkar.util.HibernateUtil;

public class SelectRecord {
	public static void main(String[] args) {
		Session session = null;
		// Transaction transaction = null;
		boolean flag = false;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			if (session != null) {
				InsurcancePolicy policy = session.get(InsurcancePolicy.class, 1);// gets from db and put in L1 cache

				System.out.println("1 :: Hash code" + policy.hashCode() + " ::" + policy);
				InsurcancePolicy policy1 = session.get(InsurcancePolicy.class, 1);// gets from L1 cache
				System.out.println("2 :: Hash code" + policy1.hashCode() + " ::" + policy1);
				session.evict(policy);// removes from l1 cache
				System.out.println(session.contains(policy));
				System.out.println();
				InsurcancePolicy policy3 = session.get(InsurcancePolicy.class, 1);// gets from db and put in L1 cache

				System.out.println("3 :: Hash code" + policy3.hashCode() + " ::" + policy3);
				InsurcancePolicy policy4 = session.get(InsurcancePolicy.class, 1);// gets from L1 cache
				System.out.println("4 :: Hash code" + policy4.hashCode() + " ::" + policy4);
				/*
				 * HibernateUtil.getSession() Hibernate: select insurcance0_.policyId as
				 * policyid1_0_0_, insurcance0_.company as company2_0_0_,
				 * insurcance0_.policyName as policyna3_0_0_, insurcance0_.policyType as
				 * policyty4_0_0_, insurcance0_.tenuare as tenuare5_0_0_ from InsurcancePolicy
				 * insurcance0_ where insurcance0_.policyId=? 1 :: Hash code337051462
				 * ::InsurcancePolicy [policyId=1, policyName=jeevan bima, policyType=yearly,
				 * company=LIC, tenuare=5] 2 :: Hash code337051462 ::InsurcancePolicy
				 * [policyId=1, policyName=jeevan bima, policyType=yearly, company=LIC,
				 * tenuare=5] false
				 * 
				 * 3 :: Hash code1880484847 ::InsurcancePolicy [policyId=1, policyName=jeevan
				 * bima, policyType=yearly, company=LIC, tenuare=5] 4 :: Hash code1880484847
				 * ::InsurcancePolicy [policyId=1, policyName=jeevan bima, policyType=yearly,
				 * company=LIC, tenuare=5]
				 */

				
				
				// code to drmonstrate ehchache
				InsurcancePolicy policy5 = session.get(InsurcancePolicy.class, 2);
				System.out.println("1:: " + policy5);
				// gets from DB, put in L2-cache and in L1-cache

				InsurcancePolicy policy6 = session.get(InsurcancePolicy.class, 2);
				System.out.println("2:: " + policy6);
				// gets from L1-cache

				session.evict(policy1); // Remove policy object from L1-cache

				InsurcancePolicy policy7 = session.get(InsurcancePolicy.class, 2);
				System.out.println("3:: " + policy7);
				// gets from L2-cache and keep it in L1-cache
				/*
				 * select insurcance0_.policyId as policyid1_0_0_, insurcance0_.company as
				 * company2_0_0_, insurcance0_.policyName as policyna3_0_0_,
				 * insurcance0_.policyType as policyty4_0_0_, insurcance0_.tenuare as
				 * tenuare5_0_0_ from InsurcancePolicy insurcance0_ where
				 * insurcance0_.policyId=? 1:: InsurcancePolicy [policyId=2, policyName=jeevan
				 * bima, policyType=yearly, company=LIC, tenuare=5] 2:: InsurcancePolicy
				 * [policyId=2, policyName=jeevan bima, policyType=yearly, company=LIC,
				 * tenuare=5] 3:: InsurcancePolicy [policyId=2, policyName=jeevan bima,
				 * policyType=yearly, company=LIC, tenuare=5]
				 */

			}
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		if (session != null) {
			HibernateUtil.closeSession();
		}
		HibernateUtil.closeSessionFactory();
	}

}
