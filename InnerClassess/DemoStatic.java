package InnerClassess;

import InnerClassess.Demo.InnerDemoStatic;

public class DemoStatic {
 public static void main(String[] args) {

    // Because it is a static nested class so we can create the instance it just by the outer class name
    Demo.InnerDemoStatic indemo = new Demo.InnerDemoStatic();
    indemo.inner();
    InnerDemoStatic.innerStatic();
 }   
}




class Demo {

   static void outerStatic() {
        System.out.println(InnerDemoStatic.innerField);
        InnerDemoStatic.innerStatic();
    }

    void outerNonStatic() {
        System.out.println("Non-static outer method...........");
    }

    private static String outerField = "Bishal says hello from outside.....";
    String outerNonStaicField = "Outer Non-static field";


    // Static nested class
    static class InnerDemoStatic {

        private static String innerField = "Bishal says hello from inside...........";

        public void inner() {
            System.out.println("Static inner method say hello....");
            d.outerNonStatic();
            System.out.println(d.outerNonStaicField);
        }

        static void innerStatic() {
            System.out.println("Innerstatic says hello..........");
             // The inner static nested class can access the static fields and methods() of the outer class directly
            System.out.println(outerField); 
            outerStatic();
        }
            Demo d = new Demo(); //create the instance of the outer class to access the outer non-static field

    }
}