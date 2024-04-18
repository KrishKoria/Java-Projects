import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris fringilla tempor augue quis posuere. Proin erat tellus, sodales sed nisi sed, auctor ullamcorper purus. Quisque non ante vel erat pretium convallis. Nulla molestie lectus ipsum. Vestibulum nec interdum enim. Aliquam erat volutpat. Vestibulum arcu elit, congue ac laoreet quis, pellentesque non justo. Sed vestibulum tortor a diam semper scelerisque. Aenean non velit lobortis, lacinia quam ut, euismod nisl. Sed venenatis at odio nec tincidunt. Nulla ac nisl sed ligula iaculis pharetra. Cras id turpis vel ex imperdiet semper id et augue. Fusce vel ornare tellus. Sed enim libero, egestas sit amet nisi ut, egestas rutrum arcu.

                Integer scelerisque sodales elit malesuada egestas. Pellentesque cursus mauris finibus, sollicitudin lorem ut, congue nisl. Duis vehicula consequat elit non tristique. Cras lorem tellus, auctor sed ornare eget, eleifend ut enim. Maecenas quis nunc quam. Cras tempus elit ac laoreet faucibus. Phasellus facilisis tristique risus, sit amet bibendum arcu venenatis at. Vivamus convallis neque velit, vitae vehicula erat pulvinar id.

                Etiam vel tortor vel erat varius vulputate. Suspendisse potenti. Nulla sit amet justo consectetur, fermentum lectus eu, tincidunt lorem. Aliquam venenatis vulputate massa, ultricies vulputate mi tempor eu. Integer mollis lorem non sapien egestas, posuere elementum diam placerat. Donec lorem ante, interdum id scelerisque quis, fermentum vel diam. Nunc egestas varius lectus, id condimentum est tincidunt at. Aliquam tristique risus eget mauris gravida, sit amet viverra orci volutpat. Nullam pulvinar justo at sapien dictum, non vehicula dolor luctus. Sed ornare lacus libero, euismod vestibulum odio pellentesque nec.

                Quisque ullamcorper nunc quis libero aliquam, ac fringilla lectus facilisis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi tempor nisl nec lobortis dictum. Sed id neque erat. Nunc finibus ut felis eget feugiat. Sed ut tristique urna. Phasellus ac commodo lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum eget auctor ligula. Vivamus rutrum a tortor in feugiat.

                Aliquam erat volutpat. Nunc ac consectetur sapien. Ut justo nibh, vestibulum eu tincidunt maximus, imperdiet ut diam. Nunc consectetur augue massa, ac tincidunt magna tempor nec. Pellentesque mattis tempor quam vel sodales. Pellentesque sagittis ligula elit, sit amet placerat arcu interdum a. Pellentesque ut tellus sit amet dui tempor interdum id ac felis.

                Integer pulvinar eget nibh et volutpat. Morbi vel finibus libero. Aenean tincidunt dui ac sapien porta rhoncus in sed sapien. Fusce rhoncus nisi metus. Vestibulum eleifend finibus nisl nec condimentum. Sed dictum nibh ut augue pulvinar, a sollicitudin tellus ornare. Morbi finibus mi eu libero vehicula imperdiet. In hendrerit interdum sem, eget volutpat augue consectetur sit amet.

                Nullam blandit nibh in placerat malesuada. In laoreet nibh tortor, ut tristique enim lacinia vitae. Nulla facilisi. Proin sagittis, ante vitae iaculis placerat, elit nunc scelerisque lorem, vitae rutrum turpis ligula vel est. Donec metus magna, tristique ut pulvinar eu, molestie et nunc. Proin blandit posuere pulvinar. Mauris luctus neque turpis, ut fermentum nisl cursus ac. Mauris efficitur ultricies ornare. Fusce et nisi neque. Aliquam vel eleifend metus. Ut iaculis magna eu eleifend lacinia. Fusce tincidunt, orci sed pretium tristique, neque leo laoreet erat, ac lacinia augue ex a augue. Donec rhoncus porta arcu vel venenatis.

                Vivamus ut varius arcu. Nullam id nisi non quam mattis interdum vitae non ligula. Quisque tristique dolor est, id varius enim dignissim nec. Donec nec tempus diam, at maximus metus. Sed lacinia mauris eget ex feugiat porta. Proin condimentum elit nibh, nec fringilla dui commodo at. Integer quam libero, sodales eu ipsum vitae, maximus semper dolor. Fusce pharetra interdum nisi sed molestie. Aliquam metus sapien, eleifend eu accumsan sodales, faucibus nec ligula. Sed molestie ut erat sit amet finibus.

                Vivamus ac ex volutpat, finibus nunc vitae, tristique felis. Quisque a ligula vitae justo commodo imperdiet. In tincidunt euismod eros sit amet lacinia. Maecenas sodales elit sit amet sapien fringilla, vel pulvinar ante posuere. Phasellus commodo sapien id est consequat, non aliquet purus mattis. Curabitur iaculis, quam vitae tempor ultrices, tellus nibh ultrices felis, sed mattis lorem est nec elit. Sed non euismod mauris, ut consectetur sem. Ut molestie aliquam nibh, sed ullamcorper sem ultricies ut. Quisque et leo eget est euismod laoreet quis et lectus. Sed pellentesque rhoncus mauris, id dapibus risus efficitur at. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean congue consectetur felis ac gravida. Aliquam feugiat elit in tortor consequat, eu vestibulum orci eleifend. Nullam bibendum fringilla nulla, eget vestibulum nibh suscipit sed.

                Mauris lacinia suscipit ex, non facilisis sem commodo et. Cras erat velit, volutpat a turpis ac, pellentesque iaculis risus. Nam purus enim, luctus vel dolor egestas, sagittis ornare arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Phasellus egestas vehicula nisl eget lobortis. Ut at pretium velit. Aenean maximus eros eu ligula cursus, sed facilisis nibh convallis. Suspendisse scelerisque feugiat diam sed ultricies. Praesent sit amet leo sit amet magna vestibulum malesuada nec eget est. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In augue tellus, suscipit et dui at, rhoncus dapibus nisi. In hac habitasse platea dictumst. Aenean vulputate at quam quis feugiat. Nunc in venenatis nisi, quis laoreet felis. Nullam hendrerit finibus libero, a tempor risus gravida eu. In non arcu et ante posuere eleifend in sit amet sem.""";

        String[] words = text.split(" ");
        Random random = new Random();
        String replace = "Java Lab 5";
        for (int i = 0; i < 20; i++) {
            File file = new File("./files/" + i + ".txt");
            try {
                if (file.createNewFile()) {
                    FileWriter writer = new FileWriter(file);
                    int numWords = random.nextInt(words.length);
                    for (int j = 0; j < numWords; j++) {
                        writer.write(words[random.nextInt(words.length)] + " ");
                    }
                    writer.close();
                    System.out.println("File created: " + file.getName());
                }
                if(file.exists()){
                    Scanner scanner = new Scanner(file);
                    StringBuilder fileContent = new StringBuilder();
                    while (scanner.hasNextLine()) {
                        fileContent.append(scanner.nextLine());
                    }
                    scanner.close();
                    String newContent = fileContent.toString().replaceAll("\\p{Punct}", replace);
                    FileWriter writer = new FileWriter(file);
                    writer.write(newContent);
                    writer.close();

                    System.out.println("File content replaced: " + file.getName());
                }

            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }
    }
}