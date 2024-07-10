import java.awt.*;

// Definition of the GameObject class
public class GameObject {
    
    // Instance variables to store the position, dimensions, and image of the game object
    int x, y, width, height;
    Image img;
     
    public GameObject(Image img, int x, int y, int width, int height) { //argument based const.
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Method to draw the game object on the graphics context
    public void draw(Graphics g) {
        // Draw the image of the game object at the specified position and with the specified dimensions
        g.drawImage(img, x, y, width, height, null);
    }
}
