import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personnage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personnage extends Actor
{
    private int x;
    private Bande currentBande;
    
    /**
     * Act - do whatever the Personnage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up") ) {
            // Changer de bande
            setLocation(getX(), getY() - 1);
            Greenfoot.playSound("frogs.wav");
        }
        if (Greenfoot.isKeyDown("down") ) {
            // Changer de bande
            setLocation(getX(), getY() + 1);
            Greenfoot.playSound("frogs.wav");
        }
        if (Greenfoot.isKeyDown("right") ) {
            // Changer de bande
            setLocation(getX()+1, getY());
            this.x = x + 1;
            Greenfoot.playSound("frogs.wav");
        }
        if (Greenfoot.isKeyDown("left") ) {
            // Changer de bande
            setLocation(getX()-1, getY());
            this.x = x - 1;
            Greenfoot.playSound("frogs.wav");
        }
        
        
    }    
}
