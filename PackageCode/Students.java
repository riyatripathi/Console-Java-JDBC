package students.students;
import java.util.*;

public class Students{
	private String studentname = null;
	private int studentage = 0;
	private int studentid = 0;

	public Students(String name,int age){
		this.studentname = name;
		this.studentage = age;
		
	}

	public String getName(){
		return this.studentname;
	}

	public int getAge(){
		return this.studentage;
	}
}