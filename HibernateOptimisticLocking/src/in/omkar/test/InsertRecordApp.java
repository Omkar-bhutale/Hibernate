package in.omkar.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.attribute.AclEntryFlag;
import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Template;

import in.omkar.modal.JobSeeker;
import in.omkar.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		byte[] photo = null;
		char[] resume = null;
		boolean flag =false;
	

		try (FileInputStream fis = new FileInputStream(
				new File("C:\\Users\\Omkar Bhutale\\Pictures\\Camera Roll\\om.jpg"));) {
			photo = new byte[fis.available()];
			fis.read(photo);
			File file = new File("C:\\Users\\Omkar Bhutale\\Downloads\\Resume.txt");
			System.out.println(file.exists());
			try(FileReader fr = new FileReader(file)){
				 
				resume = new char[(int)file.length()];
				fr.read(resume);
			}catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		catch (HibernateException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		try {
			System.out.println();
			System.out.println(Arrays.toString(photo));
			System.out.println( Arrays.toString(resume));
			session = HibernateUtil.getSession();
			if (transaction == null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				JobSeeker jobSeeker = new JobSeeker();
				jobSeeker.setJsAddress("bhuttan hipparga");
				jobSeeker.setJsName("omkar");
				jobSeeker.setResume(resume);
				jobSeeker.setPhoto(photo);
				
				session.save(jobSeeker);
				flag = true;
				
				
			}
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("obj saved");
			}else {
				System.out.println("object can not be saved");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}


		
	}
}
