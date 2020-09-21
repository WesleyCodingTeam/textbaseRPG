// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        //Intro.introduction();
        //Part1 disabled for the test of item. Just activate it by removing //
        //Part1.questFGame();
        //buttom code is just for inventory testing
        
        ItemGen.itemGeneration();
        Inventory.setInventoryItem(3001, 3);
        Inventory.printSpecificPotion(0);
        System.out.println(ItemValue.getPotionHP(0));
        System.out.println(ItemValue.getPotionMP(0));
        System.out.println(ItemValue.getPotionName(0));
        System.out.println(ItemValue.getPotionQuantity(0));
        ItemValue.setPotionQuantity(0, 100);
        Inventory.printSpecificPotion(0);
        
        
        
    } 
}
