public class Part1 {
    static boolean found = false;
    public static void questFGame(){
        //dialogue part 1
        MainCharacter.currentPart = 1;
        MainCharacter.currentState = "idle";
        MainCharacter.currentLocation = "guild";
        System.out.println();
        System.out.println("Part 1: Coward's Alteration");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        Program.waitingTime(2000);
        Program.systemDialogue("You are now at the staircase of the guild building where the quest board stands.");
        Program.systemDialogue("See Quest Board? (y/n)");
        char ans = Program.askChar();
        while (ans != 'y'){
            Program.narrationDialogue("You think of your sister. You can't just go empty handed.");
            Program.systemDialogue("See Quest Board? (y/n)");
            ans = Program.askChar();
        }
        //need to direct to map!!@!!!!!
        Program.npcDialogue("Hey, " + MainCharacter.name + "! Going gathering again laddie?");
        Program.dialogue("Haha... yeah...");
        Program.npcDialogue("Ya remember how to gather 'em right?'");
        Program.dialogue("Uh...");
        Program.npcDialogue("No wonder yer sister calls you hopeless, arighty...");
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
        //only getting wood
        if (wood == true && stone == false){
            int i = Program.randomNum(5, 9);
            Program.systemDialogue("You got " + i + " wood!");
            quest1.currentNumDetail1 += i;
            Inventory.setInventoryItem(4002, i);
        }
        //only getting stone
        else if (wood == false && stone == true){
            int j = Program.randomNum(5, 9);
            Program.systemDialogue("You got " + j + " stone!");
            quest1.currentNumDetail2 += j;
            Inventory.setInventoryItem(4001, j);
        }
        //getting both wood and stone
        else if (wood == true && stone == true){
            int i = Program.randomNum(3, 6);
            int j = Program.randomNum(3, 6);
            quest1.currentNumDetail1 += i;
            quest1.currentNumDetail2 += j;
            System.out.println("| You got " + i + " wood and " + j + " stone!");
            Inventory.setInventoryItem(4002, i);
            Inventory.setInventoryItem(4001, j); 
        }
        //not getting anything
        else{
            Program.systemDialogue("You didn't get anything!");
        }
        //check if quest was completed
        quest1.questCheckCompletion();
        //special action trigger
        if (quest1.currentNumDetail1 >= 50 && quest1.currentNumDetail2 >= 20 && found == false){
            gettingPower();
            found = true;
        }
    }
    
    //dialogue when he is about to die and god comes
    public static void gettingPower(){
        Program.narrationDialogue("===Swish, Swish=== You hear the bushes around you shake.");
        Program.narrationDialogue("You hear disturbing growls");
        Program.narrationDialogue("You start to shake");
        Program.dialogue("Dire Wolves...");
        Program.dialogue("I've never fought a monster before...");
        Program.narrationDialogue("A Dire Wolf strikes!");
        System.out.println("" ); //edit reqired on dialogue
        Battle.battleNowTutorial(102);
        Part1half.play();
    }
}