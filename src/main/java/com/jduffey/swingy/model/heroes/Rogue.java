package swingy.model.heroes;

public class Rogue extends Hero {
    public Rogue(String name, String heroClass, int level, int exp, int x, int y){
        super(name, heroClass, level, exp, x, y);
        this.hitPoints = 80;
        this.attack = 20;
    }
}