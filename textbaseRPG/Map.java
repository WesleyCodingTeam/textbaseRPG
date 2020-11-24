import java.util.*;
public class Map {
    private static ArrayList<Location> list_of_location = new ArrayList<Location>();
    public static void changeLocation(String name_Of_Location){
        MainCharacter.currentLocation = name_Of_Location;
    }
    public static void generateMap(){
        Location yourHouse = new Location("Your House");
        list_of_location.add(yourHouse);
        Location guild = new Location("Guild");
        list_of_location.add(guild);
        Location shop = new Location("Shop");
        list_of_location.add(shop);
        Location village = new Location("Village");
        list_of_location.add(village);
    }
    public static void updateMap(){
        //reset all the inaccessible location
        changeAllToInaccessible();
        //adding accessible location
        switch (MainCharacter.currentPart) {
            case 2:
                
                
            case 1:
                if(MainCharacter.currentState.equals("Idle") && MainCharacter.currentLocation.equals("Village")){
                    changeLocationToAccessible("Your House");
                    changeLocationToAccessible("Shop");
                    changeLocationToAccessible("Guild");
                }
                else if(MainCharacter.currentState.equals("Idle")){
                    changeLocationToAccessible("Village");
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
        switch (MainCharacter.currentLocation) {
            case "Village":
                System.out.println("Yay!");
                moveUI();
                break;

            case "Shop":

                break;
            case "Home":

                break;
                
            case "Guild":

                break;
            
            
            case "Your House":

                break;
                
                
            case "Sample2":

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
