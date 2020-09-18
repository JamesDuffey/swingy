package swingy.model.heroes;

public class Hunter extends Hero {
    public Hunter(String name, String heroClass, int level, int x, int y){
        super(name, heroClass, level, x, y);
        hitPoints = 50;
        exp = 0;
    }
}