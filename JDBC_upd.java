package st_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_upd 
{
	public static void main(String[]args)
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded ");
			
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localHost:5433/student_teacher_db","postgres","root");
			System.out.println("Connection Created ");
			
			
			Scanner Sc = new Scanner(System.in);
			
			System.out.println(" Enter Student id to Update ");
			int id = Sc.nextInt();
			Sc.nextLine();
			
			System.out.println("Updated name ");
			String name = Sc.nextLine();
			Sc.nextLine();
			
			
			System.out.println("update age ");
			int age = Sc.nextInt();
			Sc.nextLine();
			
			
			System.out.println("Update Email");
			String email = Sc.nextLine();
			Sc.nextLine();
			
			
			
			
			
			
			String sql =" update students SET name = ?, age = ? , email = ? where id = ? " ;
			PreparedStatement ps  = con.prepareStatement(sql);
			
			
			
			ps.setString(1,name);
			ps.setInt(2, age);
			ps.setString(3,email);
			ps.setInt(4,id);
			
			
			int upStud = ps.executeUpdate();
			if (upStud>0)
			{
				System.out.println("Student Update");
				
			}
			
			else 
			{
				System.out.println("No Id present");
				
			}
			
			
			ps.close();
			con.close();
			
			
			
			
			
			
			
			
			
		}
		catch (Exception e)
		{
			
            e.printStackTrace();			
		}
	}
	
	

}
