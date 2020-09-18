package swingy;

import java.io.PrintStream;
import java.io.File;
import java.util.*;
import java.io.*;
import swingy.model.heroes.Rogue;
import swingy.model.heroes.Hero;
import swingy.controller.Controller;

public class Swingy {
    public static void main (String[] args) {
        

        PrintStream heroSave;
        PrintStream originalOut = System.out;
        // try {
          // heroSave = new PrintStream("herosave.txt");
          // System.setOut(heroSave);
          // Hero hero = new Rogue("Jimmy", "Warrior", 1);
          // System.out.println(hero.toString());
          // System.setOut(originalOut);
          try {
            if (args[0].equalsIgnoreCase("console") || args[0].equalsIgnoreCase("gui")){
                Controller controller = new Controller();
                controller.getInterface("args[0");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        // } catch (FileNotFoundException e1) {
        //   System.out.println("There was an error while trying to write to simulation.txt");
        //   e1.printStackTrace();
        // }
      }
      
    }