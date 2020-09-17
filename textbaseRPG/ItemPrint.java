import java.util.ArrayList;

public class ItemPrint{

    public static void printItemState(int ID){
        ArrayList<String> infoReceived = ItemGen.itemList.get(ID);
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

    public static void printItems(){
        for (int i = 0; i < 3000; i++) {
            if(ItemGen.itemList.containsKey(i)){
                ArrayList<String> infoReceived = ItemGen.itemList.get(i);
                System.out.println(infoReceived);
            }
        }
    }
}
