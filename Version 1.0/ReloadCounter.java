import greenfoot.*;

public class ReloadCounter extends Objects
{
    //Written by Connor
    private int frame = 0;
    private int shots = 0;
    
    //Written by Addison
    public void act()
    {
        check();
    }

    //Written by Addison
    private void check()
    {
        shots = ((Map)getWorld()).getSniper().getShotsFired();

        if (shots == 0 || shots == 5)
        {
            frame = 0;
        }
        
        else if (shots == 1 || shots == 6)
        {
            frame = 1;
        }
        
        else if (shots == 2 || shots == 7)
        {
            frame = 2;
        }
        
        else if (shots == 3 || shots == 8)
        {
            frame = 3;
        }
        
        else if (shots == 4 || shots == 9)
        {
            frame = 4;
        }
        
        else if (shots == 10)
        {
            setImage("Reload/Mag_5.png");
            ((Map)getWorld()).endRound();
        }
        
        setImage("Reload/Mag_" + frame + ".png");
    }
}
