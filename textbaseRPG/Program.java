import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Program {
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
    //scanning a Character
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
        String word = sc.next();
        sc.nextLine();
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
    
    //deep copy of arraylist
    public static ArrayList<String> deepCopy(ArrayList<String> list){
        ArrayList<String> returnList = new ArrayList<String>();
        for(int i = 0; i< list.size();i++){
            String temp = list.get(i);
            returnList.add(temp);
        }
        return returnList;
    }
}