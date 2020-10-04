// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        //Intro.introduction();
        //Part1 disabled for the test of item. Just activate it by removing //
        //Part1.questFGame();
        //buttom code is just for inventory testing
        Part1.questFGame();
        Character.makeStats("Jaeyoung", "None", 1, 13, 10000000, 10, 10, 100, 100, 100, 100, 10, 10);
        Monster.generateMonster();
        Monster.printMonster(101);
        Battle.battleNow(101);
    } 
}
