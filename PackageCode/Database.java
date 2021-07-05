package students.database;
import java.sql.*;
import students.students.Students;

public class Database{
	private Connection con = null;
	private PreparedStatement ps = null;

	public Database(){
		try{
			// Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");  
		   // Connection establish
    	this.con = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/univ","root","Pace2020@");								
	      }catch(Exception e){
		     System.out.println("Exception" + e.getMessage());
	  }
   }


   public void insert(Students st){

   	String query = "Insert into students(name,age) values(?,?)";
   	try{
   		this.ps = con.prepareStatement(query);
   		this.ps.setString(1,st.getName());
   		this.ps.setInt(2,st.getAge());
   		this.ps.executeUpdate();

   	}catch(SQLException e){
   		System.out.println("Exception " + e);
   	}
  }


  public void delete(int id){
  	String query = "delete from students where id = ?";
  	try{

  		this.ps = con.prepareStatement(query);
  		this.ps.setInt(1,id);
  		this.ps.executeUpdate();
  	}
  	catch(SQLException e){
  		System.out.println("Exception " + e);
  	}
  }

  public void update(String upname ,int upid){
  	String query = "update students set name = ? where id = ?";
  	try{
  		this.ps = con.prepareStatement(query);
  		this.ps.setString(1,upname);
  		this.ps.setInt(2,upid);
  		this.ps.executeUpdate();
  	}
  		catch(SQLException e){
  		System.out.println("Exception " + e);
  	}
  }

   public void update(int age , int upid){
  	String query = "update students set age = ? where id = ?";
  	try{
  		this.ps = con.prepareStatement(query);
  		this.ps.setInt(1,age);
  		this.ps.setInt(2,upid);
  		this.ps.executeUpdate();
  	}
  		catch(SQLException e){
  		System.out.println("Exception " + e);
  	}
  }

    public void update(int upid, String upname , int upage){
  	String query = "update students set age = ? , name = ? where id = ?";
  	try{
  		this.ps = con.prepareStatement(query);
  		this.ps.setInt(1,upage);
  		this.ps.setString(2,upname);
  		this.ps.setInt(3,upid);
  		this.ps.executeUpdate();
  	}catch(SQLException e){
  		System.out.println("Exception " + e);
  	}
  }

  public ResultSet select(String ... columns){
  	ResultSet r = null;
  	String query = "select ";
  		for(int i=0;i<columns.length-1;i++){
  		query = query + columns[i] + " ";
  	  }
  	  query = query + columns[columns.length - 1] + " from students";
  	   
  	try{
		this.ps = this.con.prepareStatement(query);
			r = this.ps.executeQuery();
		}catch(SQLException e){
			System.out.println("Exception "+e);
		}
		return r;
  }

   public ResultSet select(int upid,String ... columns){

  	ResultSet r = null;
  	String query = "select ";
  		for(int i=0;i<columns.length-1;i++){
  		query = query + columns[i] + ",";
  	  }

  	  query = query + columns[columns.length - 1] + " from students where id = ?";
  	try{
  		this.ps = this.con.prepareStatement(query);
  		this.ps.setInt(1,upid);
		
			r = this.ps.executeQuery();
		}catch(SQLException e){
			System.out.println("Exception "+e);
		}
		return r;
  }




}