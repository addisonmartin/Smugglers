import greenfoot.*;

public class Location extends Actor
{
    //Written by Addison
    protected int x;
    protected int y;
    
    //Written by Addison
    public Location(int nx, int ny)
    {
        x = nx;
        y = ny;
    }
    
    //Written by Addison
    public int getTargetX()
    {
        return x;
    }
    
    //Written by Addison
    public int getTargetY()
    {
        return y;
    }  
    
    //Written by Addison
    public static boolean isAtLocation(int xl, int yl, int xtl, int ytl)
    {
        for (int xo =  -10; xo <= 10; xo++)
        {
            for (int yo = -10; yo <= 10; yo++)
            {
                if ((xl + xo) == xtl && (yl + yo) == ytl)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}
