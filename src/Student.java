import java.util.ArrayList;

public class Student extends Person {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";


    private static int studentCount = 1;
    private final int studentID;
    private final ArrayList<Integer> grades;

    public Student(String name, String surname, int age, boolean gender, ArrayList<Integer> grades) {
        super(name, surname, age, gender);
        this.studentID = studentCount++;
        this.grades = new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grades.add(grade);
        }
    }

    public double calculateGPA() {
        if (this.grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (int grade : this.grades) {
            sum += grade;
        }
        return sum / this.grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + ANSI_GREEN + " I am student with ID " + this.studentID + "." + ANSI_RESET + ANSI_BLUE + " My GPA is " + calculateGPA() + "." + ANSI_RESET;
    }
}
