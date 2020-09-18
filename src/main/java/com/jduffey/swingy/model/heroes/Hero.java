package swingy.model.heroes;

public class Hero {
    protected static String name;
    protected static String heroClass;
    protected static int level;
    protected static int exp;
    protected static int attack;
    protected static int defense;
    protected static int hitPoints;
    protected static int x;
    protected static int y;

    public Hero(String name, String heroClass, int level, int x, int y) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "Name: " + name + " Class: " + heroClass + " Lvl: " + level + " Exp: " + exp;
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
}