package WesleyCodingTeam;

import java.util.ArrayList;
import java.util.Random;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class Program {
    private static int dialogueSpeed;
    public static TextIO textIO = TextIoFactory.getTextIO();
    public static TextTerminal terminal = textIO.getTextTerminal();
    //initialization. Things that needs to be ran in the beginning
    public static void thingsToRunInBeginning(){
        Data.initialization();
        Map.generateMap();
        Guild.questIntitialization();
        Shop.shopInitialization();
        setDialogueSpeed(20);
    }
    //dialogue style
    public static void dialogue(String dialogue){

        for(int i = 0; i < dialogue.length(); i++){
            Program.terminal.print(dialogue.substring(i, i+1));
            waitingTime(dialogueSpeed);
        }
        Program.terminal.println("");
        Program.terminal.println("");
        waitingTime(400);
    }
    //NPC dialogue
    public static void npcDialogue(String dialogues) {
        Program.terminal.print("- ");
        dialogue(dialogues);
    }
    //system dialogue
    public static void systemDialogue(String dialogues) {
        Program.terminal.print("| ");
        dialogue(dialogues);
    }
    //narration dialogue
    public static void narrationDialogue(String dialogues) {
        Program.terminal.print("-- ");
        dialogue(dialogues);
    }
    //set dialogue speed
    public static void setDialogueSpeed(int speed){
        dialogueSpeed = speed;
    }
    //make arbitrary character for testing
    public static void testCharacterGeneration(){
        MainCharacter.makeStats("Jaeyoung", "None", 1, 13, 10, 11, 11, 100, 100, 100, 100, 10000);
        MainCharacter.currentLocation = "Your House";
        MainCharacter.currentPart = 1;
        MainCharacter.currentState = "Idle";
    }
    //makes the Program stops for a while for amount t. 1 second is t = 1000
    public static void waitingTime(int t) {
        try {
            Thread.sleep(t);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    //returns number greater than equal to a and less than equal to b
    public static int randomNum(int a, int b){
        Random rand = new Random();
        return rand.nextInt((b - a) + 1) + a;
    }

    //input a% and results in true or false based on the probablity
    public static boolean percentProb(int a) {
        boolean i = false;
        Random rand = new Random();
        int result = rand.nextInt(100) + 1;
        if (a > 100){
            Program.terminal.println("Error. Probablity can't be greater than 100%");
        }
        else if (a < 0){
            Program.terminal.println("Error. Probablity can't be less than 0%");
        }
        else i = result <= a;
        return i;
    }
    //deep copy of arraylist
    public static ArrayList<String> deepCopy(ArrayList<String> list){
        return new ArrayList<>(list);
    }

    //adding consitent space
    public static String wordConsistence(int lengths, String content){
        String result = content;
        int space = lengths - content.length();
        for(int i = 0; i < space; i++){
            result += " ";
        }
        return result;
    }
    public static char askChar(){
        return Character.toLowerCase(Program.textIO.newCharInputReader().read("> "));
    }
    public static int askInt(){
        return Program.textIO.newIntInputReader().read("> ");
    }
    public static String askString(){
        return Program.textIO.newStringInputReader().read("> ").toLowerCase();
    }


}
