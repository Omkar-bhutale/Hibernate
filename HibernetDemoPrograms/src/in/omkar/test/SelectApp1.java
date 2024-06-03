package in.omkar.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;
 class SelectApp1 {
	public static void main(String[] args) {
		Session session = null;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			if (session != null) {
				//eager loding or early loding
				Student student = session.get(in.omkar.modal.Student.class, 1);
				System.out.println(student);
				//lazy loding
				Student student2 = session.load(Student.class,11);
				System.out.println("Student with id is not fetched form db yet (rimery key val from proxy object)"+ student2.getId());
				System.out.println("to load actual obj press enter ");
				System.in.read();
				System.out.println(student2);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}
}
