import java.util.Scanner;
class Student
{
    int roll;
    String name;
    String address;
    String phone;
    String grade;
}
class SMS
{
    public boolean addStudent(int roll,String name,String addr,String phone,String grade)
    {   
        
        Add add = new Add();
        int i=add.insert(roll,name,addr,phone,grade);
        if(i==1)
        {
            System.out.println(name);
            return true;
        }
        else{
            return false;
        }
    }
    public void displayStudent()
    {
        
    }
    public void removeStudent()
    {

    }
    public void searchStudent()
    {

    }
    public void updateStudent()
    {
        
    }
}
public class App {
    public static void main(String[] args)
    {
        String grade;
        int choice=0;
        System.out.println("--------------------------------");
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("--------------------------------");
        do
        {
            SMS studentManage = new SMS();
            System.out.println("Select Your Option:\npress 1 to Add Student\npress 2 to Display All Student \npress 3 to Remove Student\npress 4 to Search for Student\npress 5 to Update Student Details\npress 6 to Exit");
            System.out.println("--------------------------------");
            Scanner sc = new Scanner(System.in);
            choice=sc.nextInt();
            System.out.println("--------------------------------");
            switch(choice)
            {
                case 1:
                {
                    Student s =new Student();
                    System.out.println("Enter Student Roll No:");
                    s.roll=sc.nextInt();
                    System.out.println("Enter Student Full Name:");
                    s.name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter Student Address:");
                    s.address=sc.nextLine();
                    System.out.println("Enter Student Phone No:");
                    s.phone=sc.nextLine();
                    System.out.println("Enter Student Grade:");
                    s.grade=sc.nextLine();

                    if(studentManage.addStudent(s.roll,s.name,s.address,s.phone,s.grade))
                    {
                        System.out.println("Successfully Student Added");
                    }
                    else{
                        System.out.println("There is a problem");
                    }
                    break;
                }
                case 2:
                {
                    break;
                }
            }
        }while(choice!=6);
       

    }
}
