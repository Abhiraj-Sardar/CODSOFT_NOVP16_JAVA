import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;
public class CreateDB {
    public static void main(String[] args) throws Exception {
        try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/studentmanagementsystem";
			 
			 String user="root";
			 String pass="admin";
			 Connection con = DriverManager.getConnection(url,user,pass);
			 JOptionPane.showMessageDialog(null,"DATABASE Connection is established");
             System.out.println("There is no error.....");
		 }catch(SQLException e)
		 {
			 System.out.println("There is an error");
		 }
    }
}
