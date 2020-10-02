public class Part1 {
    //intialize QuestGenerator
    static QuestGenerator quest1 = new QuestGenerator();
    static boolean found = false;
    public static void questFGame(){
        //dialogue part 1
        Character.currentPart = 1;
        Character.currentState = "idle";
        System.out.println();
        System.out.println("Part 1: All the Heroes do not go to Battle in the Beginning");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| You are now at the staircase of the guild building where the quest board stands.");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| Do you want to see the quest? (y/n)");
        System.out.print("> ");
        char ans = Program.scanChar();
        while (ans == 'n'){
            System.out.println();
            System.out.println("Hey! You need to earn money!"); //revision required on the word
            System.out.println(); 
            Program.waitingTime(2000);
            System.out.println("| Do you want to see the quest? (y/n)");
            System.out.print("> ");
            ans = Program.scanChar();
        }
        System.out.println();
        Guild.guildPage();
        System.out.println("- (Shouting) Hey, " + Character.name + "! Going gathering? I will teach you how to do it.");
        System.out.println();
        Program.waitingTime(2000);
        //first help message
        Action.help();
        //charAction method in action.java
        Action.charAction();
    }

    //method for gathering action
    public static void gatheringAction(){
        System.out.println();
        System.out.print("| Gathering ");
        for (int i = 0; i <5; i++){
            System.out.print(".");
            Program.waitingTime(300);
        }
        System.out.println();
        System.out.println();
        //probablity of gathering wood and stone
        boolean wood = Program.percentProb(65);
        boolean stone = Program.percentProb(40);
        //special action trigger
        if (quest1.currentNumDetail1 > 40 && quest1.currentNumDetail2 > 20 && found == false){
            gettingPower();
            found = true;
        }
        //only getting wood
        if (wood == true && stone == false){
            int i = Program.randomNum(5, 9);
            System.out.println("| You got " + i + " wood!");
            quest1.currentNumDetail1 += i;
            
        }
        //only getting stone
        else if (wood == false && stone == true){
            int j = Program.randomNum(5, 9);
            System.out.println("| You got " + j + " stone!");
            quest1.currentNumDetail2 += j;
        }
        //getting both wood and stone
        else if (wood == true && stone == true){
            int i = Program.randomNum(3, 6);
            int j = Program.randomNum(3, 6);
            quest1.currentNumDetail1 += i;
            quest1.currentNumDetail2 += j;
            System.out.println("| You got " + i + " wood and " + j + " stone!"); 
        }
        //not getting anything
        else{
            System.out.println("| You didn't get anything!");
        }
        System.out.println();
        Program.waitingTime(2000);
        //check if quest was completed
        quest1.questCheckCompletion();
    }
    
    //dialogue when he is about to die and god comes
    public static void gettingPower(){
        System.out.println("Some sound of hitting a chest."); //edit reqired on dialogue
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
    }
}
