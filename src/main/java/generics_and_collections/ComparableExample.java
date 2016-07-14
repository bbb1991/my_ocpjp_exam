package generics_and_collections;

import java.util.*;

/**
 * Created by bbb1991 on 7/13/16.
 */
public class ComparableExample {
    static class Person implements Comparable<Person>{
        String surname;
        String firstname;
        double salary;

        public Person(final String surname, final String firstname, final double salary) {
            this.surname = surname;
            this.firstname = firstname;
            this.salary = salary;
        }

        @Override
        public int compareTo(Person o) {
            return this.surname.compareTo(o.surname);
        }

        @Override
        public String toString() {
            return String.format("%s, %s: %.2f", firstname, surname, salary);
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Smith", "John", 10000));
        persons.add(new Person("Williams", "Jane", 1666.66));
        persons.add(new Person("Kaiden", "Alenko", 5000));
        persons.add(new Person("T'Sony", "Liara", 2000));


        System.out.println("Sort by surname: ");
        Collections.sort(persons); // sorted by surname
        persons.forEach(System.out::println);
        System.out.println();


        System.out.println("Sort by salary asc");
        Collections.sort(persons, new SalaryComparator());
        persons.forEach(System.out::println);
    }

    static class SalaryComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return Double.compare(o1.salary, o2.salary);
        }
    }
}
