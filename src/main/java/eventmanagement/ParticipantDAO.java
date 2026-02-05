package eventmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {

    // CREATE
    public int addParticipant(Participant p, int eventId) {
        String sql = "INSERT INTO participants (name, email, event_id) VALUES (?, ?, ?)";
        int generatedId = -1;

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getEmail());
            ps.setInt(3, eventId);
            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()) {
                if(rs.next()) {
                    generatedId = rs.getInt(1);
                    p.setId(generatedId);
                }
            }

            System.out.println("Participant добавлен в базу");

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }

    // READ
    public void showParticipants() {
        String sql = "SELECT * FROM participants";

        try(Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            while(rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateParticipant(Participant p) {
        String sql = "UPDATE participants SET name = ?, email = ? WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getEmail());
            ps.setInt(3, p.getId());
            ps.executeUpdate();

            System.out.println("Participant обновлен");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteParticipant(int id) {
        String sql = "DELETE FROM participants WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Participant удален");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
