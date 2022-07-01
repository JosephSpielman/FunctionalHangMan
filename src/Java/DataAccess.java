import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class DataAccess {

    static String displayFilePath = "src/Java/hangmanDisplay22.txt";
    static String scoreFilePath = "src/Java/scores.txt";

    public static void displayFileExists(){
        File filePath = new File(displayFilePath);
        if(!filePath.exists()){
            System.out.println("hangmanDisplay.txt file has been moved or deleted. Program will end.");
            System.exit(1);
        }
    }

    public static void createScoreFile(){
        File filePath = new File(scoreFilePath);
        if(!filePath.exists()){
            try{
                filePath.createNewFile();
                System.out.println("Score File has been created.");
        } catch (IOException e) {
                System.out.println("Unable to create score file.");
            }
        }
    }

    public static void updateScoreFile(String name,int score){
        String record = name+" "+score;
        try{
            Files.writeString(Path.of(scoreFilePath),record +System.lineSeparator(), StandardOpenOption.APPEND);
            System.out.println("File write successful");
        } catch (IOException e) {
            System.out.println("Unable to write to file");
            throw new RuntimeException(e);
        }
    }



    public static void readFromDisplayFile(int i){
        int skip = 0;
        int max = 0;
        switch(i){
            case 0:
                skip =1;
                max=6;
                break;
            case 1:
                skip =7;
                max=12;
                break;
            case 2:
                skip =13;
                max=18;
                break;
            case 3:
                skip =19;
                max=24;
                break;
            case 4:
                skip =25;
                max=30;
                break;
            case 5:
                skip =31;
                max=36;
                break;
            case 6:
                skip =37;
                max=42;
                break;
            default:
                skip=43;
                max=48;
        }
        try {
            Files.lines(Paths.get(displayFilePath)).skip(skip).limit(max-skip).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
