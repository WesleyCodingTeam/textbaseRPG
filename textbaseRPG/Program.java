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
        };
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

    Scanner sc = new Scanner(System.in);
    //scanning a Character
    public char scanChar() {
        char next = sc.next().charAt(0);
        sc.nextLine();
        return next;  
    }
    //scanning a string
    public String scanString() {
        String word = sc.next();
        sc.nextLine();
        return word;  
    }
    //scanning an integer
    public int scanInt() {
        int num = sc.nextInt();
        sc.nextLine();
        return num;  
    }
    //just Program needed for scanner. NOT ACTUALLY USED
    public void stop(){
        sc.close();
    }
}
