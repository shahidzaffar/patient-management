import JavaDB.*;
import java.util.*;

public class Client {

	public static void main(String[] args) 
	{
		
		Display();
		DBProcess dbp=new DBProcess();
		int a;
		Scanner s=new Scanner(System.in);
		int ch=1;
		do
		{
			DisplayMenu();
			a=s.nextInt();
			switch(a)
			{
				case 1:
				{
					dbp.retrievePatient();
					break;
				}
				case 2:
				{
					dbp.retrieveDoctor();
					break;
				}
				case 3:
				{
					dbp.retrieveBeds();
					break;
				}
				default:
					System.out.println("Invalid Input");
			}
			System.out.println("\n\nEnter any number to run again or '0' to exit");
			ch=s.nextInt();
		}while(ch!=0);	
	}
	
	public static void Display()
	{
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*              Please Wait                       *");
		System.out.println("*        We Are Connecting to Database           *");
		System.out.println("*                                                *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");
		System.out.println("\n\n\n");
		
	}
	
	public static void DisplayMenu()
	{
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*                  Enter Your Choice             *");
		System.out.println("* 1: Retrieve Data of ALl patients               *");
		System.out.println("* 2: Retrieve doctor treating a patient           *");
		System.out.println("* 3: Bed Number occupied                         *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");
		System.out.println("\n\n");
		
	}

}
