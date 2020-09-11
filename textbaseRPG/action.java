public class action {
    static boolean found = false;
    public static void charAction() {
        System.out.println("| What are you going to do right now?");
        program read = new program();
        String action = read.scanString();
        
        if (action.equals("gather") && character.currentPart == 1){
            gatheringAction();
            charAction();
        }
        else if (action.equals("shop")){
            charAction();    
        }
        else if (action.equals("quest")){
            switch (character.currentPart){
                case 1:
                    part1.quest1.questCheck();
                    break;
            
                default:
                    break;
            }
            charAction();
        }
        else if (action.equals("guild")){
            if (part1.quest1.questState == false){
                System.out.println("- Keep working, " + character.name + ". You didn't finish your quest!");
                System.out.println();
                program.waitingTime(2000);
                charAction();
            }
        }
        else if (action.equals("help")){
            help();
            charAction();    
        }
        else {
            System.out.println("| Wrong command. Try again.");
            System.out.println(); 
        }
        System.out.println();
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
        boolean wood = program.percentProb(65);
        boolean stone = program.percentProb(40);
        if (part1.quest1.currentNumDetail1 > 40 && part1.quest1.currentNumDetail2 > 20 && found == false){
            System.out.println("Some sound of hitting a chest."); //edit reqired 
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            found = true;
        }
        if (wood == true && stone == false){
            int i = program.randomNum(1, 7);
            System.out.println("| You got " + i + " wood!");
            part1.quest1.currentNumDetail1 += i;
            
        }
        else if (wood == false && stone == true){
            int j = program.randomNum(1, 7);
            System.out.println("| You got " + j + " stone!");
            part1.quest1.currentNumDetail2 += j;
        }
        else if (wood == true && stone == true){
            int i = program.randomNum(1, 7);
            int j = program.randomNum(1, 7);
            part1.quest1.currentNumDetail1 += i;
            part1.quest1.currentNumDetail2 += j;
            System.out.println("| You got " + i + " wood and " + j + " stone!"); 
        }
        else{
            System.out.println("| You didn't get anything!");
        }
        System.out.println();
        program.waitingTime(2000);
        part1.quest1.questCheckCompletion();
    }

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
        System.out.println("| If you need help for commands, type 'help' to see this message again.");
        System.out.println();
        program.waitingTime(2000);
    }
}