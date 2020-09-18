package swingy.model.artifacts;

public class Artifact {
    private String name;
    protected int attack;
    protected int defense;
    protected int hitPoints;

    public Artifact() {
        this.name = name;
    }

    public String getArtifactName(){
        return this.name;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }
}