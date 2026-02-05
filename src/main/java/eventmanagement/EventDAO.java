package eventmanagement;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class EventDAO {

    // CREATE
    public int addEvent(Event e) {
        String sql = "INSERT INTO events (name, date, location, description) VALUES (?, ?, ?, ?)";
        int generatedId = -1;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, e.getName());
            ps.setDate(2, Date.valueOf(e.getDate()));
            ps.setString(3, e.getLocation());
            ps.setString(4, e.getDescription()); // новая колонка
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                    e.setId(generatedId);
                }
            }

            System.out.println("Event добавлено в базу данных");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return generatedId;
    }

    // READ
    public void showEvents() {
        String sql = "SELECT * FROM events";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDate("date") + " | " +
                        rs.getString("location") + " | " +
                        rs.getString("description")); // новая колонка
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Event e = new Event(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("date").toString(),
                        rs.getString("location"),
                        rs.getString("description")
                );
                events.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return events;
    }

    // UPDATE
    public void updateEvent(Event e) {
        String sql = "UPDATE events SET name = ?, date = ?, location = ?, description = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setDate(2, Date.valueOf(e.getDate()));
            ps.setString(3, e.getLocation());
            ps.setString(4, e.getDescription()); // новая колонка
            ps.setInt(5, e.getId());
            ps.executeUpdate();

            System.out.println("Event обновлено");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // DELETE
    public void deleteEvent(int id) {
        String sql = "DELETE FROM events WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Event удалено");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
