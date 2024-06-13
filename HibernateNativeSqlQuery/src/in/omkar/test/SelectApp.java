package in.omkar.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;
import net.bytebuddy.utility.privilege.SetAccessibleAction;

public class SelectApp {

private static ProcedureCall storedProcedureCall;

/*
DELIMITER //

CREATE PROCEDURE get_ALL_STUDENT(
    IN  _sid INT,
    OUT _sname VARCHAR(255),
    OUT _sage INT,
    OUT _saddress VARCHAR(255),
    OUT _smarks INT
)
BEGIN
    SELECT sname, sage, saddress, smarks 
    INTO _sname, _sage, _saddress, _smarks 
    FROM Student 
    WHERE sid = _sid;
END //

DELIMITER ;

 */
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			if (session != null) {
				Integer id =1;
				storedProcedureCall = session.createStoredProcedureCall("get_ALL_STUDENT");
				
				storedProcedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(id);;
				storedProcedureCall.registerParameter(2, String.class, ParameterMode.OUT);
				storedProcedureCall.registerParameter(3, Integer.class, ParameterMode.OUT);
				storedProcedureCall.registerParameter(4, String.class, ParameterMode.OUT);
				storedProcedureCall.registerParameter(5, Integer.class, ParameterMode.OUT);
				
				String sname = (String)storedProcedureCall.getOutputParameterValue(2);
				String saddress = (String)storedProcedureCall.getOutputParameterValue(4);
				Integer sage = (Integer)storedProcedureCall.getOutputParameterValue(3);
				Integer smarks = (Integer)storedProcedureCall.getOutputParameterValue(5);
				
				System.out.println(sname);
				System.out.println(saddress);
				System.out.println(sage);
				System.out.println(smarks);
				}
			
		
/////////////////------------------------////////////////////////
		
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

