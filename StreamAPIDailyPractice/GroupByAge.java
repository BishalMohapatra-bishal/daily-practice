package StreamAPIDailyPractice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByAge {
    public static void main(String[] args) {

        Person p1 = new Person("Bishal", 24);
        Person p2 = new Person("Barasa", 17);
        Person p3 = new Person("Gudu", 24);
        Person p4 = new Person("Piggy", 17);
        Person p5 = new Person("Ketan", 16);
        Person p6 = new Person("Kitty", 11);
        Person p7 = new Person("Rinku bhaina", 31);
        Person p8 = new Person("Richa nani", 25);
        Person p9 = new Person("Payal nani", 25);
        Person p10 = new Person("Kuldeep bhaina", 31);

        List<Person> listOfWord = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);

        Map<Integer, List<Person>> peopleByAge = listOfWord.stream().collect(Collectors.groupingBy(Person::getAge));

        System.out.println("Grouped Results: ");
        peopleByAge.forEach((age, group) -> {
            System.out.println("Age " + age + ": " + group);
        });

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
        return "Person [name=" + name + ", age=" + age + "]";
    }

    
}