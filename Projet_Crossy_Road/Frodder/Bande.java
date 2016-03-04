import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bande here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bande extends Actor
{
    private Surface surface;
    // Transformer en tableau d'obstacle
    private Obstacle obstacle;
    private int y;
    /**
     * Constructor for objects of class Bande.
     * 
     */
    public Bande(int y)
    {    
        this.y = y;
        this.surface = new Route();
        GreenfootImage texture = this.surface.getImage();
        texture.scale(650,50);
        setImage(texture);
        
        
        //GreenfootImage texture = this.surface.getTexture();
        //texture.scale(60,1);
        //setImage(texture);
    }
    public int getY()
    {
        return this.y;
    }
    
    public void act()
    {
        
    }
}
