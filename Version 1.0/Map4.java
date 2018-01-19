import greenfoot.*;

public class Map4 extends Map
{
    
    //Written by Addison
    public Map4(ScoreBoardOrganizer s, boolean nHaungsMode, int roundNum, int smugScoreRound1, int policeScoreRound1, int minutesRound1, int secondsRound1)
    {
        super(s, nHaungsMode, roundNum, smugScoreRound1, policeScoreRound1, minutesRound1, secondsRound1);
        mapNum = 4;
        simpleChecking = true;
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
        addObject (new SniperCharacter(), 800, 660);
        addObject(clock, 600, 95);
        addObject(smugCount, 105, 385);
        addObject(policeCount, 1260, 385);
        addObject(new ReloadCounter(), 1295, 680);
        //Written by Connor
        addObject(new ClipCounter(), 1300, 585);
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
        getMingleSpots().add(new MingleSpot(430,390));
        getMingleSpots().add(new MingleSpot(660,290));
        getMingleSpots().add(new MingleSpot(985,300));
        getMingleSpots().add(new MingleSpot(800,455));

        for (int i = 0; i < getMingleSpots().size(); i++)
        {
            addObject(getMingleSpots().get(i), getMingleSpots().get(i).getTargetX(), getMingleSpots().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateBuildings()
    {
        //0 is right, 1 is up, 2 is left, 3 is down
        getBuildings().add(new Barber(250, 385, 115, 385, 0));
        getBuildings().add(new GeneralStore(600, 210, 600, 95, 3));
        getBuildings().add(new NewsStand(1110, 385, 1250, 385, 2));
        getBuildings().add(new ButcherShop(800, 515, 800, 650, 1));
        
        numBuildings = 4;

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
            if (clock.returnMinutes() == 4 && clock.returnSeconds() == 55)
            {
                cop = new Cop();
                addObject(cop, 410, 765);
                setupCop();
                copHasSpawned = true;
            }
        }
    }
    
    //Written by Addison
    public void setupCop()
    {
        cop.setTargets(410, 465, 1016, 465, 1015, 285, 411, 285);
        cop.setTarget(410, 465);
    }
}
