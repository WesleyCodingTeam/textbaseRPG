import java.util.Random;
import java.util.Scanner;
public class program {
    public static void waitingTime(int t) {
        try {
            Thread.sleep(t);
        } 
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        };
    }

    public static int randomNum(int a, int b){
        Random rand = new Random();
        int out = rand.nextInt((b - a) + 1) + a;
        return out;
    }

    Scanner sc = new Scanner(System.in);
    
    public char scanChar() {
        char next = sc.next().charAt(0);
        sc.nextLine();
        return next;  
    }
    public String scanString() {
        String word = sc.next();
        sc.nextLine();
        return word;  
    }
    public int scanInt() {
        int num = sc.nextInt();
        sc.nextLine();
        return num;  
    }
    public void stop(){
        sc.close();
    }
}
