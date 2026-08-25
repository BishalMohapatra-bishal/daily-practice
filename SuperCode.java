public class SuperCode {

    static volatile boolean flag = false;
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch(InterruptedException i) {
                i.getMessage();
            }
        flag = true;
    });

// ----------------------------------------------------------------------------------------------

     Thread t2 = new Thread(() -> {
        while (!flag) {
            // System.out.println("t2 is running.."); This method is bydefault synchronized so it will read the 
            // value from ram instead of reading it from cache.
        }
        System.out.println("t2 is finshed!!");
     });

// --------------------------------------------------------------------------------------------------------------

     t1.start();
     t2.start();

     try {
         t1.join();
         t2.join();
     } catch (InterruptedException i) {
        i.getMessage();
     }
     

// --------------------------------------------------------------------------------------------------------

     System.out.println("Main finshed!!!");

    }
}
