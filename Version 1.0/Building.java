import greenfoot.*;

public class Building extends Location
{
    //Written by Addison
    private int centerX;
    private int centerY;
    private int direction;
    
    //Written by Addison
    public Building(int nx, int ny, int cx, int cy)
    {
        super(nx, ny);
        centerX = cx;
        centerY = cy;
    }
    
    //Written by Addison
    public int getCenterX()
    {
        return centerX;
    }
    
    //Written by Addison
    public int getCenterY()
    {
        return centerY;
    }
    
    //Written by Addison
    public void draw(int dir)
    {
        //0 is right, 1 is up, 2 is left, 3 is down
        direction = dir;
        
        if (dir == 0)
        {
            turn(270);
        }
        
        else if (dir == 1)
        {
           turn(180);
        }
        
        else if (dir == 2)
        {
            turn(90);
        }
    }
    
    //Written by Addison
    public int getDirection()
    {
        return direction;
    }
}
