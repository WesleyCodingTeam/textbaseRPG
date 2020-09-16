import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    public static HashMap<Integer, ArrayList<String>> inventory = new HashMap<Integer, ArrayList<String>>();
    public static Integer itemIndexNum = 0;

    public static void setInventory(int ID, int quantity){
        ArrayList<String> infoReceived = ItemGen.itemList.get(ID);
        for (int i = 0; i < quantity; i++) {
            while(inventory.get(itemIndexNum) != null){
                itemIndexNum++;
            }
            inventory.put(itemIndexNum, infoReceived);  
        }
        
    }

    public static void getInventory(){
        for (int i = 0; i < itemIndexNum + 1; i++){
        ArrayList<String> infoReceived = inventory.get(i);
        System.out.println(i + ". " + infoReceived.get(0));
        }
    }

    public static void printInventoryItem(int ID){
        ArrayList<String> infoReceived = inventory.get(ID);
        String itemName = infoReceived.get(0);
        String itemType = infoReceived.get(1);
        String itemDamage = infoReceived.get(2);
        String itemDurability = infoReceived.get(3);
        String itemSpecial = infoReceived.get(4);
        String itemDescription = infoReceived.get(5);
        System.out.println("___________Item info___________");
        System.out.println("Name:        " + itemName);
        System.out.println("Type:        " + itemType);
        System.out.println("Damage:      " + itemDamage);
        System.out.println("Durability:  " + itemDurability);
        System.out.println("Special:     " + itemSpecial);
        System.out.println("Description: " + itemDescription);
        System.out.println("_______________________________");
        System.out.println("");

    }
    
    
}
