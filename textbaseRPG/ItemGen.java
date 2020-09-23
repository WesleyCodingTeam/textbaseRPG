import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemGen{
    //initializing hashmap
    public static HashMap<Integer, ArrayList<String>> itemList = new HashMap<Integer, ArrayList<String>>();
    //itnitalizing item details to the hashmap
    public static void itemGeneration() {
    //starting to set weapons  
    ArrayList<String> ID1001 = new ArrayList<String>();
    ID1001.addAll(Arrays.asList("1001", "Basic Sword", "Normal", "10", "100", "100","1", "Strength","Just a normal sword","Unequiped"));
    ArrayList<String> ID1002 = new ArrayList<String>();
    ID1002.addAll(Arrays.asList("1002","Basic Wand", "Normal", "10", "100","100", "1", "Wisdom", "Just a normal wand","Unequiped"));
    ArrayList<String> ID1003 = new ArrayList<String>();
    ID1003.addAll(Arrays.asList("1003","Basic Knife", "Normal", "10", "100","100", "1", "Agility", "Just a normal knife","Unequiped"));
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
    ID4001.addAll(Arrays.asList("4001","Stone", "Quest", "1"));
    ArrayList<String> ID4002 = new ArrayList<String>();
    ID4002.addAll(Arrays.asList("4002","Wood", "Quest", "1"));
    itemList.put(4001, ID4001);
    itemList.put(4002, ID4002);
    }
}
