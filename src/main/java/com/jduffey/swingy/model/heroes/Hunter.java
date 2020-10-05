package swingy.model.heroes;

public class Hunter extends Hero {
    public Hunter(String name, String heroClass, int level, int exp, int x, int y){
        super(name, heroClass, level, exp, x, y);
        this.hitPoints = 80;
        this.attack = 15;
    }
}