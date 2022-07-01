import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {


    public static List<Character> strToCharList(String s) {
        return s.chars().distinct().mapToObj(item->(char)item).collect(Collectors.toList());
    }
    public static Boolean correctAnswer(List<Character> answer, List<Character> guess) {
        Collections.sort(answer);
        Collections.sort(guess);
        return answer.equals(guess);
    }

    public static char getAnswer(List<Character> guessList){
        Scanner sc = new Scanner(System.in);
        char cValue = 0;
        try {
            System.out.println("Enter a single character: ");
            String input = sc.nextLine();

            if (input.length() != 1 || !input.matches("[[A-Z]a-z]")) {
                System.out.println("Invalid Entry");
            } else {
                cValue = input.charAt(0);
                if(guessList.contains(cValue)){
                    System.out.println("You have already guessed that letter!");
                }
                else{
                    guessList.add(cValue);
                }
            }
        }catch(Exception e){
            System.out.println("Failed to get user Input.");
        }
        return cValue;
    }

    public static String chooseWord() {
        String[] words = new String[]{"cat", "bat", "vat", "mat","bologna","cheese","blueberries","topaz",
                "abyss","frizzled","mnemonic","transcript","quizzes","whizzing"};
        Random rnd = new Random();
        int choice = rnd.nextInt(words.length);
        return words[choice];
    }

    public static void loseGameMessage(String correct){
        System.out.println("----------------");
        DataAccess.readFromDisplayFile(7);
        System.out.println("YOU LOSE! The correct word was: "+correct);
    }


}
