import greenfoot.*;

public class HowToPlay extends Button
{
    //Written by Patrick
    private boolean mouseOver = false;
    
    //Written by Rahul
    public void act() 
    {
        checkClick();
        hover();
    }   

    //Written by Rahul
    public void checkClick()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new HowToPlayWorld());
        }
    }   

    //Written by Patrick
    public void hover()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            setImage("How to Play_H.png");
            mouseOver = true;
        }
        
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage ("How to play.png");
            mouseOver = false;
        }
    } 
}
