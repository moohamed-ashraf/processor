import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.JFrame;

public class gameop {

    public static Scene games(String username) {
        // GridPane layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30, 30, 10, 30));
        layout.setVgap(20);
        layout.setHgap(20);
        layout.setBackground(new Background(new BackgroundFill(Color.rgb(21, 25, 28),
                CornerRadii.EMPTY, Insets.EMPTY)));

        // Load the images
        Image image1 = new Image("file:///C:/Users/Ashraf/Desktop/Rocket launcher2/yarab/src/img/flappybirdbtn.png");
        Image image2 = new Image("file:///C:/Users/Ashraf/Desktop/Rocket launcher2/yarab/src/img/snake.png");
        Image image3 = new Image("file:///C:/Users/Ashraf/Desktop/Rocket launcher2/yarab/src/img/XO.png");
        Image image4 = new Image("file:///C:/Users/Ashraf/Desktop/Rocket launcher2/yarab/src/img/blackjack.png");

        // Create ImageViews for the images
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // Set the size and preserve ratio for ImageViews
        imageView1.setFitWidth(300);
        imageView1.setFitHeight(300);
        imageView1.setPreserveRatio(true);

        imageView2.setFitWidth(300);
        imageView2.setFitHeight(300);
        imageView2.setPreserveRatio(true);

        imageView3.setFitWidth(300);
        imageView3.setFitHeight(300);
        imageView3.setPreserveRatio(true);

        imageView4.setFitWidth(300);
        imageView4.setFitHeight(300);
        imageView4.setPreserveRatio(true);

        // Button with image
        Button btn1 = new Button();
        btn1.setGraphic(imageView1);
        btn1.setPrefSize(300, 300);
        btn1.setBackground(new Background(new BackgroundFill(Color.rgb(21, 25, 28), CornerRadii.EMPTY, Insets.EMPTY)));
        btn1.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        btn1.setOnMouseEntered(e -> btn1.setBorder(new Border(new BorderStroke(Color.BISQUE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));
        btn1.setOnMouseExited(e -> btn1.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));

        Button btn2 = new Button();
        btn2.setGraphic(imageView2);
        btn2.setPrefSize(300, 300);
        btn2.setBackground(new Background(new BackgroundFill(Color.rgb(21, 25, 28), CornerRadii.EMPTY, Insets.EMPTY)));
        btn2.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        btn2.setOnMouseEntered(e -> btn2.setBorder(new Border(new BorderStroke(Color.AQUA,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));
        btn2.setOnMouseExited(e -> btn2.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));
                btn2.setOnAction(e -> {
                   
                    JFrame frame = new JFrame("Snake Game");
                    snakegame snakeGame = new snakegame(800, 600);
                    frame.add(snakeGame);
                    frame.pack();
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                });
        

        Button btn3 = new Button();
        btn3.setGraphic(imageView3);
        btn3.setPrefSize(300, 300);
        btn3.setBackground(new Background(new BackgroundFill(Color.rgb(21, 25, 28), CornerRadii.EMPTY, Insets.EMPTY)));
        btn3.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        btn3.setOnMouseEntered(e -> btn3.setBorder(new Border(new BorderStroke(Color.CHOCOLATE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));
        btn3.setOnMouseExited(e -> btn3.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));

        Button btn4 = new Button();
        btn4.setGraphic(imageView4);
        btn4.setPrefSize(300, 300);
        btn4.setBackground(new Background(new BackgroundFill(Color.rgb(21, 25, 28), CornerRadii.EMPTY, Insets.EMPTY)));
        btn4.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        btn4.setOnMouseEntered(e -> btn4.setBorder(new Border(new BorderStroke(Color.AZURE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));
        btn4.setOnMouseExited(e -> btn4.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))));

        Label l1 = new Label("WELCOME " + username);
        l1.setTextFill(Color.BLACK);
        l1.setFont(new Font("Arial", 30));
        l1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        l1.setAlignment(Pos.TOP_LEFT);

        // Adding buttons to the layout
        GridPane.setConstraints(btn1, 0, 1);
        GridPane.setConstraints(btn2, 0, 2);
        GridPane.setConstraints(btn3, 1, 1);
        GridPane.setConstraints(btn4, 1, 2);
        GridPane.setConstraints(l1, 0, 0);

        layout.getChildren().addAll(btn1, btn2, btn3, btn4, l1);

        // Scene setup
        Scene scene = new Scene(layout, 1500, 800); // Adjust the size of the scene as needed

        return scene;
    }

   
}
