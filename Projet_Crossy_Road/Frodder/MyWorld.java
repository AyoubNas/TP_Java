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
        
        initWorld();
        personnage = new Personnage();
        addObject (personnage, 30, 40);
        
        GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");
        backgroundMusic.playLoop();
        
    }
    
    public void initWorld(){
        createBande(new Route(), 2);
        createBande(new Herbe(), 7);
        createBande(new Herbe(), 12);
        createBande(new Route(), 17);
        createBande(new Herbe(), 22);
        createBande(new Herbe(), 27);
        createBande(new Route(), 32);
        createBande(new Herbe(), 37);
    }
    public void hasWin(){
        if ( this.personnage.getY() == 2 ){
            this.personnage.setLocation(30,0);
        }
    }
    
    public void createBande(Surface texture, int y){
        bande = new Bande(texture, y);
        addObject(bande,30,bande.getY());
        if (texture instanceof Route){
            bande.addVoiture();
        }

    }
    

    
    public int getMaxX(){
        return this.maxX;
    }
    

}
