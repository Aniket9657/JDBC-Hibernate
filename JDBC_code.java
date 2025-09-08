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

            // =========================
            // 1️⃣ Query Students Table
            // =========================
            PreparedStatement psStudent = con.prepareStatement(
                "SELECT * FROM students WHERE id = ?"
            );
            psStudent.setInt(1, 101);

            ResultSet rsStudent = psStudent.executeQuery();
            System.out.println("\n🎓 Student Info:");
            boolean studentFound = false;
            while (rsStudent.next()) {
                studentFound = true;
                System.out.println(rsStudent.getInt("id") + " " + rsStudent.getString("name"));
            }
            if (!studentFound) {
                System.out.println("⚠️ No student found with id=101");
            }

            // =========================
            // 2️⃣ Query Teachers Table
            // =========================
            PreparedStatement psTeacher = con.prepareStatement(
                "SELECT * FROM teachers WHERE id = ?"
            );
            psTeacher.setInt(1, 201);

            ResultSet rsTeacher = psTeacher.executeQuery();
            System.out.println("\n👨‍🏫 Teacher Info:");
            boolean teacherFound = false;
            while (rsTeacher.next()) {
                teacherFound = true;
                System.out.println(rsTeacher.getInt("id") + " " + rsTeacher.getString("name"));
            }
            if (!teacherFound) {
                System.out.println("⚠️ No teacher found with id=201");
            }

            // =========================
            // Close Resources 
            // =========================
            rsStudent.close();
            rsTeacher.close();
            psStudent.close();
            psTeacher.close();
            con.close();
            System.out.println("\n✅ Connection Closed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
