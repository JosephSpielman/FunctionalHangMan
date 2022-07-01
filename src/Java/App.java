
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = Game.chooseWord();
        String guess = "";
        List<Character> distinctLetters = Game.strToCharList(word);
        List<Character> guessList = Game.strToCharList(guess);
        boolean playing = true;
        int incorrectGuesses =0;

        System.out.println("--------HANG-MAN-------");
        while(!playing){

            DataAccess.readFromDisplayFile(incorrectGuesses);
            System.out.println();
            char input =Game.getAnswer(guessList);

            if(!distinctLetters.contains(input)) { incorrectGuesses++;}         }
            if(incorrectGuesses ==7){
                Game.loseGameMessage(word);
                playing = false;
        } else if(Game.correctAnswer(distinctLetters,guessList)) {
                System.out.println("-----------------------------!");
                System.out.println("YOU WIN! The correct word was: "+word);
                playing = false;
            }
    }

}
