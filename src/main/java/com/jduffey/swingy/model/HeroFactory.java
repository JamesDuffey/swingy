package swingy.model;

import java.io.*;
import swingy.model.heroes.Hero;
import swingy.model.heroes.Hunter;
import swingy.model.heroes.Rogue;
import swingy.model.heroes.Warrior;

public class HeroFactory {
    public static Hero newHero(String name, String heroClass, int level, int x, int y){
        switch (heroClass.toLowerCase()){
            case "warrior":
                return new Warrior(name, heroClass, level, x, y);
            case "hunter":
                return new Hunter(name, heroClass, level, x, y);
            case "rogue":
                return new Rogue(name, heroClass, level, x, y);
            }
            return null;
    }
}