import java.util.ArrayList;
//sets and gets item value in inventory
public class ItemValue extends Inventory{
    //returns the name of the weapon
    public static String getWeaponName(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = infoReceived.get(WEAPONNAME);
        return i;
    }
    //set name of the weapon
    public static void setWeaponName(int inventoryItemID, String changedName){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        infoReceived.set(WEAPONNAME, changedName);
    }
    //return int value of weapon damage
    public static int getWeaponDamage(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = infoReceived.get(WEAPONDAMAGE);
        int j = Integer.parseInt(i);  
        return j;
    }
    //set damage
    public static void setWeaponDamage(int inventoryItemID, int changedDamage){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = Integer.toString(changedDamage); 
        infoReceived.set(WEAPONDAMAGE, i);
    }
    //returns the current durability
    public static int getWeaponCurrentDurability(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = infoReceived.get(WEAPONCURRENTDURABILITY);
        int j = Integer.parseInt(i);  
        return j;
    }
    //set current durability
    public static void setWeaponCurrentDurability(int inventoryItemID, int changedCurrentDurability){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = Integer.toString(changedCurrentDurability); 
        infoReceived.set(WEAPONCURRENTDURABILITY, i);
    }
    //returns the durability
    public static int getWeaponDurability(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = infoReceived.get(WEAPONDURABILITY);
        int j = Integer.parseInt(i);  
        return j;
    }
    //set durability
    public static void setWeaponDurability(int inventoryItemID, int changedDurability){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = Integer.toString(changedDurability); 
        infoReceived.set(WEAPONDURABILITY, i);
    }
    //returns the special int
    public static int getWeaponSpecial(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = infoReceived.get(WEAPONSPECIAL);
        int j = Integer.parseInt(i);  
        return j;
    }
    //set special
    public static void setWeaponSpecial(int inventoryItemID, int changedSpecial){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = Integer.toString(changedSpecial); 
        infoReceived.set(WEAPONSPECIAL, i);
    }
    //returns the specialtype
    public static String getWeaponSpecialType(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = infoReceived.get(WEAPONSPECIALTYPE);
        return i;
    }
    //gets weapon state equiped, unequiped
    public static String getWeaponState(int inventoryItemID){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        String i = infoReceived.get(WEAPONSTATE);
        return i;
    }
    //sets weapon state equiped, unequiped
    public static void setWeaponState(int inventoryItemID, String changedState){
        ArrayList<String> infoReceived = weapon.get(inventoryItemID);
        infoReceived.set(WEAPONSTATE, changedState);
    }
    //returns the name of the potion
    public static String getPotionName(int inventoryItemID){
        ArrayList<String> infoReceived = potion.get(inventoryItemID);
        String i = infoReceived.get(POTIONNAME);
        return i;
    }
    //return int value of heal HP value in the inventory
    //uses the element number as inventoryItemID
    public static int getPotionHP(int inventoryItemID){
        ArrayList<String> infoReceived = potion.get(inventoryItemID);
        String i = infoReceived.get(POTIONDHP);
        int j = Integer.parseInt(i);  
        return j;
    }
    //simailar to getPotionHP, but returns MP
    public static int getPotionMP(int inventoryItemID){
        ArrayList<String> infoReceived = potion.get(inventoryItemID);
        String i = infoReceived.get(POTIONMP);
        int j = Integer.parseInt(i);  
        return j;
    }
    //gets quantity
    public static int getPotionQuantity(int inventoryItemID){
        ArrayList<String> infoReceived = potion.get(inventoryItemID);
        String i = infoReceived.get(POTIONQUANTITY);
        int j = Integer.parseInt(i);  
        return j;
    }
    public static void setPotionQuantity(int inventoryItemID, int changedQuantity){
        ArrayList<String> infoReceived = potion.get(inventoryItemID);
        String i = Integer.toString(changedQuantity);
        infoReceived.set(POTIONQUANTITY, i);
    }
}
