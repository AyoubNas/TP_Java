import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Space world contains the methods requried for the world to work
 * 
 * @author James Thompson
 * @version 1.0
 */
public class Space  extends World
{
    private Score sObj;
    private AudioManager audio;
    private int countDown = 0;
    
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(640, 480, 1);
        Greenfoot.setSpeed(50);
        
        Turret tObj = new Turret();
        addObject( tObj, (getWidth()/2), (getHeight()/2) );
        
        sObj = new Score();
        addObject( sObj, (getWidth()/2), 22 );
        
        audio = new AudioManager();
        audio.load("Metroid.mid");
    }
    
    public void started()
    {
        audio.start();
    }
    
    public void stopped()
    {
        audio.stop();
    }
    
    public void act()
    {
        if(countDown <= 0) {
            addObject( new BigRock(), getRandomX(), getRandomY() );
            int rng = Greenfoot.getRandomNumber(350) + 200;
            countDown = rng;
        }
        else {
            countDown--;
        }
    }
    
    /**
     * Update the score text to display its current value + val
     * @param val The value to add to the current score
     */
    public void updateScore(int val)
    {
        sObj.updateText(val);
    }
    
    /**
     * Random number based on width
     */
    public int getRandomX() {
        return Greenfoot.getRandomNumber(getWidth());
    }
    
    /**
     * Random number based on height
     */
    public int getRandomY() {
        return Greenfoot.getRandomNumber(getHeight());
    }
}
