import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CRUDScene {
    public static Scene createCRUDScene(Stage stage) {
        TableView<Student> table = new TableView<>();
        ObservableList<Student> data = FXCollections.observableArrayList();

        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(idCol, nameCol, emailCol);
        table.setItems(data);

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            if (!name.isEmpty() && !email.isEmpty()) {
                data.add(new Student(data.size() + 1, name, email));
                nameField.clear();
                emailField.clear();
            }
        });

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> {
            Student selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                data.remove(selected);
            }
        });

        HBox inputBox = new HBox(10, nameField, emailField, addBtn, deleteBtn);
        VBox layout = new VBox(10, table, inputBox);
        layout.setPadding(new Insets(20));

        return new Scene(layout, 600, 400);
    }
}



// package demomavinfx;

// import controller.CRUDController;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
// import model.Student;

// public class CRUDView {
//     public static Scene createCRUDScene(Stage stage) {
//         TableView<Student> table = new TableView<>();
//         ObservableList<Student> data = FXCollections.observableArrayList();

//         TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
//         idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

//         TableColumn<Student, String> nameCol = new TableColumn<>("Name");
//         nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

//         TableColumn<Student, String> emailCol = new TableColumn<>("Email");
//         emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

//         table.getColumns().addAll(idCol, nameCol, emailCol);
//         table.setItems(data);

//         TextField nameField = new TextField();
//         nameField.setPromptText("Name");

//         TextField emailField = new TextField();
//         emailField.setPromptText("Email");

//         Button addBtn = new Button("Add");
//         Button deleteBtn = new Button("Delete");

//         CRUDController controller = new CRUDController(table, nameField, emailField);
//         controller.loadStudents(data);

//         addBtn.setOnAction(e -> controller.addStudent(data));
//         deleteBtn.setOnAction(e -> {
//             Student selected = table.getSelectionModel().getSelectedItem();
//             controller.deleteStudent(data, selected);
//         });

//         HBox inputBox = new HBox(10, nameField, emailField, addBtn, deleteBtn);
//         VBox layout = new VBox(10, table, inputBox);
//         layout.setPadding(new Insets(20));

//         return new Scene(layout, 600, 400);
//     }
// }
