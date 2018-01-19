import greenfoot.*;

public class Map3 extends Map
{
    
    //Written by Addison
    public Map3(ScoreBoardOrganizer s, boolean nHaungsMode, int roundNum, int smugScoreRound1, int policeScoreRound1, int minutesRound1, int secondsRound1)
    {
        super(s, nHaungsMode, roundNum, smugScoreRound1, policeScoreRound1, minutesRound1, secondsRound1);
        mapNum = 3;
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
        addObject (new SniperCharacter(), 683, 686);
        addObject(clock, 683, 97);
        addObject(smugCount, 50, 384);
        addObject(policeCount, 1316, 384);
        addObject(new ReloadCounter(), 1300, 625);
        //Written by Connor
        addObject(new ClipCounter(), 1300, 535);
    }
    
    //Written by Addison
    public void generateEntrances()
    {
        getEntrances().add(new Entrance(341,5));
        getEntrances().add(new Entrance(341,1360));
        getEntrances().add(new Entrance(1025,5));
        getEntrances().add(new Entrance(1025,1360));

        for (int i = 0; i < getEntrances().size(); i++)
        {
            addObject(getEntrances().get(i), getEntrances().get(i).getTargetX(), getEntrances().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateExits()
    {
        getExits().add(new Exit(341,5));
        getExits().add(new Exit(341,763));
        getExits().add(new Exit(1025,5));
        getExits().add(new Exit(1025,763));

        for (int i = 0; i < getExits().size(); i++)
        {
            addObject(getExits().get(i), getExits().get(i).getTargetX(), getExits().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateMingleSpots()
    {
        getMingleSpots().add(new MingleSpot(420,315));
        getMingleSpots().add(new MingleSpot(420,500));
        getMingleSpots().add(new MingleSpot(935,315));
        getMingleSpots().add(new MingleSpot(935,500));

        for (int i = 0; i < getMingleSpots().size(); i++)
        {
            addObject(getMingleSpots().get(i), getMingleSpots().get(i).getTargetX(), getMingleSpots().get(i).getTargetY());
        }
    }
    
    //Written by Addison
    public void generateBuildings()
    {
        //0 is right, 1 is up, 2 is left, 3 is down
        getBuildings().add(new GeneralStore(683, 215, 683, 97, 3));
        getBuildings().add(new Factory(683, 575, 683, 686, 1));
        
        numBuildings = 2;

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
                addObject(cop, 341, 763);
                setupCop();
                copHasSpawned = true;
            }
        }
    }
    
    //Written by Addison
    public void setupCop()
    {
        cop.setTargets(420, 501, 936, 500, 935, 316, 421, 315);
        cop.setTarget(420, 501);
    }
}
