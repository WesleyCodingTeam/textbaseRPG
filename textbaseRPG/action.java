public class action {
    public static void charAction() {
        program read = new program();
        String action = read.scanString();
        
        if (action.equals("gather")){
            
        }
        else if (action.equals("shop")){
            
        }
        else if (action.equals("quest")){
        part1.quest1.questCheck(2);
        }
        else {
            System.out.println("Wrong command. Try again.");
            System.out.println(); 
        }
        
    }
}
