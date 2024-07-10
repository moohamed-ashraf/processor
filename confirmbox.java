//import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class confirmbox {
    static boolean answer;
    static Button yesbtn,nobtn;
    public static boolean display(String title , String message)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //block ay haga fe el window el 2blha le 7d ma tet2fel 
        window.setTitle(title);
        window.setMinWidth(250);
        Label label1 = new Label();
        label1.setText(message);

        yesbtn=new Button("yes");
        nobtn=new Button("no");
        
        yesbtn.setOnAction(e -> 
        {
            answer = true;
            window.close();
        });

        nobtn.setOnAction(e -> 
        {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,yesbtn,nobtn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }

}
