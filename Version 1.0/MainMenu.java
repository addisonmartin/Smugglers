import greenfoot.*;

public class MainMenu extends World
{
    //Written by Rahul
    public MainMenu()
    {    
        super(1366, 768, 1); 
        addObject(new Play(), getWidth() - 300, 100);
        addObject(new HowToPlay(), getWidth() - 300, 250);
        addObject(new HighScore(), getWidth() - 300, 400);
        addObject(new Credits(), getWidth() - 300, 550);
        addObject(new Haungs(), getWidth() - 1200, 650);
    }
}
