import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends Application {
    int boardWidth = 360;
    int boardHeight = 640;

    // images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    // bird class
    int birdX = boardWidth / 8;
    int birdY = boardWidth / 2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    // pipe class
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;  // scaled by 1/6
    int pipeHeight = 512;

    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false;

        Pipe(Image img) {
            this.img = img;
        }
    }

    // game logic
    Bird bird;
    int velocityX = -4; // move pipes to the left speed (simulates bird moving right)
    int velocityY = 0; // move bird up/down speed.
    int gravity = 1;

    ArrayList<Pipe> pipes;
    Random random = new Random();

    boolean gameOver = false;
    double score = 0;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(boardWidth, boardHeight);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flappy Bird");
        primaryStage.setResizable(false);
        primaryStage.show();

        // load images
        backgroundImg = new Image(getClass().getResourceAsStream("/flappybirdbg.png"));
        birdImg = new Image(getClass().getResourceAsStream("/flappybird.png"));
        topPipeImg = new Image(getClass().getResourceAsStream("/toppipe.png"));
        bottomPipeImg = new Image(getClass().getResourceAsStream("/bottompipe.png"));

        // bird
        bird = new Bird(birdImg);
        pipes = new ArrayList<>();

        // game loop
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();
                draw(canvas.getGraphicsContext2D());
                if (gameOver) {
                    stop();
                }
            }
        };

        // place pipes timer
        // new javafx.animation.Timeline(
        //         new javafx.animation.KeyFrame(
        //                 javafx.util.Duration.seconds(1.5),
        //                 event -> placePipes()
        //         )
        // ).setCycleCount(javafx.animation.Animation.INDEFINITE).play();

        // key event handler
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == javafx.scene.input.KeyCode.SPACE) {
                velocityY = -9;

                if (gameOver) {
                    // restart game by resetting conditions
                    bird.y = birdY;
                    velocityY = 0;
                    pipes.clear();
                    gameOver = false;
                    score = 0;
                    gameLoop.start();
                }
            }
        });

        gameLoop.start();
    }

    void placePipes() {
        int randomPipeY = (int) (pipeY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingSpace = boardHeight / 4;

        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }

    public void draw(GraphicsContext gc) {
        // background
        gc.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight);

        // bird
        gc.drawImage(birdImg, bird.x, bird.y, bird.width, bird.height);

        // pipes
        for (Pipe pipe : pipes) {
            gc.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height);
        }

        // score
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Arial", 32));
        if (gameOver) {
            gc.fillText("Game Over: " + (int) score, 10, 35);
        } else {
            gc.fillText(String.valueOf((int) score), 10, 35);
        }
    }

    public void move() {
        // bird
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0); // apply gravity to current bird.y, limit the bird.y to top of the canvas

        // pipes
        for (Pipe pipe : pipes) {
            pipe.x += velocityX;

            if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                score += 0.5; // 0.5 because there are 2 pipes! so 0.5*2 = 1, 1 for each set of pipes
                pipe.passed = true;
            }

            if (collision(bird, pipe)) {
                gameOver = true;
            }
        }

        if (bird.y > boardHeight) {
            gameOver = true;
        }
    }

    boolean collision(Bird a, Pipe b) {
        return a.x < b.x + b.width &&   // a's top left corner doesn't reach b's top right corner
               a.x + a.width > b.x &&   // a's top right corner passes b's top left corner
               a.y < b.y + b.height &&  // a's top left corner doesn't reach b's bottom left corner
               a.y + a.height > b.y;    // a's bottom left corner passes b's top left corner
    }

    public static void startFlappyBird() {
        launch();
    }
}
