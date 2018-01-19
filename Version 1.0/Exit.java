import greenfoot.*;

public class Exit extends Location
{
    //Written by Addison
    public Exit(int nx, int ny)
    {
        super(nx, ny);
    }
    
    //Written by Addison
    public static boolean isAtExit(int xl, int yl, int xel, int yel)
    {
        for (int xo =  -50; xo <= 50; xo++)
        {
            for (int yo = -50; yo <= 50; yo++)
            {
                if ((xl + xo) == xel && (yl + yo) == yel)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}
