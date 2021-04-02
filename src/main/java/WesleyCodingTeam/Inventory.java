package WesleyCodingTeam;

import java.util.ArrayList;

public class Inventory {
    public static ArrayList<Weapon> weapon = new ArrayList<>(); //arraylist that stores weapons
    public static ArrayList<Potion> potion = new ArrayList<>(); //arraylist that stores potions
    public static ArrayList<OtherItem> otherItem = new ArrayList<>(); //arraylist that stores items
    //constant for weapon array order
    public static int currentEquipedWeapon = -1; //int value that shows what number(item ID) of Weapon is equipped. -1 if not equipped

    //put item in the inventory
    public static void setInventoryItem (int itemID, int quantity){
        //adding weapon
        Item item = Data.itemList.get(itemID);
        if (itemID >= 1000 && itemID < 2000){
            for (int i = 0; i < quantity; i++) {
                item.quantity = 1;
               weapon.add((Weapon) item.clone());
            }
            Program.systemDialogue("You got " + quantity + " " + item.name +"!");
        }
        //adding potion
        else if (itemID >= 3000 && itemID < 4000){
            if(!(potion.isEmpty())){
                boolean duplicateFound = false;
                for(Potion x:potion){
                    if(x.id == itemID){
                        duplicateFound = true;
                        x.quantity += quantity;
                    }
                }
                if(!duplicateFound){
                    item.quantity = quantity;
                    potion.add((Potion) item.clone());
                }
            }
            else {
                item.quantity = quantity;
                potion.add((Potion) item.clone());
            }
            Program.systemDialogue("You got " + quantity + " " + item.name+"!");
        }
        //other items
        else if(itemID >= 4000 && itemID < 5000){
            if(!(otherItem.isEmpty())){
                boolean duplicateFound = false;
                for(OtherItem x:otherItem){
                    if(x.id == itemID){
                        duplicateFound = true;
                        x.quantity += quantity;
                    }
                }
                if(!duplicateFound){
                    item.quantity = quantity;
                    otherItem.add((OtherItem) item.clone());
                }
            }
            else {
                item.quantity = quantity;
                otherItem.add((OtherItem) item.clone());
            }
            Program.systemDialogue("You got " + quantity + " " + item.name+"!");
        }
        else {
            Program.systemDialogue("Item to inventory error");
        }

    }
    //removes Item
    //return false if no item found or if size is too big
    public static boolean removeSpecificItem(int ID, int qty){
        //only can remove 1
        if (ID >= 1000 && ID < 2000) {
            boolean found = false;
            for(int x = 0;x<weapon.size();x++){
                if(ID == weapon.get(x).id){
                    weapon.remove(x);
                    found = true;
                    break;
                }
            }
            return found;
        }
        else if (ID >= 3000 && ID < 4000) {
            boolean found = false;
            for (Potion value : potion) {
                if (ID == value.id) {
                    found = true;
                    if (qty < value.quantity) {
                        value.quantity -= qty;
                    } else {
                        return false;
                    }
                    break;
                }
            }
            return found;
        }
        // other items
        else if (ID >= 4000 && ID < 5000) {
            boolean found = false;
            for (OtherItem item : otherItem) {
                if (ID == item.id) {
                    found = true;
                    if (qty < item.quantity) {
                        item.quantity -= qty;
                    } else {
                        return false;
                    }
                    break;
                }
            }
            return found;
        }
        return true;
    }
    //Current display of inventory
    public static void showInventory(){
        System.out.println("______________INVENTORY______________");
        System.out.println("");
        System.out.println("1. Weapons");
        System.out.println("");
        System.out.println("2. Armours");
        System.out.println("");
        System.out.println("3. Potions");
        System.out.println("");
        System.out.println("4. Other Items");
        System.out.println("");
        System.out.println("Type the number of category you want.");
        System.out.println("_____________________________________");
        int ans = Program.askInt();
        //choosing category
        switch (ans) {
            case 1:
                getWeapons();
                break;
            case 2:
                //armour not made yet
                break;
            case 3:
                getPotions();
                break;
            case 4:
                getOtherItem();
                break;

            default:
                break;
        }

    }

