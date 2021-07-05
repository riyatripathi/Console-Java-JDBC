import java.util.*;
import java.sql.ResultSet;
import students.students.Students;
import students.database.Database;

class ManagementApp{
	public static void main(String[] args) {
		Database db = new Database();

		while(true){
		System.out.println("\n...Welcome to Management App...\n");
		System.out.println("Choose any Option \n ");
		System.out.println("1. Insert Student ");
		System.out.println("2. Delete Student ");
		System.out.println("3. Update Student ");
		System.out.println("4. Display Any Student ");
		System.out.println("5. Display all ");
		System.out.println("6. Exit \n");

		Scanner s = new Scanner(System.in);
		int option = s.nextInt();
		s.nextLine();

		if(option == 1){

			System.out.println("Enter name of Student : ");
			String name = s.nextLine();

			System.out.println("Enter age of Student : ");
			int age = s.nextInt();

			Students st = new Students(name,age);
			

			db.insert(st);
			System.out.println("\n------------------------\nInserted Successfully...\n------------------------");			 

		}
		else if(option==2){
		   System.out.println("Enter Student id to delete : ");
		   int id = s.nextInt();

		   db.delete(id);
		   System.out.println("\n------------------------\nDeleted Successfully...\n------------------------");

		}
		else if(option == 3){
			System.out.println("Enter choice to update:  ");
			System.out.println("1. Name\n2. Age\n3. Both");
			int choice = s.nextInt();
			if(choice==1){
				System.out.print("Enter the Student id: ");
				int upid = s.nextInt();
				s.nextLine();
				System.out.print("Enter the updated Name: ");
				String upname = s.nextLine();

				db.update(upname,upid);
				System.out.println("\n------------------------\nUpdated Successfully...\n------------------------");

			}else if(choice == 2){
				System.out.print("Enter the Student id: ");
				int upid = s.nextInt();
				s.nextLine();
				System.out.print("Enter the updated age: ");
				int upage = s.nextInt();

				db.update(upage,upid);
				System.out.println("\n------------------------\nUpdated Successfully...\n------------------------");

			}else if(choice == 3){
				System.out.print("Enter the Student id: ");
				int upid = s.nextInt();
				s.nextLine();
				System.out.print("Enter the updated name: ");
				String upname = s.nextLine();
				System.out.print("Enter the updated age: ");
				int upage = s.nextInt();

				db.update(upid,upname,upage);
				System.out.println("\n------------------------\nUpdated Successfully...\n------------------------");				
			}	
	    }
	     else if(option == 4){

	    	System.out.println("Enter id of the student : ");
	    	int upid = s.nextInt();

	    	System.out.println(" id\tName\t\t\tAge");
				System.out.println(" __\t____\t\t\t____");
				System.out.println("");

				try{
				ResultSet r = db.select(upid, "*");
				if(r.next()){
					System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t"+r.getInt(3));
			    } 
			}catch(Exception e){
			    	//System.out.println("SQLException " + e.printStackTrace());
				e.printStackTrace();
			   }
	    }
	     else if(option==5){
				System.out.println(" id\tName\t\t\tAge");
				System.out.println(" __\t____\t\t\t____");
				System.out.println("");
				try{
				ResultSet r = db.select("*");
				while(r.next()){
				System.out.println(" " + r.getInt(1)+"\t"+r.getString(2)+"\t\t\t"+r.getInt(3));
				System.out.println("");
			    } 
			}catch(Exception e){
			    	System.out.println("SQLException " + e);
			   }
	    }
	    else if(option == 6){

			break;
	    }
	      else if(option<1 || option>6){
	  	       System.out.println("Please choose the valid option ...\n\n");
	    }
	    
	}
  }
}