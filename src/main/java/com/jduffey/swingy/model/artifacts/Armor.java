package swingy.model.artifacts;

public class Armor extends Artifact{
    Armor(String artifact) {
        switch (artifact){
            case "Dragon's Hide Armor":
                this.defense = 15;
            case "Leather Armor":
                this.defense = 10;
            case "Plated Armor":
                this.defense = 10;
            case "Cloth Armor":
                this.defense = 10;
        }
    }
}