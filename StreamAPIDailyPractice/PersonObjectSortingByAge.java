package StreamAPIDailyPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonObjectSortingByAge {
    public static void main(String[] args) {

        Person p1 = new Person("Bishal", 24);
        Person p2 = new Person("Barasa", 17);
        Person p3 = new Person("Richa nani", 25);
        Person p4 = new Person("Ketan", 16);
        Person p5 = new Person("Rinku bhaina", 31);
        Person p6 = new Person("Kitty", 11);
        
        List<Person> list4 = new ArrayList<>();
        list4.add(p1);
        list4.add(p2);
        list4.add(p3);
        list4.add(p4);
        list4.add(p5);
        list4.add(p6);

        // List<Integer> sortedList = list4.stream().map(x -> x.getAge()).sorted().toList();
        // // list4.stream().map(x -> x.get).sorted().toList(); 
        // System.out.println(sortedList);
        // System.out.println(p1); // print a aperticular object.

        list4.stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);
    }
    
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

}
