package in.omkar.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Employee;
import in.omkar.util.HibernateUtil;

public class InsertRecordApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEid(2);
				employee.setEname("omkar");
				employee.setEaddress("bhuttenHipparga");
				employee.setBankAccount(Map.of("SBI",11223344l,"HDFC",223344l,"Kotak",556677l));
				employee.setPhones(Set.of(8551964911l,7709680290l,9730788633l));
				employee.setFriendsList(List.of("Raju","govind","Shri","ladnaPandu"));
				session.save(employee);
				flag =true;
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("saved to db");
			}else {
				transaction.rollback();
				System.out.println("failed to save in db");
			}
		}
	}

}
/*
 * Hibernate: 
    
    create table Emp_Account (
       emp_id integer not null,
        Account_number bigint,
        bankName varchar(10) not null,
        primary key (emp_id, bankName)
    ) engine=InnoDB
Hibernate: 
    
    create table Emp_friends (
       emp_id integer not null,
        Friends_Name varchar(255),
        Friends_no integer not null,
        primary key (emp_id, Friends_no)
    ) engine=InnoDB
Hibernate: 
    
    create table Emp_Names (
       emp_id integer not null,
        Mobile_No bigint
    ) engine=InnoDB
Hibernate: 
    
    create table Employee_Collection (
       eid integer not null,
        eaddress varchar(255),
        ename varchar(255),
        primary key (eid)
    ) engine=InnoDB
Hibernate: 
    
    alter table Emp_Account 
       add constraint FKg2pbp8hgs570qog5bs2b6pts7 
       foreign key (emp_id) 
       references Employee_Collection (eid)
Hibernate: 
    
    alter table Emp_friends 
       add constraint FK9ikrw37lehift6mhm2ureqwd7 
       foreign key (emp_id) 
       references Employee_Collection (eid)
Hibernate: 
    
    alter table Emp_Names 
       add constraint FKhmyfpxergew8y48pp2j28s60v 
       foreign key (emp_id) 
       references Employee_Collection (eid)
       
       *///////////////////////////////////////////
/*
Hibernate: 
    insert 
    into
        Employee_Collection
        (eaddress, ename, eid) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_Account
        (emp_id, bankName, Account_number) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_Account
        (emp_id, bankName, Account_number) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_Account
        (emp_id, bankName, Account_number) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_friends
        (emp_id, Friends_no, Friends_Name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_friends
        (emp_id, Friends_no, Friends_Name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_friends
        (emp_id, Friends_no, Friends_Name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_friends
        (emp_id, Friends_no, Friends_Name) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        Emp_Names
        (emp_id, Mobile_No) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        Emp_Names
        (emp_id, Mobile_No) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        Emp_Names
        (emp_id, Mobile_No) 
    values
        (?, ?)
       */
