package swingy.model;

import java.io.*;
import java.util.*;
import java.io.IOException;
import swingy.model.heroes.Hero;
import swingy.view.ConView;

public class SaveHero{
    public static ArrayList<Hero> heroes = new ArrayList<>();
    ConView conView = new ConView();

    public void saveHero(Hero hero, int x, int y) {
        try{
            if (checkExists(hero.getName())){
                FileWriter heroSave = new FileWriter("../heroSave.txt");
                File file = new File("../heroSave.txt");
                int i = 0;
                for (Hero h : heroes){
                    if (h.getName().equalsIgnoreCase(hero.getName())){
                        heroSave.write(hero.getName() + " " + hero.getHeroClass() + " " + hero.getLevel() + " " + hero.getExp() + " " + hero.getX() + " " + hero.getY());
                    }
                    else{
                        heroSave.write(h.getName() + " " + h.getHeroClass() + " " + h.getLevel() + " " + h.getExp() + " " + h.getX() + " " + h.getY());
                    }
                    if (i < (heroes.size() - 1)){
                        heroSave.write("\n");
                    }
                    i++;
                }
                heroSave.close();
            }
            else{
                FileWriter heroSave = new FileWriter("../heroSave.txt", true);
                File file = new File("../heroSave.txt");
                if (file.length() != 0){
                    heroSave.write("\n");
                }
                heroSave.write(hero.getName() + " " + hero.getHeroClass() + " " + hero.getLevel() + " " + hero.getExp() + " " + hero.getX() + " " + hero.getY());
                heroSave.close();
            }
        }
        catch (IOException e) {
            conView.errorOc();
            e.printStackTrace();
        }
    }

    public boolean checkExists(String name){
        LoadHero loadhero = new LoadHero();
        heroes = loadhero.getSavedHeroes();
        if (heroes == null)
            return false;
        for (Hero x : heroes){
            if (x.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
}