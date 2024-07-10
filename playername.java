
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
//import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class playername extends Application {
    public static void main(String[] args) {
        launch(args);
    }
   static Scene scene4;
   @Override
   public void start(Stage primaryStage) {
        Stage window = new Stage();
       //window.initModality(Modality.APPLICATION_MODAL); // Block any interactions with other windows until this one is closed
        window.setTitle("Login");

        BorderPane borderPane = new BorderPane();

        // Left VBox for form elements
        VBox leftColumn = new VBox(20);
        leftColumn.setPadding(new Insets(10,5,10,50));
        leftColumn.setAlignment(Pos.CENTER); // Center the content of the VBox

        // Add empty space above and below the form elements to center them vertically
        VBox.setVgrow(leftColumn, Priority.ALWAYS);

        // Name label
        Label namelb = new Label("Username: ");
       namelb.setPadding(new Insets(10,10,10,10));
        TextField nameip = new TextField();
        nameip.setPromptText("Name");

        // Password label
        Label passlb = new Label("Password:");
        PasswordField passip = new PasswordField();
        passip.setPromptText("Password");

        // Login button
        Button loginbtn = new Button("LOGIN");
        loginbtn.setOnAction(e -> {
            if (nameip.getText().isEmpty() || passip.getText().isEmpty()) {
                alert("Error", "Please enter your username and password.");
            } else {
                window.setScene(gameop.games(nameip.getText()));
            }
        });
        // Add elements to the leftColumn VBox
        leftColumn.getChildren().addAll(namelb, nameip, passlb, passip, loginbtn);

        // Right VBox for image
        VBox rightColumn = new VBox();
        rightColumn.setPadding(new Insets(10));
        rightColumn.setAlignment(Pos.CENTER); // Center the content of the VBox
        
        // Load the image
        Image image = new Image("file:///C:/Users/Ashraf/Desktop/Rocket launcher2/yarab/src/img/Rocket.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(600); // Adjust the size as needed
        imageView.setFitWidth(400);  // Adjust the size as needed

        rightColumn.getChildren().add(imageView);

        // Set the left and right columns in the BorderPane
        borderPane.setLeft(leftColumn);
        borderPane.setCenter(rightColumn);

        scene4 = new Scene(borderPane, 800, 600); // Adjusted size to the scene
       window.setScene(scene4);
       window.showAndWait();

        
    }
    private static void alert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
