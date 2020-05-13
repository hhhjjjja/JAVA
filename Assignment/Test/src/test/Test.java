package test;
public class Test {
    public static void main(String[] args) {
        Human tom = new Human("Tom");
        Alien alien1 = new Alien("PPUPPU");
        Alien alien2 = new Alien("PPAPPA");
        alien1.letMeKnowYourName(tom);
        alien2.tellHumanName();
        alien1.tellHumanName();
    }
}