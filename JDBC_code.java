package st_JDBC;

import java.sql.*;

public class JDBC_code {
    public static void main(String[] args) {
        try {
            // Load the Driver 
            Class.forName("org.postgresql.Driver");
            System.out.println("✅ Driver Loaded");

            // Establish Connection 
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/student_teacher_db",
                "postgres",
                "root"
            );
            System.out.println("✅ Connected to DB");

            // Create statement 
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE id = ?"
            );
            ps.setInt(1, 101);

            // Execute Query
            ResultSet rs = ps.executeQuery();
            System.out.println("✅ Query Executed");

            // Process Result 
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }

            if (!found) {
                System.out.println("⚠️ No record found for id=1");
            }

            // Close Resources 
            rs.close();
            ps.close();
            con.close();
            System.out.println("✅ Connection Closed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
