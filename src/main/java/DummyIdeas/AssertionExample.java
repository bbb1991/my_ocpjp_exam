package DummyIdeas;

public class AssertionExample {
    public static void main(String[] args) {
        System.out.println(new Person("John", "Smith"));
    }
}

class Person {
    private String name;
    private String surname;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}