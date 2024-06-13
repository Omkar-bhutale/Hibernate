package in.omkar.modal;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;



@Entity
@DynamicUpdate(value = true)
public class StudentPassed {
	@Id
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	public StudentPassed(){
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