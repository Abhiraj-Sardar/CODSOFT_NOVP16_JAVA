import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		 System.out.println("--------------------------------");
		 System.out.println("Welcome to The Address Book System");
	     System.out.println("--------------------------------");
	     Scanner sc = new Scanner(System.in);
	     AddressBook AB = new AddressBook();
	     Contact c=new Contact();
	     int flag=0;
	     int err=0;
	     do
	     {
	    	 
	    	 System.out.println("Options:\n");
	         System.out.println("press 1 to Add Contact\npress 2 to Display Contact\npress 3 to remove Contact\npress 4 for Search\npress 5 to Exit");
	         System.out.println("--------------------------------");
	         int choice=sc.nextInt();
	         switch(choice)
	         {
		         case 1:
		         {
		        	 try 
		        	 {
		        	 System.out.println("Enter Name:");
		        	 sc.nextLine();
		        	 c.name=sc.nextLine();
		        	 if(c.name.isEmpty())
		        	 {
		        		 System.out.println("Name can't be Empty!");
		        		 break;
		        	 }
		        	 if(c.name.matches("[a-zA-Z]+[0-9-/@]+")||c.name.matches("[0-9]+"))
		        	 {
		        		 System.out.println("Enter valid Name");
		        		 break;
		        	 }
		        	 System.out.println("Enter Phone No:");
		        	 c.phone=sc.nextLine();
		        	 if(c.phone.length()==0)
		        	 {
		        		 System.out.println("Phone No can't left empty");
		        		 break;
		        	 }
		        	 if((c.phone.length()>10) ||(c.phone.matches("[a-zA-Z]+"))||(c.phone.length()<10 && c.phone.length()>=1))
		        	 {
		        		 System.out.println("please enter valid Phone No");
		        		 break;
		        	 }
		        	 System.out.println("Enter The Email:");
		        	 c.email=sc.nextLine();
		        	 if(c.email.length()==0)
		        	 {
		        		 System.out.println("Email can't left empty");
		        		 break;
		        	 }
		        	 if (!(c.email.matches("[a-z0-9_-]+@[a-z]{5}.[a-z]{3}")))
		        	 {
		        		 System.out.println("Enter Valid email");
		        		 break;
		        	 }
		        	 System.out.println("Enter Address:");
		        	 c.address=sc.nextLine();
		        	 if(c.address.length()==0)
		        	 {
		        		 System.out.println("Address can't left empty");
		        		 break;
		        	 }
		        	 if(c.address.matches("[a-zA-Z]+[0-9-/@#]+")||c.address.matches("[0-9-/#]+")||c.address.matches("[0-9]+[a-zA-Z]+"))
		        	 {
		        		 System.out.println("Enter Valid Address");
		        		 break;
		        	 }
		        	 }catch(Exception e)
		        	 {
		        		 System.out.println("Type Mismatch");
		        	 }
		        	 int status=AB.addContact(c.name, c.phone, c.email, c.address);
		        	 if(status==0)
		        	 {
		        		 System.out.println("There Must be an Error while inserting data...");
		        	 }
		        	 else {
		        		 System.out.println("Data successfully added..");
		        	 }
		        	 break;
		         }
		         case 2:
		         {
		        	 System.out.println("--------------------------------");
		    		 System.out.println("NAME\t\t|\tPHONE NO\t\t|\tEMAIL\t\t\t|\tADDRESS");
		    	     System.out.println("--------------------------------------------------------------------------------------");
		    	     int status=AB.displayContact();
		    	     if(status==0)
		    	     {
		    	    	 System.out.println("There Must be an Error while displaying data...");
		    	     }
		        	 break;
		         }
		         case 3:
		         {
		        	System.out.println("Enter the email:");
		        	sc.nextLine();
		        	String email=sc.nextLine();
		        	if(email.length()==0)
		        	 {
		        		 System.out.println("Email can't left empty");
		        		 break;
		        	 }
		        	 if (!(email.matches("[a-z0-9_-]+@[a-z]{5}.[a-z]{3}")))
		        	 {
		        		 System.out.println("Enter Valid email");
		        		 break;
		        	 }
		        	int status= AB.removeContact(email);
		        	if(status==0)
		        	{
		        		System.out.println("There Must be an Error while removing data...might be the contact you are deleting is not there...");
		        	}
		        	else {
		        		System.out.println("Contact Details deleted..");
		        	}
		        	 break;
		         }
		         case 4:
		         {
		        	 System.out.println("Enter the email:");
			        	sc.nextLine();
			        	String email=sc.nextLine();
			        	if(email.length()==0)
			        	 {
			        		 System.out.println("Email can't left empty");
			        		 break;
			        	 }
			        	 if (!(email.matches("[a-z0-9_-]+@[a-z]{5}.[a-z]{3}")))
			        	 {
			        		 System.out.println("Enter Valid email");
			        		 break;
			        	 }
			        	int status= AB.searchContact(email);
			        	if(status==0)
			        	{
			        		System.out.println("There Must be an Error while searching data...might be the contact you are searching is not there...");
			        	}
			        	 break;
		         }
		         case 5:
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
