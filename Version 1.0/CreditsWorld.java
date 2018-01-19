import greenfoot.*;

public class CreditsWorld extends World
{
    
    //Written by Addison
    public CreditsWorld()
    {    
        super(1366, 768, 1); 
    }
    
    //Writte by Addison
    public void act()
    {
        if (Greenfoot.mouseClicked(null))
        {
           Greenfoot.setWorld(new MainMenu()); 
        }
    }
}
