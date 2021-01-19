import java.util.*;
public class Map {
    private static ArrayList<Location> list_of_location = new ArrayList<Location>();
    //locations of the places in Game
    private static String[] places = {"Your House","Guild","Shop","Town Square","Forest","Ruins"};
    public static void changeLocation(String name_Of_Location){
        MainCharacter.currentLocation = name_Of_Location;
    }
    public static void generateMap(){
        for (String x : places) {
            list_of_location.add(new Location(x));
        }
    }
    public static void updateMap(){
        //reset all the inaccessible location
        changeAllToInaccessible();
        //adding accessible location
        switch (MainCharacter.currentPart) {
            case 2:
                changeLocationToAccessible("Ruins");
            case 1:
                if(MainCharacter.currentLocation.equals("Town Square")){
                    changeLocationToAccessible("Your House");
                    changeLocationToAccessible("Shop");
                    changeLocationToAccessible("Guild");
                    changeLocationToAccessible("Forest");
                }
                else if (MainCharacter.currentLocation.equals("Forest")){
                    changeLocationToAccessible("Town Square");
                }
                else if(MainCharacter.currentState.equals("Idle")){
                    changeLocationToAccessible("Town Square");
                }
                break;
            default:
                System.out.println("Error on updateMap. You are in some strange place.");
                break;
        }
        
    }
    //use this to make user change location
    public static void moveUI(){
        printMap();
        askChangeForLocation();
        actionAtLocation();
    }
    public static void printMap(){
        System.out.println("      MAP");
        System.out.println("________________");
        updateMap();
        Location temp;
        for (int i = 0; i < list_of_location.size(); i++) {
            temp = list_of_location.get(i);
            if(temp.getEnabled() == 1){
                System.out.print("- ");
                System.out.println(temp.getName());
            }
        }
        System.out.println("");
    }
    public static void askChangeForLocation(){
        System.out.println("");
        System.out.println("Where do you want to go?");
        System.out.print("> ");
        String place = Program.scanString();
        boolean placeExists = false;
        Location temp;
        for (int i = 0; i < list_of_location.size(); i++) {
            temp = list_of_location.get(i);
            if(temp.getEnabled() == 1 && temp.getName().toLowerCase().equals(place)){
                changeLocation(temp.getName());
                placeExists = true;
                break;
            }
        }
        if(placeExists == false){
            System.out.println("No such place exists or it is inaccesible currently.");
            askChangeForLocation();
        }
    }
    public static void actionAtLocation(){
        Program.narrationDialogue("You are now at " + MainCharacter.currentLocation + ".");
        switch (MainCharacter.currentLocation) {
            case "Town Square":
                moveUI();
                break;

            case "Shop":
                MainCharacter.currentState = "Busy";
                Shop.shopPage();
                MainCharacter.currentState = "Idle"; 
                break;
            case "Guild":
                MainCharacter.currentState = "Busy";
                Guild.guildPage();
                MainCharacter.currentState = "Idle"; 
                break;
            case "Your House":
                // maybe healing for free by sleeping
                break;
                
                
            case "Forest":

                break;
            
            
            case "Sample3":

                break;
                
            default:
                System.out.println("Error. Can't perform any actions. Let's reposition you!");
                moveUI();
                break;
        }
    }
    public static void changeAllToInaccessible() {
        Location temp;
        for (int i = 0; i < list_of_location.size(); i++) {
            temp = list_of_location.get(i);
            temp.setEnabled(0);
        }
    }
    public static void changeLocationToAccessible(String location){
        Location temp;
        boolean found = false;
        for (int i = 0; i < list_of_location.size(); i++) {
            temp = list_of_location.get(i);
            if(temp.getName().equals(location)){
                temp.setEnabled(1);
                found = true;
                break;
            }
        }
        if(found == false){
            System.out.println("Error. Mismatching Location name.");    
        }
        
    }
}
