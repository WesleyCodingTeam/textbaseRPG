import java.util.ArrayList;

public class Inventory {
    public static ArrayList<ArrayList<String>> weapon = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> potion = new ArrayList<ArrayList<String>>();
    //put item in the inventory
    public static void setInventoryItem(int itemID, int quantity){
        ArrayList<String> infoReceived = ItemGen.itemList.get(itemID);
        //adding weapon
        if (itemID >= 1000 && itemID < 2000){
            for (int i = 0; i < quantity; i++) {
               weapon.add(infoReceived);  
            }   
            }
        //adding armour
        else if (itemID >= 2000 && itemID < 3000){

        }
        //adding potion
        else if (itemID >= 3000 && itemID < 4000){
            for (int i = 0; i < quantity; i++) {
                if(!(potion.isEmpty())){
                    boolean hasSame = false;
                    int sameLocation = -1;
                    int size = infoReceived.size() - 1;
                    int a = 0;
                    while (hasSame == false && a < potion.size()){
                        ArrayList<String> copy = potion.get(a);
                        String original = infoReceived.get(0);
                        String copied = copy.get(0);
                        hasSame = original.equals(copied);
                        if (hasSame == true){
                            sameLocation = a;
                        }
                        a++;
                    }    
                    if (hasSame == true){
                        ArrayList<String> copy = potion.get(sameLocation);
                        String k = copy.get(size);
                        int j = Integer.parseInt(k);
                        j++;
                        copy.set(size, Integer.toString(j));
                        potion.set(sameLocation, copy);
                    }
                    else if (hasSame == false){
                        potion.add(infoReceived);
                    }
                    else {
                        System.out.println("Error while stacking items.");
                    }
                    
                }
                else if (potion.isEmpty()){
                    potion.add(infoReceived);
                }
            }
        }
        else {
            System.out.println("Item to inventory error");
        }
        
    }

    //returns boolean if the player has the item. Can be used for stackable items
    public static boolean haveItem(int ID){
        boolean haveItem = false;
        if(haveItemNum(ID) == -1){
            haveItem = false;
        }
        else if(haveItemNum(ID) != -1) {
            haveItem = true;
        }
        return haveItem;
    }

    //Search for the order number of item if it is present in the inventory
    //otherwise returns a value of -1
    //remember that this does not work for non-stackable items
    public static int haveItemNum(int ID){
        String iDString = Integer.toString(ID);
        int haveItemNum = -1;
        //for weapon
        if(ID >= 1000 && ID < 2000){
            for(int i = 0; i < weapon.size();i++){
                ArrayList<String> copy = weapon.get(i);
                String copiedID = copy.get(0);
                if(copiedID.equals(iDString)){
                    haveItemNum = i;
                }
            }
            System.out.println("Error. Can't use haveItemNum method for non-stackable item");
        }
        //for armour
        else if(ID >= 2000 && ID < 3000){

        }
        //for potion
        else if(ID >= 3000 && ID < 4000){
            for(int i = 0; i < potion.size();i++){
                ArrayList<String> copy = potion.get(i);
                String copiedID = copy.get(0);
                if(copiedID.equals(iDString)){
                    haveItemNum = i;
                }
            }
        }
        return haveItemNum;
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
        System.out.println("Type the number of category you want.");
        System.out.println("_____________________________________");
        Program read = new Program();
        int ans = read.scanInt();
        System.out.println("");
        //chosing category
        switch (ans) {
            case 1:
                getweapon();
                break;    
            case 2:
                
                break;
            case 3:
                getpotion();
                break;
        
            default:
                break;
        }
        
    }

    //displaying weapons in inventory
    public static void getweapon(){
        for (int i = 0; i < weapon.size(); i++){
        ArrayList<String> infoReceived = weapon.get(i);
        System.out.println(i + ". [" + infoReceived.get(1) + "]");
        }
        System.out.println("");
        if (weapon.isEmpty()){
            System.out.println("You do not have any item in this category.");
        }
        else if (!(weapon.isEmpty())){
            System.out.println("Choose the number of the weapon you want to select.");
            Program read = new Program();
            int ans = read.scanInt();
            System.out.println("");
            printWeapon(ans);
        }
    }

    //displaying potions in inventory
    public static void getpotion(){
        for (int i = 0; i < potion.size(); i++){
        ArrayList<String> infoReceived = potion.get(i);
        System.out.println(i + ". [" + infoReceived.get(1) + "] x" + infoReceived.get(6));
        }
        System.out.println("");
        if (potion.isEmpty()){
            System.out.println("You do not have any item in this category.");
        }
        else if (!(potion.isEmpty())){
            System.out.println("Choose the number of the potion you want to select.");
            Program read = new Program();
            int ans = read.scanInt();
            System.out.println("");
            printPotion(ans);
        }
    }
    //print specific weapon detail based on the order number in arraylist
    public static void printWeapon(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String weaponName = infoReceived.get(1);
        String weaponType = infoReceived.get(2);
        String weaponDamage = infoReceived.get(3);
        String weaponDurability = infoReceived.get(4);
        String weaponSpecial = infoReceived.get(5);
        String weaponDescription = infoReceived.get(6);
        System.out.println("___________Item info___________");
        System.out.println("Name:        " + weaponName);
        System.out.println("Type:        " + weaponType);
        System.out.println("Damage:      " + weaponDamage);
        System.out.println("Durability:  " + weaponDurability);
        System.out.println("Special:     " + weaponSpecial);
        System.out.println("Description: " + weaponDescription);
        System.out.println("_______________________________");
        System.out.println("");

    }
    //print specific potion detail based on the order number in arraylist
    public static void printPotion(int inventoryItemID){
        ArrayList<String> infoReceived = potion.get(inventoryItemID);
        String potionName = infoReceived.get(1);
        String potionType = infoReceived.get(2);
        String potionHP = infoReceived.get(3);
        String potionMP = infoReceived.get(4);
        String potionDescription = infoReceived.get(5);
        String potionQuantity = infoReceived.get(6);
        System.out.println("___________Item info___________");
        System.out.println("Name:        " + potionName);
        System.out.println("Type:        " + potionType);
        System.out.println("+ HP:        " + potionHP);
        System.out.println("+ MP:        " + potionMP);
        System.out.println("Description: " + potionDescription);
        System.out.println("Quantity:    " + potionQuantity);
        System.out.println("_______________________________");
        System.out.println("");

    }
    
    
}
