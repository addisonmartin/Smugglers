import greenfoot.*;

public class MapSelect extends World
{
    //Written by Connor
    private Placeholder placeholder;
    
    //Written by Connor
    public MapSelect(boolean haungsMode)
    {    
        super(1366, 768, 1); 
        prepare(haungsMode);
    }

    //Written by Connor
    private void prepare(boolean haungsMode)
    {
        addObject(new Placeholder1(haungsMode), 369, 315);
        addObject(new Placeholder2(haungsMode), 369, 624);
        addObject(new Placeholder3(haungsMode), 957, 315);
        addObject(new Placeholder4(haungsMode), 957, 624);
    }
}
