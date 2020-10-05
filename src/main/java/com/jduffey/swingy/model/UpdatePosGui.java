package swingy.model;

import java.util.*;
import swingy.model.heroes.Hero;
import swingy.model.Map;
import swingy.model.SaveHero;

public class UpdatePosGui{
    public String updatePosGui(String input, Hero hero, Map map){
        if (input.equalsIgnoreCase("right")){
            if (hero.getX() != map.getMapX()){
                hero.setX(hero.getX() + 1);
            }
            else{
                return ("You're at the end of the map\nyou can't go right");
            }
        }
        else if (input.equalsIgnoreCase("left")){
            if (hero.getX() != 0){
                hero.setX(hero.getX() - 1);
            }
            else{
                return ("You're at the end of the map\nyou can't go left");
            }
        }
        else if (input.equalsIgnoreCase("up")){
            if (hero.getY() != 0){
                hero.setY(hero.getY() - 1);
            }
            else{
                return ("You're at the end of the map\nyou can't go up");
            }
        }
        else if (input.equalsIgnoreCase("down")){
            if (hero.getY() != map.getMapY()){
                hero.setY(hero.getY() + 1);
            }
            else{
                return ("You're at the end of the map\nyou can't go down");
            }
        }
        return ("Player Position - x: " + hero.getX() + " y: " + hero.getY() + "\n");
    }
}