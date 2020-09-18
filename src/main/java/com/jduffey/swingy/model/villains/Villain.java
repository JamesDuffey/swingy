package swingy.model.villains;

public class Villain {
    protected String name;
    protected int hitPoints;
    protected double attack;
    protected double defense;
    protected int exp;

    public String getVilName(){
        return this.name;
    }

    public double getVilAtk(double level) {
        if (level == 1){
            return this.attack;
        }
        else{
            return this.attack * (1 + (level * 0.05));
        }
    }

    public double getVilDef(double dmg) {
        return this.defense;
    }

    public int getVilExp() {
        return this.exp;
    }
}