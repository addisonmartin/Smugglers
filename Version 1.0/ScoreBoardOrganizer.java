import greenfoot.*;
import java.awt.Color;
import java.util.ArrayList;

public class ScoreBoardOrganizer extends Objects
{
    //Written by Dylan
    public ArrayList<ScoreBoardItem> p1Scores1;
    public ArrayList<ScoreBoardItem> p1Scores2;
    public ArrayList<ScoreBoardItem> p2Scores1;
    public ArrayList<ScoreBoardItem> p2Scores2;
        
    private int which;
    private String phrase;
    private int round;
    
    private ScoreBoardItem s;

    public boolean hasElements;
    
    //Written by Dylan
    public ScoreBoardOrganizer()
    {
       p1Scores1 = new ArrayList();
       p1Scores2 = new ArrayList();
       p2Scores1 = new ArrayList();
       p2Scores2 = new ArrayList();
    }
    
    //Written by Dylan
    public void addData(int which, String phrase, int round)
    {
        s = new ScoreBoardItem(phrase);
        
        if (which == 1)
        {
            if (round == 1) p1Scores1.add(s);
            if (round == 2) p1Scores2.add(s);
        }
        else if (which == 2)
        {
            if (round == 1) p2Scores1.add(s);
            if (round == 2) p2Scores2.add(s);
        } 
    }
}
