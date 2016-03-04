import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet  extends ExtendedActor
{
    private final int BULLET_SPEED = 5;
    private final int BULLET_LIFE = 120;
    private int mCurrentLife = 0;
    private boolean destroySelf = false; // set to false to allow bullet repetition
    
    /**
     * Class constructor
     * @param direction The direction the bullet should travel
     */
    public Bullet(int direction)
    {
        super.setMoveData(direction, BULLET_SPEED);
    }
    
    public void act() 
    {
        super.move();
        if( checkBounds() ) return;
        mCurrentLife++;
        if(mCurrentLife >= BULLET_LIFE) {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * This method checks the bullets position to see if it should be removed from the game
     */
    public final boolean checkBounds() 
    {
        if ( super.isOffWorld()  ) {
            if( destroySelf ) {
                getWorld().removeObject(this);
                return true;
            }
            else {
                flipWorldLoc();
                destroySelf = true;
            }
        }
        return false;
    }  
}
