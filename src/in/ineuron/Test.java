package in.ineuron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Test {
	public static void main(String[] args) throws SQLException {
		
	   
	   Scanner scanner = new Scanner(System.in);
	   int choice;
	   
		
		Driver driver = new Driver();
		DriverManager.deregisterDriver(driver);
		
		String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
		String userName = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		Statement statement = connection.createStatement();
		
		PreparedStatement pstmt = null;
		
		do {
			 System.out.println("*****MENU*****");
			 System.out.println("1. INSERT RECORD");
			 System.out.println("2. DELETE RECORD");
			 System.out.println("3. FETCH RECORD");
			 System.out.println("4. UPDATE RECORD");
			 System.out.println("4. EXIT");
			 System.out.println("Enter your choice:");
			 System.out.println("\n");
			 choice = scanner.nextInt();
			 
			 switch(choice)
			 {
			 case 1:
				System.out.print("Enter the person id: ");
				int pid = scanner.nextInt();

				System.out.print("Enter the Address:: ");
				String paddress = scanner.next();

				System.out.print("Enter the Name:: ");
				String pname = scanner.next();

				String sqlInsertQuery = "INSERT INTO person (pid, paddress, pname) VALUES (?, ?, ?)";
				pstmt = connection.prepareStatement(sqlInsertQuery);
				
				pstmt.setInt(1, pid);
				pstmt.setString(2, paddress);
				pstmt.setString(3, pname);
				pstmt.executeUpdate();
				
		        System.out.print("Record inserted successfully!");
		   	    System.out.println("\n");
				break;
				
			 case 2:
				    System.out.print("Enter the person id which you want to delete : ");
					int pid1 = scanner.nextInt();
					
				    String sqlDeleteQuery = "DELETE FROM person WHERE pid=?";
				    
				    PreparedStatement statement4 = connection.prepareStatement(sqlDeleteQuery);
				    
				    statement4.setInt(1, pid1);
				    
				    int rowsDeleted = statement4.executeUpdate();
				    if(rowsDeleted > 0) {
				    	System.out.print("Record deleted successfully!");
				    }
					System.out.println("\n");
				    break;
				    
				    
			case 3:
				    String selectQuery = "SELECT pid, paddress, pname FROM person";
					ResultSet resultSet = statement.executeQuery(selectQuery);
					
					System.out.println("PID\tPADDRESS\tPNAME");
					while(resultSet.next()){
						int pid2 = resultSet.getInt("pid");
						String paddress1 = resultSet.getString("paddress");
						String pname1 = resultSet.getString("pname");
						System.out.println(pid2+"\t"+paddress1+"\t"+pname1);
					}
					resultSet.close();
					System.out.println("\n");
					break;
					
			 case 4:
				   System.out.println("Enter records for updation");
				   System.out.println("Enter person id whose records are to be updated");
				   int id = scanner.nextInt();
				   System.out.println("Enter updated address");
				   String address = scanner.next();
				   System.out.println("Enter updated name");
				   String name = scanner.next();
				   
				   String sqlUpdateQuery = "update person set pid=?, paddress=?, pname=?";
				   PreparedStatement statement3 = connection.prepareStatement(sqlUpdateQuery);
				   
				   statement3.setInt(1, id);
				   statement3.setString(2,address);
				   statement3.setString(3,name);
				   
				   int rowUpdated = statement3.executeUpdate();
				   
				   if(rowUpdated > 0) {
					   System.out.print("Record updated successfully!");
				   }
				   break;
				   
			default:
                   System.out.println("Invalid option! Please enter correct option!");
                   break;
				   
		 }
			 
		}while(choice != 5); {
			 System.out.println("Thank you for using our services...!!");
			
		}
		
		statement.close();
		connection.close();
	}
}
