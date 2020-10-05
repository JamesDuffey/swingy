package swingy.model;

import java.io.File;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import swingy.model.heroes.Hero;
import swingy.model.HeroFactory;
import swingy.view.ConView;

public class LoadHero{
    public Hero hero;
    public ArrayList<Hero> heroes = new ArrayList<>();
    Conview conView = new ConView();

    public int loadHero(){
            File heroSave = new File("../heroSave.txt");
        try {
            Scanner myReader = new Scanner(heroSave);
            if (!myReader.hasNextLine())
                return 0;
            //Hero heroesTmp[] = new Hero[6];
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split(" ");
                HeroFactory hf = new HeroFactory();
                heroes.add(hf.newHero(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), 0, 0));
            }
            int i = 0;
            for (Hero x:heroes){
                System.out.println(i + ") " + x.toString());
                i++;
            }
        }
        catch (Exception e) {
            conView.errorLoading();
            try {
                heroSave.createNewFile();
            }
            catch (Exception ex) {
                conView.errorCreatingSave();
            }
            return (0);
        }
        return 1;
    }

    public ArrayList<Hero> getSavedHeroes(){
            File heroSave = new File("../heroSave.txt");
        try {
            Scanner myReader = new Scanner(heroSave);
            if (!myReader.hasNextLine())
                return null;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split(" ");
                HeroFactory hf = new HeroFactory();
                heroes.add(hf.newHero(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5])));
            }
            return heroes;
        }
        catch (Exception e) {
            conView.errorLoading();
        }
        return null;
    }

    public Hero getHero(int find){
        try {
            File scenario = new File("../heroSave.txt");
            Scanner myReader = new Scanner(scenario);
            int i = 0;
            hero = null;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (i == find){
                    String[] arr = data.split(" ");
                    HeroFactory hf = new HeroFactory();
                    hero = hf.newHero(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                }
                i++;
            }
            if (hero == null){
                return null;
            }
        }
        catch (Exception e) {
            conView.errorLoading();
        }
        return hero;
    }

    public Hero getHeroGui(String find){
        try {
            File scenario = new File("../heroSave.txt");
            Scanner myReader = new Scanner(scenario);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split(" ");
                HeroFactory hf = new HeroFactory();
                hero = hf.newHero(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                if (arr[0].equals(find)){
                    return hero;
                }
            }
        }
        catch (Exception e) {
            conView.errorLoading();
        }
        return null;
    }

    public String[] getSaved(){
        try {     
            File scenario = new File("../heroSave.txt");
            Scanner myReader = new Scanner(scenario);
            ArrayList<String> heroesx = new ArrayList<String>();
            heroesx.add("Select Hero");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split(" ");
                HeroFactory hf = new HeroFactory();
                hero = hf.newHero(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                heroesx.add(hero.getName());
            }
            String heroes[] = new String[heroesx.size()];
            heroesx.toArray(heroes);
            return heroes;
        }
        catch (Exception e) {
            conView.errorLoading();
        }
        return null;
    }
}