import greenfoot.*;

public class Map2 extends Map
{
    
    //Written by Addison
    public Map2(ScoreBoardOrganizer s, boolean nHaungsMode, int roundNum, int smugScoreRound1, int policeScoreRound1, int minutesRound1, int secondsRound1)
    {
        super(s, nHaungsMode, roundNum, smugScoreRound1, policeScoreRound1, minutesRound1, secondsRound1);
        mapNum = 2;
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
        addObject (new SniperCharacter(), 765, 680);
        addObject(clock, 610, 85);
        addObject(smugCount, 355, 95);
        addObject(policeCount, 1070, 95);
        addObject(new ReloadCounter(), 1305, 625);
        //Written by Connor
        addObject(new ClipCounter(), 1310, 540);
    }
    
    //Written by Addison
    public void generateEntrances()
    {
        getEntrances().add(new Entrance(250,760));
        getEntrances().add(new Entrance(5,5));
        getEntrances().add(new Entrance(1070,755));
        getEntrances().add(new Entrance(1355,280));

        for (int i = 0; i < getEntrances().size(); i++)
        {
            addObject(getEntrances().get(i), getEntrances().get(i).getTargetX(), getEntrances().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateExits()
    {
        getExits().add(new Exit(250,760));
        getExits().add(new Exit(5,5));
        getExits().add(new Exit(1070,755));
        getExits().add(new Exit(1355,280));

        for (int i = 0; i < getExits().size(); i++)
        {
            addObject(getExits().get(i), getExits().get(i).getTargetX(), getExits().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateMingleSpots()
    {
        getMingleSpots().add(new MingleSpot(1060,550));
        getMingleSpots().add(new MingleSpot(1135,375));
        getMingleSpots().add(new MingleSpot(850,400));
        getMingleSpots().add(new MingleSpot(540,365));

        for (int i = 0; i < getMingleSpots().size(); i++)
        {
            addObject(getMingleSpots().get(i), getMingleSpots().get(i).getTargetX(), getMingleSpots().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateBuildings()
    {
        //0 is right, 1 is up, 2 is left, 3 is down
        getBuildings().add(new Barber(250, 420, 115, 420, 0));
        getBuildings().add(new GeneralStore(355, 210, 355, 95, 3));
        getBuildings().add(new NewsStand(600, 255, 600, 120, 3));
        getBuildings().add(new ButcherShop(840, 255, 840, 120, 3));
        getBuildings().add(new Diner(1070, 255, 1070, 120, 3));
        getBuildings().add(new Factory(1200, 630, 1285, 625, 2));
        getBuildings().add(new Saloon(765, 520, 765, 650, 1));
        getBuildings().add(new Bank(500, 515, 500, 655, 1));
        
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
                addObject(cop, 335, 768); 
                setupCop();
                copHasSpawned = true;
            }
        }
    }
    
    //Written by Addison
    public void setupCop()
    {
        cop.setTargets(330, 476, 1060, 476, 1060, 326, 330, 326);
        cop.setTarget(330, 475);
    }
}
