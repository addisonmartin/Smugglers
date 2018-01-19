import greenfoot.*;

public class CivilianDead extends NPC
{
    //Written by Connor
    private int AnimationCounter = 0;
    private int Frame = 0;
    private int AltFrame = 0;
    private boolean First = true;

    //Written by Connor
    public CivilianDead()
    {
        if (Greenfoot.getRandomNumber(100) < 50)
        {
            First = true;
        }
        else
        {
            First = false;
        }
    }

    //Written by Connor
    public void act() 
    {
        Animate();
    }  

    //Written by Connor
    private void Animate()
    {
        if (First == true)
        {
            AnimationCounter++;
            
            if (AnimationCounter % 2 == 0 && Frame < 22)
            {
                Frame++;
                setImage("Player/PCDeath1_" + Frame + ".png");
                
                if ( Frame == 22 )
                {
                    setImage("Player/PCDeath1_" + 22 + ".png");
                }
            }
        }
        
        else if (First == false)
        {
            AnimationCounter++;
            
            if (AnimationCounter % 5 == 0 && AltFrame < 19)
            {
                AltFrame++;
                setImage("Player/PCDeath2_" + AltFrame + ".png");
                
                if ( AltFrame == 19 )
                {
                    setImage("Player/PCDeath2_" + 19 + ".png");
                }
            }
        }
    }
}