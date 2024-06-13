package in.omkar.test;

import in.omkar.dao.ITransferDao;
import in.omkar.dao.TransferDaoImpl;

public class TranserRecordT1ToT2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITransferDao transferDao = new TransferDaoImpl();
		System.out.println( transferDao.doTransferStudentByID(1));

	}

}
