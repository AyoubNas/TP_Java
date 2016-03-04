import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;

 /** 
 * @author Zovisk Zonk (Some code from the ScrollWorld 
 * project at the Greenfoot gallery)
 * @version 1.0
 */
public class SpaceShip extends Actor
{
    private int CounterFow = 0;
    private int CounterSide = 0;    

     /** 
      * Controls the direction of the SpaceShip and plays the corresponding 
      * sound based on the number of acts. The game gets very slow if the 
      * sound is played at every act.
      */     
    public void act() 
    {
        if (Greenfoot.isKeyDown("up") ) {
            setLocation (getX(), getY() - 2);
            if (CounterSide < 20){
                CounterSide ++;
            }
            else{
                CounterSide = 0;
                Greenfoot.playSound("Rocket_Side.wav");
            }                
        }
        if (Greenfoot.isKeyDown("down") ) {
            setLocation (getX(), getY() + 2);
            if (CounterSide < 20){
                CounterSide ++;
            }
            else{
                CounterSide = 0;
                Greenfoot.playSound("Rocket_Side.wav");
            }              
        }

        if (Greenfoot.isKeyDown("left") ) {
            setLocation (getX() - 2, getY());        
        }
        
        if (Greenfoot.isKeyDown("right") ) {
            setLocation (getX() + 2, getY());  
            if (CounterFow < 20){
                CounterFow ++;
            }
            else{
                CounterFow = 0;
                Greenfoot.playSound("Rocket.wav");                
            }
        }
        
    }     

     /** 
      * Checks if the SpaceShip has hit the Asteroid
      */     
    public boolean hitAsteroid()
    {
        Actor asteroid = getOneObjectAtOffset(0, 0, Asteroid.class);
        if(asteroid != null) {
            return true;
        }
        else {
            return false;
        }
    }  
    
}