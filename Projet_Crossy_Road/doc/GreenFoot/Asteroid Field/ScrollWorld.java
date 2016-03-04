import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot) 
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * The ScrollWorld is used to construct the environment. 
 * It creates the moving space, the space ship, the asteroids
 * and the explosion
 * @author Zovisk Zonk (Some code from the ScrollWorld 
 * project at the Greenfoot gallery)
 * @version 1.0
 */
public class ScrollWorld extends World 
{ 
     private static final GreenfootImage bgImage = new GreenfootImage("space1.gif"); 
     private static final int scrollSpeed = 2; 
     
     private GreenfootImage scrollingImage; 
     private int scrollPosition = 0; 
     
     private SpaceShip spaceShip;
     
     private int WIDTH = 800;
     private int HEIGHT = 400;
     
     private int Score = 0;
     
     public ScrollWorld() 
     { 
         super(800, 400, 1); 
         scrollingImage = getScrollingImage(800, 400); 
         
         spaceShip = new SpaceShip();
         addObject (spaceShip, 350, 200);
     } 

     /** 
      * Constructs the initial scenario and the functioning of the game. 
      */      
     public void act() 
     {
            if (spaceShip.hitAsteroid() == false){
                if(scrollPosition < 0) { 
                    scrollPosition = getWidth(); 
                }
                scrollPosition -= scrollSpeed; 
                paint(scrollPosition);
                Score ++;
                if (Greenfoot.getRandomNumber(300) > (298 - (Score/5000))){
                    addObject (new Asteroid(), WIDTH, Greenfoot.getRandomNumber(HEIGHT));
                }
            }
            else{
                spaceShipExplodes();
                gameOver();
            }
     }
     
     /** 
      * Paint scrolling image at given position and make sure the rest of 
      * the background is also painted with the same image. 
      */ 
     private void paint(int position) 
     { 
         GreenfootImage bg = getBackground(); 
         bg.drawImage(scrollingImage, position, 0); 
         if(position > 0) { 
             bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0); 
         } 
         else { 
             bg.drawImage(scrollingImage, position + scrollingImage.getWidth(), 0); 
         } 
     } 
     
     /** 
      * Returns an image with the given dimensions. 
      */ 
     private GreenfootImage getScrollingImage(int width, int height) 
     { 
         GreenfootImage image = new GreenfootImage(width, height); 
         for(int x = 0; x < width; x += bgImage.getWidth()) { 
             for(int y = 0; y < height; y += bgImage.getHeight()) { 
                 image.drawImage(bgImage, x, y); 
             } 
         } 
         return image; 
     } 
     
     /** 
      * Adds the object Explosion at the Spaceship coordinates
      */      
    public void spaceShipExplodes() {
        addObject(new Explosion(), spaceShip.getX(), spaceShip.getY());
    }       
    
     /** 
      * Adds the GameOver object and terminates the game
      */     
    public void gameOver() {
        addObject(new GameOver(Score/10), getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }    
    
}
