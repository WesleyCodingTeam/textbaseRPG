package WesleyCodingTeam;

// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        //need to implement equipment system
        //need to adjust item stats cookie and cake and more item need to be added or adjusted
//        Program.thingsToRunInBeginning();
//        Intro.introduction();
        Program.testCharacterGeneration();
        //Program.thingsToRunInBeginning();
        Data.generateField();
        Data.generateMonster();
        Data.field.move();
    }
}
