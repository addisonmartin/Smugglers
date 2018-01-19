import greenfoot.*;
import java.util.List;

public class Sniper extends Player
{
    //Written by Addison
    private int reloadTime = 75;
    private int cooldown = 0;
    
    //Written by Connor
    private int shotsFired = 0;

    //Written by Rahul
    public void act() 
    {
        followMouse();
        fire();
        changeReticle();
        remove();
    }
    
    //Written by Connor
    private void remove()
    {
        if (shotsFired == 5)
        {
            getWorld().removeObjects(getObjectsInRange(2000, ClipCounter.class));
        }
    }

    //Written by Rahul
    private void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();

        if (mi != null )
        {
            setLocation(mi.getX(), mi.getY());
        }
    }

    //Written by Addison
    public void fire()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (cooldown == 0 && shotsFired < 10 && mouse != null)
        {
            int button = mouse.getButton();

            if (button == 1 && Greenfoot.mouseClicked(null))
            {
                Greenfoot.playSound("gunshot.wav");
                shotsFired++;
                List l = getNeighbours(25, true, null);

                for (int i = 0; i < l.size(); i++)
                {
                    if (l.get(i).getClass() == Civilian.class)
                    {
                        Actor D = new CivilianDead();
                        getWorld().addObject(D, ((Civilian)l.get(i)).getX(), ((Civilian)l.get(i)).getY());
                        List neighbours = getObjectsInRange(150, Civilian.class);
                        scatterNPCs(neighbours);
                        //scream();
                        getWorld().removeObject((Civilian)l.get(i));
                        
                        if (((Map)getWorld()).returnRound() == 1)
                        {
                            ((Map)getWorld()).getScore().addData(2, "Innocent killed: -$100.00", 1);
                        }
                        else if (((Map)getWorld()).returnRound() == 2)
                        {
                            ((Map)getWorld()).getScore().addData(1, "Innocent killed: -$100.00", 2);
                        }
                        
                        ((Map)getWorld()).scoreChange(0, -100);
                        
                        cooldown = reloadTime;
                        return;
                    }

                    else if (l.get(i).getClass() == Smuggler.class)
                    {   
                        setImage("RedReticle.png");
                        
                        if (((Map)getWorld()).returnRound() == 1)
                        {
                            ((Map)getWorld()).getScore().addData(2, "Smuggler killed: $750.00", 1);
                        }
                        
                        else if (((Map)getWorld()).returnRound() == 2)
                        {
                            ((Map)getWorld()).getScore().addData(1, "Smuggler killed: $750.00", 2);
                        }
                        
                        ((Map)getWorld()).scoreChange(0, 750);
                        
                        ((Map)getWorld()).endRound();
                        cooldown = reloadTime;
                    }
                    
                    else if (l.get(i).getClass() == HaungsSmuggler.class)
                    {   
                        setImage("RedReticle.png");
                        
                        if (((Map)getWorld()).returnRound() == 1)
                        {
                            ((Map)getWorld()).getScore().addData(2, "Smuggler killed: $750.00", 1);
                        }
                        
                        else if (((Map)getWorld()).returnRound() == 2)
                        {
                            ((Map)getWorld()).getScore().addData(1, "Smuggler killed: $750.00", 2);
                        }
                        
                        ((Map)getWorld()).scoreChange(0, 750);
                        
                        ((Map)getWorld()).endRound();
                        cooldown = reloadTime;
                    }
                    
                    else if (l.get(i).getClass() == Cop.class)
                    {
                        getWorld().removeObject((Cop)l.get(i));
                        
                        if (((Map)getWorld()).returnRound() == 1)
                        {
                            ((Map)getWorld()).getScore().addData(2, "Cop Killed: -$250.00", 1);
                        }
                        
                        else if (((Map)getWorld()).returnRound() == 2)
                        {
                            ((Map)getWorld()).getScore().addData(1, "Cop Killed: -$250.00", 2);
                        }
                        
                        ((Map)getWorld()).scoreChange(0, -250);
                        cooldown = reloadTime;
                    }
                    
                    //Written by Riley
                    else if (l.get(i).getClass() == Cluster.class)
                    {   
                        Cluster c = (Cluster)l.get(i);
                        c.activate(); 
                        getWorld().removeObject((Cluster)l.get(i));
                        cooldown = reloadTime;
                    }
                    
                    else if (l.get(i).getClass() == Remove.class)
                    {   
                        Remove r = (Remove)l.get(i);
                        r.activate(); 
                        getWorld().removeObject((Remove)l.get(i));
                        cooldown = reloadTime;
                    }
                    //End written by Riley
                    //Written by Dylan
                    else if (l.get(i).getClass() == xtraPoints.class)
                    {
                        xtraPoints x = (xtraPoints)l.get(i);
                        ((Map)getWorld()).scoreChange(0, 100);
                        
                        if (((Map)getWorld()).returnRound() == 1)
                        {
                            ((Map)getWorld()).getScore().addData(2, "Xtra Points: $100.00", 1);
                        }
                        
                        else if (((Map)getWorld()).returnRound() == 2)
                        {
                            ((Map)getWorld()).getScore().addData(1, "Xtra Points: $100.00", 2);
                        }
                        
                        getWorld().removeObject((xtraPoints)l.get(i));
                        cooldown = reloadTime;
                    }
                }

                cooldown = reloadTime;
            }
        }

        else
        {
            cooldown--;
        }
    } 

    //Written by Patrick
    public void changeReticle()
    {
        if (isTouching(Civilian.class) || isTouching(Smuggler.class))
        {
            setImage ("RedReticle.png");
        }

        else
        {
            setImage ("GreenReticle.png");
        }
    }

    //Written by Addison
    public void scatterNPCs(List npcs)
    {
        for (int i = 0; i < npcs.size(); i++)
        {
            ((Civilian)npcs.get(i)).scatter();
        }
    }

    //Written by Addison
    public void scream()
    {
        int randScream = Greenfoot.getRandomNumber(6);

        if (randScream == 0)
        {
            Greenfoot.playSound("wilhelm_scream.wav");
        }

        else if (randScream == 1)
        {
            Greenfoot.playSound("screaming.wav");
        }

        else if (randScream == 2)
        {
            Greenfoot.playSound("female_scream.wav");
        }

        else if (randScream == 3)
        {
            Greenfoot.playSound("howarddean_scream.wav");
        }

        else if (randScream == 4)
        {
            Greenfoot.playSound("scream_and_die.wav");
        }

        else if (randScream == 5)
        {
            Greenfoot.playSound("screaming_female.wav");
        }
    }
    
    //Written by Connor
    public int getShotsFired()
    {
        return shotsFired;
    }
}
