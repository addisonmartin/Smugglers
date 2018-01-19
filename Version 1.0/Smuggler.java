import greenfoot.*;
import java.util.ArrayList;

public class Smuggler extends Player
{
    //Written by Addison
    private int speed = 2;
    private int turnAmount = 3;

    //Written by Riley
    private int sprintCounter = 75;
    private int stamina = 0;

    //Written By Addison
    private boolean hasPickUp = false;
    private boolean hasDropOff = false;
    private Building pickUpBuilding;
    private Building dropOffBuilding;
    private int pickUpBuildingNumber;
    private int alcohol = 0;
    private int fCooldown = 25;
    private int copCooldown = 0;

    //Written by Connor
    private int Frame = 0;
    private int AnimationCounter = 0;

    //Written by Addison
    public void act() 
    {
        checkKeys();
        assignPickUp();
        assignDropOff();
        checkPickUp();
        checkDropOff();
        checkCop();
        Animate();
    }    

    //Written by Addison
    public void assignPickUp()
    {
        if (!hasPickUp)
        {
            ArrayList<Building> b = ((Map)getWorld()).getBuildings();

            for (int xo = -buildingRange; xo <= buildingRange; xo++)
            {
                for (int yo = -buildingRange; yo <= buildingRange; yo++)
                {                    
                    for (int i = 0; i < b.size(); i++)
                    {
                        if ((getX() + xo) == b.get(i).getCenterX() && (getY() + yo) == b.get(i).getCenterY()) 
                        {
                            pickUpBuilding = b.get(i);
                            pickUpBuildingNumber = i;
                            hasPickUp = true;
                            return;
                        }
                    }
                }
            }
        }
    }

    //Written by Addison
    public void assignDropOff()
    {
        if (hasPickUp && !hasDropOff)
        {
            ArrayList<Building> b = ((Map)getWorld()).getBuildings();

            for (int xo = -buildingRange; xo <= buildingRange; xo++)
            {
                for (int yo = -buildingRange; yo <= buildingRange; yo++)
                {                    
                    for (int i = 0; i < b.size(); i++)
                    {
                        if ((getX() + xo) == b.get(i).getCenterX() && (getY() + yo) == b.get(i).getCenterY()) 
                        {
                            if (!((Map)getWorld()).getSimpleChecking())
                            {
                                int dropOffMax = pickUpBuildingNumber + 2;
                                int dropOffMin = pickUpBuildingNumber - 2;

                                if (dropOffMin < 0)
                                {
                                    int tDropOffMin = dropOffMax;
                                    dropOffMax = dropOffMin + b.size();
                                    dropOffMin = tDropOffMin;

                                    if (i < dropOffMax && i > dropOffMin)
                                    {
                                        dropOffBuilding = b.get(i);
                                        hasDropOff = true;
                                    }

                                    return;
                                }

                                else if (dropOffMax >= b.size())
                                {
                                    int tDropOffMax = dropOffMin;
                                    dropOffMin = dropOffMax - b.size();
                                    dropOffMax = tDropOffMax;

                                    if (i < dropOffMax && i > dropOffMin)
                                    {
                                        dropOffBuilding = b.get(i);
                                        hasDropOff = true;
                                    }

                                    return;
                                }

                                if (i > dropOffMax || i < dropOffMin)
                                {
                                    dropOffBuilding = b.get(i);
                                    hasDropOff = true;
                                    return;
                                }
                            }

                            else
                            {
                                if (i != pickUpBuildingNumber)
                                {
                                    dropOffBuilding = b.get(i);
                                    hasDropOff = true;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //Written by Addison
    public void checkPickUp()
    {
        if (hasPickUp)
        {
            for (int xo = -buildingRange; xo <= buildingRange; xo++)
            {
                for (int yo = -buildingRange; yo <= buildingRange; yo++)
                {
                    if (hasPickUp && alcohol == 0 && (getX() + xo) == pickUpBuilding.getCenterX() && (getY() + yo) == pickUpBuilding.getCenterY())
                    {
                        alcohol++;
                        ((Map)getWorld()).logPickup();
                        ((Map)getWorld()).scoreChange(1, 5);

                        if (((Map)getWorld()).returnRound() == 1)
                        {
                            ((Map)getWorld()).getScore().addData(1, "Successful Pickup: $5.00", 1);
                        }

                        else if (((Map)getWorld()).returnRound() == 2)
                        {
                            ((Map)getWorld()).getScore().addData(2, "Successful Pickup: $55.00", 2);
                        }

                        return;
                    }
                }
            }
        }
    }

    //Written by Addison
    public void checkDropOff()
    {
        if (hasPickUp && hasDropOff)
        {
            for (int xo = -buildingRange; xo <= buildingRange; xo++)
            {
                for (int yo = -buildingRange; yo <= buildingRange; yo++)
                {
                    if (hasDropOff && alcohol == 1 && (getX() + xo) == dropOffBuilding.getCenterX() && (getY() + yo) == dropOffBuilding.getCenterY())
                    {
                        alcohol--;
                        ((Map)getWorld()).logDropoff();
                        ((Map)getWorld()).scoreChange(1, 95);

                        if (((Map)getWorld()).returnRound() == 1)
                        {
                            ((Map)getWorld()).getScore().addData(1, "Successful Dropoff: $95.00", 1);
                        }

                        else if (((Map)getWorld()).returnRound() == 2)
                        {
                            ((Map)getWorld()).getScore().addData(2, "Successful Dropoff: $95.00", 2);
                        }

                        return;
                    }
                }
            }
        }
    }

    //Written by Addison
    public void checkKeys()
    {
        if (copCooldown == 0)
        {
            if (Greenfoot.isKeyDown("w"))
            {
                move(speed);
            }

            if (Greenfoot.isKeyDown("s"))
            {
                move(-speed);
            }

            if (Greenfoot.isKeyDown("a"))
            {
                turn(-turnAmount); 
            }

            if (Greenfoot.isKeyDown("d"))
            {
                turn(turnAmount);
            }

            //Written by Riley
            if (Greenfoot.isKeyDown("shift"))
            {
                if  (stamina < 75)
                {
                    stamina++;
                    speed = 4;
                }

                else
                {
                    speed = 2;
                }
            }

            else
            {
                speed = 2;

                if (stamina > 0)
                {
                    stamina--;
                }
            }
            //End written by Riley

            //Written by Addison
            if (Greenfoot.isKeyDown("f") && fCooldown == 0)
            {
                turn(180);
                fCooldown = 25;
            }

            else if (fCooldown > 0)
            {
                fCooldown--;
            }
        }

        else
        {
            copCooldown--;
        }
    }

    //Written by Connor
    public void Animate()
    {
        AnimationCounter++;
        if (AnimationCounter % 15 == 0)
        {
            Frame++;
            setImage("Player/Player_" + "G" + "_" + Frame + ".png");
            
            if (Frame >= 6)
            {
                Frame = 0;
            }
        }
    }

    //Written by Patrick
    public void checkCop()
    {
        if (isTouching(Cop.class))
        {
            copCooldown = 500;
        }
    }
}