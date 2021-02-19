import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    public static boolean shopStoryDone = false;
    public static HashMap<Integer, ShopStock> weaponStonks = new HashMap<Integer, ShopStock>();
    public static HashMap<Integer, ShopStock> potionStonks = new HashMap<Integer, ShopStock>();;
    public static HashMap<Integer, ShopStock> otherStonks = new HashMap<Integer, ShopStock>();;

    public static void shopInitialization(){
        //weapon
        weaponStonks.put(1001, new ShopStock(350, Items.itemList.get(1001), 1));
        weaponStonks.put(1002, new ShopStock(350, Items.itemList.get(1002), 1));
        weaponStonks.put(1003, new ShopStock(350, Items.itemList.get(1003), 1));
        //potion
        potionStonks.put(3001, new ShopStock(350, Items.itemList.get(3001), 5));
        potionStonks.put(3002, new ShopStock(100, Items.itemList.get(3002), 1));

    }

    public static void shopAsk(){
        if(Guild.guildStory2Done && !shopStoryDone){
            Story.shopTutorial();
            shopStoryDone = true;
        }
        Program.systemDialogue("Choose a shop! Jun's Weapon Shop (say \"weapon\") or Jon's Potion Shop (say \"potion\") Say \" exit \" to exit.");
        String askedShop = Program.askString();
        if (askedShop.equals("weapon")){
            weaponPage();
            weaponAsk();
        } 
        else if (askedShop.equals("potion")){
            potionPage();
            potionAsk();
        }
    }

    public static boolean availableChecker(int sellPrice, int itemQuantity){
        if (MainCharacter.coin < sellPrice){
            return false;
        }
        if (itemQuantity <= 0){
            return false;
        }
        return true;
    }

    //page print for list of items
    public static void weaponPage(){
        System.out.println();
        System.out.println("                                                  Weapons");
        System.out.println("Your current gold: " + MainCharacter.coin + "coins");
        System.out.println("______________________________________________________________________________________________________________________");
        System.out.println("|ID|Items                           |Price      |Description                                                         |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------|");
        int tempPrice = 0;
        int tempQuantity = 0;
        ArrayList<String> tempItem;
        for (int i = 1001; i <= 1003; i++){
            tempItem = weaponStonks.get(i).item;
            tempPrice = weaponStonks.get(i).price;
            tempQuantity = weaponStonks.get(i).quantity;
            System.out.println(Program.wordConsistence(3, "|" + (i)) + Program.wordConsistence(33, "|" + tempItem.get(Inventory.WEAPONNAME) + " x " + tempQuantity) + Program.wordConsistence(12, "|"+ tempPrice + "g") + Program.wordConsistence(69, "|" + tempItem.get(Inventory.WEAPONDESCRIPTION)) + "|");
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
    }

    public static void weaponAsk(){
        Program.systemDialogue("Which item would you like to buy? (Say the item ID!) If you don't want anything, say \"0\"!");
        int askedWeapon = Program.askInt();
        if (weaponStonks.containsKey(askedWeapon)){
            int Price = weaponStonks.get(askedWeapon).price;
            int Quantity = weaponStonks.get(askedWeapon).quantity;
            if (availableChecker(Price, Quantity) == false){
                Program.systemDialogue("Either stocks ran out or you ran out of gold!");   
                weaponAsk();
            } else{
                Items.setInventoryItem(askedWeapon, 1);
                weaponStonks.get(askedWeapon).quantity -= 1;
                MainCharacter.minusGold(Price);
                Program.systemDialogue("You purchased " + weaponStonks.get(askedWeapon).item.get(Inventory.WEAPONNAME) + "!");
                shopAsk();
            }
        }
        else {
            shopAsk();
        }
    }

    //page print for list of items
    public static void potionPage(){
        System.out.println();
        System.out.println("                                                  Potions");
        System.out.println("Your current gold: " + MainCharacter.coin + "coins");
        System.out.println("______________________________________________________________________________________________________________________");
        System.out.println("|ID|Items                           |Price      |Description                                                         |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------|");
        int tempPrice = 0;
        int tempQuantity = 0;
        ArrayList<String> tempItem;
        for (int i = 3001; i <= 3002; i++){
            tempItem = potionStonks.get(i).item;
            tempPrice = potionStonks.get(i).price;
            tempQuantity = potionStonks.get(i).quantity;
            System.out.println(Program.wordConsistence(3, "|" + (i)) + Program.wordConsistence(33, "|" + tempItem.get(Inventory.POTIONNAME) + " x " + tempQuantity) + Program.wordConsistence(12, "|"+ tempPrice + "g") + Program.wordConsistence(69, "|" + tempItem.get(Inventory.POTIONDESCRIPTION)) + "|");
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
    }

    public static void potionAsk(){
        Program.systemDialogue("Which item would you like to buy? (Say the item ID!) If you don't want anything, say \"0\"!");
        int askedPotion = Program.askInt();
        if (potionStonks.containsKey(askedPotion)){
            int Price = potionStonks.get(askedPotion).price;
            int Quantity = potionStonks.get(askedPotion).quantity;
            if (availableChecker(Price, Quantity) == false){
                Program.systemDialogue("Either stocks ran out or you ran out of gold!");
                potionAsk();
            } else{
                Items.setInventoryItem(askedPotion, 1);
                potionStonks.get(askedPotion).quantity -= 1;
                MainCharacter.minusGold(Price);
                Program.systemDialogue("You purchased " + potionStonks.get(askedPotion).item.get(Inventory.POTIONNAME) + "!");
                shopAsk();
            }
        }
        else {
            shopAsk();
        }
    }

}