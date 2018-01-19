import greenfoot.*;
import java.awt.Color;

public class ScoreBoardItem extends Objects
{
    //Written by Dylan
    private String phrase;
    
    public ScoreBoardItem(String p)
    {
        phrase = p;
        Color clear = new Color(0, 0, 0, 0);        
        setImage(new GreenfootImage(p + "", 20, Color.WHITE, clear));
    }
    
    //Written by Dylan
    public String getPhrase()
    {
        return phrase;
    }
}
