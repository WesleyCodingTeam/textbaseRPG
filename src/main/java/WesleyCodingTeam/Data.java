package WesleyCodingTeam;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Data {
    //initializing hashmap
    public static HashMap<Integer, Monster> monsterList = new HashMap<>();
    public static HashMap<Integer, Item> itemList = new HashMap<>();
    public static Field field;

    public static void initialization(){
        generateField();
        generateItem();
        generateMonster();
    }
    public static void generateMonster(){
        Scanner in;
        in = new Scanner(Data.class.getClassLoader().getResourceAsStream("monster.txt"));
        while(in.hasNextLine()){
            String[] specs = in.nextLine().split(",");
            int id = Integer.parseInt(specs[0]);
            String name = specs[1];
            String type = specs[2];
            int hp = Integer.parseInt(specs[3]);
            int defense = Integer.parseInt(specs[4]);
            int damage = Integer.parseInt(specs[5]);
            String description = specs[6];
            int expAmount = Integer.parseInt(specs[7]);
            monsterList.put(id,new Monster(id,name,type,hp,defense,damage,description,expAmount));
        }

    }
    public static void generateItem(){
        Scanner in;
        in = new Scanner(Data.class.getClassLoader().getResourceAsStream("items.txt"));
        while(in.hasNextLine()){
            String[] specs = in.nextLine().split(",");
            String itemType = specs[0];
            int id = Integer.parseInt(specs[1]);
            int price = Integer.parseInt(specs[2]);
            String name = specs[3];
            String type = specs[4];
            String description = specs[5];
            switch (itemType){
                case "W": {
                    int damage = Integer.parseInt(specs[6]);
                    boolean hasSpecial = Boolean.parseBoolean(specs[7]);
                    String specialType = null;
                    int specialStat = 0;
                    boolean equipped;
                    int quantity;
                    if (hasSpecial) {
                        specialType = specs[8];
                        specialStat = Integer.parseInt(specs[9]);
                        equipped = Boolean.parseBoolean(specs[10]);
                        quantity = Integer.parseInt(specs[11]);
                    } else {
                        equipped = Boolean.parseBoolean(specs[8]);
                        quantity = Integer.parseInt(specs[9]);
                    }
                    itemList.put(id, new Weapon(itemType,id, price, name, type, description, damage, hasSpecial, specialType, specialStat, equipped, quantity));
                }
                    break;
                case "P": {
                    int hp = Integer.parseInt(specs[6]);
                    int mp = Integer.parseInt(specs[7]);
                    boolean hasSpecial = Boolean.parseBoolean(specs[8]);
                    String specialType = null;
                    int specialStat = 0;
                    int quantity;
                    if (hasSpecial) {
                        specialType = specs[9];
                        specialStat = Integer.parseInt(specs[10]);
                        quantity = Integer.parseInt(specs[11]);
                    } else {
                        quantity = Integer.parseInt(specs[9]);
                    }
                    itemList.put(id, new Potion(itemType,id, price, name, type, description,hp,mp, hasSpecial, specialType, specialStat, quantity));

                }
                    break;
                case "Q":{
                    boolean sellable = Boolean.parseBoolean(specs[6]);
                    int quantity = Integer.parseInt(specs[7]);
                    itemList.put(id,new OtherItem(itemType,id, price, name, type, description, sellable,quantity));
                }
                    break;
                default:
                    Program.terminal.println("Error while generating item");
                    break;
            }
        }
    }
    public static void printAllItems(){
        for(Item x:itemList.values()){
            x.printInfo();
        }
    }
    public static void generateField(){
        Scanner in;
        in = new Scanner(Data.class.getClassLoader().getResourceAsStream("field.txt"));
        int width = in.nextInt();
        int height = in.nextInt();
        field = new Field(height,width,true);
        while(in.hasNext()){
            String tileType = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            switch (tileType){
                case "M":
                    int id = in.nextInt();
                    field.addMonsterTile(x,y,id);
                    break;
                case "C":
                    MainCharacter.changeCoordinate(x,y);
                    break;
                case "I":
                    field.addChestTile(x,y);
                    break;
                default:
                    Program.terminal.println("Error while generating map");
                    break;
            }
        }
    }
}
