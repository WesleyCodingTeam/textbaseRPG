// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        Items.itemGeneration();
        Monster.generateMonster();
        //Intro.introduction();
        //Part1 disabled for the test of item. Just activate it by removing //
        //@jun use code below for testing
        Character.makeStats("Jaeyoung", "None", 1, 13, 11, 11, 11, 100, 100, 100, 100, 10);
        Part1.gettingPower();
        
        
    } 
}
