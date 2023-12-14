import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AddressBook{
PreparedStatement pstm;
int addContact(String name,String phone,String email,String address)
{
	try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("insert into contacts values(?,?,?,?)");
		 pstm.setString(1,name);
		 pstm.setString(2,phone);
		 pstm.setString(3,email);
		 pstm.setString(4,address);
		 pstm.executeUpdate();
		 con.close();
	 }catch(Exception e) {
		 return 0;
	 } 
	 return 1;
}
int displayContact()
{
	ResultSet rs;
	try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("select * from contacts");
		 rs=pstm.executeQuery();
		 
		 while(rs.next())
		 {
			 System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t");
		 }
		 con.close();
	 }catch(Exception e) {
		 return 0;
	 } 
	 return 1;
}
int removeContact(String email)
{
	try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("delete from contacts where email=?");
		 pstm.setString(1, email);
		 return pstm.executeUpdate();
	 }catch(Exception e) {
		 return 0;
	 } 
}
int searchContact(String email)
{
	ResultSet rs;
	try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("select * from contacts where email=?");
		 pstm.setString(1, email);
		 rs=pstm.executeQuery();
		 System.out.println("--------------------------------");
		 System.out.println("NAME\t\t|\tPHONE NO\t\t|\tEMAIL\t\t\t|\tADDRESS");
	     System.out.println("--------------------------------------------------------------------------------------");
		 while(rs.next())
		 {
			 System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t");
		 }
		 
		 con.close();
	 }catch(Exception e) {
		 return 0;
	 } 
	 return 1;
}
}
