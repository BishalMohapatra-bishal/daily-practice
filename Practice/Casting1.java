public class Casting1 {
    public static void main(String[] args) {
        // widely casting no required of manual casting java will handel it internally
        byte b = 10; // rang of byte is -127 to 128
        int i = b;
        System.out.println("Internal casting: " + i);

        // it is narrowing casting which required manual casting
        int ii = 20;
        byte bb = (byte)ii;
        System.out.println("Manual casting: " + bb);

        // Truncating conversion
        float f = 16.0f;
        double d = f;
        System.out.println("Float to Double auto conversion: " + d);

        int iii = (int)f;
        System.out.println("Float to int manual conversion: " + iii);

        // boolean datatype cannot convert to any other data type

        //Automatic type promotion
        byte bbbb = 50;
        bbbb =  (byte)(bbbb * 2);
    }
}
