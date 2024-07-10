import java.awt.*;

// Definition of the Pipe class that inherint  the GameObject class
public class Pipe extends GameObject {
    
    // Constants representing the dimensions of a pipe
    public static final int PIPE_WIDTH = 64;
    public static final int PIPE_HEIGHT = 512;
    
    // Boolean flag indicating whether the bird has passed through this pipe
    boolean passed = false;
    
    // Horizontal velocity of the pipe
    int velocityX = -4; //start of velocity is 0 horizontal 

    // Constructor for creating a Pipe object with specified parameters
    public Pipe(Image img, int x, int y) { //argument based constructor 
        
        // Call the constructor of the superclass (GameObject) to initialize the pipe object
        super(img, x, y, PIPE_WIDTH, PIPE_HEIGHT);  
    }

    // Method to move the pipe horizontally
    public void move() {
        // Update the x-coordinate of the pipe by adding the horizontal velocity
        x += velocityX;
    }
}
