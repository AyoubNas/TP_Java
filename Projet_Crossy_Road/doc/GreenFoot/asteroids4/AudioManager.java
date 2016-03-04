import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.sound.midi.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Audioplayer plays midi files.
 * 
 * @author James Thompson <i>(original: Anthony Hoang)
 * @version 1.0
 */
public class AudioManager  extends Actor
{
    private boolean isPlaying = false;
    private boolean hasLoaded = false;
    private Sequencer sequencer;
    
    public void act() 
    {
        if( !hasLoaded) return;
        
        if (sequencer.getTickPosition() == sequencer.getTickLength())
        {
            sequencer.setTickPosition(0);
            sequencer.start();
        }
    }
    
    /**
     * Load a new file.
     * 
     * @param fileName the name of the file. (requires folderName/fileName.mid).
     */
    public final void load(String fileName) 
    {
        try {
            URL url = getClass().getClassLoader().getResource("sounds/"+fileName);
            Sequence sequence = MidiSystem.getSequence(url);
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            
            hasLoaded = true;
        }
        catch (MalformedURLException e) {}
        catch (IOException e) {}
        catch (MidiUnavailableException e) {}
        catch (InvalidMidiDataException e) {}
    }
    
    /**
     * Start the loaded file
     */
    public final void start() 
    {
        if( !hasLoaded) return;
        
        sequencer.start();
        isPlaying = true;
    }
    
    /**
     * Stop the loaded file
     */
    public final void stop() 
    {
        if( !hasLoaded) return;
        
        sequencer.stop();
        isPlaying = false;
    }
    
    /**
     * Just calls greenfoot's playsound
     */
    public final static void playOnce(String fileName) 
    {
        Greenfoot.playSound(fileName);
    }  
}
