import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; //all pipes in the game 
import java.util.Random; //placing pipes@random postion 
import javax.swing.*;

import javafx.scene.image.ImageView;

public class Flappybirdd extends JPanel implements ActionListener, KeyListener { //flappy bird inhert from jpanel for gui
    int boardWidth = 360;                                           //keylistner interface to use the keyboard 
    int boardHeight = 640; 
                             
    Image backgroundImg;   //variables for bg image 
    Bird bird; // declares a variable named bird that will reference a Bird object
    ArrayList<Pipe> pipes; // because we have many pipes to put
    Random random = new Random(); //to replace pipes in random postion 

    Timer gameLoop;  //resposible for game mainloop where updating actions in each loopoint(move,score,...etc)
    Timer placePipeTimer; //place timer in regular interval (1.5 sec.)
    boolean gameOver = false; //intilize gameove bool false
    double score = 0; //intalize score=0 

    int initialOpeningSpace = boardHeight / 4;
    int minOpeningSpace = 80; // Minimum gap between pipes
    int gapReductionStep = 5; // Reduction step for the gap
    int pipesPassed = 0; // Counter for pipes passed

    public Flappybirdd() { //constructor for flappybird 
        setPreferredSize(new Dimension(boardWidth, boardHeight)); //setting the size 
        setFocusable(true);  //key board flappy bird
        addKeyListener(this);  //to use the keyboard
 
            /////////////////////////////////////////
       

            ////////////////////////////////////////
        // Load images                                               path of image 
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        Image birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        Image topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        Image bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        // Create bird
        bird = new Bird(birdImg, boardWidth / 8, boardWidth / 2, 34, 24);
        pipes = new ArrayList<>(); 

        // Place pipes timer
        placePipeTimer = new Timer(1500, e -> placePipes(topPipeImg, bottomPipeImg)); //place a new pipe every 1.5 sec.
        placePipeTimer.start(); 

        // Game loop timer
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start(); //start loop timer 
    }

    void placePipes(Image topPipeImg, Image bottomPipeImg) { // Method to add pipes to the game
        int minHeight = Pipe.PIPE_HEIGHT / 4;    // Define the minimum height for the top pipe placement
        int maxHeight = boardHeight - initialOpeningSpace - minHeight; // Calculate the maximum height for the top pipe placement
    
        // Generate a random Y  within the  range for the top pipe
        int randomPipeY = minHeight + random.nextInt(maxHeight - minHeight);
    
        // Create a top pipe object with the provided image and calculated Y 
        Pipe topPipe = new Pipe(topPipeImg, boardWidth, randomPipeY - Pipe.PIPE_HEIGHT);
        pipes.add(topPipe); // Add the top pipe to the list of pipes
    
        // Calculate the current opening space based on the initial opening space, number of pipes passed, and gap reduction step
        int currentOpeningSpace = Math.max(initialOpeningSpace - pipesPassed * gapReductionStep, minOpeningSpace);
    
        // Create a bottom pipe object with the provided image and calculated Y coordinate
        Pipe bottomPipe = new Pipe(bottomPipeImg, boardWidth, randomPipeY + currentOpeningSpace);
        pipes.add(bottomPipe); // Add the bottom pipe to the list of pipes
    }
    
    @Override
    protected void paintComponent(Graphics g) { //function fron j pannel
        super.paintComponent(g); //super to invoke the component 
        draw(g); 
    }

    void draw(Graphics g) {
        // Draw the background image at the top-left corner of the panel with the specified width and height
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
    
        // Draw the bird on the graphics 
        bird.draw(g);
    
        // Iterate through the list of pipes and draw each pipe on the graphics 
            for(int i=0;i<pipes.size();i++){
        Pipe pipe=pipes.get(i);
        pipe.draw(g);
            
            
        }
    
    
         // setting score temp.
        g.setColor(Color.red); //color
        g.setFont(new Font("Arial", Font.PLAIN, 32)); //font and size 
        if (gameOver) {
            g.drawString("Game Over: " + (int) score, 10, 35);
        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    void move() { //method to make the bird and the pipes move 
        bird.move();

        for (Pipe pipe : pipes) { //for loop
            pipe.move();

            if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                score += 0.5;
                pipe.passed = true;
                if (score % 1 == 0) { // Increase pipesPassed only after both top and bottom pipes are passed
                    pipesPassed++;
                }
            }

            if (bird.collidesWith(pipe)) { //law khabat fel pipe
                gameOver = true;
            }
        }

        if (bird.y > boardHeight) { 
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {   //lama ykhsar
            move();
            repaint();
        } else {
            placePipeTimer.stop();
            gameLoop.stop();
            Sound.playGameOverSound();
            showGameOverDialog();
        }
    }

    void startGame() { //start building the game again 
        bird.reset(boardWidth / 8, boardWidth / 2);
        pipes.clear();
        gameOver = false;
        score = 0;
        pipesPassed = 0; // Reset the pipesPassed counter
        placePipeTimer.start();
        gameLoop.start();
    }

    void showGameOverDialog() { //box that shows when game over 
        int option = JOptionPane.showOptionDialog(this, "Game Over! Do you want to play again?", "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (option == JOptionPane.YES_OPTION) {
            startGame();
        } else {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {  //this method onside interface "key listener" to use anykey in the keyboard 
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.flap();
            Sound.playFlapSound();
            if (gameOver) {
              startGame();
            }
        }
    }

    @Override // put it  to avoid  interface key listner errors
    public void keyTyped(KeyEvent e) {} 

    @Override
    public void keyReleased(KeyEvent e) {}

    
}
