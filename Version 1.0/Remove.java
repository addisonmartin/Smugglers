import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Remove extends PowerUps
{
    //Written by Riley
    private int speed = 3;
    private int AnimationCounter = 0;
    public boolean isAtEdge;
    
    //Written by Riley
    public void act()
    {
        setLocation(getX() + speed, getY());
        animate();
        
        if (getX() < -5 || getX() > getWorld().getWidth() + 5)
        {
            getWorld().removeObject(this);
        }
    }

    //Written by Riley
    public void activate()
    { 
        List civs = getWorld().getObjects(Civilian.class);
        int max = (civs.size()/4) - (Greenfoot.getRandomNumber(civs.size()/4) + 5);
        int min = 20;
        
        if (civs.size() < 20)
        {
            min = civs.size() - 3;
        }
        
        for(int i = 0; i < min; i++)
        {
            int randExit = Greenfoot.getRandomNumber(4);
            ((Civilian)civs.get(i)).setToExit(((Map)getWorld()).getExits().get(randExit).getTargetX(), ((Map)getWorld()).getExits().get(randExit).getTargetY());
            ((Civilian)civs.get(i)).setHeadingToExit(true);
        }
    }

    //Written by Riley
    public void animate()
    {
        AnimationCounter++;
        
        if (AnimationCounter == 0)
        {
            setImage("Bird_Blue_0.png");
        }
        
        if (AnimationCounter == 1)
        {
            setImage("Bird_Blue_2.png");
        }  
        
        if (AnimationCounter == 2)
        {
            setImage("Bird_Blue_3.png");
        }   
        
        if (AnimationCounter == 3)
        {
            setImage("Bird_Blue_4.png");
        }  
        
        if (AnimationCounter == 4)
        {
            setImage("Bird_Blue_5.png");
        }  
        
        if (AnimationCounter == 5)
        {
            setImage("Bird_Blue_7.png");
        }
        
        if (AnimationCounter == 6)
        {
            setImage("Bird_Blue_8.png");
        } 
        
        if (AnimationCounter == 7)
        {
            setImage("Bird_Blue_9.png");
            AnimationCounter = 0;
        }
    }
}