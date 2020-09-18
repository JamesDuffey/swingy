package swingy.model;

import java.io.File;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import swingy.model.heroes.Hero;
import swingy.model.HeroFactory;

public class LoadHero{
    public static Hero hero;

    public static int loadHero(){
        try {
            File scenario = new File("../heroSave.txt");
            Scanner myReader = new Scanner(scenario);
            int i = 0;
            if (!myReader.hasNextLine())
                return 0;
                
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split(" ");
                hero = HeroFactory.newHero(arr[0], arr[1], Integer.parseInt(arr[2]), 0, 0);
                System.out.println(i + ") " + hero.toString());
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Looks like we had an issue loading old heroes.");
        }
        return 1;
    }

    public static Hero getHero(int find){
        try {
            File scenario = new File("../heroSave.txt");
            Scanner myReader = new Scanner(scenario);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (i == find){
                    String[] arr = data.split(" ");
                    hero = HeroFactory.newHero(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
                }
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Looks like we had an issue loading old heroes.");
        }
        return hero;
    }
}