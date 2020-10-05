package swingy.controller;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import swingy.model.heroes.Hero;
import swingy.model.LoadHero;
import swingy.model.HeroFactory;
import swingy.model.Map;
import swingy.view.View;
import swingy.model.NewHero;
import swingy.model.SaveHero;
import swingy.model.villains.Villain;
import swingy.model.GetVillain;
import swingy.model.Encounter;
import swingy.model.UpdatePos;
import swingy.model.UpdatePosGui;
import swingy.view.ConView;
import swingy.model.Roll;
import swingy.model.LoadHero;

public class Controller {
    public int xInterface;
    public Hero hero;
    private View view;
    Random random = new Random();
    Roll r = new Roll();
    UpdatePos updatePos = new UpdatePos();
    UpdatePosGui upg = new UpdatePosGui();
    GetVillain gv = new GetVillain();
    ConView conView = new ConView();
    Villain villain = null;
    Encounter enc = new Encounter();;
    public Map map;
    String info;
    String playerPos;
    public static ArrayList<Hero> heroes = new ArrayList<>();
    
    private int e;
    private Boolean encounter[] = {true, false, true, false};

    public void getInterface(String mode) {
        if (mode.equalsIgnoreCase("console")){
            xInterface = 0;
            menu();
        }
        else if (mode.equalsIgnoreCase("gui")){
            xInterface = 1;
            this.view = new View();
        }
    }

    public void menu(){
        try {
            Scanner scanner = new Scanner(System.in);
            conView.start();
            String input = scanner.nextLine();
 
            if (input.equalsIgnoreCase("new")){
                NewHero newHero = new NewHero();
                hero = newHero.newHero(scanner);
                SaveHero savehero = new SaveHero();
                savehero.saveHero(hero, 0, 0);
            }
            else if (input.equalsIgnoreCase("load")){
                LoadHero lh = new LoadHero();
                int loaded = lh.loadHero();
                heroes = lh.getSavedHeroes();
                if (heroes == null){
                    conView.loadFailed();
                    NewHero newHero = new NewHero();
                    hero = newHero.newHero(scanner);
                    SaveHero savehero = new SaveHero();
                    savehero.saveHero(hero, 0, 0);
                }
                conView.awaitNum();
                while (hero == null){
                    input = scanner.nextLine();
                    hero = lh.getHero(Integer.parseInt(input));
                }
                conView.selectedHero(hero);
            }
            Map map = new Map(hero.getLevel());
            conView.mapSize(map.getMapX(), map.getMapY());
            conView.playerPos(hero.getX(), hero.getY());
            conView.options();
            while (true){
                input = scanner.nextLine();
                if (updatePos.updatePos(input, hero, map)){
                        e = random.nextInt(5);
                        if (e == 1){
                            Villain villain = gv.getVillain(hero.getLevel());
                            conView.encounter(villain.getVilName());
                            while (true){
                                input = scanner.nextLine();
                                if (input.equalsIgnoreCase("run")){
                                    e = random.nextInt(2);
                                    if (e == 1){
                                        conView.escapeFailed(villain.getVilName(), villain.getVilAtk(hero.getLevel()), hero.getHP());
                                        // enc = new Encounter();
                                        if (enc.encounter(villain, hero, scanner)){
                                            hero.heroLeveled();
                                            map = new Map(hero.getLevel());
                                            conView.newMap(map);
                                        }
                                        break;
                                    }
                                    else{
                                        conView.escaped();
                                        break ;
                                    }
                                }
                                else if (input.equalsIgnoreCase("fight")){
                                    conView.fight();
                                    Encounter enc = new Encounter();
                                    if (enc.encounter(villain, hero, scanner)){
                                        map = new Map(hero.getLevel());
                                        conView.newMap(map);
                                    }
                                    break ;
                                }
                            }
                        }
                        conView.playerPos(hero.getX(), hero.getY());
                    }
                } 
        }
        catch (Exception e){
            System.out.println("Something went wrong.");
        }
    }

    public static void guiController(){
        
    }

    public String selectedHeroGui(String name){
        //load hero
        //

        if (name == null)
            name = hero.getName();
        if ((!name.equals("Select Hero"))){
            LoadHero loadhero = new LoadHero();
            hero = loadhero.getHeroGui(name);
            String selected = hero.guiStats();
            //area.setText(selected);
            hero.saveHP();
            map = new Map(hero.getLevel());
            return selected;
          }
            return "";
    }

    public String getPlayerPos(){
        return "Player Position - x:" + hero.getX() + " y:" + hero.getY() + "\n";
    }

    public Boolean newHeroGui(String name, String hclass){
        NewHero newHero = new NewHero();
        hero = newHero.newHeroGui(name, hclass);
        if (hero == null){
            return true;
        }
        SaveHero savehero = new SaveHero();
        savehero.saveHero(hero, 0, 0);
        hero.saveHP();
        map = new Map(hero.getLevel());
        return false;
    }

    public String moveGui(String direction){
        info = "";
        genMap(hero);
        playerPos = upg.updatePosGui(direction, hero, map);
        info += playerPos;
        if (r.roll(5,1) && info.length() == 28){
            //hide movement buttons
            villain = gv.getVillain(hero.getLevel());
            info += "You have encountered a " + villain.getVilName() + "\nFight or run?";
        }
        return info;
    }

    public Hero updateHero(){
        return hero;
    }

    public boolean checkVilHP(){
        if (villain != null){
            if (villain.getVilHP() > 0)
                return true;
        }
        return false;
    }

    public String updateStats(){
        return hero.guiStats();
    }

    public boolean checkVilDead(){
        if (villain != null){
            if (villain.getVilHP() <= 0)
                return true;
        }
        return false;
    }

    public String fightVil(){
        int p = 0;
        if (villain != null && hero != null){
            p = enc.encounterGui(villain, hero);
        }
        //map = map1;
        return enc.handleEnc(p, villain, hero, view);
    }

    public void saveExit(){
        SaveHero savehero = new SaveHero();
        savehero.saveHero(hero, hero.getX(), hero.getY());
        System.exit(0);
    }

    public String run(){
        info = "";
        if (r.roll(2,1)){
            villain = null;
            return info = "you have successfully escaped!";
        }
        return info = null;
    }

    public void genMap(Hero hero){
        map = new Map(hero.getLevel());
        //update map in stats view
    }
}