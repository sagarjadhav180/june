package org.com.automation.practise;

public class Student implements Comparable
{
	
	int id;
	String name;
	char gender;
	
	public Student(int id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}


	public int compareTo(Object o1) {
		// TODO Auto-generated method stub
		
		Student s1=(Student)o1;
		return this.id-s1.id;
	}
	
	public int hashCode()
	{
		return id;
	
	}
	
	
	
	

}
