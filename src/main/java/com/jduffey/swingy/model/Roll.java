package swingy.model;

import java.util.*;

public class Roll{
    private int e;
    Random random = new Random();
    public boolean roll(int range, int x){
        e = random.nextInt(range);
        if (e == x)
            return true;
        return false;
    }
}