
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		 System.out.println("--------------------------------");
		 System.out.println("Welcome to The Student Management System");
	     System.out.println("--------------------------------");
	     Scanner sc = new Scanner(System.in);
	     StudentManageSystem sms = new StudentManageSystem();
	     Student s=new Student();
	     int flag=0;
	     int err=0;
	     do
	     {
	    	 
	    	 System.out.println("Options:\n");
	         System.out.println("press 1 to Add Student\npress 2 to Display Student Details\npress 3 to remove Student\npress 4 for to update\npress 5 for Search\npress 6 to Exit");
	         System.out.println("--------------------------------");
	         int choice=sc.nextInt();
	         switch(choice)
	         {
		         case 1:
		         {
		        	 try 
		        	 {
		        	 System.out.println("Enter Roll no:");
		        	 sc.nextLine();
		        	 String roll=sc.nextLine();
		        	 if(roll.matches("[0-9]"))
		        	 {
		        		 s.roll=Integer.parseInt(roll);
		        	 }
		        	 else {
		        		 System.out.println("please enter int value");
		        		 break;
		        	 }
		        	 System.out.println("Enter Full Name:");
		        	 s.name=sc.nextLine();
		        	 if(s.name.matches("[a-zA-Z0-9]+")) //checking alphanumeric or not
		        	 {
		        		 System.out.println("please enter valid name");
		        		 break;
		        	 }
		        	 System.out.println("Enter Address:");
		        	 s.address=sc.nextLine();
		        	 for(int i=0;i<s.address.length();i++)
		        	 {
		        		 Character c =s.address.charAt(i); 
		        		 if(Character.isDigit(c))
		        		 {
		        			 flag=1;
		        			 break;
		        		 }
		        	 }
		        	 if(flag==1)
		        	 {
		        		 System.out.println("Enter a Valid Address");
		        		 break;
		        	 }
		        	 System.out.println("Enter Phone No:");
		        	 s.phone=sc.nextLine();
		        	 if(s.phone.matches("[a-z|A-Z]"))
		        	 {
		        		 System.out.println("please enter valid phone No");
		        		 break;
		        	 }
		        	 else if(s.phone.length()!=10)
		        	 {
		        		 System.out.println("please enter valid phone No");
		        		 break;
		        	 }
		        	 System.out.println("Enter Grade:");
		        	 s.grade=sc.nextLine();
		        	 if(s.grade.matches("[0-9]")||s.grade.length()!=1)
		        	 {
		        		 System.out.println("please enter valid grade");
		        		 break;
		        	 }
		        	 int status=sms.add(s.roll,s.name,s.address,s.phone,s.grade);
		        	 if(status==1)
		        	 {
		        		 System.out.println("--------------------------------");
		        		 System.out.println("Student Details are Successfully Added...");
		        		 System.out.println("--------------------------------");
		        	 }
		        	 else
		        	 {
		        		 System.out.println("--------------------------------");
		        		 System.out.println("There is an Error while Adding Student...");
		        		 System.out.println("--------------------------------");
		        	 }
		        	 }catch(Exception e)
		        	 {
		        		 System.out.println("Type Mismatch");
		        	 }
		        	 break;
		         }
		         case 2:
		         {
		        	 System.out.println("--------------------------------");
		    		 System.out.println("ROLL NO\t|\tNAME\t\t|\tADDRESS\t|\tPHONE NO\t|\tGRADE\t|");
		    	     System.out.println("--------------------------------------------------------------------------------------");
		    	     int status=sms.display();
		    	     System.out.println("--------------------------------");
		    	     if(status==0)
		    	     {
		    	    	 System.out.println("--------------------------------");
		    	    	 System.out.println("There is an Error while Displaying Students...");
		    	    	 System.out.println("--------------------------------");
		    	     }
		        	 break;
		         }
		         case 3:
		         {
		        	 System.out.println("--------------------------------");
		        	 System.out.println("Enter Student Roll/ID:");
		        	 sc.nextLine();
		        	 String roll=sc.nextLine();
		        	 if(roll.matches("[0-9]"))
		        	 {
		        		 s.roll=Integer.parseInt(roll);
		        	 }
		        	 else {
		        		 System.out.println("please enter int value");
		        		 break;
		        	 }
		        	 int status=sms.remove(roll);
		        	 if(status==1)
		    	     {
		        		 System.out.println("--------------------------------");
		        		 System.out.println("Student Record Successfully Removed...");
		        		 System.out.println("--------------------------------");
		    	     }
		        	 else
		        	 {
		        		 System.out.println("--------------------------------");
		        		 System.out.println("There is no such Student to remove...");
		        		 System.out.println("--------------------------------");
		        	 }
		        	 break;
		         }
		         case 4:
		         {
		        	 System.out.println("--------------------------------");
		        	 System.out.println("Enter Student Roll/ID:");
		        	 sc.nextLine();
		        	 String roll=sc.nextLine();
		        	 if(roll.matches("[0-9]"))
		        	 {
		        		 s.roll=Integer.parseInt(roll);
		        	 }
		        	 else {
		        		 System.out.println("please enter int value");
		        		 break;
		        	 }
		        	 int status=sms.search(roll);
		        	 System.out.println("--------------------------------");
		        	 if(status==0)
		        	 {
		        		 System.out.println("--------------------------------");
		        		 System.out.println("There is no such Student to update...");
		        		 System.out.println("--------------------------------");
		        		 break;
		        	 }
		        	 System.out.println("--------------------------------");
		        	 System.out.println("Enter what you want to update:");
		        	 System.out.println("press 1 to Update Name\npress 2 to Update Address\npress 3 to Update PhoneNo\npress 4 to update Grade\npress 5 for exit");
		        	 System.out.println("--------------------------------");
			         int ch=sc.nextInt();
			        
			         switch(ch)
			         {
				         case 1:
				         {
				        	 System.out.println("Enter Student New Name:");
				        	 sc.nextLine();
				        	 s.name=sc.nextLine();
				        	 if(s.name.matches("[a-zA-Z0-9]+")) //checking alphanumeric or not
				        	 {
				        		 System.out.println("please enter valid name");
				        		 status=0;
				        		 break;
				        	 }
				        	 System.out.println("--------------------------------");
				        	 int status1=sms.update(roll,s.name,ch);
				        	 break;
				         }
				         case 2:
				         {
				        	 System.out.println("Enter Student New Address:");
				        	 sc.nextLine();
				        	 s.address=sc.nextLine();
				        	 for(int i=0;i<s.address.length();i++)
				        	 {
				        		 Character c =s.address.charAt(i); 
				        		 if(Character.isDigit(c))
				        		 {
				        			 flag=1;
				        			 break;
				        		 }
				        	 }
				        	 if(flag==1)
				        	 {
				        		 System.out.println("Enter a Valid Address");
				        		 status=0;
				        		 break;
				        	 }
				        	 System.out.println("--------------------------------");
				        	 int status1=sms.update(roll,s.address,ch);
				        	 break;
				         }
				         case 3:
				         {
				        	 System.out.println("Enter Student New Phone No:");
				        	 sc.nextLine();
				        	 s.phone=sc.nextLine();
				        	 if(s.phone.matches("[a-z|A-Z]"))
				        	 {
				        		 System.out.println("please enter valid phone No");
				        		 status=0;
				        		 break;
				        	 }
				        	 else if(s.phone.length()!=10)
				        	 {
				        		 System.out.println("please enter valid phone No");
				        		 status=0;
				        		 break;
				        	 }
				        	 System.out.println("--------------------------------");
				        	 int status1=sms.update(roll,s.phone,ch);
				        	 break;
				         }
				         case 4:
				         {
				        	 System.out.println("Enter Student New Grade:");
				        	 sc.nextLine();
				        	 s.grade=sc.nextLine();
				        	 if(s.grade.matches("[0-9]")||s.grade.length()!=1)
				        	 {
				        		 System.out.println("please enter valid grade");
				        		 status=0;
				        		 break;
				        	 }
				        	 System.out.println("--------------------------------");
				        	 status=sms.update(roll,s.grade,ch);
				        	 break;
				         }
				         case 5:
				         {
				        	 err=1;
				        	 status=0;
				        	 System.out.println("You Have exited from update operation");
				        	 break;
				         }
				         default:
				         {
				        	 
				        		 System.out.println("--------------------------------");
					        	 System.out.println("You may Have selected wrong option..");
					        	 System.out.println("--------------------------------");
					        	 status=0;
				        	 
				         }
			         }
			         if(status==1)
		        	 {
			        	 System.out.println("--------------------------------");
		        		 System.out.println("Student Record is Updated..");
		        		 System.out.println("--------------------------------");
		        	 }
			         else
			         {
			        	 if(err==1)
			        	 {
			        	 
			        	 }
			        	 else
			        	 {
			        		 System.out.println("--------------------------------");
				        	 System.out.println("There is an Error while Updating Students...");
				        	 System.out.println("--------------------------------");
			        	 }
			         }
		        	 break;
		         }
		         case 5:
		         {
		        	 System.out.println("--------------------------------");
		        	 System.out.println("Enter Student Roll/ID:");
		        	 sc.nextLine();
		        	 String roll=sc.nextLine();
		        	 if(roll.matches("[0-9]"))
		        	 {
		        		 s.roll=Integer.parseInt(roll);
		        	 }
		        	 else {
		        		 System.out.println("please enter int value");
		        		 break;
		        	 }
		        	 int status=sms.search(roll);
		        	 System.out.println("--------------------------------");
		        	 if(status==0)
		    	     {
		        		 System.out.println("--------------------------------");
		    	    	 System.out.println("NO Student is There with this ID...");
		    	    	 System.out.println("--------------------------------");
		    	     }
		        	 break;
		         }
		         case 6:
		         {
		        	 System.exit(0);
		         }
		         default:
		         {
		        	 System.out.println("--------------------------------");
		        	 System.out.println("You may Have selected wrong option..");
		        	 System.out.println("--------------------------------");
		         }
	         }
	    	 
	     }while(true);

	}

}
