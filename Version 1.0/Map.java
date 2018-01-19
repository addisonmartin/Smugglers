import greenfoot.*;
import java.util.ArrayList;
import java.util.Collections;

public class Map extends World
{
    //Written by Addison
    protected ArrayList<Entrance> entrances;
    protected ArrayList<Exit> exits;
    protected ArrayList<MingleSpot> mingleSpots;
    protected ArrayList<Building> buildings;
    protected int numBuildings;
    protected int mapNum;
    protected Cop cop;
    protected boolean simpleChecking;
    
    //Written by Dylan
    private ArrayList<Long> times;
    private ScoreBoardOrganizer score;
    private long pickupTime;
    public Counter smugCount;
    public Counter policeCount;

    //Written by Riley
    private GreenfootSound bkgMusic;

    //Written by Dylan
    public int round1Minutes;
    public int round1Seconds;
    public int round2Minutes;
    public int round2Seconds;
    public int smugScorePrev = 0;
    public int policeScorePrev = 0;
    public long round1ShortDropoff;
    public long round1LongDropoff;
    private int round;
    protected Clock clock;

    //Written by Riley
    private boolean hasSpawned = false;
    private boolean hasSpawned1 = false;
    private boolean hasSpawned2 = false;
    private boolean hasSpawned3 = false;
    private boolean hasSpawned4 = false;
    private boolean hasSpawned5 = false;
    private boolean hasSpawned6 = false; 
    private boolean hasSpawned7 = false; 
    private boolean hasSpawned8 = false;
    private boolean hasSpawned9 = false;
    private boolean hasSpawned10 = false;
    private boolean hasSpawned11 = false;
    
    private boolean timer = false;
    
    private int min ;
    private int min1;
    private int min2;
    private int min3;
    private int min4;
    private int min5;
    private int min6;
    private int min7;
    private int min8;
    private int min9 ;
    private int min10;
    private int min11;
    private int min12;
    private int min13;
    private int min14;
    private int min15;
    private int min16;
    private int min17;
    private int min18;
    private int min19;
    
    //Written by Connor
    protected Sniper sniper;
    
    //Written by Patrick
    protected boolean haungsMode;
    protected boolean copHasSpawned = false;

    //Written by Addison
    public Map(ScoreBoardOrganizer s, boolean nHaungsMode, int roundNum, int smugScoreRound1, int policeScoreRound1, int minutesRound1, int secondsRound1)
    {
        super(1366, 768, 1, false);
        
        setup();
        //Written by Riley
        bkgMusic = new GreenfootSound("Oldies.mp3");
        bkgMusic.playLoop();
        //End written by Riley
        
        //Written by Dylan
        round = roundNum;
        smugScorePrev = smugScoreRound1;
        policeScorePrev = policeScoreRound1;
        haungsMode = nHaungsMode;
        round1Minutes = minutesRound1;
        round1Seconds = secondsRound1;
        score = s;
        //End written by Dylan
        
        setPaintOrder(Sniper.class, PowerUps.class, SniperCharacter.class, ReloadCounter.class, ClipCounter.class, Clock.class, Counter.class, Building.class, Civilian.class);
    }

    //Written by Addison
    public void setup()
    {
        sniper = new Sniper();
        addObject(sniper, getWidth()/2, getHeight()/2);
        entrances = new ArrayList();
        exits = new ArrayList();
        mingleSpots = new ArrayList();
        buildings = new ArrayList();
        clock = new Clock();
        smugCount = new Counter();
        policeCount = new Counter();
        times = new ArrayList<Long>();
    }

    //Written by Addison
    public void act()
    {
        randSpawnCivilians(); 
        spawnPowerUps();
    }

    //Written by Dylan
    public void scoreChange(int which, int score)
    {
        if (which == 0)
        {
            policeCount.setValue(policeCount.getValue() + score);
        }

        if (which == 1)
        {
            smugCount.setValue(smugCount.getValue() + score);
        }
    }
    
    //Written by Dylan
    public void logPickup() 
    {
        pickupTime = System.currentTimeMillis();
    }
    
    //Written by Dylan
    public void logDropoff() 
    {
        times.add(System.currentTimeMillis() - pickupTime);
    }
    
    //Written by Dylan
    public ScoreBoardOrganizer getScore()
    {
        return score;
    }

    //Written by Dylan
    public void endRound()
    {
        bkgMusic.stop();
        
        if (times.isEmpty())
        {
            times.add(0l);
        }
        
        Collections.sort(times);

        if (round == 1)
        {
            round1Minutes = clock.returnMinutes();
            round1Seconds = clock.returnSeconds();
            
            RoundSwitch roundChange = new RoundSwitch(score, haungsMode, smugCount.getValue(), policeCount.getValue(), times.get(0), times.get(times.size()-1), round1Minutes, round1Seconds, mapNum);
            Greenfoot.setWorld(roundChange);
        }
        
        else if (round == 2)
        {
            round2Minutes = clock.returnMinutes();
            round2Seconds = clock.returnSeconds();
            
            GameOver roundEnd = new GameOver(score, smugScorePrev, policeCount.getValue(), policeScorePrev, smugCount.getValue(), times.get(0), times.get(times.size()-1), round1Minutes, round1Seconds, round2Minutes, round2Seconds);
            roundEnd.setPlayerHighScore(Integer.toString(smugScorePrev + policeCount.getValue()));
            roundEnd.setPlayerHighScore(Integer.toString(policeScorePrev + smugCount.getValue()));
            Greenfoot.setWorld(roundEnd);
        }
    }

    //Written by Addison
    public ArrayList<Entrance> getEntrances()
    {
        return entrances;
    }

    //Written by Addison
    public ArrayList<Exit> getExits()
    {
        return exits;
    }

