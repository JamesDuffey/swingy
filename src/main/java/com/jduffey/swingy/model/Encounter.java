package swingy.model;

import java.io.*;
import java.util.*;
import swingy.model.heroes.Hero;
import swingy.model.villains.Villain;
import swingy.controller.Controller;
import swingy.view.View;
import swingy.view.ConView;

public class Encounter{
    String input;
    ConView conView = new ConView();
    public boolean encounter(Villain villain, Hero hero, Scanner scanner){
        hero.saveHP();
        while (true){
            if (villain.getVilHP() <= 0){
                conView.defeat(villain.getVilName());
                
                break;
            }
            else if (hero.getHP() <= 0){
                conView.death();
                break; //reset xp for the level, reset hero position
            }
            else{
                conView.hitVil();
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("hit")){
                    villain.attackVil(hero.getAtk());
                        hero.attackHero(villain.getVilAtk(hero.getLevel()));
                    conView.printHP(villain.getVilHP(), hero.getHP());
                    if (villain.getVilHP() <= 0){
                        conView.defeat(villain.getVilName());
                        hero.setHP();
                        return hero.setXP(villain.getVilExp());
                        //break;
                    }
                }
            }
        }
        return false;
    }

    public int encounterGui(Villain villain, Hero hero){
        if (villain.getVilHP() <= 0){
            if (hero.setXP(villain.getVilExp())){
                Controller controller = new Controller();
                    controller.genMap(hero);
            }
            return 0;
        }
        else if (hero.getHP() <= 0){
            return 1;
            //reset xp for the level, reset hero position
        }
        else{
            villain.attackVil(hero.getAtk());
            hero.attackHero(villain.getVilAtk(hero.getLevel()));
            if (villain.getVilHP() <= 0){
                if (hero.setXP(villain.getVilExp())){
                    Controller controller = new Controller();
                    controller.genMap(hero);
                    return 3;
                }
                return 0;
            }
            
            return 2;
        }
    }

    public String handleEnc(int x, Villain villain, Hero hero, View view){
        if (x == 0){
            hero.setHP();
            Controller controller = new Controller();
            controller.genMap(hero);
            return ("You have defeated the " + villain.getVilName());
        }
        else if (x == 1){
            return ("You have died!");
        }
        else if (x == 3){
            hero.setHP();
            Controller controller = new Controller();
            controller.genMap(hero);
            return null;
            //return ("You have defeated the " + villain.getVilName() + "\n" + hero.heroLeveled());
        }
        return ("Enemy HP: " + villain.getVilHP() + " Your HP: " + hero.getHP());
    }
}