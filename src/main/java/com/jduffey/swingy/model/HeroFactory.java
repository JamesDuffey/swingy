package swingy.model;

import java.io.*;
import java.util.Set;
import swingy.model.heroes.Hero;
import swingy.model.heroes.Hunter;
import swingy.model.heroes.Rogue;
import swingy.model.heroes.Warrior;


//import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import junit.framework.Assert;

//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroFactory {
    Hero hero;
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();
    public Hero newHero(String name, String heroClass, int level, int exp, int x, int y){
        switch (heroClass.toLowerCase()){
            case "warrior":{
                return new Warrior(name, heroClass, level, exp, x, y);
            }
            case "hunter":
                return new Hunter(name, heroClass, level, exp, x, y);
            case "rogue":
                return new Rogue(name, heroClass, level, exp, x, y);
            }
            return null;
    }
}