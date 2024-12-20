public class Teacher extends Person {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final String subject;
    private final int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void giveRaise(int percent) {
        this.salary = this.salary + (this.salary * percent) / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ANSI_RED + " I am teach " + this.subject + "." + ANSI_RESET + ANSI_YELLOW + " My salary is " + this.salary + " and I have " + this.yearsOfExperience + " years of experience." + ANSI_RESET;
    }
}
