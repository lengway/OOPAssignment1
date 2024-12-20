public class Person {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";


    private final String name;
    private final String surname;
    private final int age;
    private final boolean gender;

    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public int getAge() {
        return this.age;
    }
    public boolean getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return ANSI_CYAN + "Hi, my name is " + getName() + " " + getSurname() + ", a " + getAge() + "-year-old " + (getGender() ? "Male." : "Female.") + ANSI_RESET;
    }

}
