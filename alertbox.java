//import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
//import javax.swing.JPanel;
import javafx.geometry.Pos;

//class for alertbox btfta7 window gdeda

public class alertbox {

    Image image;

    public static void display(String title , String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); //block ay haga fe el window el 2blha le 7d ma tet2fel 
        window.setTitle(title);
        window.setMinWidth(250);

        Label label1 = new Label();
        label1.setText(message);
        Button closebtn = new Button("close window");
        closebtn.setOnAction(e -> window.close());


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,closebtn);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
    }

}
