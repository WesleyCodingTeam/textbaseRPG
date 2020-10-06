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
    public static final int MONSTERCURRENTHP = 4;
    public static final int MONSTERDEFENSE = 5;
    public static final int MONSTERDAMAGE = 6;
    public static final int MONSTERDESCRIPTION = 7;
    public static void generateMonster(){
        ArrayList<String> ID101 = new ArrayList<String>();
        ArrayList<String> ID102 = new ArrayList<String>();
        ID101.addAll(Arrays.asList("101", "Test Mob 1", "Normal", "1000000", "500", "3", "40", "This is the tesing mob."));
        ID102.addAll(Arrays.asList("102", "Dire wolve", "Rare", "200", "200", "20", "30", "Horrible mob. Run if you meet one."));
        monsterList.put(101, ID101);
        monsterList.put(102, ID102);
    }

    public static void printMonster(int monsterIDs){
        ArrayList<String> infoReceived = monsterList.get(monsterIDs);
        String monsterID = infoReceived.get(MONSTERID);
        String monsterName = infoReceived.get(MONSTERNAME);
        String monsterType = infoReceived.get(MONSTERTYPE);
        String monsterHP = infoReceived.get(MONSTERHP);
        String monsterDefense = infoReceived.get(MONSTERDEFENSE);
        String monsterDamage = infoReceived.get(MONSTERDAMAGE);
        String monsterDescription = infoReceived.get(MONSTERDESCRIPTION);
        System.out.println(""); 
        System.out.println("__________Monster info_________");
        System.out.println("ID:          " + monsterID);
        System.out.println("Name:        " + monsterName);
        System.out.println("Type:        " + monsterType);
        System.out.println("HP:          " + monsterHP);
        System.out.println("Defense:     " + monsterDefense);
        System.out.println("Damage:      " + monsterDamage);
        System.out.println("Description: " + monsterDescription);
        System.out.println("_______________________________");
        System.out.println(""); 
    }
    //gets monster name
    public static String getMonsterName(int monsterID){
        ArrayList<String> infoReceived = monsterList.get(monsterID);
        String i = infoReceived.get(MONSTERNAME);
        return i;
    }
    //gets monster HP
    public static int getMonsterHP(int monsterID){
        ArrayList<String> infoReceived = monsterList.get(monsterID);
        String i = infoReceived.get(MONSTERHP);
        int j = Integer.parseInt(i);  
        return j;
    }
    //gets monster defense
    public static int getMonsterDefense(int monsterID){
        ArrayList<String> infoReceived = monsterList.get(monsterID);
        String i = infoReceived.get(MONSTERDEFENSE);
        int j = Integer.parseInt(i);  
        return j;
    }
    //gets monster defense
    public static int getMonsterDamage(int monsterID){
        ArrayList<String> infoReceived = monsterList.get(monsterID);
        String i = infoReceived.get(MONSTERDAMAGE);
        int j = Integer.parseInt(i);  
        return j;
    }
}
