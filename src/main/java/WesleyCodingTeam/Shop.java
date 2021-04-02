package WesleyCodingTeam;

import java.util.HashMap;

public class Shop {
    public static boolean shopStoryDone = false;
    public static HashMap<Integer, ShopStock> weaponStocks = new HashMap<>();
    public static HashMap<Integer, ShopStock> potionStocks = new HashMap<>();
    public static HashMap<Integer, ShopStock> otherStocks = new HashMap<>();

    public static void shopInitialization(){
        //weapon
        weaponStocks.put(1001, new ShopStock(Data.itemList.get(1001), 1));
        weaponStocks.put(1002, new ShopStock(Data.itemList.get(1002), 1));
        weaponStocks.put(1003, new ShopStock(Data.itemList.get(1003), 1));
        //potion
        potionStocks.put(3001, new ShopStock(Data.itemList.get(3001), 5));
        potionStocks.put(3002, new ShopStock(Data.itemList.get(3002), 1));

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
        return itemQuantity > 0;
    }

    //page print for list of items
    public static void weaponPage(){
        System.out.println();
        System.out.println("                                                  Weapons");
        System.out.println("Your current gold: " + MainCharacter.coin + "coins");
        System.out.println("______________________________________________________________________________________________________________________");
        System.out.println("|ID|Items                           |Price      |Description                                                         |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------|");
        int tempPrice;
        int tempQuantity;
        Weapon tempItem;
        for (int i = 1001; i <= 1003; i++){
            tempItem = (Weapon) weaponStocks.get(i).item;
            tempPrice = weaponStocks.get(i).price;
            tempQuantity = weaponStocks.get(i).quantity;
            System.out.println(Program.wordConsistence(3, "|" + (i)) + Program.wordConsistence(33, "|" + tempItem.name + " x " + tempQuantity) + Program.wordConsistence(12, "|"+ tempPrice + "g") + Program.wordConsistence(69, "|" + tempItem.description + "|"));
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
    }

    public static void weaponAsk(){
        Program.systemDialogue("Which item would you like to buy? (Say the item ID!) If you don't want anything, say \"0\"!");
        int askedWeapon = Program.askInt();
        if (weaponStocks.containsKey(askedWeapon)){
            int Price = weaponStocks.get(askedWeapon).price;
            int Quantity = weaponStocks.get(askedWeapon).quantity;
            if (!availableChecker(Price, Quantity)){
                Program.systemDialogue("Either stocks ran out or you ran out of gold!");
                weaponAsk();
            } else{
                Inventory.setInventoryItem(askedWeapon, 1);
                weaponStocks.get(askedWeapon).quantity -= 1;
                MainCharacter.minusGold(Price);
                Program.systemDialogue("You purchased " + weaponStocks.get(askedWeapon).item.name + "!");
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
        int tempPrice;
        int tempQuantity;
        Potion tempItem;
        for (int i = 3001; i <= 3002; i++){
            tempItem = (Potion) potionStocks.get(i).item;
            tempPrice = potionStocks.get(i).price;
            tempQuantity = potionStocks.get(i).quantity;
            System.out.println(Program.wordConsistence(3, "|" + (i)) + Program.wordConsistence(33, "|" + tempItem.name + " x " + tempQuantity) + Program.wordConsistence(12, "|"+ tempPrice + "g") + Program.wordConsistence(69, "|" + tempItem.description + "|"));
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
    }

    public static void potionAsk(){
        Program.systemDialogue("Which item would you like to buy? (Say the item ID!) If you don't want anything, say \"0\"!");
        int askedPotion = Program.askInt();
        if (potionStocks.containsKey(askedPotion)){
            int Price = potionStocks.get(askedPotion).price;
            int Quantity = potionStocks.get(askedPotion).quantity;
            if (!availableChecker(Price, Quantity)){
                Program.systemDialogue("Either stocks ran out or you ran out of gold!");
                potionAsk();
            } else{
                Inventory.setInventoryItem(askedPotion, 1);
                potionStocks.get(askedPotion).quantity -= 1;
                MainCharacter.minusGold(Price);
                Program.systemDialogue("You purchased " + potionStocks.get(askedPotion).item.name + "!");
                shopAsk();
            }
        }
        else {
            shopAsk();
        }
    }

}
