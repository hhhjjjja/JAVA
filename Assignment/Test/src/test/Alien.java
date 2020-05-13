package test;

public class Alien {
    private String name;
    private String hname;
    Alien() {}
    Alien(String name) {
        this.name = name;
    }
    void letMeKnowYourName(Human human) {
        hname = human.getName();
    }
    void tellHumanName() {
        System.out.println("I'm alien, " + name + ". Human name is " + hname + ".");
    }
}