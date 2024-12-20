import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School sc = new School();
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = getStudent(line);

                sc.addMember(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("teachers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Teacher teacher = getTeacher(line);

                sc.addMember(teacher);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean isRunning = true;
        while (isRunning) {
            isRunning = chooseActivity(sc);
        }

        System.out.println("Goodbye!");
    }

    private static boolean chooseActivity(School sc) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose activity:");
        System.out.println("1 - Add grade\n2 - Raise salary\n3 - Print all members\n4 - Print all students\n5 - Print all teachers\n0 - Exit");
        int menuOption = scan.nextInt();
        scan.nextLine();
        switch (menuOption) {
            case 1:
                addGrade(scan, sc);
                break;
            case 2:
                raiseSalary(scan, sc);
                break;
            case 3:
                sc.toString();
                break;
            case 4:
                for (Student st : sc.getStudents()) {
                    System.out.println(st.toString());
                }
                break;
            case 5:
                for (Teacher te : sc.getTeachers()) {
                    System.out.println(te.toString());
                }
                break;
            case 0:
                return false;
            default:
                System.out.println("Invalid number!");
                break;
        }
        return true;
    }

    private static Teacher getTeacher(String line) {
        String[] parts = line.split(" ");
        String name = parts[0];
        String surname = parts[1];

        int age = Integer.parseInt(parts[2]);

        boolean gender = parts[3].equals("Male");

        String subject = parts[4];

        int yearsOfExperience = Integer.parseInt(parts[5]);

        int salary = Integer.parseInt(parts[6]);

        return new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
    }

    private static Student getStudent(String line) {
        String[] parts = line.split(" ");

        String name = parts[0];
        String surname = parts[1];

        int age = Integer.parseInt(parts[2]);

        boolean gender = parts[3].equals("Male");

        ArrayList<Integer> grades = new ArrayList<>();

        for (int i = 4; i < parts.length; i++) {
            grades.add(Integer.parseInt(parts[i]));
        }

        return new Student(name, surname, age, gender, grades);
    }

    private static void addGrade(Scanner scan, School sc) {
        System.out.println("Who do you want to add grade to? (name surname)");
        String[] teacherNameAndSurname = scan.nextLine().split(" ");
        for (Student st : sc.getStudents()) {
            if (st.getName().equals(teacherNameAndSurname[0]) && st.getSurname().equals(teacherNameAndSurname[1])) {
                System.out.println("Actual GPA is " + st.calculateGPA() + ".");
                System.out.println("What grade do you want to add? (0-100)");
                int grade = scan.nextInt();
                scan.nextLine();
                if (grade >= 0 && grade <= 100) {
                    st.addGrade(grade);
                    System.out.println("Grade added! Now student GPA is " + st.calculateGPA() + ".");
                } else {
                    System.out.println("Invalid grade!");
                }
                break;
            }
            System.out.println("No students with this name and surname!");
            break;
        }
    }

    private static void raiseSalary(Scanner scan, School sc) {
        System.out.println("Who do you want to raise salary? (name surname)");
        String[] studentNameAndSurname = scan.nextLine().split(" ");

        for (Teacher te : sc.getTeachers()) {
            if (te.getName().equals(studentNameAndSurname[0]) && te.getSurname().equals(studentNameAndSurname[1])) {

                System.out.println("Actual " + te.getName() + " " + te.getSurname() + " salary is " + te.getSalary() + ".");
                System.out.println("How much do you want to raise salary by? (in percents)");
                int percent = scan.nextInt();
                scan.nextLine();
                te.giveRaise(percent);
                System.out.println("Salary raised! Now it's " + te.getSalary() + ".");
                break;
            }
            System.out.println("No teachers with this name and surname!");
            break;
        }
    }
}