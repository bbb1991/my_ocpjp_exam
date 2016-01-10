package class_design;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 переопределение (overloading)  метод с таким же именем, но с другими аргументами
 пример:
 public void test(int i)
 public void test(String s)

 */
public class OverloadExample1 {

    // конструкторы можно перегружать
    OverloadExample1() {}
    OverloadExample1(String s) {}
    OverloadExample1(int i) throws Exception {}

    private void test(Object o) {}
    //private void test(String s ){}
    //private void test(StringBuffer sb) {}
    //private void test(StringBuilder sb) {}
    // private void test(int i) {}
    private void test(long l) {
        System.out.println("long");
    }

    private void test(short s) {
        System.out.println("short");
    }
    private void test(Exception ex) {}
    private void test(IOException ex) {}
    private void test(FileNotFoundException ex) {}
    private void test(Integer i) {}


    public static void main(String[] args) {

        // при вызове метода, виртуальная машина выберет метод с аргументом, который находится
        // внизу иерархий
        // пример exception - IOException - FileNotFoundException
        //new OverloadExample1().test(null);

        // Integer vs int? вызовется int
        // Integer vs long? long wins
        new OverloadExample1().test(4);
    }

    private void test (double a, double b) throws Exception {}
    //private int test (double a, double b) { return  0; }

    // статические методы можно переопределять (что для меня было сюрпризом...)
    private static void test1 () {}
    private static void test1 (String s) {}

}
