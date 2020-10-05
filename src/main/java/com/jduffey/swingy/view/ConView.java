package swingy.view;

import java.io.*;
import swingy.model.heroes.Hero;
import swingy.model.Map;

public class ConView{
    public void start(){
        System.out.println("Type load to load a hero or new to create a new hero.");
    }

    public void hName(){
        System.out.println("Hero Name:");
    }

    public void hClass(){
        System.out.println("Please select a class from the list:\nWarrior\nRogue\nHunter");
    }

    public void hStats(Hero hero){
        System.out.println("Your hero stats:\n" + hero.toString());
    }

    public void selectedHero(Hero hero){
        System.out.println("You have selected:\n" + hero.toString() + "\n");
    }

    public void loadFailed(){
        System.out.println("No heroes found please create a new character");
    }

    public void mapSize(int x, int y){
        System.out.println("You're playing on a " + x + "x" + y + "Map");
    }

    public void playerPos(int x, int y){
        System.out.println("Current position: x:" + x + " y:" + y);
    }

    public void options(){
        System.out.println("Which direction would you like to go?\nOptions: Right/R, Left/L, Up/U or Down/D.");
    }

    public void emptySave(){
        System.out.println("No heroes found please create a new character");
    }

    public void encounter(String villain){
        System.out.println("You have Encountered a " + villain + "!\nFight or run? ");
    }

    public void escapeFailed(String villain, int dmg, int hp){
        System.out.println("You have failed to escape the encounter\n" + villain + " hit you for " + dmg + " You have " + hp + " hitpoints left");
    }

    public void escaped(){
        System.out.println("You have successfully escaped!");
    }

    public void fight(){
        System.out.println("You have decided to fight!");
    }

    public void nameExists(){
        System.out.println("Name already exists please choose a different name.");
    }

    public void nameInvalid(){
        System.out.println("Name is invalid. Names may only contain letters");
    }

    public void awaitNum(){
        System.out.println("Please enter a number from the list above.");
    }

    public void newMap(Map map){
        System.out.println("Generated new map.. size: " + map.getMapX() + "x" + map.getMapY());
    }

    public void errorLoading(){
        System.out.println("Looks like we had an issue loading old heroes.");
    }

    public void errorCreatingSave(){
        System.out.println("couldn't create hero save file.");
    }

    public void errorOc(){
        System.out.println("An error occurred.");
    }

    public void endOfMap(String dir){
        System.out.println("You're at the end of the map you can't go " + dir);
    }

    public void heroSaved(){
        System.out.println("Hero Saved... exiting");
    }

    public void defeat(String villain){
        System.out.println("You have defeated the " + villain);
    }

    public void death(){
        System.out.println("You have died!");
    }

    public void hitVil(){
        System.out.println("Type hit to attack the enemy");
    }

    public void printHP(int vilhp, int herohp){
        System.out.println("Enemy HP: " + vilhp + " Your HP: " + herohp);
    }
}