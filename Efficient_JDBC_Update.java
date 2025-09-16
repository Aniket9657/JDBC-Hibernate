package st_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Efficient_JDBC_Update {
	

	
	
	    public static void main(String[] args) {
	        try {
	            // Load driver
	            Class.forName("org.postgresql.Driver");
	            System.out.println("✅ Driver loaded");

	            // Establish connection
	            Connection con = DriverManager.getConnection(
	                "jdbc:postgresql://localhost:5433/student_teacher_db",
	                "postgres",
	                "root"
	            );
	            System.out.println("✅ Connection Created");

	            Scanner sc = new Scanner(System.in);

	            System.out.print("Enter Student ID to update: ");
	            int id = sc.nextInt();
	            sc.nextLine(); // clear buffer

	            boolean keepUpdating = true;

	            while (keepUpdating) {
	                System.out.println("\n--- Update Menu ---");
	                System.out.println("1. Update Name");
	                System.out.println("2. Update Age");
	                System.out.println("3. Update Email");
	                System.out.println("4. Exit");
	                System.out.print("Choose option: ");
	                int choice = sc.nextInt();
	                sc.nextLine(); // clear buffer

	                String sql = "";
	                PreparedStatement ps = null;

	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter new Name: ");
	                        String name = sc.nextLine();
	                        sql = "UPDATE students SET name = ? WHERE id = ?";
	                        ps = con.prepareStatement(sql);
	                        ps.setString(1, name);
	                        ps.setInt(2, id);
	                        break;

	                    case 2:
	                        System.out.print("Enter new Age: ");
	                        int age = sc.nextInt();
	                        sql = "UPDATE students SET age = ? WHERE id = ?";
	                        ps = con.prepareStatement(sql);
	                        ps.setInt(1, age);
	                        ps.setInt(2, id);
	                        break;

	                    case 3:
	                        System.out.print("Enter new Email: ");
	                        String email = sc.nextLine();
	                        sql = "UPDATE students SET email = ? WHERE id = ?";
	                        ps = con.prepareStatement(sql);
	                        ps.setString(1, email);
	                        ps.setInt(2, id);
	                        break;

	                    case 4:
	                        keepUpdating = false;
	                        continue; // skip rest of loop
	                        
	                    default:
	                        System.out.println("❌ Invalid choice. Try again.");
	                        continue;
	                }

	                if (ps != null) {
	                    int rows = ps.executeUpdate();
	                    if (rows > 0) {
	                        System.out.println("✅ Student updated successfully.");
	                    } else {
	                        System.out.println("⚠️ No student found with ID: " + id);
	                    }
	                    ps.close();
	                }
	            }

	            sc.close();
	            con.close();
	            System.out.println("🔒 Connection closed.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



