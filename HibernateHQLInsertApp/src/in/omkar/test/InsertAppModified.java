package in.omkar.test;

import in.omkar.dao.IStudentDao;
import in.omkar.dao.StudentDaoImpl;

public class InsertAppModified {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IStudentDao studentDao = new StudentDaoImpl();
		String trnsferStudent = studentDao.trnsferStudent(40);
		System.out.println(trnsferStudent);

	}

}
