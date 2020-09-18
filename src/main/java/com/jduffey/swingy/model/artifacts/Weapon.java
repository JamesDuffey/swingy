package swingy.model.artifacts;

public class Weapon extends Artifact {
    Weapon(String artifact) {
        switch (artifact) {
            case "Dagger":
                this.attack = 10;
            case "Bow":
                this.attack = 10;
            case "Sword":
                this.attack = 10;
            case "Dragon's Tooth Dagger":
                this.attack = 15;
            case "Enchanted Bow":
                this.attack = 15;
            case "Empowered Sword":
                this.attack = 15;
        }
    }
}