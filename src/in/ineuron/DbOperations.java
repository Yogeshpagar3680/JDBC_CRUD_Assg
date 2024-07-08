/*
 * package in.ineuron;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement;
 * 
 * import com.mysql.cj.jdbc.Driver;
 * 
 * public class DbOperations {
 * 
 * public void inserRecord() throws SQLException { Driver driver = new Driver();
 * DriverManager.deregisterDriver(driver);
 * 
 * String url = "jdbc:mysql://localhost:3306/enterprisejavabatch"; String
 * userName = "root"; String password = "root";
 * 
 * Connection connection = DriverManager.getConnection(url, userName, password);
 * 
 * Statement statement = connection.createStatement();
 * 
 * String selectQuery = "SELECT pid, paddress, pname FROM person";
 * 
 * ResultSet resultSet = statement.executeQuery(selectQuery);
 * 
 * System.out.println("PID\tPADDRESS\tPNAME"); while(resultSet.next()){ int pid
 * = resultSet.getInt("pid"); String paddress = resultSet.getString("paddress");
 * String pname = resultSet.getString("pname");
 * System.out.println(pid+"\t"+paddress+"\t"+pname); }
 * 
 * resultSet.close(); statement.close(); connection.close(); }
 * 
 * }
 */