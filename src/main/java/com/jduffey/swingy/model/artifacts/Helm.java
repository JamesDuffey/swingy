package swingy.model.artifacts;

public class Helm extends Artifact {
    Helm(String artifact) {
        switch (artifact) {
            case "Dragon's Hide Helm":
                this.hitPoints = 15;
            case "Leather Helm":
                this.hitPoints = 10;
            case "Plated Helm":
                this.hitPoints = 10;
            case "Cloth Helm":
                this.hitPoints = 10;
        }
    }
}