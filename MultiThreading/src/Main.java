public class Main {
    public static void main(String[] args) {
        PrintNumbers thread1 = new PrintNumbers();
        PrintLetters thread2 = new PrintLetters();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have finished execution.");
    }
}