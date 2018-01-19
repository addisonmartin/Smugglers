import greenfoot.*;

public class Play extends Button
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
            MapSelect world = new MapSelect(false);
            Greenfoot.setWorld(world); 
        }
    }   

    //Written by Patrick
    public void hover ()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            setImage("Play_H.png");
            mouseOver = true;
        }
        
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage ("Play.png");
            mouseOver = false;
        }
    } 
}
