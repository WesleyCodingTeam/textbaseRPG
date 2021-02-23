package WesleyCodingTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Items extends Inventory{
    //initializing hashmap
    public static HashMap<Integer, ArrayList<String>> itemList = new HashMap<Integer, ArrayList<String>>();
    //itnitalizing item details to the hashmap
    public static void itemGeneration() {
    //starting to set weapons  
    ArrayList<String> ID1001 = new ArrayList<String>();
    ID1001.addAll(Arrays.asList("1001", "Basic Sword", "Normal", "10", "100", "100","1", "Strength","Can't even touch a goblin with this!","Unequiped"));
    ArrayList<String> ID1002 = new ArrayList<String>();
    ID1002.addAll(Arrays.asList("1002","Basic Wand", "Normal", "10", "100","100", "1", "Wisdom", "Abra Kadabra! Wait... Nothing happened?","Unequiped"));
    ArrayList<String> ID1003 = new ArrayList<String>();
    ID1003.addAll(Arrays.asList("1003","Basic Knife", "Normal", "10", "100","100", "1", "Agility", "Good for tickling monsters... Not really.","Unequiped"));
    itemList.put(1001, ID1001);
    itemList.put(1002, ID1002);
    itemList.put(1003, ID1003);
    //setting potions
    ArrayList<String> ID3001 = new ArrayList<String>();
    ID3001.addAll(Arrays.asList("3001","Cookie", "Normal", "10", "10", "Nice chocolate cookie. Increases your hp and mp by 10.", "1"));
    ArrayList<String> ID3002 = new ArrayList<String>();
    ID3002.addAll(Arrays.asList("3002","Mysterious cake", "Unknown", "-10", "-10","Looks nice(?)...", "1"));
    itemList.put(3001, ID3001);
    itemList.put(3002, ID3002);
    //questItem/ other items
    ArrayList<String> ID4001 = new ArrayList<String>();
    ID4001.addAll(Arrays.asList("4001","Stone", "Quest", "1","1"));
    ArrayList<String> ID4002 = new ArrayList<String>();
    ID4002.addAll(Arrays.asList("4002","Wood", "Quest", "1","1"));
    ArrayList<String> ID4003 = new ArrayList<String>();
    ID4003.addAll(Arrays.asList("4003","Wolf fur", "Monster Loot", "1","30"));
    itemList.put(4001, ID4001);
    itemList.put(4002, ID4002);
    itemList.put(4003, ID4003);
    }

    //prints item detail in the itemlist of the game
    public static void printItemState(int ID){
        ArrayList<String> infoReceived = Items.itemList.get(ID);
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
        //other items
        else if(ID >= 4000 && ID < 5000){
            String otherItemID = infoReceived.get(OTHERITEMID);
            String otherItemName = infoReceived.get(OTHERITEMNAME);
            String otherItemType = infoReceived.get(OTHERITEMTYPE);
            String otherItemQuantity = infoReceived.get(OTHERITEMQUANTITY);
            System.out.println("___________Item info___________");
            System.out.println("ID:          " + otherItemID);
            System.out.println("Name:        " + otherItemName);
            System.out.println("Type:        " + otherItemType);
            System.out.println("Quantity:    " + otherItemQuantity);
            System.out.println("_______________________________");
            System.out.println("");
        }

    }
    //prints all the items in the itemlist
    public static void printItems(){
        for (int i = 0; i < 5000; i++) {
            if(Items.itemList.containsKey(i)){
                ArrayList<String> infoReceived = Items.itemList.get(i);
                System.out.println(infoReceived);
            }
        }
    }
}