    //displaying weapons in inventory
    public static void getWeapons(){
        Program.systemDialogue("Are you going to equip weapon(y/n)");
        Program.systemDialogue("If no, then list of weapons will be printed");
        char answer = Program.askChar();
        for (int i = 0; i < weapon.size(); i++){
            System.out.println(i + ". [" + weapon.get(i).name + "]");
        }
        System.out.println("");
        if (weapon.isEmpty()){
            Program.systemDialogue("You do not have any item in this category.");
        }
        else {
            Program.systemDialogue("Choose the number of the weapon you want to select.");
            int ans = Program.askInt();
            if(ans < weapon.size()&&ans>=0){
                weapon.get(ans).printInfo();
                if(answer == 'y'){
                    Program.systemDialogue("Do you want to equip this weapon?(y/n)");
                    char a = Program.askChar();
                    if(a =='y'){
                        equipItem(ans,1);
                    }
                }
            }
        }

    }

    //displaying potions in inventory
    public static void getPotions(){
        Program.systemDialogue("Are you going to use potion(y/n)");
        Program.systemDialogue("If no, then list of potion will be printed");
        char answer = Program.askChar();
        for (int i = 0; i < potion.size(); i++){
            System.out.println(i + ". [" + potion.get(i).name + "] x" + potion.get(i).quantity);
        }
        System.out.println("");
        if (potion.isEmpty()){
            Program.systemDialogue("You do not have any item in this category.");
        }
        else {
            Program.systemDialogue("Choose the number of the potion you want to select.");
            int ans = Program.askInt();
            if(ans < potion.size()&&ans>=0){
                potion.get(ans).printInfo();
                if(answer == 'y'){
                    Program.systemDialogue("Do you want to use this potion?(y/n)");
                    char a = Program.askChar();
                    if(a =='y'){
                        usePotion(ans);
                    }
                    else{
                        if (MainCharacter.currentState.equals("Fighting")) {
                            Battle.battleStatus();
                        }
                    }
                }
            }
        }


    }
    //displaying items in inventory
    public static void getOtherItem(){
        for (int i = 0; i < otherItem.size(); i++){
            System.out.println(i + ". [" + otherItem.get(i).name + "] x" + otherItem.get(i).quantity);
        }
        System.out.println("");
        if (otherItem.isEmpty()){
            Program.systemDialogue("You do not have any item in this category.");
        }
        else {
            Program.systemDialogue("Choose the number of the item you want to select.");
            int ans = Program.askInt();
            if(ans < potion.size()&&ans>=0){
                otherItem.get(ans).printInfo();
            }
        }
    }

    //equips item in position itemEquipNum. itemType: 1= weapon, 2=armor
    public static void equipItem(int itemEquipNum, int itemType) {
        switch (itemType) {
            case 1:
                if(weapon.size()>itemEquipNum&&itemEquipNum>=0){
                    for(Weapon x: weapon){
                        x.equipped = false;
                    }
                    weapon.get(itemEquipNum).equipped = true;
                    Program.systemDialogue("[" + weapon.get(itemEquipNum).name + "] equipped.");
                }
                else{
                    Program.systemDialogue("Error on equipping");
                }
                break;
            case 2:
                //not yet made
                break;
            default:
                Program.systemDialogue("Error. Non-equip item.");
                break;
        }
    }
    //use potion
    public static void usePotion(int order) {
        Potion curr = potion.get(order);
        MainCharacter.healHP(curr.hp);
        Program.systemDialogue("You healed " + curr.hp + " HP!");
        MainCharacter.healMP(curr.mp);
        Program.systemDialogue("You healed " + curr.mp + " MP!");
        removeSpecificItem(curr.id,1);
    }
}
