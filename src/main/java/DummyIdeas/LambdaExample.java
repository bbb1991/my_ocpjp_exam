package DummyIdeas;

/**
 * Created by bbb1991 on 1/11/16.
 */
public class LambdaExample {
    public static void main(String[] args) {
        A a = s -> System.out.println(s);
        a.printMe("Hello");

        A a1 = System.out::println;
        a1.printMe("Test");
    }
}

interface A {
    void printMe(String s);
}
