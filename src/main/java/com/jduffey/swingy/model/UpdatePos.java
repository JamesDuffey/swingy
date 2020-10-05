package swingy.model;

import java.util.*;
import swingy.model.heroes.Hero;
import swingy.model.Map;
import swingy.model.SaveHero;
import swingy.view.ConView;

public class UpdatePos{
    ConView conView = new ConView();
    public Boolean updatePos(String input, Hero hero, Map map){
        if (input.equalsIgnoreCase("right") || input.equalsIgnoreCase("r")){
            if (hero.getX() != map.getMapX()){
                hero.setX(hero.getX() + 1);
            return (true);
            }
            else{
                conView.endOfMap("right");
            }
        }
        else if (input.equalsIgnoreCase("left") || input.equalsIgnoreCase("l")){
            if (hero.getX() != 0){
                hero.setX(hero.getX() - 1);
            return (true);
            }
            else{
                conView.endOfMap("left");
            }
        }
        else if (input.equalsIgnoreCase("up") || input.equalsIgnoreCase("u")){
            if (hero.getY() != 0){
                hero.setY(hero.getY() - 1);
            return (true);
            }
            else{
                conView.endOfMap("up");
            }
        }
        else if (input.equalsIgnoreCase("down") || input.equalsIgnoreCase("d")){
            if (hero.getY() != map.getMapY()){
                hero.setY(hero.getY() + 1);
            return (true);
            }
            else{
                conView.endOfMap("down");
            }
        }
        else if (input.equalsIgnoreCase("exit")){
            SaveHero savehero = new SaveHero();
            savehero.saveHero(hero, hero.getX(), hero.getY());
            conView.heroSaved();
            System.exit(0);
        }
        else {
            System.out.println(input + " is not a valid command");
        }
        return (false);
    }
}