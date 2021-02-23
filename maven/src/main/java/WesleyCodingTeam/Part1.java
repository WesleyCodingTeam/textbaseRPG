package WesleyCodingTeam;

public class Part1 {
    static boolean found = false;
    public static void questFGame(){
        //dialogue part 1
        MainCharacter.currentPart = 1;
        MainCharacter.currentState = "Idle";
        MainCharacter.currentLocation = "Town Square";
        System.out.println("Part 1: Coward's Alteration");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        Program.waitingTime(2000);
        Program.narrationDialogue("You wonder how to get to the guild.");
        Program.npcDialogue("Try type map to move around!");
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
            Inventory.setInventoryItem(4002, i);
        }
        //only getting stone
        else if (wood == false && stone == true){
            int j = Program.randomNum(5, 9);
            Inventory.setInventoryItem(4001, j);
        }
        //getting both wood and stone
        else if (wood == true && stone == true){
            int i = Program.randomNum(3, 6);
            int j = Program.randomNum(3, 6);
            Inventory.setInventoryItem(4002, i);
            Inventory.setInventoryItem(4001, j); 
        }
        //not getting anything
        else{
            Program.systemDialogue("You didn't get anything!");
        }
        //special action trigger
        if (Guild.questList.get(1001).questCheckCompletionBoolean() == true){
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
        Battle.battleNowTutorial(102);
        Story.storyOfHeroInTheBeginning();
    }
}