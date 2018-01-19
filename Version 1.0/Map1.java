import greenfoot.*;

public class Map1 extends Map
{
    
    //Written by Addison
    public Map1(ScoreBoardOrganizer s, boolean nHaungsMode, int roundNum, int smugScoreRound1, int policeScoreRound1, int minutesRound1, int secondsRound1)
    {
        super(s, nHaungsMode, roundNum, smugScoreRound1, policeScoreRound1, minutesRound1, secondsRound1);
        mapNum = 1;
        simpleChecking = false;
        prepare();
    }
    
    //Written by Addison
    public void act()
    {
        super.act();
        checkCop();
    }
    
    //Written by Addison
    public void prepare()
    {
        generateEntrances();
        generateExits();
        generateMingleSpots();
        generateBuildings();
        addObjects();
        
        for (int i = 0; i < 40; i++)
        {
            int ms = Greenfoot.getRandomNumber(getMingleSpots().size());
            Civilian c = new Civilian();
            addObject(c, getMingleSpots().get(ms).getTargetX() + (Greenfoot.getRandomNumber(125)-75), getMingleSpots().get(ms).getTargetY() + (Greenfoot.getRandomNumber(125)-75));
            c.setTarget(getMingleSpots().get(ms).getTargetX() + (Greenfoot.getRandomNumber(125)-75), getMingleSpots().get(ms).getTargetY() + (Greenfoot.getRandomNumber(125)-75));
        }

        int ms = Greenfoot.getRandomNumber(getMingleSpots().size());
        
        if(!haungsMode)
        {
            addObject(new Smuggler(), getMingleSpots().get(ms).getTargetX() + (Greenfoot.getRandomNumber(125)-75), getMingleSpots().get(ms).getTargetY() + (Greenfoot.getRandomNumber(125)-75));
        }
        
        else
        {
            addObject(new HaungsSmuggler(), getMingleSpots().get(ms).getTargetX() + (Greenfoot.getRandomNumber(125)-75), getMingleSpots().get(ms).getTargetY() + (Greenfoot.getRandomNumber(125)-75));
        }
    }
    
    //Written by Addison
    public void addObjects()
    {
        addObject (new SniperCharacter(), 725, 690);
        addObject(clock, 600, 98);
        addObject(smugCount, 110, 318);
        addObject(policeCount, 1262, 368);
        addObject(new ReloadCounter(), 1275, 650);
        //Written by Connor
        addObject(new ClipCounter(), 1271, 560);
    }
    
    //Written by Addison
    public void generateEntrances()
    {
        getEntrances().add(new Entrance(323,760));
        getEntrances().add(new Entrance(1077,760));
        getEntrances().add(new Entrance(1360,5));
        getEntrances().add(new Entrance(365,5));

        for (int i = 0; i < getEntrances().size(); i++)
        {
            addObject(getEntrances().get(i), getEntrances().get(i).getTargetX(), getEntrances().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateExits()
    {
        getExits().add(new Exit(323,760));
        getExits().add(new Exit(1077,760));
        getExits().add(new Exit(10,470));
        getExits().add(new Exit(365,5));

        for (int i = 0; i < getExits().size(); i++)
        {
            addObject(getExits().get(i), getExits().get(i).getTargetX(), getExits().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateMingleSpots()
    {
        getMingleSpots().add(new MingleSpot(380,205));
        getMingleSpots().add(new MingleSpot(995,435));
        getMingleSpots().add(new MingleSpot(760,310));
        getMingleSpots().add(new MingleSpot(440,435));

        for (int i = 0; i < getMingleSpots().size(); i++)
        {
            addObject(getMingleSpots().get(i), getMingleSpots().get(i).getTargetX(), getMingleSpots().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateBuildings()
    {
        getBuildings().add(new Bank(270, 645, 120, 645, 0));
        getBuildings().add(new Barber(260, 340, 115, 340, 0));
        getBuildings().add(new NewsStand(270, 115, 120, 115, 0));
        getBuildings().add(new GeneralStore(600, 235, 600, 98, 3));
        getBuildings().add(new ButcherShop(865, 290, 865, 125, 3));
        getBuildings().add(new Diner(1090, 385, 1240, 385, 2));
        getBuildings().add(new Saloon(1090, 635, 1240, 635, 2));
        getBuildings().add(new Factory(715, 570, 715, 685, 1));
        
        numBuildings = 8;

        for (int i = 0; i < getBuildings().size(); i++)
        {
            addObject(getBuildings().get(i), getBuildings().get(i).getCenterX(), getBuildings().get(i).getCenterY());
        }
    }
    
    //Written by Patrick
    public void checkCop()
    {
        if (!copHasSpawned)
        {
            if (clock.returnMinutes() == 4 && clock.returnSeconds() == 0)
            {
                cop = new Cop();
                addObject(cop, 400, 768); 
                setupCop();
                copHasSpawned = true;
            }
        }
    }
    
    //Written by Addison
    public void setupCop()
    {
        cop.setTargets(450, 520, 980, 520, 980, 320, 450, 320);
        cop.setTarget(450, 520);
    }
}
