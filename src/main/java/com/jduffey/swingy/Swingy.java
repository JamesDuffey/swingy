package swingy;

import java.io.PrintStream;
import java.io.File;
import java.util.*;
import java.io.*;
import swingy.model.heroes.Rogue;
import swingy.model.heroes.Hero;
import swingy.controller.Controller;
import swingy.view.View;

public class Swingy {
  public static void main (String[] args) {
    //View view = new View();
    Controller controller = new Controller();
    try {
      if (args[0].equalsIgnoreCase("console") || args[0].equalsIgnoreCase("gui")){
          controller.getInterface(args[0]);
      }
    } catch (Exception e) {
        System.out.println("Something went wrong.");
    }
  }
}