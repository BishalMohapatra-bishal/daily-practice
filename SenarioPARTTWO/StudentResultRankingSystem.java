package SenarioPARTTWO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{

    private final int rollNumber;
    private final String name;
    private final double marks;

    public Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNumber, other.rollNumber);
    }

    @Override
    public String toString() {
        return "Student [rollNumber=" + rollNumber + ", name=" + name + ", marks=" + marks + "]";
    }
}

class MarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getMarks(), s1.getMarks());
    }
}

public class StudentResultRankingSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(103, "Bishal", 85.5));
        students.add(new Student(101, "Amit", 92.0));
        students.add(new Student(102, "Priya", 78.0));

        Collections.sort(students);
        System.out.println("Sorted by Roll No(Comparable):");
        students.forEach(System.out::println);

        students.sort(new MarksComparator());
        System.out.println("Sorted by Marks Descending (Comparator):");
        students.forEach(System.out::println);
    }
    
}
