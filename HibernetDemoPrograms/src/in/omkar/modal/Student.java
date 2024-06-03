package in.omkar.modal;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "student")
@DynamicUpdate(value = true)
public class Student {
	@Id
	//HIBERNET
//	@GenericGenerator(name="gen1",strategy="increment")
//	@GeneratedValue(generator = "gen1")// -->my sql darabase
//	@GenericGenerator(name="gen1",strategy="sequance")
//	@GeneratedValue(generator = "gen1")  --> oracle database
	
	//JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY)//--> besst for mysql db
//	@GeneratedValue(strategy = GenerationType.SEQUENCE) -->best for oracle
	
//	@SequenceGenerator(name = "gen1",sequenceName = "JPA_SID_SEQUANCE",initialValue = 5,allocationSize = 5) 
//	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)-->if the sequnce is created by devloper
	
	@Column(name = "sid")
	private Integer id;
	@Column(name = "sname")
	private String name;
	@Column(name = "sage")
	private Integer age;
	@Column(name = "saddress")
	private String address;
	public Student(){
		System.out.println("Hibernet uses zero arg constructor internally");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	

}
