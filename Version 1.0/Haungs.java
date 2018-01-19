import greenfoot.*;

public class Haungs extends Button
{
    //Written by Patrick
    private boolean mouseOver = false;

    //Written by Patrick
    public void act() 
    {
        hover();
        checkClick();
    }    

    //Written by Patrick
    public void hover ()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            setImage("Haungs_H.png");
            mouseOver = true;
        }
        
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage ("Haungs.png");
            mouseOver = false;
        }
    }

    //Written by Rahul
    public void checkClick()
    {
        if (Greenfoot.mouseClicked(this))
        {
            MapSelect world = new MapSelect(true);
            Greenfoot.setWorld(world);
        }
    }
}