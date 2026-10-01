package ScenarioBasedQuestions.Multithreading;

public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Working...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep!");

                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Worker thread stopping safely.");
        });

        worker.start();
        Thread.sleep(2500);

        worker.interrupt();
    }
 
}