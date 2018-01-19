import greenfoot.*;

public class HowToPlayWorld extends World
{
    //Written by Rahul
    Left l;
    Right r;
    
    private int screen = 1;
    
    //Written by Rahul
    public HowToPlayWorld()
    {
        super(1366, 768, 1);
        l = new Left();
        addObject(l, 100, 650);
        r = new Right();
        addObject(r, 1266, 650);
    }
    
    //Written by Addison
    public void act()
    {
        if (Greenfoot.mouseClicked(l))
        {
            screen--;
        }
        
        else if (Greenfoot.mouseClicked(r))
        {
            screen++;
        }
        
        if (screen == 0 || screen == 6)
        {
            Greenfoot.setWorld(new MainMenu());
            screen = 1;
        }
        
        setBackground("How to Play " + screen + ".png");
    }
}
