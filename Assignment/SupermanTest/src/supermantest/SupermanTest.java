package supermantest;
class Animal {
    public String name;
    public int age, height;
    public Animal() {
        this("Animal", 0, 1);
        System.out.println("Animal 기본생성자");
    }
    public Animal(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
        System.out.println("Animal 생성자");
    }
    public void breath() {
        System.out.println("Animal.breath");
    }
    public void yell() {
        System.out.println("Animal.yell");
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Dragon extends Animal {
    public Dragon() {
        super();
    }
    public Dragon(String name, int age, int height) {
        super(name, age, height);
    }
    public void Fire() {
        System.out.println("Dragon can Fire");
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Human extends Animal {
    public int account;
    public Human() {
        super();
        account = 0;
        System.out.println("Human 기본생성자");
    }
    public Human(String name, int age, int height, int account) {
        super(name, age, height);
        this.account = account;
        System.out.println("Human 생성자");
    }
    public void speak() {
        System.out.println("Human.speak");
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Dracula extends Human {
    public Dracula() {
        super();
    }
    public Dracula(String name, int age, int height, int account) {
        super(name, age, height, account);
    }
    public void DrinkBlood() {
        System.out.println("Dracula drinking blood");
    }
    public void DieUnderTheSun() {
        System.out.println("Dracula die under the sun");
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Superman  extends Human {
    public Superman() {
        super();
    }
    public Superman(String name, int age, int height, int account) {
        super(name, age, height, account);
    }
    public void fly() {
        System.out.println("Superman.fly");
    }
    public void laserByEye() {
        System.out.println("Superman.laserByEye"); 
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class SupermanTest {
    public static void main(String[] args) {
        Superman ilgook = new Superman();
        ilgook.fly();
        ilgook.laserByEye();
        ilgook.breath();
        ilgook.speak();
        ilgook.yell();
        System.out.println("----------------------------");
        Superman ilgook2 = new Superman("ilgook", 40, 180, 11101);
        System.out.println("----------------------------");
        Dragon dragon = new Dragon();
        dragon.Fire();
        System.out.println("----------------------------");
        Dracula dracula = new Dracula();
        dracula.DrinkBlood();
        dracula.DieUnderTheSun();
    }
}