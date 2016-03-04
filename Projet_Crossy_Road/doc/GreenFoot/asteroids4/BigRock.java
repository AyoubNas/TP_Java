import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Big rock class
 * 
 * @author James Thompson
 * @version 1.0
 */
public class BigRock  extends Rock
{
    public void act() 
    {
        super.act();
    }
    
    /**
     * Override the default onDestroy method to create rocks
     */
    public void onDestroy()
    {
        getWorld().addObject( new SmallRock(), getX(), getY() );
        getWorld().addObject( new SmallRock(), getX() - 14, getY() + 14 );
    }
}
