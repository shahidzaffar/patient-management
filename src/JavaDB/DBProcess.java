package JavaDB;

import java.util.Scanner;

public class DBProcess 
{
	Scanner s=new Scanner(System.in);
	private DBConnect c;
	public DBProcess()
	{
		c=new DBConnect("jdbc:ucanaccess://"+"E:\\5th Smester\\Java workplace\\JavaDatabaseProblem\\Hospital.accdb","net.ucanaccess.jdbc.UcanaccessDriver");

	}
	
	public void retrievePatient()
	{
		c.retrievePatients();
		
	}
	public void retrieveDoctor()
	{
		int id;
		System.out.println("\n***************************************************\nEnter ID of Patient\n**********************************************");
		id=s.nextInt();
		c.retrieveDoctor(id);
	}
	

	public void retrieveBeds()
	{
		c.bedOccupied();
	}
	public void clos()
	{
		c.clos();
	}

}

