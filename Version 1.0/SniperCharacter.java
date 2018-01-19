import greenfoot.*;

public class SniperCharacter extends Player
{
    //Written by Rahul
    public void act() 
    {
        followMouse();
    }   
    
    //Written by Rahul
    public void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        if (mi != null && mi.getY() < 650)
        {
            turnTowards(mi.getX(), mi.getY());
            turn(90);
        }
    }    
}
