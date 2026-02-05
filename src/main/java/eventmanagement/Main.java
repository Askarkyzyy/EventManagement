package eventmanagement;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:postgresql://localhost:5433/EventManagement";
        String user = "postgres";
        String password = "Oq1!i?hh";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.print("Enter Event ID: ");
            int eventId = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            System.out.print("Enter participant name: ");
            String name = scanner.nextLine();

            String insertSQL = "INSERT INTO participants (name, email, event_id) VALUES (?, NULL, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, name);
                ps.setInt(2, eventId);
                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("Participant added with ID: " + id + " and Name: " + name);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
