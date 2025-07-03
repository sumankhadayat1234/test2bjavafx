package demomavinfx;



import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Student;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDController {
    private TableView<Student> tableView;
    private TextField nameField;
    private TextField emailField;

    public CRUDController(TableView<Student> tableView, TextField nameField, TextField emailField) {
        this.tableView = tableView;
        this.nameField = nameField;
        this.emailField = emailField;
    }

    public void loadStudents(ObservableList<Student> data) {
        data.clear();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                data.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(ObservableList<Student> data) {
        String name = nameField.getText();
        String email = emailField.getText();

        if (name.isEmpty() || email.isEmpty()) return;

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, email);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    data.add(new Student(id, name, email));
                    nameField.clear();
                    emailField.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(ObservableList<Student> data, Student student) {
        if (student == null) return;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, student.getId());
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                data.remove(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
