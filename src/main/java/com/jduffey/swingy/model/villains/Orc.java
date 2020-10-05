package swingy.model.villains;

public class Orc extends Villain {
    public Orc(int level) {
        super("Orc", (50 + (level *2)), (8+level), 0.95, (100 * level));
    }
}