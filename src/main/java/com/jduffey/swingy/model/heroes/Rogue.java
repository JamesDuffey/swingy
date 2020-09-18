package swingy.model.heroes;

public class Rogue extends Hero {
    public Rogue(String name, String heroClass, int level, int x, int y){
        super(name, heroClass, level, x, y);
        hitPoints = 50;
        exp = 0;
    }
}