package swingy.model.heroes;

public class Warrior extends Hero {
    public Warrior(String name, String heroClass, int level, int x, int y){
        super(name, heroClass, level, x, y);
        this.hitPoints = 50;
        this.exp = 0;
    }
}