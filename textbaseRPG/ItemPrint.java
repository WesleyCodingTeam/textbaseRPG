import java.util.ArrayList;

public class ItemPrint extends Inventory{
    //prints item detail in the itemlist of the game
    public static void printItemState(int ID){
        ArrayList<String> infoReceived = ItemGen.itemList.get(ID);
        //for weapon
        if (ID >= 1000 && ID < 2000){
            String weaponID = infoReceived.get(WEAPONID);
            String weaponName = infoReceived.get(WEAPONNAME);
            String weaponType = infoReceived.get(WEAPONTYPE);
            String weaponDamage = infoReceived.get(WEAPONDAMAGE);
            String weaponDurability = infoReceived.get(WEAPONDURABILITY);
            String weaponSpecial = infoReceived.get(WEAPONSPECIAL);
            String weaponSpecialType = infoReceived.get(WEAPONSPECIALTYPE);
            String weaponDescription = infoReceived.get(WEAPONDESCRIPTION);
            String weaponState = infoReceived.get(WEAPONSTATE);
            System.out.println("___________Item info___________");
            System.out.println("ID:          " + weaponID);
            System.out.println("Name:        " + weaponName);
            System.out.println("Type:        " + weaponType);
            System.out.println("Damage:      " + weaponDamage);
            System.out.println("Durability:  " + weaponDurability);
            System.out.println("Special:     " + weaponSpecialType +" +"+ weaponSpecial);
            System.out.println("Description: " + weaponDescription);
            System.out.println("State:       " + weaponState);
            System.out.println("_______________________________");
            System.out.println("");
        }
        //for potion
        else if (ID >= 3000 && ID < 4000){
            String potionID = infoReceived.get(POTIONID);
            String potionName = infoReceived.get(POTIONNAME);
            String potionType = infoReceived.get(POTIONTYPE);
            String potionHP = infoReceived.get(POTIONDHP);
            String potionMP = infoReceived.get(POTIONMP);
            String potionDescription = infoReceived.get(POTIONDESCRIPTION);
            String potionQuantity = infoReceived.get(POTIONQUANTITY);
            System.out.println("___________Item info___________");
            System.out.println("ID:          " + potionID);
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
    //prints all the items in the itemlist
    public static void printItems(){
        for (int i = 0; i < 5000; i++) {
            if(ItemGen.itemList.containsKey(i)){
                ArrayList<String> infoReceived = ItemGen.itemList.get(i);
                System.out.println(infoReceived);
            }
        }
    }
}
