public class Action {
    
    public static void charAction() {
        Program.systemDialogue("What are you going to do right now?");
        String action = Program.askString();
        switch (action) {
            //trigers gathering action and this only applies to part 1
            case "gather":
                if (MainCharacter.currentPart == 1){
                    Part1.gatheringAction();
                }
                else {
                    Program.dialogue("I am not weak!! I now can earn money by fighting!");
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
                switch (MainCharacter.currentPart) {
                    case 1:
                        if (Part1.quest1.questState == false){
                            Program.dialogue("Keep working, " + MainCharacter.name + ". You didn't finish your quest!");
                            charAction();
                    }
                        break;
                
                    default:
                        Program.systemDialogue("Code error guild action default.");
                        charAction();
                        break;
                }
                break;
            //stat page
            case "stat":
                MainCharacter.statPage();
                charAction();
                break;
            //help message
            case "help":
                help();
                charAction(); 
                break;
            case "inventory":
                Inventory.showInventory();
                break;
            //when the user typed in wrong command
            default:
                Program.systemDialogue("Wrong command. Try again. 'help' command suggested to look for the right command");
                charAction(); 
                break;
        }      
    }
    //checking guest based on parts
    public static void questCheck(){
        switch (MainCharacter.currentPart){
            case 1:
                Part1.quest1.questCheck();
                break;
        
            default:
                Program.systemDialogue("Code error questCheck default");
                break;
        }
    }
    //help message
    public static void help(){
        Program.systemDialogue("You can gather woods and stones if you type 'gather'.");
        Program.systemDialogue("You also can sell item you obtained in the shop. Type 'shop' to go the the shop.");
        Program.systemDialogue("If you want to check your progress, type 'quest'.");
        Program.systemDialogue("If you completed the quest, type 'home' to get back to home.");
        Program.systemDialogue("If you want to see your stats, type 'stat' to see your stat.");
        Program.systemDialogue("If you need help for commands, type 'help' to see this message again.");
    }
}
