package swingy.model.villains;

public class Elf extends Villain {
    public Elf(int level) {
        super("Elf", (30 + (level *2)), (15+level), 0.90, (100 * level));
    }
}