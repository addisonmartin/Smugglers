import greenfoot.*;

public class Civilian extends NPC
{
    //Written by Addison
    private int targetX;
    private int targetY;
    private int speed = 2;
    
    //Written by Connor
    private int Frame = 0;
    private int AnimationCounter = 0;
    private boolean Right = false;
    private boolean Down = false;
    private boolean Left = false;
    
    //Written by Addison
    private boolean hasTarget = false;
    private boolean headingToMingle = true;
    private boolean headingToBuilding = false;
    private boolean headingToExit = false;
    private boolean headingToBuildingCenter = false;
    private boolean exitingBuilding = false;
    private int building;
    
    //Written by Addison
    public void act()
    {
        newMoveCycle();
        moveCycle();
        animate();
    }

    //Written by Addison
    public void newMoveCycle()
    {
        if (!hasTarget)
        {
            if (headingToMingle && Greenfoot.getRandomNumber(1000) < 1)
            {   
                int randBuilding = Greenfoot.getRandomNumber(((Map)getWorld()).getNumBuildings());
                
                if (randBuilding == 8)
                {
                    int randExit = Greenfoot.getRandomNumber(4);
                    targetX = ((Map)getWorld()).getExits().get(randExit).getTargetX();
                    targetY = ((Map)getWorld()).getExits().get(randExit).getTargetY();
                    headingToExit = true;
                }
                
                else
                {
                    targetX = ((Map)getWorld()).getBuildings().get(randBuilding).getTargetX();
                    targetY = ((Map)getWorld()).getBuildings().get(randBuilding).getTargetY();
                    building = randBuilding;
                    headingToBuilding = true;
                }
                
                headingToMingle = false;
            }
            
            else if (headingToBuilding)
            {
                targetX = ((Map)getWorld()).getBuildings().get(building).getCenterX();
                targetY = ((Map)getWorld()).getBuildings().get(building).getCenterY();
                
                headingToBuilding = false;
                headingToBuildingCenter = true;
            }
            
            else if (headingToBuildingCenter)
            {
                targetX = ((Map)getWorld()).getBuildings().get(building).getTargetX();
                targetY = ((Map)getWorld()).getBuildings().get(building).getCenterY();
                
                headingToBuildingCenter = false;
                exitingBuilding = true;
            }
            
            else if (exitingBuilding)
            {
                int randMingle = Greenfoot.getRandomNumber(4);
                targetX = ((Map)getWorld()).getMingleSpots().get(randMingle).getTargetX() + (Greenfoot.getRandomNumber(125) - 75);
                targetY = ((Map)getWorld()).getMingleSpots().get(randMingle).getTargetY() + (Greenfoot.getRandomNumber(125) - 75);
                
                exitingBuilding = false;
                headingToMingle = true;
            }
            
            hasTarget = true;
        }
        
        if (hasTarget && headingToBuilding && Greenfoot.getRandomNumber (10000) < 5)
        {
            int randMingle = Greenfoot.getRandomNumber(4);
            targetX = ((Map)getWorld()).getMingleSpots().get(randMingle).getTargetX() + (Greenfoot.getRandomNumber(125) - 75);
            targetY = ((Map)getWorld()).getMingleSpots().get(randMingle).getTargetY() + (Greenfoot.getRandomNumber(125) - 75);
            
            headingToBuilding = false;
            headingToMingle = true;
        }
    }

    //Written by Addison
    public void moveCycle()
    {
        if (headingToExit || headingToBuildingCenter || exitingBuilding)
        {
            turnTowards(targetX, targetY);
        }
        
        else
        {
            turnTowards(targetX, targetY);
            
            if (Greenfoot.getRandomNumber(100) < 5)
            {
                turn(Greenfoot.getRandomNumber(40) - 20);
            }
        }
        
        if (!Location.isAtLocation(getX(), getY(), targetX, targetY))
        {
            move(speed);
        }
        
        else
        {
            if (headingToExit && Exit.isAtExit(getX(), getY(), targetX, targetY))
            {
                getWorld().removeObject(this);
            }
            
            else
            {
                hasTarget = false;
            }
        }
    }

    //Written by Addison
    public void setTarget(int newX, int newY)
    {
        targetX = newX;
        targetY = newY;
    }
    
    //Written by Addison
    public void setToExit(int newX, int newY)
    {
        targetX = newX;
        targetY = newY;
        headingToExit = true;
    }
    
    //Written by Addison
    public void logBooleans()
    {
        System.out.println("hasTarget = " + hasTarget);
        System.out.println("headingToMingle = " + headingToMingle);
        System.out.println("headingToBuilding = " + headingToBuilding);
        System.out.println("headingToExit = " + headingToExit);
        System.out.println("headingToBuildingCenter = " + headingToBuildingCenter);
        System.out.println("exitingBuilding = " + exitingBuilding);
    }
    
    //written by Connor
    public void animate()
    {
        AnimationCounter++;
        Frame++;
        
        if ( AnimationCounter % 20 == 0)
        {
            setImage("Player/Player_" + "G" + "_" + Frame + ".png");
        }
        
        if ( Frame >= 6 )
        {
            Frame = 0;
        }
    }
    
    //Written by Addison
    public void scatter()
    {
        int randDir = Greenfoot.getRandomNumber(4);
        
        if (randDir == 0)
        {
            setTarget(getX() + (Greenfoot.getRandomNumber(250) + 125) , getY() + (Greenfoot.getRandomNumber(250) + 125));
        }
        
        else if (randDir == 1)
        {
            setTarget(getX() - (Greenfoot.getRandomNumber(250) + 125) , getY() + (Greenfoot.getRandomNumber(250) + 125));
        }
        
        else if (randDir == 2)
        {
            setTarget(getX() + (Greenfoot.getRandomNumber(250) + 125) , getY() - (Greenfoot.getRandomNumber(250) + 125));
        }
        
        else if (randDir == 3)
        {
            setTarget(getX() - (Greenfoot.getRandomNumber(250) + 125) , getY() - (Greenfoot.getRandomNumber(250) + 125));
        }
    }
    
    //Written by Addison
    public void setHeadingToExit(boolean nHeadingToExit)
    {
        headingToExit = nHeadingToExit;
    }
}
