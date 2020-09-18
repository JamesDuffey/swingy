package swingy.model;

public class Map {
    public int x;
    public int y;

    public Map(int level){
        this.x = (level-1)*5+10-(level%2);
        this.y = (level-1)*5+10-(level%2);
    }

    public int getMapX(){
        return this.x;
    }
    public int getMapY(){
        return this.y;
    }
}