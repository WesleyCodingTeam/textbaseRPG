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
            Program.terminal.println();
        }
        for(int i = 0; i < leftToRight*2+2; i++){
            Program.terminal.print("_");
        }
        Program.terminal.println();
        for (int i = top; i <= bottom; i++) {
            Program.terminal.print("|");
            for (int j = left; j <= right; j++) {
                if(i == currentYCoordinate && j == currentXCoordinate){
                    Program.terminal.print('O' + " ");
                }
                else {
                    Tile temp = tiles[i][j];
                    Program.terminal.print(temp.tileShape + " ");
                }
            }
            Program.terminal.print("|");
            Program.terminal.println();
        }
        for(int i = 0; i < leftToRight*2+2; i++){
            Program.terminal.print("_");
        }
        Program.terminal.println();
    }

    public void addWallTile(int xCoordinate, int yCoordinate){
        tiles[yCoordinate][xCoordinate] = new WallTile(xCoordinate, yCoordinate);
    }
    public void addMonsterTile(int xCoordinate, int yCoordinate,int monsterId){
        tiles[yCoordinate][xCoordinate] = new MonsterTile(xCoordinate, yCoordinate,monsterId);
    }
    public void addChestTile(int xCoordinate, int yCoordinate){
        int[][] items = {{1001,1},{1002,3}};
        tiles[yCoordinate][xCoordinate] = new ChestTile(xCoordinate, yCoordinate,items);
    }
    public void deleteTile(int x,int y){
        tiles[y][x] = new Tile(x,y);
    }
    public void move(char direction){
        int currentXCoordinate = MainCharacter.xCoordinate;
        int currentYCoordinate = MainCharacter.yCoordinate;
        switch (direction){
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
        printField();
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
            int percentage = 10;
            int value = (int) (Math.random() * percentage) + 1;
            int monster = Program.randomNum(104, 111);
            if (1 == value){
                Battle.battleNow(monster);
            }
        }

        public void message() {

        }
    }

    private class ChestTile extends Tile {
        //the matrix should be n by 2 matrix where the first stores the ID of the item and second one stores the quantity
        int[][] itemList;

        public ChestTile(int xCoordinate, int yCoordinate, int[][] itemList) {
            super(xCoordinate, yCoordinate);
            this.itemList = itemList;
            super.tileShape = 'I';
        }

        @Override
        public void message() {
            Program.systemDialogue("You found a chest! Do you want to open it? (y/n)");
        }

        @Override
        public void action() {
            if (Program.askChar() == 'y') {
                displayItem();
                askForSelection();
                putInInventory();
            }

        }

        public void displayItem() {
            Program.terminal.println("___________________");
            Program.terminal.println("       Items       ");
            for(int i =0;i<itemList.length;i++){
                Program.terminal.println("| No." + i + " " + Data.itemList.get(itemList[i][0]).name + " x" + itemList[i][1]);
            }
            Program.terminal.println("___________________");
        }

        public void askForSelection() {
            Program.systemDialogue("Which item do you want to take? Choose only 1. Type -1 to quit");
        }

        public void putInInventory() {
            int received = Program.askInt();
            if (received != -1 && received<itemList.length){
                if(itemList[received][1] !=0) {
                    Inventory.setInventoryItem(itemList[received][0],1);
                    itemList[received][1]--;
                }
            }
            Program.systemDialogue("Do you want to pick other item? (y/n)");
            action();
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
            int prevKill = MainCharacter.killCount;
            Battle.battleNow(monsterId);
            if(prevKill + 1 == MainCharacter.killCount){
                deleteTile(this.x,this.y);
            }
        }

    }

    private class buildingTile extends Tile {
        public buildingTile(int xCoordinate, int yCoordinate, int buildingID) {
            super(xCoordinate, yCoordinate);
        }
    }
//grass average 5 tiles monster and normal average 10 tiles
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
