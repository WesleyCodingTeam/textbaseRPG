public class Action {
    static boolean found = false;
    public static void charAction() {
        System.out.println("| What are you going to do right now?");
        //initializing
        program read = new program();
        String action = read.scanString();
        switch (action) {
            //trigers gathering action and this only applies to part 1
            case "gather":
                if (Character.currentPart == 1){
                    gatheringAction();
                }
                else {
                    System.out.println("- You are not weak!! You can earn money by fighting!");
                    System.out.println();
                    program.waitingTime(2000);
                }
                charAction();
                break;
            //going shopping
            case "shop":
                Shop.shopPage(); 
                break;
            //check current status
            case "quest":
                questCheck();
                charAction();
                break;
            //check for new quest    
            case "guild":
                switch (Character.currentPart) {
                    case 1:
                        if (Part1.quest1.questState == false){
                            System.out.println("- Keep working, " + Character.name + ". You didn't finish your quest!");
                            System.out.println();
                            program.waitingTime(2000);
                            charAction();
                    }
                        break;
                
                    default:
                        System.out.println("Code error guild action default");
                        break;
                }
                break;
            //stat page
            case "stat":
                Character.statPage();
                break;
            //help message
            case "help":
                help();
                charAction(); 
                break;
            //when the user typed in wrong command
            default:
                System.out.println("| Wrong command. Try again. 'help' command suggested to look for the right command");
                System.out.println();
                charAction(); 
                break;
        }
        System.out.println();        
    }
    //checking guest based on parts
    public static void questCheck(){
        switch (Character.currentPart){
            case 1:
                Part1.quest1.questCheck();
                break;
        
            default:
                System.out.println("Code error questCheck default");
                break;
        }
    }


    //method for gathering action
    public static void gatheringAction(){
        System.out.println();
        System.out.print("| Gathering ");
        for (int i = 0; i <5; i++){
            System.out.print(".");
            program.waitingTime(300);
        }
        System.out.println();
        System.out.println();
        //probablity of gathering wood and stone
        boolean wood = program.percentProb(65);
        boolean stone = program.percentProb(40);
        //special action trigger
        if (Part1.quest1.currentNumDetail1 > 40 && Part1.quest1.currentNumDetail2 > 20 && found == false){
            gettingPower();
            found = true;
        }
        //only getting wood
        if (wood == true && stone == false){
            int i = program.randomNum(5, 9);
            System.out.println("| You got " + i + " wood!");
            Part1.quest1.currentNumDetail1 += i;
            
        }
        //only getting stone
        else if (wood == false && stone == true){
            int j = program.randomNum(5, 9);
            System.out.println("| You got " + j + " stone!");
            Part1.quest1.currentNumDetail2 += j;
        }
        //getting both wood and stone
        else if (wood == true && stone == true){
            int i = program.randomNum(3, 6);
            int j = program.randomNum(3, 6);
            Part1.quest1.currentNumDetail1 += i;
            Part1.quest1.currentNumDetail2 += j;
            System.out.println("| You got " + i + " wood and " + j + " stone!"); 
        }
        //not getting anything
        else{
            System.out.println("| You didn't get anything!");
        }
        System.out.println();
        program.waitingTime(2000);
        //check if quest was completed
        Part1.quest1.questCheckCompletion();
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

    //help message
    public static void help(){
        System.out.println("| You can gather woods and stones if you type 'gather'.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| You also can sell item you obtained in the shop. Type 'shop' to go the the shop.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| If you want to check your progress, type 'quest'.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| If you completed the quest, type 'guild' to get back to guild.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| If you want to see your stats, type 'stat' to see your stat.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| If you need help for commands, type 'help' to see this message again.");
        System.out.println();
        program.waitingTime(2000);
    }
}
