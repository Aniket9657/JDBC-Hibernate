package st_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_del {
	
	public static void main(String[]args) {
		try 
		{
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			Connection con  = DriverManager.getConnection("jdbc:postgresql://localHost:5433/student_teacher_db","postgres","root");
			
			
			PreparedStatement ps = con.prepareStatement("Delete from students Where id =?");
			ps.setInt(1, 103);
			
			int rowup = ps.executeUpdate();
			
			if (rowup>0)
			{
				System.out.println("Student Deleted ");
				
			}else 
			{
				System.out.println("No rows of given id ");
				
				
				
			}
			ps.close();
			con.close();
			System.out.println("Connection closed ");
			
			
		}
		catch(Exception e ) {
			e.printStackTrace();		}
	}

}
