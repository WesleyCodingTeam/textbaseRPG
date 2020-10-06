public class Part1 {
    //intialize QuestGenerator
    static QuestGenerator quest1 = new QuestGenerator();
    static boolean found = false;
    public static void questFGame(){
        //dialogue part 1
        Character.currentPart = 1;
        Character.currentState = "idle";
        System.out.println();
        System.out.println("Part 1: Coward's Alteration");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("-- You are now at the staircase of the guild building where the quest board stands. --");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| See Quest Board? (y/n)");
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
        System.out.println("- Hey, " + Character.name + "! Going gathering again laddie?");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println(" Haha... yeah...");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("- Ya remember how to get gather 'em right?'");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println(" Uh...");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println(" No wonder yer sister calls you hopeless, arighty...");
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
        System.out.println("===Swish, Swish=== You hear the bushes around you shake." ); //edit reqired on dialogue
            System.out.println();
            System.out.println();
            Program.waitingTime(1000);
            System.out.println();
            System.out.println("-- You hear disturbing growls --");
            System.out.println();
            System.out.println();
            Program.waitingTime(2000);
            System.out.println("Dire Wolves... ");
            System.out.println();
            Program.waitingTime(2000);
            System.out.println("-- You start to shake --");
            System.out.println();
            Program.waitingTime(2000);
            System.out.println("I've never fought a monster before...");
            System.out.println();
            Program.waitingTime(2000);
            System.out.println("-- A Dire Wolve strikes! --");
            System.out.println();
            Program.waitingTime(2000);
            Battle.battleNow(101);


    }
}

