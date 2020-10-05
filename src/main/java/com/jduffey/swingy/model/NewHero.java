package swingy.model;

import java.util.*;
import swingy.model.heroes.Hero;
import swingy.view.ConView;
import swingy.model.LoadHero;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class NewHero {
    ConView conView = new ConView();
    public ArrayList<Hero> heroes = new ArrayList<>();
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    public Hero newHero(Scanner scanner){
        String name;
        String heroClass;
        conView.hName();
        name = scanner.nextLine();
        while (checkExists(name)){
            if (!name.matches("^[a-zA-Z]*$")){
                conView.nameInvalid();
            }
            else{
                conView.nameExists();
            }
            name = scanner.nextLine();
        }
        conView.hClass();
        heroClass = scanner.nextLine();
        while (!(heroClass.equalsIgnoreCase("warrior") || heroClass.equalsIgnoreCase("hunter") || heroClass.equalsIgnoreCase("rogue"))){
            heroClass = scanner.nextLine();
        }
        HeroFactory hf = new HeroFactory();
        Hero hero = hf.newHero(name, heroClass, 1, 0, 0, 0);
        conView.hStats(hero);
        Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(hero);

        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Hero> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
            System.exit(0);
        }
        return hero;
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

    public Hero newHeroGui(String name, String hClass){
        if (!checkExists(name)){
            HeroFactory hf = new HeroFactory();
            Hero hero = hf.newHero(name, hClass, 1, 0, 0, 0);

            Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(hero);

            if (constraintViolations.size() > 0) {
                for (ConstraintViolation<Hero> violation : constraintViolations) {
                    System.out.println(violation.getMessage());
            }
                System.exit(0);
            }

            return hero;
        }
        return null; //display popup
    }
}