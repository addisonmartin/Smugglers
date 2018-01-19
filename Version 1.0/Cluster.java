import greenfoot.*;
import java.util.List;

public class Cluster extends PowerUps
{
    //Written by Riley
    private int speed = 3;
    private int AnimationCounter = 0;
    
    //Written by Riley
    public void act() 
    {
        setLocation(getX()- speed, getY());
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
        
        for(int i = 0; i < civs.size(); i += 2)
        {
            Civilian c = (Civilian)civs.get(i);
            c.setTarget(650 + Greenfoot.getRandomNumber(140), 300 + Greenfoot.getRandomNumber(140));
        }
    }

    //Written by Riley
    public void animate()
    {
        AnimationCounter++;
        
        if (AnimationCounter == 0)
        {
            setImage("Bird_Purple_2.png");
        }
        
        if (AnimationCounter == 1)
        {
            setImage("Bird_Purple_3.png");
        }
        
        if (AnimationCounter == 2)
        {
            setImage("Bird_Purple_4.png");
        }  
        
        if (AnimationCounter == 3)
        {
            setImage("Bird_Purple_5.png");
        } 
        
        if (AnimationCounter == 4)
        {
            setImage("Bird_Purple_7.png");
        }   
        
        if (AnimationCounter == 5)
        {
            setImage("Bird_Purple_8.png");
        }  
        
        if (AnimationCounter == 6)
        {
            setImage("Bird_Purple_9.png");
            AnimationCounter = 0;
        }
    }
}