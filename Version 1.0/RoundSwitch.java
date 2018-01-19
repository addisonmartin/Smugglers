import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;

public class RoundSwitch extends World
{
    //Written by Dylan
    private int smugScoreRound1;
    private int policeScoreRound1;
    
    private int round1Minutes;
    private int round1Seconds;
    
    private ScoreBoardOrganizer score;
    
    private int which;
    private String phrase;
    
    private int runCount = 0;
    private int copCount = 0;
    private int xCount = 0;
    private int innocentCount = 0;
    
    //Written by Addison
    private boolean haungsMode;
    private int mapNum;
    
    //Written by Dylan
    public RoundSwitch(ScoreBoardOrganizer s, boolean nHaungsMode, int p1Score1, int p2Score1, long shortDropoffTime, long longDropoffTime, int minutesRound1, int secondsRound1, int nMapNum)
    {    
        super(1366, 768, 1); 
        
        smugScoreRound1 = p1Score1;
        policeScoreRound1 = p2Score1;
        round1Minutes = minutesRound1;
        round1Seconds = secondsRound1;
        haungsMode = nHaungsMode;
        float round1ShortRun = (float)shortDropoffTime/1000;
        float round1LongRun = (float)longDropoffTime/1000;
        mapNum = nMapNum;
        score = s;
        
        addObject(new Text("Round 1: $" + p1Score1 + ".00", 40, Color.WHITE, 0), getWidth() / 4, 100);
        
        for (int i = 0; i < score.p1Scores1.size(); i++)
        {
            if (score.p1Scores1.get(i).getPhrase().equals("Successful Dropoff: $95.00"))
            {
                runCount++;
            }
        }
        
        score.p1Scores1.clear();
        
        if (runCount > 0)
        {
            score.addData(1, runCount + " successful dropoff(s): $" + (runCount * 100) + ".00", 1);
        }
        
        if (p1Score1 > 0)
        {
            score.addData(1, "Shortest run: " + round1ShortRun + " seconds", 1);
            if (round1ShortRun != round1LongRun)
            {
                score.addData(1, "Longest run: " + round1LongRun + " seconds", 1);
            }
        }
        
        for (int i = 0; i < score.p1Scores1.size(); i++)
        {
            addObject(score.p1Scores1.get(i), getWidth() / 4, 140 + (20 * i));
        }
        
        addObject(new Text("Round 1: $" + p2Score1 + ".00", 40, Color.WHITE, 0), 3 * (getWidth() / 4), 100);
        
        ScoreBoardItem sbi;
        
        if (score.p2Scores1.size() == 0)
        {
            sbi = null;
        }
        
        else
        {
            sbi = score.p2Scores1.get(score.p2Scores1.size() - 1);
        }
            
        for (int i = 0; i < score.p2Scores1.size(); i++)
        {
            if (score.p2Scores1.get(i).getPhrase().equals("Innocent killed: -$100.00"))
            {
                innocentCount++;
            }
            
            else if (score.p2Scores1.get(i).getPhrase().equals("Cop Killed: -$250.00"))
            {
                copCount++;
            }
            
            else if (score.p2Scores1.get(i).getPhrase().equals("Xtra Points: $100.00"))
            {
                xCount++;
            }
        }
        
        score.p2Scores1.clear();
        
        if (innocentCount > 0)
        {
            score.addData(2, innocentCount + " innocent(s) killed: -$" + (innocentCount * 100) + ".00", 1);
        }
        
        if (copCount > 0)
        {
            score.addData(2, copCount + " cop(s) killed: -$" + (copCount * 250) + ".00", 1);
        }
        
        if (xCount > 0)
        {
            score.addData(2, xCount + " extra points powerup(s) shot: $" + (xCount * 100) + ".00", 1);
        }
        
        if (sbi != null)
        {
            score.addData(2, sbi.getPhrase(), 1);
        }
        
        for (int i = 0; i < score.p2Scores1.size(); i++)
        {
            addObject(score.p2Scores1.get(i), 3 * (getWidth() / 4), 140 + (30 * i));
        }
        
        advice();
    }
    
    //Written by Dylan
    private void advice()
    {
        which = Greenfoot.getRandomNumber(11);
        
        if (which == 0) phrase = "Hint: try not to lose.";
        else if (which == 1) phrase = "Smuggler: do not die.";
        else if (which == 2) phrase = "Hint: don't drink the alcohol.";
        else if (which == 3) phrase = "Hint: Lay a hand on me, sonny Jim, and I'll give it to ya good, understand?";
        else if (which == 4) phrase = "Sniper: don't miss.";
        else if (which == 5) phrase = "Hint: methanol may be a industrial chemical, but it can also get you drunk!";
        else if (which == 6) phrase = "Hint: side effects of methanol poisoning include difficulty breathing, blindness, seizures, jaundice, and death."; //https://www.nlm.nih.gov/medlineplus/ency/article/002680.htm
        else if (which == 7) phrase = "Hint: don't forget to call your drinking buddies after a night out to make sure they're still alive.";
        else if (which == 8) phrase = "Hint: golly, those moving pictues sure are the bees knees!";
        else if (which == 9) phrase = "Hint: read all text in a Trans-Atlantic accent for greater immersion.";
        else if (which == 10) phrase = "Smuggler: if you die to the Sniper, all funds go to the cost of your funeral. If you die to alcohol poisoning, all funds go to the person closest to your body.";
        
        addObject(new Text(phrase, 20, Color.WHITE, 0), getWidth() / 2, 30);
    }
    
    //Written by Addison
    public void act()
    {
        if ( Greenfoot.mouseClicked(this) )
        {
            if (mapNum ==1)
            {
                Map1 world = new Map1(score, haungsMode, 2, smugScoreRound1, policeScoreRound1, round1Minutes, round1Seconds);
                Greenfoot.setWorld(world);
            }
            
            else if (mapNum == 2)
            {
                Map2 world = new Map2(score, haungsMode, 2, smugScoreRound1, policeScoreRound1, round1Minutes, round1Seconds);
                Greenfoot.setWorld(world);
            }
            
            else if (mapNum == 3)
            {
                Map3 world = new Map3(score, haungsMode, 2, smugScoreRound1, policeScoreRound1, round1Minutes, round1Seconds);
                Greenfoot.setWorld(world);
            }
            
            else
            {
                Map4 world = new Map4(score, haungsMode, 2, smugScoreRound1, policeScoreRound1, round1Minutes, round1Seconds);
                Greenfoot.setWorld(world);
            }
        }
    }
}
