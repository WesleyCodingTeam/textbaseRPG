// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        //intro currrently disabled for testing of part 1
        //Intro.introduction();
        //Part1 disabled for the test of item. Just activate it by removing //
        //Part1.questFGame();
        ItemGen.itemGeneration();
        Inventory.setInventory(1003, 1);
        Inventory.setInventory(3001, 1);
        Inventory.setInventory(3002, 2);
        Inventory.setInventory(3001, 3);
        Inventory.setInventory(1001, 3);
        Inventory.setInventory(3002, 5);
        Inventory.getweapon();
        Inventory.getpotion();
    } 
}
