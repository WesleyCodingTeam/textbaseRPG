// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        //Intro.introduction();
        //Part1 disabled for the test of item. Just activate it by removing //
        //Part1.questFGame();
        //buttom code is just for inventory testing
        
        Items.itemGeneration();
        Inventory.setInventoryItem(1001, 1);
        Inventory.setInventoryItem(3001, 2);
        Inventory.equipItem(0, 1);
        Character.makeStats("Jaeyoung", "None", 1, 13, 100, 10, 10, 100, 100, 100, 100, 10);
        Monster.generateMonster();
        Battle.battleNow(101);
        
    } 
}
