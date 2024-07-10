
//import javax.swing.ImageIcon;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
// import javafx.scene.layout.Background;
// import javafx.scene.layout.BackgroundImage;
// import javafx.scene.layout.BackgroundPosition;
// import javafx.scene.layout.BackgroundRepeat;
// import javafx.scene.layout.BackgroundSize;
// //import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class RocketLauncher extends Application implements EventHandler<ActionEvent>  {
    Stage window;
    Scene scene1, scene2;
    Button button, button2, button3, button4, btn1, btn2,button5;
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Rocket Launcher");



        // ///////////////////////////////////////////////////////////////////////////////////////////////
        // // Load the background image
        // Image backgroundImage = new Image("file:///C:/Users/Ashraf/Desktop/Rocket launcher2/yarab/src/flappybird.png");
        
        // // Create a BackgroundImage object for the background
        // BackgroundImage bgImage = new BackgroundImage(backgroundImage,
        // BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        // BackgroundPosition.CENTER,
        // new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));    
        // ///////////////////////////////////////////////////////////////////////////////////////////////////

        // Layout for Scene 1
        VBox layout1 = new VBox(20);
        //layout1.setBackground(new Background(bgImage));//////////////////////



        
        scene1 = new Scene(layout1, 1000, 500);




        // Buttons for scene1   
        btn1 = new Button("Go to scene 2");
      //  btn1.setOnAction(e -> window.setScene(playername.menu()));////////////////////////////////////////////////////mohm gdn
       btn1.setOnAction(e -> window.setScene(scene2));

        button = new Button("Go to alert box");
        // Assuming alertbox is a defined class with a static display method
        button.setOnAction(e -> alertbox.display("Alert", "Hello!"));

        button2 = new Button("Go to confirm box");
        // Assuming confirmbox is a defined class with a static display method
        button2.setOnAction(e -> {
            boolean result = confirmbox.display("Confirm Box", "Hello Confirm Box");
            System.out.println(result);
        });

        // button3 = new Button("Player");
        // // Assuming playername is a defined class with a static menu method
        // button3.setOnAction(e -> playername.menu());

        button4 = new Button("Table");
        // Assuming gettabledata is a defined class with a static display method
        button4.setOnAction(e -> gettabledata.display());


        ////
        // button5 = new Button("games");
        // button5.setOnAction(e -> gameop.games());

        layout1.getChildren().addAll(btn1, button, button2, button3, button4);

        // Layout for Scene 2
        StackPane layout2 = new StackPane();
        scene2 = new Scene(layout2, 500, 300);
        btn2 = new Button("Go back to scene 1");
        btn2.setOnAction(e -> window.setScene(scene1));
        layout2.getChildren().add(btn2);

        // Set initial scene
        window.setScene(scene1);
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button) {
            System.out.println("Button pressed");
        }
    }
}
