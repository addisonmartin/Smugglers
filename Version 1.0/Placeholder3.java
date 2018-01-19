import greenfoot.*;

public class Placeholder3 extends Placeholder
{
    //Connor
    private boolean mouseOver = false;

    //Written by Addison
    public Placeholder3(boolean haungsMode)
    {
        super(haungsMode);
    }

    //Written by Connor
    public void act() 
    {
        click();
        hover();
    }    

    //Written by Rahul
    private void click()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Map3 world = new Map3(new ScoreBoardOrganizer(), haungsMode,1,0,0,0,0);
            Greenfoot.setWorld(world);
        }
    }    

    //Written by Connor
    private void hover()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            setImage("hoverMap3.png");
            mouseOver = true;

        }
        
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("Map3.png");
            mouseOver = false;
        }
    }
}
