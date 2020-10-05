package swingy.model.villains;

import java.lang.Math;

public class Villain {
    protected static String name;
    protected static int hitPoints;
    protected static int attack;
    protected static double defense;
    protected static int exp;

    public Villain(String name, int hitPoints, int attack, double defense, int exp){
        this.name = name;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.defense = defense;
        this.exp = exp;
    }

    public String getVilName(){
        return this.name;
    }

    public int getVilAtk(int level) {
        if (level == 1){
            return this.attack;
        }
        return (int) Math.round(this.attack * (level * 0.05));
    }

    public int getVilDef(double dmg) {
        return (int) Math.round(dmg * this.defense);
    }

    public int getVilExp() {
        return this.exp;
    }

    public int getVilHP(){
        return this.hitPoints;
    }

    public void attackVil(int dmg){
        this.hitPoints -= dmg;//(int) Math.round(dmg * this.defense);
    }
}