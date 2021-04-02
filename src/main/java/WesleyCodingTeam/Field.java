package WesleyCodingTeam;

public class Field {
    Tile[][] tiles;
    int width;
    int height;
    boolean monsterField;

    public Field(int height, int width, boolean monsterField) {
        tiles = new Tile[height][width];
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }
    }

    public void printField() {
        int currentXCoordinate = MainCharacter.xCoordinate;
        int currentYCoordinate = MainCharacter.yCoordinate;
        int view = MainCharacter.maxViewDistance;
        int left = (Math.max(currentXCoordinate - view, 0));
        int right = (currentXCoordinate+view <width?currentXCoordinate+view:width-1);
        int top = (Math.max(currentYCoordinate - view, 0));
        int bottom = (currentYCoordinate+view <height?currentYCoordinate+view:height-1);
        int leftToRight = right - left+1;
        int blankSpace = 20;
        for(int k = 0; k < blankSpace; k++){
            System.out.println();
        }
        for(int i = 0; i < leftToRight*2+2; i++){
            System.out.print("_");
        }
        System.out.println();
        for (int i = top; i <= bottom; i++) {
            System.out.print("|");
            for (int j = left; j <= right; j++) {
                if(i == currentYCoordinate && j == currentXCoordinate){
                    System.out.print('O' + " ");
                }
                else {
                    Tile temp = tiles[i][j];
                    System.out.print(temp.tileShape + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i = 0; i < leftToRight*2+2; i++){
            System.out.print("_");
        }
        System.out.println();
    }

    public void addWallTile(int xCoordinate, int yCoordinate){
        tiles[yCoordinate][xCoordinate] = new WallTile(xCoordinate, yCoordinate);
    }
    public void addMonsterTile(int xCoordinate, int yCoordinate,int monsterId){
        tiles[yCoordinate][xCoordinate] = new MonsterTile(xCoordinate, yCoordinate,monsterId);
    }
    public void deleteTile(int x,int y){
        tiles[y][x] = new Tile(x,y);
    }
    public void move(){
        printField();
        Program.systemDialogue("What do you want to do?");
        int currentXCoordinate = MainCharacter.xCoordinate;
        int currentYCoordinate = MainCharacter.yCoordinate;
        char move = Program.askChar();
        switch (move){
            case 'w':
                currentYCoordinate -= 1;
                break;
            case 's':
                currentYCoordinate += 1;
                break;
            case 'd':
                currentXCoordinate += 1;
                break;
            case 'a':
                currentXCoordinate -= 1;
                break;
            default:
                Program.systemDialogue("Error, wrong command.");
        }
        if(currentXCoordinate >=0 && currentYCoordinate >= 0 && currentXCoordinate <width && currentYCoordinate < height){
            MainCharacter.changeCoordinate(currentXCoordinate,currentYCoordinate);
            doSpecifiedAction(currentXCoordinate,currentYCoordinate);
        }
        else{
            Program.systemDialogue("You are not allowed to go to that place. It is out of bound");
        }
        move();
    }
    private void doSpecifiedAction(int x,int y){
        Tile curr = tiles[y][x];
        curr.message();
        curr.action();
    }

    private class Tile {
        int x;
        int y;
        char tileShape;

        public Tile(int xCoordinate, int yCoordinate) {
            x = xCoordinate;
            y = yCoordinate;
            tileShape = ' ';
        }

        public void action() {

        }

        public void message() {

        }
    }

    // TODO make various tiles that can do many different things
    private class ChestTile extends Tile {
        //the matrix should be n by 2 matrix where the first stores the ID of the item and second one stores the quantity
        int[][] itemList;

        public ChestTile(int xCoordinate, int yCoordinate, int[][] itemList) {
            super(xCoordinate, yCoordinate);
            this.itemList = itemList;
        }

        @Override
        public void message() {
            Program.systemDialogue("");
        }

        @Override
        public void action() {
            while (Program.scanChar() == 'y') {
                displayItem();
                askForSelection();
                putInInventory();
            }

        }

        public void displayItem() {

        }

        public void askForSelection() {

        }

        public void putInInventory() {

        }
    }

    private class MonsterTile extends Tile {
        private final int monsterId;

        public MonsterTile(int xCoordinate, int yCoordinate, int monsterId) {
            super(xCoordinate, yCoordinate);
            this.monsterId = monsterId;
            super.tileShape ='M';
        }

        @Override
        public void message() {
            Program.systemDialogue("You've encountered with a monster!");
        }

        @Override
        public void action() {
            Battle.battleNow(monsterId);
        }

    }

    private class buildingTile extends Tile {
        public buildingTile(int xCoordinate, int yCoordinate, int buildingID) {
            super(xCoordinate, yCoordinate);
        }
    }

    private class GrassTile extends Tile {
        public GrassTile(int xCoordinate, int yCoordinate) {
            super(xCoordinate, yCoordinate);
        }
    }

    private class WallTile extends Tile {
        public WallTile(int xCoordinate, int yCoordinate) {
            super(xCoordinate, yCoordinate);
            tileShape = '#';
        }
    }
}
