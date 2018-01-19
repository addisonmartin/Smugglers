import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;
import java.nio.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class HighScoreWorld extends World
{
    
    //Written by Rahul
    public HighScoreWorld()
    {    
        super(1366, 768, 1); 
        ReturnHighScore();
        addObject (new Text("Highscore: " + ReturnHighScore(), 75, Color.WHITE, 0), getWidth()/2, getHeight()/2);
    }
    
    //Written by Rahul
    public void act()
    {
        checkClick();
    }

    //Written by Rahul
    private String ReturnHighScore()
    {
        String hs = null;
        try
        {
            Path scoreFile = Paths.get("./scoreFile.txt");

            if (Files.exists(scoreFile))
            {
                byte[] bytes = Files.readAllBytes(scoreFile);
                hs = new String(bytes);                
            } 
        } catch (IOException e)
        {
            System.out.println("IOException");
        }

        return hs;
    }
    
    //Written by Addison
    public void checkClick()
    {
        if (Greenfoot.mouseClicked(this))
        {
            MainMenu a = new MainMenu();
            Greenfoot.setWorld (a);
        }
    }
}