    //Written by Addison
    public ArrayList<MingleSpot> getMingleSpots()
    {
        return mingleSpots;
    }

    //Written by Addison
    public ArrayList<Building> getBuildings()
    {
        return buildings;
    }

    //Written by Addison
    public void randSpawnCivilians()
    {
        if (Greenfoot.getRandomNumber(10000) < 7)
        {
            Civilian c = new Civilian();

            int randSpawn = Greenfoot.getRandomNumber(4);
            int spawnX = getEntrances().get(randSpawn).getTargetX();
            int spawnY = getEntrances().get(randSpawn).getTargetY();

            addObject(c, spawnX, spawnY);

            int randMingle = Greenfoot.getRandomNumber(4);
            int mingleX = getMingleSpots().get(randMingle).getTargetX() + (Greenfoot.getRandomNumber(125) - 75);
            int mingleY = getMingleSpots().get(randMingle).getTargetY() + (Greenfoot.getRandomNumber(125) - 75);

            c.setTarget(mingleX, mingleY);
        }
    }
    
    //Written by Riley
    public void spawnPowerUps()
    {
        calc();
        add();
        cluster();
        remove();
        xtraPoints();
    }
    
    //Written by Riley
    private void calc()
    {
        if (!timer)
        {
            min = Greenfoot.getRandomNumber(3);
            min1 = Greenfoot.getRandomNumber(30)+30;
            min2 = Greenfoot.getRandomNumber(5);
            min3 = Greenfoot.getRandomNumber(30);
            min4 = Greenfoot.getRandomNumber(3);
            min5 = Greenfoot.getRandomNumber(30);
            min6 = Greenfoot.getRandomNumber(5);
            min7 = Greenfoot.getRandomNumber(30)+30;
            min8 = Greenfoot.getRandomNumber(3);
            min9 = Greenfoot.getRandomNumber(30)+30;
            min10 = Greenfoot.getRandomNumber(5);
            min11 = Greenfoot.getRandomNumber(30);
            min12 = Greenfoot.getRandomNumber(3);
            min13 = Greenfoot.getRandomNumber(30);
            min14 = Greenfoot.getRandomNumber(5);
            min15 = Greenfoot.getRandomNumber(30)+30;
            min16 = Greenfoot.getRandomNumber(3);
            min17 = Greenfoot.getRandomNumber(30) + 30;
            min18 = Greenfoot.getRandomNumber(5);
            min19 = Greenfoot.getRandomNumber(30);
        }
        
    }
    
    //Written by Riley
    public void cluster()
    {
        if (!hasSpawned3)
        {
            if (clock.returnMinutes() == min4 && clock.returnSeconds() == min5)
            {
                Cluster cluster = new Cluster();
                addObject (cluster, 1360,Greenfoot.getRandomNumber(getHeight() -40)+20); 
                hasSpawned3 = true;
            }
        }
        
        if (!hasSpawned4)
        {
            if (clock.returnMinutes() == min6 && clock.returnSeconds() == min7)
            {
                Cluster cluster = new Cluster();
                addObject (cluster, 1360,Greenfoot.getRandomNumber(getHeight() -40)+20); 
                hasSpawned4 = true;
            }
        }
    }
    
    //Written By Riley
    public void remove()
    {
        if (!hasSpawned5)
        {
            if (clock.returnMinutes() == min8 && clock.returnSeconds() == min9)
            {
                Remove remove = new Remove();
                addObject (remove, 2,Greenfoot.getRandomNumber(getHeight() -20)+10); 

                hasSpawned5 = true;
            }
        }
        
        if (!hasSpawned6)
        {
            if (clock.returnMinutes() == min10 && clock.returnSeconds() == min11)
            {
                Remove remove = new Remove();
                addObject (remove, 2,Greenfoot.getRandomNumber(getHeight() -20)+10); 

                hasSpawned6 = true;
            }
        }
    }
    
    //Written By Riley
    public void add()
    {
        if (!hasSpawned7)
        {
            if (clock.returnMinutes() == min12 && clock.returnSeconds() == min13)
            {
                Add a = new Add();
                addObject (a, Greenfoot.getRandomNumber(getWidth()-400)+200, Greenfoot.getRandomNumber(getHeight()-200)+100 ); 
                hasSpawned7 = true;
            }
        }
        else if (!hasSpawned8)
        {
            if (clock.returnMinutes() == min14 && clock.returnSeconds() == min15)
            {
                Add a = new Add();
                addObject (a, 650, 300); 
                hasSpawned8 = true;
            }
        }
    }
    
    //Written by Dylan and Riley
    public void xtraPoints()
    {
        if (!hasSpawned9)
        {
            if (clock.returnMinutes() == min16 && clock.returnSeconds() == min17)
            {
                xtraPoints x = new xtraPoints();
                addObject (x, Greenfoot.getRandomNumber(getWidth() - 20) + 10,getHeight() - 2); 

                hasSpawned9 = true;
            }
        }
        
        if (!hasSpawned10)
        {
            if (clock.returnMinutes() == min18 && clock.returnSeconds() == min19)
            {
                xtraPoints x = new xtraPoints();
                addObject (x, Greenfoot.getRandomNumber(getWidth() - 20) + 10,getHeight() - 2); 

                hasSpawned10 = true;
            }
        }
    }
    
    //Written by Dylan
    public int returnRound()
    {
        return round;
    }
    
    //Written by Connor
    public Sniper getSniper()
    {
        return sniper;
    }
    
    //Written by Addison
    public int getNumBuildings()
    {
        return numBuildings;
    }
    
    //Written by Addison
    public boolean getSimpleChecking()
    {
        return simpleChecking;
    }
}