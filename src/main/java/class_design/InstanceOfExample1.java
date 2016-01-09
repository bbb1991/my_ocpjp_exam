package class_design;

/**
 * Created by bbb1991 on 1/8/16.
 */
public class InstanceOfExample1 {

    public static void main(String[] args) {
        Animal horse = new Horse();
        Animal sheep = new Sheep();

        test(horse);
        System.out.println();
        test(sheep);
    }


    public static void test(Animal animal) {
        animal.eat();
        if (animal instanceof Horse) {
            ((Horse) animal).ride();
        } else if (animal instanceof Sheep) {
            System.out.println("Hur dur I am a sheep!");
        }
        animal.run();

    }
}

abstract class Animal {
    abstract void eat();
    abstract void run();
}

class Horse extends Animal {
    @Override
    void eat() {
        System.out.println("Eating grass");
    }

    @Override
    void run() {
        System.out.println("Running fast");
    }

    public void ride() {
        System.out.println("Hold tight Hooman!"); // Yeah, I know that is mistake but it's my code and I'm decide here
    }
}

class Sheep extends Animal {

    @Override
    void eat() {
        System.out.println("eating grass");
    }

    @Override
    void run() {
        System.out.println("running fast");
    }
}