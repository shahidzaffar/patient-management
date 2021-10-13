package JavaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect 
{
	Statement stat=null;
	Connection con=null;
	ResultSet result=null;
	ResultSetMetaData meta=null;
	int n;
	
	
	public DBConnect(String path,String path2) 
	{
	
		try
		{
			Class.forName(path2);
			con=DriverManager.getConnection(path);
			stat=con.createStatement();
			
			
			System.out.println("Successfully Connected to Hospital DB\n");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		} 
	}
	
	
	public void retrievePatients()
	{
		try 
		{
			
			result=stat.executeQuery("Select * from patient_t ");
			meta=result.getMetaData();
			for(int i=1;i<=meta.getColumnCount();i++)
				System.out.print(meta.getColumnName(i)+"\t");
			System.out.println("\n******************************************************");
			while(result.next())
			{
				
				
				System.out.print(result.getString("name_p")+"\t");
				System.out.print(result.getInt("bed_id")+"\t");
				System.out.print(result.getInt("doctor_id")+"\t\t");
				System.out.print(result.getInt("ID")+"\t");
				System.out.print(result.getInt("room_id")+"\t");
				System.out.print(result.getInt("age")+"\t");
				
				System.out.println();
			}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	public void retrieveDoctor(int aID)
	{
		int id=0;
		try 
		{
			
			result=stat.executeQuery("Select * from patient_t where ID="+aID);
			while(result.next())
			{
				id=result.getInt("doctor_id");
			}
			
			
			result=stat.executeQuery("Select * from Doctor_t where ID="+id);
		
			meta=result.getMetaData();
			for(int i=1;i<=meta.getColumnCount();i++)
				System.out.print(meta.getColumnName(i)+"\t");
			System.out.println("\n******************************************************");
			
			while(result.next())
			{
				System.out.print(result.getString("name_d")+"  \t");
				System.out.print(result.getInt("age")+"\t");
				System.out.print(result.getInt("cnic")+"\t");
				System.out.print(result.getInt("ID")+"\t");
				
				System.out.println();
			}
	
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void clos()
	{
		try {
			con.close();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	
	public void bedOccupied()
	{
		int status=0;
		try
		{
			
				System.out.println("Displaying Bed numbers which are Currently occupied");
				
			
			
			result=stat.executeQuery("Select * from beds ");
			meta=result.getMetaData();
			while(result.next())
			{
			
				status=result.getInt("status");
				if(status==1)
				{
					display(result);
				}
			}
			
			
			System.out.println("are Currently occupied");
		
		
		
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	private void display(ResultSet result2) 
	{
		try {
			while(result2.next())
			{
				
				System.out.print("Bed No : "+result2.getInt("ID")+"\t");
				
				System.out.println();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	
	public static void getConnection(String path) {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
			statement  = connection.createStatement();
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


}
*/
