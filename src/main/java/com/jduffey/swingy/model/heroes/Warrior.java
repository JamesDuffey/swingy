package swingy.model.heroes;

import javax.persistence.Entity;
import javax.validation.constraints.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Hero {
    public Warrior(@NotNull String name, String heroClass, int level, int exp, int x, int y){
        super(name, heroClass, level, exp, x, y);
        this.hitPoints = 80;
        this.attack = 10;
    }
}