import java.util.ArrayList;

public class ItemPrint{
    //prints item detail in the itemlist of the game
    public static void printItemState(int ID){
        ArrayList<String> infoReceived = ItemGen.itemList.get(ID);
        //for weapon
        if (ID >= 1000 && ID < 2000){
            String itemName = infoReceived.get(0);
            String itemRank = infoReceived.get(1);
            String itemType = infoReceived.get(2);
            String itemDamage = infoReceived.get(3);
            String itemDurability = infoReceived.get(4);
            String itemSpecial = infoReceived.get(5);
            String itemDescription = infoReceived.get(6);
            System.out.println("___________Item info___________");
            System.out.println("Name:        " + itemName);
            System.out.println("Rank:        " + itemRank);
            System.out.println("Type:        " + itemType);
            System.out.println("Damage:      " + itemDamage);
            System.out.println("Durability:  " + itemDurability);
            System.out.println("Special:     " + itemSpecial);
            System.out.println("Description: " + itemDescription);
            System.out.println("_______________________________");
            System.out.println("");
        }
        //for potion
        else if (ID >= 3000 && ID < 4000){
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
    //pprints all the items in the itemlist
    public static void printItems(){
        for (int i = 0; i < 5000; i++) {
            if(ItemGen.itemList.containsKey(i)){
                ArrayList<String> infoReceived = ItemGen.itemList.get(i);
                System.out.println(infoReceived);
            }
        }
    }
}
