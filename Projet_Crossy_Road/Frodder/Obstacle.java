import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Objet
{
    private double h,v;
    public Obstacle()
    {
        h=0;
        v=0;
    }
    public final void setMoveData(int direction, int speed){
        double angle = Math.toRadians(direction);
        h = Math.cos(angle) * (double)speed;
        v = Math.sin(angle) * (double)speed;
    }
    public final void move()
    {
        setLocation((int)Math.round(getX()+h), (int)Math.round(getY() + v));
    }
}
