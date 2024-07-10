import java.awt.*;

// Definition of the Bird class tha inherint the GameObject class
public class Bird extends GameObject {
    
    // Instance variables to store the vertical velocity and gravity affecting the bird
    int velocityY = 0;
    int gravity = 1;

    // Constructor for creating a Bird object with specified parameters
    public Bird(Image img, int x, int y, int width, int height) {
        // Call the constructor of the superclass (GameObject) to initialize the bird object
        super(img, x, y, width, height);
    }

    // Method to update the position of the bird based on its velocity and gravity
    public void move() {
        // Update the vertical velocity by adding the gravitational force
        velocityY += gravity;
        // Update the y-coordinate of the bird by adding its vertical velocity
        y += velocityY;
        // Ensure that the bird stays within the top boundary of the screen
        y = Math.max(y, 0);
    }

    // Method to make the bird flap its wings (jump)
    public void flap() {
        // Set the vertical velocity to a negative value to make the bird jump upward
        velocityY = -9;
    }

    // Method to reset the position and velocity of the bird
    public void reset(int x, int y) {
        // Set the position of the bird to the specified coordinates
        this.x = x;
        this.y = y;
        // Reset the vertical velocity to zero
        velocityY = 0;
    }

    // Method to check if the bird collides with a pipe
    public boolean collidesWith(Pipe pipe) {
        // Check if the bounding box of the bird intersects with the bounding box of the pipe
        return x < pipe.x + pipe.width &&  //(bat2akid en el bird msh hy5bat fel pipe )
               x + width > pipe.x &&
               y < pipe.y + pipe.height &&
               y + height > pipe.y;
    }
}
