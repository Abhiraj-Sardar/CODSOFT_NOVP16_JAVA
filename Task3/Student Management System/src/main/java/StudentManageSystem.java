import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class StudentManageSystem {
	public PreparedStatement pstm;
	ResultSet rs,nrs;
 public int add(int roll,String name,String addr,String phone,String grade)
 {
	 String sroll=Integer.toString(roll);
	 
	 try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("insert into student values(?,?,?,?,?)");
		 pstm.setString(1, sroll);
		 pstm.setString(2, name);
		 pstm.setString(3, addr);
		 pstm.setString(4, phone);
		 pstm.setString(5, grade);
		 pstm.executeUpdate();
		 con.close();
	 }catch(Exception e) {
		 return 0;
	 } 
	 return 1;
 }
 public int remove(String roll)
 {
	 int i=checkAvailabilty(roll);
	 if(i==0)
	 {
		 return 0;
	 }
	 else
	 {
		 try {
			 Connection con = ConnectionProvider.createC();
			 pstm=con.prepareStatement("delete from student where roll=?");
			 pstm.setString(1, roll);
			 pstm.executeUpdate();
			 con.close();
		 }catch(Exception e) {
			 return 0;
		 } 
		 return 1;
	 }
 }
 public int display()
 {
	 try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("select * from student");
		 rs=pstm.executeQuery();
		 
		 while(rs.next())
		 {
			 System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t"+rs.getString(5));
		 }
		 con.close();
	 }catch(Exception e) {
		 return 0;
	 } 
	 return 1;
 }
 public int search(String roll)
 {
	 
	 try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("select * from student where roll=?");
		 pstm.setString(1, roll);
		 rs=pstm.executeQuery();
		 int i=0;
		 System.out.println("ROLL NO\t|\tNAME\t\t|\tADDRESS\t|\tPHONE NO\t|\tGRADE\t|");
	     System.out.println("--------------------------------------------------------------------------------------");
		 while(rs.next())
		 {
			 i++;
			 System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t"+rs.getString(5));
		 }
		 if(i==0)
		 {
			 return 0;
		 }
		 con.close();
	 }catch(Exception e) {
		 return 0;
	 } 
	 return 1;
 }
 public int update(String roll,String value,int code)
 {
	 if(code==1)
	 {
		 try {
			 Connection con = ConnectionProvider.createC();
			 pstm=con.prepareStatement("update student set name=? where roll=?");
			 pstm.setString(1, value);
			 pstm.setString(2, roll);
			 pstm.executeUpdate();
			 con.close();
		 }catch(Exception e) {
			 return 0;
		 } 
		 return 1;
	 }
	 else if(code==2)
	 {
		 try {
			 Connection con = ConnectionProvider.createC();
			 pstm=con.prepareStatement("update student set address=? where roll=?");
			 pstm.setString(1, value);
			 pstm.setString(2, roll);
			 pstm.executeUpdate();
			 con.close();
		 }catch(Exception e) {
			 return 0;
		 } 
		 return 1;
	 }
	 else if(code==3)
	 {
		 try {
			 Connection con = ConnectionProvider.createC();
			 pstm=con.prepareStatement("update student set phone=? where roll=?");
			 pstm.setString(1, value);
			 pstm.setString(2, roll);
			 pstm.executeUpdate();
			 con.close();
		 }catch(Exception e) {
			 return 0;
		 } 
		 return 1;
	 }
	 else if(code==4)
	 {
		 try {
			 Connection con = ConnectionProvider.createC();
			 pstm=con.prepareStatement("update student set grade=? where roll=?");
			 pstm.setString(1, value);
			 pstm.setString(2, roll);
			 pstm.executeUpdate();
			 con.close();
		 }catch(Exception e) {
			 return 0;
		 } 
		 return 1;
	 }
	 return 0;
}
 private int checkAvailabilty(String roll)
 {
	 try {
		 Connection con = ConnectionProvider.createC();
		 pstm=con.prepareStatement("select * from student where roll=?");
		 pstm.setString(1, roll);
		 rs=pstm.executeQuery();
		 if(rs.next())
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }catch(Exception e) {
		 return 0;
	 } 
 }
}
