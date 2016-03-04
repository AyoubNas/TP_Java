import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines methods for the player-controlled turret
 * that shoots bullets
 * 
 * @author (James Thompson)
 * @version (1.0)
 */
public class Turret  extends ExtendedActor
{
    private final int MAX_DELAY = 13;
    private int delay = 0;
    
    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkInput();
    }
    
    /**
     * This method checks for any user input and applys any necessary changes
     */
    public final void checkInput()
    {
        if( Greenfoot.isKeyDown("left") ) {
            turn(-3);
        }
        else if( Greenfoot.isKeyDown("right") ) {
            turn(3);
        }
        
        if(delay <= 0) {
            if( Greenfoot.isKeyDown("space") ) {
                shoot();
                delay = MAX_DELAY;
            }
        }
        else {
            delay--;
        }
    }
    
    /**
     * This method shoots a bullet
     */
    public final void shoot()
    {
        Bullet bObj = new Bullet( getRotation() );
        getWorld().addObject( bObj, getX(), getY() );
            
        AudioManager.playOnce("pop.wav");
    }
}
