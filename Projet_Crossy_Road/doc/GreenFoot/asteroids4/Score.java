import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Writes the score as text to the screen
 * 
 * @author James Thompson
 * @version 1.0
 */
public class Score  extends Actor
{
    private String prefix = "Score: ";
    private int score = 0;
    
    public Score()
    {
        setImage(new GreenfootImage((prefix.length() + 6)*12, 31));
        updateText(0);
    }
    
    /**
     * Update the score by a given ammount
     * @param value The ammount to add to the score
     */
    public final void updateText(int value)
    {
        this.score += value;
        
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.WHITE);
        Font font = img.getFont();
        font = font.deriveFont(28.0f);
        img.setFont(font);
        img.drawString(prefix+score, 1, 24);
    }
}
