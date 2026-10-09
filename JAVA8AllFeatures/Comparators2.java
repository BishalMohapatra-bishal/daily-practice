import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Students {
    private String name;
    private Double cgpa;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public Students(String name, Double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    // @Override
    // public String toString() {
    //     return "Students [name=" + name + ", cgpa=" + cgpa + "]";
    // }

    @Override 
    public String toString() {
        return "Students [ Name : " + name + " || CGPA : " + cgpa + " ]";
    }

    
}
public class Comparators2 {
    public static void main(String[] args) {
        List<Students> studList = new ArrayList<>();
        studList.add(new Students("Bishal", 7.8));
        studList.add(new Students("Barasa", 9.9));
        studList.add(new Students("Piggy", 8.8));
        studList.add(new Students("Gudu", 8.2));

        // Collections.sort(studList, (s1, s2) -> (int) (s1.getCgpa() - s2.getCgpa()));
        // System.out.println(studList);

        // for(Students s : studList) {
        //     System.out.println(s);
        // }

        studList.sort((st1, st2) -> {
            if (st1.getCgpa() - st2.getCgpa() > 0) {
                return 1;
            } else if (st1.getCgpa() - st2.getCgpa() < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        for(Students st : studList) {
            System.out.println(st);
        }
    }
}