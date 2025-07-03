package demomavinfx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScene {
    public static Scene createLoginScene(Stage primaryStage) {
        Label userLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String user = usernameField.getText();
            String pass = passwordField.getText();
            if (user.isEmpty() || pass.isEmpty()) {
                messageLabel.setText("Please enter username and password.");
            } else {
                primaryStage.setScene(CRUDScene.createCRUDScene(primaryStage));
            }
        });

        VBox loginLayout = new VBox(10, userLabel, usernameField, passLabel, passwordField, loginButton, messageLabel);
        loginLayout.setPadding(new Insets(20));
        return new Scene(loginLayout, 400, 300);
    }
}


// package demomavinfx;

// // import controller.LoginController;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class LoginView {
//     public static Scene createLoginScene(Stage primaryStage) {
//         Label userLabel = new Label("Username:");
//         TextField usernameField = new TextField();

//         Label passLabel = new Label("Password:");
//         PasswordField passwordField = new PasswordField();

//         Button loginButton = new Button("Login");
//         Label messageLabel = new Label();

//         LoginController controller = new LoginController(primaryStage, usernameField, passwordField, messageLabel);

//         loginButton.setOnAction(e -> controller.handleLogin());

//         VBox layout = new VBox(10, userLabel, usernameField, passLabel, passwordField, loginButton, messageLabel);
//         layout.setPadding(new Insets(20));

//         return new Scene(layout, 400, 300);
//     }
// }

