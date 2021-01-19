import java.util.HashMap;

public class Guild {
    public static HashMap<Integer, Quests> questList = new HashMap<Integer, Quests>();
    public static void guildPage(){

    }
    public static void questIntitialization(){
        questList.put(1001, new Quests('F', "Get woods", 50, 50, "Get stones" , 30, 30, 100, 5, 2,1,1001));
    }
    //print available quest
    public static void availableQuests(){
        Quests temp;
        for(Integer key:questList.keySet()){
            temp = questList.get(key);
            //if it is not completed and in the same part, then it will be available
            if(temp.questCompletion == false && temp.questPart == MainCharacter.currentPart && temp.qAccepted == false){
                switch (temp.qType) {
                    case 1:
                        System.out.println("************************************** QUEST BOARD **************************************");
                        System.out.println();
                        System.out.println(" Quest(Rank " + temp.qRank + ") : " + temp.questDetail1 + " (" + temp.currentNumDetail1 + "/" + temp.numDetail1 + ").");
                        System.out.println();
                        System.out.println("                                                            Reward: " + temp.rewardM + " coins");
                        System.out.println();
                        System.out.println("*****************************************************************************************");
                        System.out.println();
                        break;
                
                    case 2:
                        System.out.println("************************************** QUEST BOARD **************************************");
                        System.out.println();
                        System.out.println(" Quest(Rank " + temp.qRank + ") : " + temp.questDetail1 + " (" + temp.currentNumDetail1 + "/" + temp.numDetail1 + ") and " + temp.questDetail2 + " (" + temp.currentNumDetail2 + "/" + temp.numDetail2 + ").");
                        System.out.println();
                        System.out.println("                                                            Reward: " + temp.rewardM + " coins");
                        System.out.println();
                        System.out.println("*****************************************************************************************");
                        System.out.println();
                        break;
                    default:
                        break;
                }
            }
        }
        
    }
}
