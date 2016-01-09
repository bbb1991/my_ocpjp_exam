package OOP_principles;

public class BuilderExample1 {
    public static void main(String[] args) {
        Person person = Person.getBuilder()
                .setSurname("Smith")
                .setFirstname("John")
                .setSecondname(null)
                .build();

        System.out.println(person);

        System.out.println(Person.getBuilder().setSecondname("Jr").build());
    }
}

class Person {
    private String surname;
    private String firstname;
    private String secondname;

    private Person() {}

    public static Builder getBuilder() {
        return new Person().new Builder();
    }

    class Builder {
        private Builder() {}

        public Builder setSurname(String surname) {
            Person.this.surname = surname;
            return this;
        }

        public Builder setFirstname(String firstname) {
            Person.this.firstname = firstname;
            return this;
        }

        public Builder setSecondname(String secondname) {
            Person.this.secondname = secondname;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(surname)
                .append(" ")
                .append(firstname)
                .append(" ")
                .append((secondname != null) ? secondname : "")
                .toString();
    }
}