public class PrintLetters extends Thread {
    public void run() {
        for (char c = 'a'; c <= 'e'; c++) {
            System.out.println("Thread 2: " + c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
