import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class for rocks
 * 
 * @author James Thompson
 * @version 1.0
 */
public abstract class Rock  extends ExtendedActor
{
    private final int ROCK_SPEED = 1;
    private boolean isRotating, canKill;
    private int rotateTarget, immunityTimer;
    
    public Rock()
    {
        isRotating = false;
        canKill = false;
        rotateTarget = 0;
        immunityTimer = 90;
        super.setMoveData( Greenfoot.getRandomNumber(360), ROCK_SPEED );
    }
    
    public void act() 
    {
        doRotation();
        super.move();
        
        if( checkIntersection() ) {
            return;
        }
        
        checkBounds();
        checkPlayerIntersection(); // bear in mind this can stop execution
        
        if(immunityTimer > 0) {
            immunityTimer--;
        }
        else if ( immunityTimer == 0 ) {
            canKill = true;
            immunityTimer = -1;
        }
    }
    
    /**
     * Rotate the object randomly
     */
    private final void doRotation() 
    {
        if (this.isRotating) {
            if ( this.rotateTarget > getRotation() ) {
                turn(1);
            }
            else if ( this.rotateTarget < getRotation() ){
                turn(-1);
            }
            else {
                this.isRotating = false;
            }
        }
        else {
            this.rotateTarget = Greenfoot.getRandomNumber(360);
            this.isRotating = true;
        }
    }
    
    /**
     * Check to see if this intersects with a bullet. Returns true if we do as it means object destruction.
     */
    private final boolean checkIntersection()
    {
        Actor bObj = getOneIntersectingObject(Bullet.class);
        if(bObj != null) {
            // Call this first.. dont want those pesky null pointer exceptions!
            onDestroy();
            
            AudioManager.playOnce("explosion.wav");
            
            Space world = getSpace();
            world.updateScore(50);            
            world.removeObject(bObj);
            world.removeObject(this);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * This is called when the rock is destroyed by a bullet
     * This is overridden by the bigrock class
     */
    public void onDestroy()
    {
    }
    
    /**
     * Check to see if this intersects with a player
     */
    public final void checkPlayerIntersection()
    {
        if( (getOneIntersectingObject(Turret.class) != null) && canKill ) {
            Greenfoot.stop();
        }
    }
    
    /**
     * Check to see if this is out of the world
     */
    public final void checkBounds()
    {
        if ( super.isOffWorld() ) {
            flipWorldLoc();
        }
    }
}
