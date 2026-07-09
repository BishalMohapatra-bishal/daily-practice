import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CF3 {
    public static void main(String[] args) {
        HashMap<Student, String> studentsMap = new HashMap<>();

        Student s1 = new Student(1, "Bishal");
        Student s2 = new Student(2, "Barsha");
        Student s3 = new Student(3, "Gudu");
        Student s4 = new Student(4, "Piggy");

        studentsMap.put(s1, "Math");
        studentsMap.put(s2, "IT");
        studentsMap.put(s3, "Science");
        studentsMap.put(s4, "History");

        Set<Student> students = studentsMap.keySet();
        for (Student stud : students) {
            System.out.println(stud);
        }
        String s = studentsMap.get(s1);
        System.out.println(s);

        Set<Map.Entry<Student, String>> entries = studentsMap.entrySet();
        for (Map.Entry<Student, String> list : entries) {
            System.out.println(list);
        }
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
