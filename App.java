import javax.swing.*;

public class App { 
    public static void main() throws Exception {
        int boardWidth = 360; //diminssions of window in pixels 
        int boardHeight = 640;

        JFrame frame = new JFrame("Flappy Bird");
        frame.setVisible(true); 
		frame.setSize(boardWidth, boardHeight); //setting window size
        frame.setLocationRelativeTo(null);    //place the window in the center of screen
        frame.setResizable(false); //to make the user can't resize 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to close the window 
 
       Flappybirdd flappyBird = new Flappybirdd();
        frame.add(flappyBird); // add background
        frame.pack(); // width and  height without  title bar
        flappyBird.requestFocus(); //requwst to use keyboard space
        frame.setVisible(true); // to make it visible
    }
}  
