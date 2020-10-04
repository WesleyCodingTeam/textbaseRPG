public class Action {
    
    public static void charAction() {
        System.out.println("| What are you going to do right now?");
        System.out.print("> ");
        //initializing
        String action = Program.scanString();
        switch (action) {
            //trigers gathering action and this only applies to part 1
            case "gather":
                if (Character.currentPart == 1){
                    Part1.gatheringAction();
                }
                else {
                    System.out.println("- You are not weak!! You can earn money by fighting!");
                    System.out.println();
                    Program.waitingTime(2000);
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
            case "home":
                switch (Character.currentPart) {
                    case 1:
                        if (Part1.quest1.questState == false){
                            System.out.println("- Keep working, " + Character.name + ". You didn't finish your quest!");
                            System.out.println();
                            Program.waitingTime(2000);
                            charAction();
                    }
                        break;
                
                    default:
                        System.out.println("Code error guild action default");
                        charAction();
                        break;
                }
                break;
            //stat page
            case "stat":
                Character.statPage();
                charAction();
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


    //help message
    public static void help(){
        System.out.println("| You can gather woods and stones if you type 'gather'.");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| You also can sell item you obtained in the shop. Type 'shop' to go the the shop.");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| If you want to check your progress, type 'quest'.");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| If you completed the quest, type 'home' to get back to home.");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| If you want to see your stats, type 'stat' to see your stat.");
        System.out.println();
        Program.waitingTime(2000);
        System.out.println("| If you need help for commands, type 'help' to see this message again.");
        System.out.println();
        Program.waitingTime(2000);
    }
}
