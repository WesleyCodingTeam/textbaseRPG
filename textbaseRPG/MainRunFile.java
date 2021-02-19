// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        Program.thingsToRunInBeginning();
        Program.testCharacterGeneration();
        MainCharacter.currentExp = 1000;
        Action.charAction();
    }
}
