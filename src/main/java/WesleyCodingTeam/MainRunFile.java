package WesleyCodingTeam;

// this file is the main file that runs the game
public class MainRunFile{
    public static void main(String[] args){
        // TODO
        //need to implement equipment system
        //need to adjust item stats cookie and cake and more item need to be added or adjusted
//        Program.thingsToRunInBeginning();
//        Intro.introduction();
        Field town = new Field(10,10,false);
        town.addWallTile(2,2);
        town.addWallTile(2,3);
        town.addWallTile(1,2);
        town.addWallTile(4,2);
        MainCharacter.changeCoordinate(4,4);
        town.move();
    }
}
