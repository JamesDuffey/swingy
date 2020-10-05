package swingy.model;

import java.io.*;
import java.util.*;
import swingy.model.villains.Villain;
import swingy.model.villains.Elf;
import swingy.model.villains.Orc;
import swingy.model.villains.Troll;

public class GetVillain{
    private int e;
    Random random = new Random();

    public Villain getVillain(int level){
        e = random.nextInt(3);
        if (e == 0){
            return new Elf(level);
        }
        else if (e == 1){
            return new Orc(level);
        }
        else{
            return new Troll(level);
        }
    }
}