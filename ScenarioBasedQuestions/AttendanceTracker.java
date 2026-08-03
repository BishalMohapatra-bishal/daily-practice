package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.List;

class StudentPresent {
   private List<String> pStudentList;

    public StudentPresent() {
        this.pStudentList = new ArrayList<>();
    }
    
    public void markPresent(String studentName) {
        if (studentName != null && !studentName.trim().isEmpty()) {
            pStudentList.add(studentName.trim().toLowerCase());
            System.out.println("Marked present: " + studentName);
        }
    }

    public boolean isStudentPresent(String name) {
        if (name == null) return false;
        return pStudentList.contains(name.trim().toLowerCase());
    }

    public int getStudentCount() {
        return pStudentList.size();
    }
}

public class AttendanceTracker {
    public static void main(String[] args) {
        StudentPresent sp = new StudentPresent();
        sp.markPresent("Bishal");
        sp.markPresent("Rahul");
        sp.markPresent("Pooja");
        sp.markPresent("Anit");

        System.out.println("\n--- Checking Attendance ---");

        String search1 = "bishal";
        String search2 = "Rohan";

        System.out.println("Is " + search1 + " present? " + sp.isStudentPresent(search1));
        System.out.println("Is " + search2 + " present? " + sp.isStudentPresent(search2));
        
        System.out.println("The total no of students present is: " + sp.getStudentCount());
    }
    
}
