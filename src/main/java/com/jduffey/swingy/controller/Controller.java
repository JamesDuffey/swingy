package swingy.controller;

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import swingy.model.heroes.Hero;
import swingy.model.LoadHero;
import swingy.model.HeroFactory;
import swingy.model.Map;

public class Controller {
    public int xInterface;
    public Hero hero;

    public void getInterface(String mode) {
        if (mode.equalsIgnoreCase("console"))
            xInterface = 0;
        else if (mode.equalsIgnoreCase("gui"))
            xInterface = 1;
        menu();
    }

    public void menu(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type load to load a hero or new to create a new hero.");
            String input = scanner.nextLine();
 
            if (input.equalsIgnoreCase("new")){
                String name;
                String heroClass;
                System.out.println("Hero Name:");
                name = scanner.nextLine();
                System.out.println("Please select a class from the list:\nWarrior\nRogue\nHunter");
                heroClass = scanner.nextLine();
                hero = HeroFactory.newHero(name, heroClass, 1, 0, 0);
                System.out.println("Your hero stats:\n" + hero.toString());
            }
            else if (input.equalsIgnoreCase("load")){
                int loaded = LoadHero.loadHero();
                if (loaded == 1){
                    input = scanner.nextLine();
                    hero = LoadHero.getHero(Integer.parseInt(input));
                    System.out.println("You have selected:\n" + hero.toString());
                }
            }
            Map map = new Map(hero.getLevel());
            System.out.println("You're playing on a " + map.getMapX() + "x" + map.getMapY() + "Map");
            System.out.println("Current position: x:" + hero.getX() + " y:" + hero.getY() + "\nWhich direction would you like to go?\nOptions: Right/R, Left/L, Up/U or Down/D.");
            while (true){
                
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("right") || input.equalsIgnoreCase("r")){
                    if (hero.getX() != map.getMapX()){
                        hero.setX(hero.getX() + 1);
                    }
                    else{
                        System.out.println("You're at the end of the map you can only go left, up or down");
                    }
                }
                else if (input.equalsIgnoreCase("left") || input.equalsIgnoreCase("l")){
                    if (hero.getX() != 0){
                        hero.setX(hero.getX() - 1);
                    }
                    else{
                        System.out.println("You're at the end of the map you can only go right, up or down");
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong.");
        }
    }
}