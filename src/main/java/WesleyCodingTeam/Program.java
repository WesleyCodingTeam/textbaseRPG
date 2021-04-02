package WesleyCodingTeam;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Program {
    private static int dialogueSpeed;
    //initialization. Things that needs to be ran in the beginning
    public static void thingsToRunInBeginning(){
        Data.generateItem();
        Data.generateField();
        Data.generateMonster();
        Map.generateMap();
        Guild.questIntitialization();
        Shop.shopInitialization();
        setDialogueSpeed(20);
    }
    //dialogue style
    public static void dialogue(String dialogue){
        for(int i = 0; i < dialogue.length(); i++){
            System.out.print(dialogue.substring(i, i+1));
            waitingTime(dialogueSpeed);
        }
        System.out.println("");
        System.out.println("");
        waitingTime(400);
    }
    //NPC dialogue
    public static void npcDialogue(String dialogues) {
        System.out.print("- ");
        dialogue(dialogues);
    }
    //system dialogue
    public static void systemDialogue(String dialogues) {
        System.out.print("| ");
        dialogue(dialogues);
    }
    //narration dialogue
    public static void narrationDialogue(String dialogues) {
        System.out.print("-- ");
        dialogue(dialogues);
    }
    //set dialogue speed
    public static void setDialogueSpeed(int speed){
        dialogueSpeed = speed;
    }
    //make arbitrary character for testing
    public static void testCharacterGeneration(){
        MainCharacter.makeStats("Jaeyoung", "None", 1, 13, 50, 11, 11, 100, 100, 100, 100, 10000);
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
        int out = rand.nextInt((b - a) + 1) + a;
        return out;
    }

    //input a% and results in true or false based on the probablity
    public static boolean percentProb(int a) {
        boolean i = false;
        Random rand = new Random();
        int result = rand.nextInt(100) + 1;
        if (a > 100){
            System.out.println("Error. Probablity can't be greater than 100%");
        }
        else if (a < 0){
            System.out.println("Error. Probablity can't be less than 0%");
        }
        else if (result <= a ){
            i = true;
        }
        else if (!(result <= a)){
            i = false;
        }
        return i;
    }

    static Scanner sc = new Scanner(System.in);
    //scanning a MainCharacter
    public static char scanChar() {
        char next = '\0';
        boolean state = false;
        while (!state){
            try {
                next = sc.next().charAt(0);
                sc.nextLine();
                state = true;
            } catch (Exception e) {
                System.out.println("Wrong input type. Try again.");
                sc.nextLine();
                state = false;
                System.out.print("> ");
            }
        }
        return next;
    }
    //scanning a string
    public static String scanString() {
        String word = sc.nextLine();
        word = word.toLowerCase();
        return word;
    }
    //scanning an integer
    public static int scanInt() {
        int num = 0;
        boolean state = false;
        while (!state){
            try {
                num = sc.nextInt();
                sc.nextLine();
                state = true;

            } catch (Exception e) {
                System.out.println("Wrong input type. Try again.");
                sc.nextLine();
                state = false;
                System.out.print("> ");
            }
        }
        return num;
    }
    //just Program needed for scanner. NOT ACTUALLY USED
    public static void stop(){
        sc.close();
    }
    //asking for return of String (scanning)
    public static String askString(){
        System.out.print("> ");
        String ans = Program.scanString();
        ans = ans.toLowerCase();
        System.out.println();
        return ans;
    }
    //asking for return of char (scanning)
    public static char askChar(){
        System.out.print("> ");
        char ans = Program.scanChar();
        ans = Character.toLowerCase(ans);
        System.out.println();
        return ans;
    }
    //asking for return of char (scanning)
    public static int askInt(){
        System.out.print("> ");
        int ans = Program.scanInt();
        System.out.println();
        return ans;
    }
    //deep copy of arraylist
    public static ArrayList<String> deepCopy(ArrayList<String> list){
        ArrayList<String> returnList = new ArrayList<String>();
        for(int i = 0; i< list.size();i++){
            String temp = list.get(i);
            returnList.add(temp);
        }
        return returnList;
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

}
