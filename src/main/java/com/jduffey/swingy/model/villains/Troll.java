package swingy.model.villains;

public class Troll extends Villain {
    public Troll (int level) {
        super("Troll", (40 + (level *2)), (10+level), 0.92, (100 * level));
    }
}