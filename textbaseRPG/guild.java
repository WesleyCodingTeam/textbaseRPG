public class guild {
    public static void guildPage(){
        //some code for receiving quest based on the part that the charater is in
        switch (character.currentPart){
            case 1:
                part1.quest1.questGen('F', "Get woods", 0, 50, "Get stones" , 0, 30, 100, 5, 2);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                break;
        }
        System.out.println();
        program.waitingTime(4000);
    }
}
