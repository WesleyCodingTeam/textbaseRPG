import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Monster {
    //initializing hashmap
    public static HashMap<Integer, ArrayList<String>> monsterList = new HashMap<Integer, ArrayList<String>>();
    public static final int MONSTERID = 0;
    public static final int MONSTERNAME = 1;
    public static final int MONSTERTYPE = 2;
    public static final int MONSTERHP = 3;
    public static final int MONSTERDEFENSE = 4;
    public static final int MONSTERDAMAGE = 5;
    public static final int MONSTERDESCRTION = 6;
    public static void generateMonster(){
        ArrayList<String> ID101 = new ArrayList<String>();
        ID101.addAll(Arrays.asList("101", "Test Mob 1", "Normal", "1000000", "10", "1", "This is the tesing mob."));
        monsterList.put(101, ID101);
    }

    public static void printMonster(int monsterID){
        ArrayList<String> infoReceived = monsterList.get(monsterID);
        String monsterID = infoReceived.get(MONSTERID);
        String weaponName = infoReceived.get(MONSTERNAME);
        String weaponType = infoReceived.get(MONSTERTYPE);
        String weaponDamage = infoReceived.get(MONSTERHP);
        String weaponDurability = infoReceived.get(MONSTERDEFENSE);
        String weaponSpecial = infoReceived.get(MONSTERDAMAGE);
        String weaponSpecialType = infoReceived.get(MONSTERDESCRTION);
        System.out.println("___________Item info___________");
        System.out.println("ID:          " + monsterID);
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
}
