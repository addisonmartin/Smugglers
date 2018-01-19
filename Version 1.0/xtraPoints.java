import greenfoot.*;
import java.util.List;

public class xtraPoints extends PowerUps
{
    //Written by Riley
    private int speed = 3;
    private int AnimationCounter = 0;
    
    //Written by Riley and Dylan
    public void act()
    {
        setLocation(getX(), getY() - speed);
        animate();
        
        if (getY() < -5 || getY() > getWorld().getHeight() + 5)
        {
            getWorld().removeObject(this);
        }
    }

    //Written by Riley
    public void animate()
    {
        AnimationCounter++;
        
        if (AnimationCounter == 0)
        {
            setImage("Bird_Red_2.png");
        }
        
        else if (AnimationCounter == 1)
        {
            setImage("Bird_Red_3.png");
        }
        
        else if (AnimationCounter == 2)
        {
            setImage("Bird_Red_4.png");
        }  
        
        else if (AnimationCounter == 3)
        {
            setImage("Bird_Red_5.png");
        } 
        
        else if (AnimationCounter == 4)
        {
            setImage("Bird_Red_7.png");
        } 
        
        else if (AnimationCounter == 5)
        {
            setImage("Bird_Red_8.png");
        }    
        
        else if (AnimationCounter == 6)
        {
            setImage("Bird_Red_9.png");
            AnimationCounter = 0;
        }
    }
}