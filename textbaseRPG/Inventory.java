import java.util.ArrayList;

public class Inventory {
    public static ArrayList<ArrayList<String>> weapon = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> potion = new ArrayList<ArrayList<String>>();

    public static void setInventory(int itemID, int quantity){
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

    public static void getweapon(){
        for (int i = 0; i < weapon.size(); i++){
        ArrayList<String> infoReceived = weapon.get(i);
        System.out.println(i + ". [" + infoReceived.get(1) + "]");
        
        }
    }

    public static void getpotion(){
        for (int i = 0; i < potion.size(); i++){
        ArrayList<String> infoReceived = potion.get(i);
        System.out.println(i + ". [" + infoReceived.get(1) + "] x" + infoReceived.get(6));
        
        }
    }
    
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

    public static void printPotion(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String potionName = infoReceived.get(1);
        String potionType = infoReceived.get(2);
        String potionHP = infoReceived.get(3);
        String potionMP = infoReceived.get(4);
        String potionDescription = infoReceived.get(5);
        String potionQuantity = infoReceived.get(6);
        System.out.println("___________Item info___________");
        System.out.println("Name:        " + potionName);
        System.out.println("Type:        " + potionType);
        System.out.println("HP:          " + potionHP);
        System.out.println("MP:          " + potionMP);
        System.out.println("Description: " + potionDescription);
        System.out.println("Quantity:    " + potionQuantity);
        System.out.println("_______________________________");
        System.out.println("");

    }
    
    
}
