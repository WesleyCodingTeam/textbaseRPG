// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        //need to implement equipment system
        Program.thingsToRunInBeginning();
        Program.testCharacterGeneration();
        MainCharacter.coin = 400;
        Inventory.setInventoryItem(4001, 50);
        Inventory.setInventoryItem(4002, 50);
        Action.charAction();
    }
}
