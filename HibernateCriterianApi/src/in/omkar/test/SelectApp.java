package in.omkar.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;
import net.bytebuddy.implementation.bytecode.Addition;
import net.bytebuddy.utility.privilege.SetAccessibleAction;

public class SelectApp {

	@SuppressWarnings({ "unused", "unchecked", "deprecation" })
	public static void main(String[] args) {
		Transaction transaction = null;
		Session session = null;
		try {

			session = HibernateUtil.getSession();
			{
				if (session != null) {
					Criteria criteria = session.createCriteria(Student.class); // FROM in.omkar.modal.Student
					List<Student> list = criteria.list();
					list.forEach(System.out::println);
				}
			}

/////////////////------------------------////////////////////////
			{
				if (session != null) {
					Criteria criteria = session.createCriteria(Student.class); // FROM in.omkar.modal.Student where
																				// marks>=50 and marks<=80
					Criterion cond1 = Restrictions.ge("marks", 50);
					Criterion cond2 = Restrictions.le("marks", 80);

					criteria.add(cond2);
					criteria.add(cond1);
					List<Student> list = criteria.list();
					list.forEach(System.out::println);
				}
			}
			////////////////////////////--------------------//////////////////
			{
				if (session != null) {
					Criteria criteria = session.createCriteria(Student.class); // FROM in.omkar.modal.Student where
																				// marks>=50 and marks<=80
					Criterion cond1 = Restrictions.ge("marks", 50);
					Criterion cond2 = Restrictions.le("marks", 80);

					criteria.add(cond2);
					criteria.add(cond1);
					List<Student> list = criteria.list();
					list.forEach(System.out::println);
				}
			}
			////////////////////////////////------------------------///////
			{
				if (session != null) {
					Criteria criteria = session.createCriteria(Student.class); // FROM in.omkar.modal.Student oreder by asc(name)
					
					ProjectionList list = Projections.projectionList();	
					
					list.add(Projections.property("id"));
					list.add(Projections.property("name"));
					
					
					
					criteria.setProjection(list);
					
					Order asc = Order.asc("name");	
						
						criteria.addOrder(asc);
					List<Object[]> list1 = criteria.list();
					list1.forEach(row->{
						for (Object object : row) {
							System.out.print(object+"\t");
						}
						System.out.println();
					});
				}
			}
			//////////////////-/////////////////---------------/////////
			{
				if (session != null) {
					Criteria criteria = session.createCriteria(Student.class); // FROM in.omkar.modal.Student oreder by asc(name)
					
					ProjectionList list = Projections.projectionList();	
					
					list.add(Projections.property("id"));
					list.add(Projections.property("name"));
					
					
					criteria.setProjection(list);
					
					Order asc = Order.asc("name");	
						
						criteria.addOrder(asc);
						
						
					Criterion between = Restrictions.between("marks", 50, 90);
					Criterion in = Restrictions.in("id",1,2,3,4,5,8,9);
					Criterion like = Restrictions.like("address","r%");
					
					Criterion lastCond = Restrictions.or(Restrictions.and(in,between),like);
					 
					criteria.add(lastCond); 
					List<Object[]> list1 = criteria.list();
					list1.forEach(row->{
						for (Object object : row) {
							System.out.print(object+"\t");
						}
						System.out.println();
					});
				}
			}


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
