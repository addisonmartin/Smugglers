import greenfoot.*;

public class Placeholder1 extends Placeholder
{
    //Connor
    private boolean mouseOver = false;

    //Written by Addison
    public Placeholder1(boolean haungsMode)
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
            Map1 world = new Map1(new ScoreBoardOrganizer(), haungsMode,1,0,0,0,0);
            Greenfoot.setWorld(world);
        }
    }    

    //Written by Connor
    private void hover()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            setImage("hoverMap1.png");
            mouseOver = true;

        }
        
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("Map1.png");
            mouseOver = false;
        }
    }
}
