import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Personnage personnage;
    private Bande bande;
    private Voiture voiture;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int maxX = 60;
    private int maxY = 40;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(60, 40, 10); 
        maxX = 60;
        maxY = 40;
        
        personnage = new Personnage();
        addObject (personnage, 30, 40);
        bande = new Bande(2);
        addObject(bande,30,bande.getY());
        voiture = new Voiture(this.bande);
        addObject(voiture,0,this.bande.getY());
        

        
    }
    
    public int getMaxX(){
        return this.maxX;
    }
    
    public void act()
    {
        
    }
}
