import java.util.*;

public class CF1 {
    public static void main(String[] args) {
        ArrayList<String> aa = new ArrayList<>();
        aa.add("Exception");
        aa.add("Threading");
        aa.add("Collection");
        aa.add("String");
        aa.add("Array");
        aa.add("JDBC");
        System.out.println("Size is: " + aa.size());
        System.out.println("See the elements.");
        Iterator<String> ii = aa.iterator();
        while(ii.hasNext()) {
            String data = ii.next();
            System.out.println(data);
            ii.remove();


        }
        System.out.println("Size is: " + aa.size());

        


    }
}
