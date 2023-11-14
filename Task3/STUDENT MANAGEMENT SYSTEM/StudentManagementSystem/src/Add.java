import java.sql.Connection;
import java.sql.PreparedStatement;

public class Add {
public int insert(int roll,String aname,String addr,String phone,String grade)
{
     System.out.println(aname);
	 Connection con;
	 PreparedStatement pstm;
	 int i=1;
	 try {
		 con=ConnectionProvider.createC();
		 pstm=con.prepareStatement("insert into student values(?,?,?,?,?)");
		 pstm.setInt(1, roll);
		 pstm.setString(2, aname);
		 pstm.setString(3, addr);
		 pstm.setString(4, phone);
		 pstm.setString(5, grade);
		 pstm.executeUpdate();
		 con.close();
	 }catch(Exception e) {
		 return 0;
	 } 
	 return i;
}
}
