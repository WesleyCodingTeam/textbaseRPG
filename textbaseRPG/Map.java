import java.util.*;
public class Map {
    public static void changeLocation(String name_Of_Location){
        Character.currentLocation = name_Of_Location;
    }
    public static void showMap(){
        ArrayList<String> places_Allowed = new ArrayList<String>();
        switch (Character.currentPart) {
            case 1:
                if(!Character.currentLocation.equals("village") && Character.currentState.equals("idle")){
                    places_Allowed.add("village");
                }
                if(Character.currentLocation.equals("village")){
                    places_Allowed.add("guild");
                    places_Allowed.add("");
                    places_Allowed.add("your house");
                }    
            
            case 2;

                break;
        
            default:
                System.out.println("Error on showMap. You are in some strange place.");
                break;
        }
    for(int i=0;i<places_Allowed.size();i++){
        String printing = places_Allowed.get(i);
        System.out.println("- " + printing);

    }
}
