import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemGen{
    //initializing hashmap
    public static HashMap<Integer, ArrayList<String>> itemList = new HashMap<Integer, ArrayList<String>>();
    public static void itemGeneration() {
    //starting to set weapons  
    ArrayList<String> ID1001 = new ArrayList<String>();
    ID1001.addAll(Arrays.asList("Basic Sword", "Normal", "10", "100","1","Just a normal sword"));
    ArrayList<String> ID1002 = new ArrayList<String>();
    ID1002.addAll(Arrays.asList("Basic Wand", "Normal", "10", "100","1","Just a normal wand"));
    ArrayList<String> ID1003 = new ArrayList<String>();
    ID1003.addAll(Arrays.asList("Basic Knife", "Normal", "10", "100","1","Just a normal knife"));
    itemList.put(1001, ID1001);
    itemList.put(1002, ID1002);
    itemList.put(1003, ID1003);
    }

}
