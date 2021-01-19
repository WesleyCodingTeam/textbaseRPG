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
                break;
            //check current status
            case "quest":
                MainCharacter.myQuests();;
                break;
            //check for new quest    
            case "map":
                Map.moveUI();
                break;
            //stat page
            case "stat":
                MainCharacter.statPage();
                break;
            //help message
            case "help":
                help();
                break;
            case "inventory":
                Inventory.showInventory();
                break;
            //when the user typed in wrong command
            default:
                Program.systemDialogue("Wrong command. Try again. 'help' command suggested to look for the right command");
                break;
        }
        charAction();      
    }
    //help message
    public static void help(){
        Program.systemDialogue("You can gather woods and stones if you type 'gather'.");
        Program.systemDialogue("You also can sell item you obtained in the shop. Type 'shop' to go the the shop.");
        Program.systemDialogue("If you want to check your progress, type 'quest'.");
        Program.systemDialogue("If you want to  move to somewhere, type 'move' to go wherever you want.");
        Program.systemDialogue("If you want to see your stats, type 'stat' to see your stat.");
        Program.systemDialogue("If you need help for commands, type 'help' to see this message again.");
    }
}
