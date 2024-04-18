import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            file.createNewFile();
            System.out.println("File created: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            file.delete();
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

    }
}