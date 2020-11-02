// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        Items.itemGeneration(); 
        Monster.generateMonster();
        Character.makeStats("Jaeyoung", "None", 1, 13, 11, 11, 11, 100, 100, 100, 100, 10);
        Character.currentPart = 1;
        Character.currentState = "idle";
        Guild.guildPage();
        Action.charAction();        
    } 
}
