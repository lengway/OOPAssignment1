package models;

import java.util.ArrayList;

public class School {
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Teacher> teachers = new ArrayList<>();

    public void addMember(Person person) {
        if (person instanceof Student) {
            this.students.add((Student) person);
        } else if (person instanceof Teacher) {
            this.teachers.add((Teacher) person);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public String toString() {
        System.out.println("\nStudents:\n");
        for (Person person : this.students) {
            System.out.println(person.toString());
        }

        System.out.println("\nTeachers:\n");
        for (Person person : this.teachers) {
            System.out.println(person.toString());
        }

        return "";
    }
}
