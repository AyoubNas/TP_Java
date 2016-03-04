import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains additional methods required by subclasses
 * 
 * @author James Thompson
 * @version 1.0
 */
public abstract class ExtendedActor  extends Actor
{
    private double h, v;
    
    public ExtendedActor()
    {
        h = 0;
        v = 0;
    }
    
    /**
     * This turns the actor by a specified ammount
     * @param ammount The ammount to turn the object by
     */
    public final void turn(int ammount)
    {
        setRotation( getRotation() + ammount );
    }
    
    /**
     * Flips the actor over so it is on the opposite edge/side of the screen
     */
    public final void flipWorldLoc()
    {
        int x = getX(), y = getY();
        int newX = getWorld().getWidth() - (x==0 ? 1 : x);
        int newY = getWorld().getHeight() - (y==0 ? 1 : y);
        
        setLocation(newX, newY);
    }
    
    /**
     * This sets data required to move
     * @param direction The direction to travel
     * @param speed The speed to move at
     */
    public final void setMoveData(int direction, int speed)
    {
        double angle = Math.toRadians(direction);
        h = Math.cos(angle) * (double)speed;
        v = Math.sin(angle) * (double)speed;
    }
    
    /**
     * This makes us move using the move data
     */
    public final void move()
    {
        setLocation( (int)Math.round(getX() + h), (int)Math.round(getY() + v) );
    }
    
    /**
     * This method checks the bullets position to see if it is out of the world
     */
    public final boolean isOffWorld() 
    {
        return ( (getX() <= 1) || (getY() <= 1) || (getX() >= (getWorld().getWidth()-1)) || (getY() >= (getWorld().getHeight()-1)) );
    }
    
    /**
     * This returns our world, typecast to space
     */
    public final Space getSpace() 
    {
        return (Space)getWorld();
    }
}
