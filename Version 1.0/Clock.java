import greenfoot.*;
import java.awt.Color;

public class Clock extends Objects
{
    //Written by Addion
    private long intialTime = (int)(System.currentTimeMillis()/1000);
    private long currentTime = (int)(System.currentTimeMillis()/1000);
    
    private int minutes = 5;
    private int seconds = 0;
    
    //Written by Addison
    public Clock()
    {
        setImage(new GreenfootImage("0:00", 60, Color.WHITE, new Color(77, 88, 170, 0)));
        
        intialTime = (int)(System.currentTimeMillis()/1000);
        currentTime = (int)(System.currentTimeMillis()/1000);
    }
    
    //Written by Addison
    public void act() 
    {
       if (seconds > 9)
       {
           setImage(new GreenfootImage(minutes + ":" + seconds, 60, Color.WHITE, new Color(77, 88, 170, 0)));
       }
        
       else
       {
           setImage(new GreenfootImage(minutes + ":0" + seconds, 60, Color.WHITE, new Color(77, 88, 170, 0)));
       }
       
       updateTimer();
    }  
    
    //Written by Addison
    public void updateTimer()
    {
        currentTime = (int)(System.currentTimeMillis()/1000);
        
        if (currentTime-intialTime == 1)
        {
            if (seconds == 0)
            {
                minutes--;
                seconds = 59;
            }
            
            else
            {
                seconds--;
            }
            
            intialTime = (int)(System.currentTimeMillis()/1000);
        }
            
        if (minutes == 0 && seconds == 0)
        {
            ((Map)getWorld()).endRound();
        }
    }   
    
    //Written by Dylan
    public int returnMinutes()
    {
        return minutes;
    }
    
    //Written by Dylan
    public int returnSeconds()
    {
        return seconds;
    }
}
