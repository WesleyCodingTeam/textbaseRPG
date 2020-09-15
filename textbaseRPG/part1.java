public class Part1 {
    //intialize QuestGenerator
    static QuestGenerator quest1 = new QuestGenerator();
    public static void questFGame(){
        //dialogue part 1
        Character.currentPart = 1;
        Character.currentState = "idle";
        System.out.println();
        System.out.println("Part 1: All the Heroes do not go to Battle in the Beginning");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| You are now at the staircase of the guild building where the quest board stands.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| Do you want to see the quest? (y/n)");
        program read = new program();
        char ans = read.scanChar();
        while (ans == 'n'){
            System.out.println();
            System.out.println("Hey! You need to earn money!"); //revision required on the word
            System.out.println();
            program.waitingTime(2000);
            System.out.println("| Do you want to see the quest? (y/n)");
            ans = read.scanChar();
        }
        System.out.println();
        Guild.guildPage();
        System.out.println("- (Shouting) Hey, " + Character.name + "! Going gathering? I will teach you how to do it.");
        System.out.println();
        program.waitingTime(2000);
        //first help message
        Action.help();
        //charAction method in action.java
        Action.charAction();
    }
}
