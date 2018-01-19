import greenfoot.*;

public class HighScore extends Button
{
    //Written by Patrick
    private boolean mouseOver = false;
    
    //Written by Addison
    public void act() 
    {
        checkClick();
        hover();
    }   

    // Written by Rahul
    public void checkClick()
    {
        if (Greenfoot.mouseClicked(this))
        {
            HighScoreWorld world = new HighScoreWorld();
            Greenfoot.setWorld(world);
        }
    }   
    
    // Written by Rahul & Patrick
    public void hover ()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            setImage("High Score.png");
            mouseOver = true;
        }
        
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage ("High Score_H.png");
            mouseOver = false;
        }
    }
}