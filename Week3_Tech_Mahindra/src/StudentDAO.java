import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    public static boolean addStudent(String name, String email, String course, double fee, double paid, String address, String phone) {
        double due = fee - paid;
        String query = "INSERT INTO student (name, email, course, fee, paid, due, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, course);
            pst.setDouble(4, fee);
            pst.setDouble(5, paid);
            pst.setDouble(6, due);
            pst.setString(7, address);
            pst.setString(8, phone);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void checkDueFees() {
        String query = "SELECT * FROM student WHERE due > 0";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.println("Student: " + rs.getString("name") + ", Due Fee: " + rs.getDouble("due"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
