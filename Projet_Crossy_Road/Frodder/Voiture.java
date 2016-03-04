import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Voiture here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Voiture extends Obstacle
{
        private Bande bande;
        private int SPEED;
        /**
     * Act - do whatever the Voiture wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Voiture(Bande bande){
        this.bande = bande;
        this.SPEED = 1;
        super.setMoveData(0,1);
    }
   
    public void act() 
    {
        super.move();
        if (getX()==60){
           getWorld().removeObject(this);
        }

    }    
}
