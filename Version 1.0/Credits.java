import greenfoot.*;

public class Credits extends Button
{
    //Written by Patrick
    private boolean mouseOver = false;
    
    //Written by Rahul
    public void act() 
    {
        checkClick();
        hover();
    }   

    //Written by Addison
    public void checkClick()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new CreditsWorld());
        }
    }   

    //Written by Patrick
    public void hover ()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            setImage("Credits_H.png");
            mouseOver = true;
        }
        
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage ("Credits.png");
            mouseOver = false;
        }
    }
}
