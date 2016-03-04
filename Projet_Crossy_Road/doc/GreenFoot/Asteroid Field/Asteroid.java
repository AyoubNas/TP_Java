simport greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

 /** 
 * @author Zovisk Zonk 
 * @version 1.0
 */

public class Asteroid extends Actor
{
     /** 
      * Makes the asteroid sroll through the screen and disapear
      * once they have reached the left end of the screen
      */ 
    public void act() 
    {
        
        setLocation (getX() - 1, getY());
        if (getX() == 0){
            getWorld().removeObject(this);
        } 
    }    
}
