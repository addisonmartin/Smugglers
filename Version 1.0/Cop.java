import greenfoot.*;

public class Cop extends NPC
{
    //Written by Patrick
    private int speed = 2;
    
    //Written by Connor
    private int Frame = 1;
    private int AnimationCounter = 0;
    
    //Written by Addison
    int x1, y1, x2, y2, x3, y3, x4, y4;
    int targetX, targetY;

    //Written by Patrick
    public void act() 
    {
        copMovement();
        animate();
    }    

    //Written by Patrick
    public void copMovement()
    {
        if (getX() == x1 && getY() == y1)
        {
            targetX = x2;
            targetY = y2;
        }
        
        else if (getX() == x2 && getY() == y2)
        {
            targetX = x3;
            targetY = y3;
        }
        
        else if (getX() == x3 && getY() == y3)
        {
            targetX = x4;
            targetY = y4;
        }
        
        else if (getX() == x4 && getY() == y4)
        {
            targetX = x1;
            targetY = y1;
        }
        
        turnTowards(targetX, targetY);
        move(speed);
    }
    
    //Written by Addison
    public void setTarget(int nx, int ny)
    {
        targetX = nx;
        targetY = ny;
    }
    
    //Written by Connor
    private void animate()
    {
        AnimationCounter++;
        Frame++;
        
        if ( AnimationCounter % 20 == 0)
        {
            setImage("Cop/COP_" + Frame + ".png");
        }
        
        if ( Frame == 7 )
        {
            Frame = 1;
        }
    }
    
    //Written by Addison
    public void setTargets(int nx1, int ny1, int nx2, int ny2, int nx3, int ny3, int nx4, int ny4)
    {
        x1 = nx1;
        y1 = ny1;
        x2 = nx2;
        y2 = ny2;
        x3 = nx3;
        y3 = ny3;
        x4 = nx4;
        y4 = ny4;
    }
}
    

