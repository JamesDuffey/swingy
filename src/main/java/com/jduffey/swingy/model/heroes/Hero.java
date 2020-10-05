package swingy.model.heroes;

import javax.validation.constraints.*;


public class Hero {
    @NotNull(message = "Name cannot be null.")
    protected String name;
    @NotNull(message = "HeroClass cannot be null.")
    protected String heroClass;
    @NotNull(message = "Level cannot be null.")
    protected int level;
    protected int exp;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected int hp;
    protected int x;
    protected int y;

    public Hero(@NotNull String name, String heroClass, int level, int exp, int x, int y) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.exp = exp;
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "Name: " + this.name + " Class: " + this.heroClass + " Lvl: " + this.level + " Exp: " + this.exp;
      }

      public String toStringGui() {
        return "Name: " + name + "\nClass: " + heroClass + "\nLvl: " + level + "\nExp: " + exp;
      }

      public String guiStats(){
        return "Lvl:" + level + "\nExp:" + exp + "\nHP:" + hitPoints + "\nAtk:" + attack;
      }

      public String heroLeveled(){
          return "You have leveled up!\nLevel: " + level + "\nHitPoints: +5\nAttack: +2\nDefense: +2";
      }

      public int getLevel(){
          return this.level;
      }

      public int getX(){
          return this.x;
      }
      public int getY(){
          return this.y;
      }

      public void setX(int x){
          this.x = x;
      }

      public void setY(int y){
          this.y = y;
      }

      public String getName(){
          return this.name;
      }

      public String getHeroClass(){
          return this.heroClass;
      }

      public int getHP(){
          return this.hitPoints;
      }

      public int getAtk(){
          return this.attack;
      }

      public void attackHero(int dmg){
          this.hitPoints -= dmg;
      }

      public void saveHP(){
          this.hp = this.hitPoints;
      }

      public void setHP(){
          this.hitPoints = this.hp;
      }

      public int getExp(){
          return this.exp;
      }

      public boolean setXP(int exp){
          this.exp += exp;
          if (this.level == 1 && this.exp >= 1000){
              this.level = 2;
              this.attack += 2;
              this.defense += 2;
              this.hitPoints += 5;
              return true;
          }
          else if (this.level == 2 && this.exp >= 2450){
              this.level = 3;
              this.attack += 2;
              this.defense += 2;
              this.hitPoints += 5;
              return true;
          }
          else if (this.level == 3 && this.exp >= 4800){
              this.level = 4;
              this.attack += 2;
              this.defense += 2;
              this.hitPoints += 5;
              return true;
          }
          else if (this.level == 4 && this.exp >= 8050){
              this.level = 5;
              this.attack += 2;
              this.defense += 2;
              this.hitPoints += 5;
              return true;
          }
          return false;
      }
}