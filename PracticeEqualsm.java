public class PracticeEqualsm {
    public static void main(String[] args) {
        Studentss s1 = new Studentss("Bishal", 24);
        Studentss s2 = new Studentss("Bishal", 24);

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class Studentss {
    String name;
    int age;

    public Studentss(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Studentss other = (Studentss) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }
    
}