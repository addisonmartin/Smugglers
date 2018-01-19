import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;
import java.nio.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class GameOver extends World
{
    //Written by Dyaln
    private int p1Score;
    private int p2Score;
    
    private int which;
    private String phrase;
    
    private int runCount = 0;
    private int copCount = 0;
    private int xCount = 0;
    private int innocentCount = 0;
    
    //Written by Dylan
    public GameOver(ScoreBoardOrganizer score, int p1Score1, int p1Score2, int p2Score1, int p2Score2, long round2ShortDropoff, long round2LongDropoff, int round1Minutes, int round1Seconds, int round2Minutes, int round2Seconds)
    {    
        super(1366, 768, 1); 
        
        p1Score = p1Score1 + p1Score2;
        p2Score = p2Score1 + p2Score2;
        
        float round2ShortRun = (float)(round2ShortDropoff/1000);
        float round2LongRun = (float)(round2LongDropoff/1000);
        
        addObject(new Text("Round 1: $" + p1Score1 + ".00", 40, Color.WHITE, 0), getWidth() / 4, 100);
        
        for (int i = 0; i < score.p1Scores1.size(); i++)
        {
            addObject(score.p1Scores1.get(i), getWidth() / 4, 140 + (30 * i));
        }
        
        addObject(new Text("Round 2: $" + p1Score2 + ".00", 40, Color.WHITE, 0), getWidth() / 4, 180 + (30 * score.p1Scores1.size()));
        
        ScoreBoardItem sbi;
        
        if (score.p1Scores2.size() == 0)
        {
            sbi = null;
        }
        
        else
        {
            sbi = score.p1Scores2.get(score.p1Scores2.size() - 1);
        }
        
        for (int i = 0; i < score.p1Scores2.size(); i++)
        {
            if (score.p1Scores2.get(i).getPhrase().equals("Innocent killed: -$100.00"))
            {
                innocentCount++;
            }
        }
        
        score.p1Scores2.clear();
        
        if (innocentCount > 0)
        {
            score.addData(1, innocentCount + " innocent(s) killed: -$" + (innocentCount * 100) + ".00", 2);
        }
        
        if (copCount > 0)
        {
            score.addData(1, copCount + " cop(s) killed: -$" + (copCount * 250) + ".00", 2);
        }
        
        if (xCount > 0)
        {
            score.addData(1, xCount + " extra points powerup(s) shot: $" + (xCount * 100) + ".00", 2);
        }
        
        if (sbi != null)
        {
            score.addData(1, sbi.getPhrase(), 2);
        }
        
        for (int i = 0; i < score.p1Scores2.size(); i++)
        {
            addObject(score.p1Scores2.get(i), getWidth() / 4, 220 + (30 * i) + (30 * score.p1Scores1.size()));
        }
       
        addObject(new Text("Total: $" + p1Score + ".00", 40, Color.WHITE, 0), getWidth() / 4, 270 + 30 * (score.p1Scores1.size() + score.p1Scores2.size()));
        
        addObject(new Text("Round 1: $" + p2Score1 + ".00", 40, Color.WHITE, 0), 3 * (getWidth() / 4), 100);
        
        for (int i = 0; i < score.p2Scores1.size(); i++)
        {
            addObject(score.p2Scores1.get(i), 3 * (getWidth() / 4), 140 + (30 * i));
        }
        
        addObject(new Text("Round 2: $" + p2Score2 + ".00", 40, Color.WHITE, 0), 3 * (getWidth() / 4), 180 + (30 * score.p2Scores1.size()));
        
        for (int i = 0; i < score.p2Scores2.size(); i++)
        {
            if (score.p2Scores2.get(i).getPhrase().equals("Successful Dropoff: $95.00"))
            {
                runCount++;
            }
            
            else if (score.p2Scores2.get(i).getPhrase().equals("Cop Killed: -$250.00"))
            {
                copCount++;
               
            }
            else if (score.p2Scores2.get(i).getPhrase().equals("Xtra Points: $100.00"))
            {
                xCount++;
            }
        }
        
        score.p2Scores2.clear();
        
        if (runCount > 0)
        {
            score.addData(2, runCount + " successful dropoff(s): $" + (runCount * 100) + ".00", 2);
        }
        
        if (p2Score2 > 0)
        {
            score.addData(2, "Shortest run: " + round2ShortRun + " seconds", 2);
            if (round2ShortRun != round2LongRun)
            {
                score.addData(2, "Longest run: " + round2LongRun + " seconds", 2);
            }
        }
        
        for (int i = 0; i < score.p2Scores2.size(); i++)
        {
            addObject(score.p2Scores2.get(i), 3 * (getWidth() / 4), 220 + 30 * (i + score.p2Scores1.size()));
        }
        
        addObject(new Text("Total: $" + p2Score + ".00", 40, Color.WHITE, 0), 3 * (getWidth() / 4), 270 + 30 * (score.p2Scores1.size() + score.p2Scores2.size()));
        
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
        else if (which == 4) phrase = "Sniper: do not miss.";
        else if (which == 5) phrase = "Hint: methanol may be a industrial chemical, but it can also get you drunk!";
        else if (which == 6) phrase = "Hint: side effects of methanol poisoning include difficulty breathing, blindness, seizures, jaundice, and death."; //https://www.nlm.nih.gov/medlineplus/ency/article/002680.htm
        else if (which == 7) phrase = "Hint: don't forget to call your drinking buddies after a night out to make sure they're still alive.";
        else if (which == 8) phrase = "Hint: golly, those moving pictues sure are the bees knees!";
        else if (which == 9) phrase = "Hint: read all text in a Trans-Atlantic accent for greater immersion.";
        else if (which == 10) phrase = "Smuggler: if you die to the Sniper, all funds go to the cost of your funeral. If you die to alcohol poisoning, all funds go to the person closest to your body.";
        
        addObject(new Text(phrase, 20, Color.WHITE, 0), getWidth() / 2, 30);
    }
    
    //Written by Rahul
    public void setPlayerHighScore(String s) 
    {
        Text highScoreMsg = new Text("High Score: $" + recordAndReturnHighScore(s) + ".00", 35, Color.WHITE, new Color(78, 78, 78));
        
        addObject(highScoreMsg, getWidth()/2, (getHeight()*7/8)+70);
    }
    
    //Written by Rahul
    private String recordAndReturnHighScore(String s)
    {
        String hs = null;
        try
        {
            Path scoreFile = Paths.get("./scoreFile.txt");
            
            if (Files.exists(scoreFile))
            {
                byte[] bytes = Files.readAllBytes(scoreFile);
                hs = new String(bytes);
                
                if (Integer.parseInt(s) > Integer.parseInt (hs))
                {
                    Files.write(scoreFile, s.getBytes());
                    hs = s;
                }
            }
            else
            {
                Files.write(scoreFile, s.getBytes());
                hs = s;
            }
            
        } catch (IOException e)
        {
            System.out.println("IOException");
        }
        
        return hs;
    }
    
    //Written by Addison
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}