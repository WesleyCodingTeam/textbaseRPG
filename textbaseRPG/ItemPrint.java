import java.util.ArrayList;

public class ItemPrint {

    public static void printItemState(int num){
        ArrayList<String> fileGotten = ItemGen.itemList.get(num);
        String itemName = fileGotten.get(0);
        String itemType = fileGotten.get(1);
        String itemDamage = fileGotten.get(2);
        String itemDurability = fileGotten.get(3);
        String itemQuantity = fileGotten.get(4);
        String itemSpecial = fileGotten.get(5);
        String itemDescription = fileGotten.get(6);
        System.out.println("___________Item info___________");
        System.out.println("Name:        " + itemName);
        System.out.println("Type:        " + itemType);
        System.out.println("Damage:      " + itemDamage);
        System.out.println("Durability:  " + itemDurability);
        System.out.println("Quantity:    " + itemQuantity);
        System.out.println("Special:     " + itemSpecial);
        System.out.println("Description: " + itemDescription);
        System.out.println("_______________________________");
        System.out.println("");

    }
}
