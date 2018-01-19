import greenfoot.*;
import java.util.List;

public class Add extends PowerUps
{
    //Written by Riley
    private int speed = 3;
    
    public void act()
    {
        remove();
    }
    
    //Written by Riley
    public void activate()
    { 
        List civs = getWorld().getObjects(Civilian.class);
        
        for(int i = 0; i < 2; i++)
        {

            Civilian a = new Civilian();
            getWorld().addObject(a, 323,760);
            Civilian b = new Civilian();
            getWorld().addObject(b, 1077,760);
            Civilian c = new Civilian();
            getWorld().addObject(c, 1360,5);
            Civilian d = new Civilian();
            getWorld().addObject(d,365,5);
           
            a.setTarget(650 + Greenfoot.getRandomNumber(140), 300 + Greenfoot.getRandomNumber(140));
            b.setTarget(650 + Greenfoot.getRandomNumber(140), 300 + Greenfoot.getRandomNumber(140));
            c.setTarget(650 + Greenfoot.getRandomNumber(140), 300 + Greenfoot.getRandomNumber(140));
            d.setTarget(650 + Greenfoot.getRandomNumber(140), 300 + Greenfoot.getRandomNumber(140));
        }
    }

    //Written by Riley
    private void remove()
    {
        if(getOneIntersectingObject(Smuggler.class) != null)   
        { 
            activate();
            getWorld().removeObject(this);
        }
    }
}
