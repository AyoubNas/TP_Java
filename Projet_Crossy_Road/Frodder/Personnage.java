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
        String key = Greenfoot.getKey();
        if ("up".equals(key)) {
            // Changer de bande
            setLocation(getX(), getY() - 7);
            Greenfoot.playSound("frogs.wav");
        }
        if ("down".equals(key)) {
            // Changer de bande
            setLocation(getX(), getY() + 7);
            Greenfoot.playSound("frogs.wav");
        }
        if ("right".equals(key)) {
            // Changer de bande
            setLocation(getX()+7, getY());
  
            Greenfoot.playSound("frogs.wav");
        }
        if ("left".equals(key)) {
            // Changer de bande
            setLocation(getX()-7, getY());
  
            Greenfoot.playSound("frogs.wav");
        }
        if (isOffWorld()){
            setLocation(30,60);
        }
        
    }   
    
    public final boolean isOffWorld() 
    {
        return ( (getY() <= 1) );
    }
}
