import greenfoot.*;
import java.awt.Color;

public class Text extends Objects
{
    //Written by Rahul and Dylan
    public Text(String s, int textHeight, Color foreground, Color background)
    {
        Color fgColor = foreground;
        Color bgColor = background;
        
        setImage(new GreenfootImage(s, textHeight, fgColor, bgColor));
    }
    
    //Written by Rahul and Dylan
    public Text(String s, int textHeight, Color foreground, int opacity)
    {
        Color fgColor = foreground;
        Color bgColor = new Color(255, 255, 255, opacity);
        
        setImage(new GreenfootImage(s, textHeight, fgColor, bgColor));
    }
}
