package in.omkar.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.ECFieldF2m;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jvnet.fastinfoset.sax.helpers.FastInfosetDefaultHandler;

import in.omkar.modal.JobSeeker;
import in.omkar.util.HibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;
		JobSeeker seeker = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				seeker = session.get(JobSeeker.class, 4);
				System.out.println(seeker);
			}
			if (seeker != null) {
//				 File directory = new File("store");
//	                if (!directory.exists()) {
//	                    directory.mkdirs();
//	                }
				
				File f1 = new File("om.png");
				System.out.println(f1.createNewFile());
				File f2 = new File("om.txt");
				System.out.println(f2.createNewFile());
				System.out.println(seeker);
				try (FileOutputStream fos = new FileOutputStream("demo.png");
						FileWriter fw = new FileWriter("om.txt");) {
					fw.write(seeker.getResume());
					fos.write(seeker.getPhoto());
					System.out.println(f1.getAbsolutePath());
					System.out.println(f2.getAbsolutePath());
					
				}
			}
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}

}
