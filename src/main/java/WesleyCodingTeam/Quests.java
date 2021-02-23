package WesleyCodingTeam;

public class Quests {
    //field
    char qRank; //F,D,C,B,A,S
    String questDetail1; //some words explaining the quest
    int currentNumDetail1; //current progress
    int numDetail1; //goal number
    String questDetail2; //some words explaining the quest
    int currentNumDetail2; //current progress
    int numDetail2; //goal number
    int rewardM; //money reward
    int rewardEXP; //EXP reward
    boolean questCompletion; //true or false based on completion of the quest
    int qType; //1 for quest with 1 objective, 2 for quest with 2 objective
    int questID;
    int questPart;
    boolean qAccepted;
    int questSyncItemID1;
    int questSyncItemID2;
    boolean questAlertDone = false;
    
    //type 2
    public Quests(char qRank, String questDetail1, int currentNumDetail1, int numDetail1, int questSyncItemID1, String questDetail2, int currentNumDetail2, int numDetail2, int questSyncItemID2, int rewardM, int rewardEXP, int questPart,int questID){
        this.qRank = qRank;
        this.questDetail1 = questDetail1;
        this.currentNumDetail1 = currentNumDetail1;
        this.numDetail1 = numDetail1;
        this.questDetail2 = questDetail2;
        this.currentNumDetail2 = currentNumDetail2;
        this.numDetail2 = numDetail2;
        this.rewardM = rewardM;
        this.rewardEXP = rewardEXP;
        this.qType = 2;
        this.questID = questID;
        this.questCompletion = false;
        this.questPart = questPart;
        this.qAccepted = false;
        this.questSyncItemID1 = questSyncItemID1;
        this.questSyncItemID2 = questSyncItemID2;
        
    }
    //type 1
    public Quests(char qRank, String questDetail1, int currentNumDetail1, int numDetail1, int questSyncItemID1, int rewardM, int rewardEXP, int questPart,int questID){
        this.qRank = qRank;
        this.questDetail1 = questDetail1;
        this.currentNumDetail1 = currentNumDetail1;
        this.numDetail1 = numDetail1;
        this.rewardM = rewardM;
        this.rewardEXP = rewardEXP;
        this.qType = 1;
        this.questID = questID;
        this.questCompletion = false;
        this.questPart = questPart;
        this.qAccepted = false;
        this.questSyncItemID1 = questSyncItemID1;
    }



    //returns true or false based on completion of the quest
    public boolean questCheckCompletionBoolean(){
        boolean completed = false;
        //qType used for distinguish between quest with 1 objective or 2 objective
        switch (qType) {
            case 1:
            if (currentNumDetail1 >= numDetail1){
                completed = true;
                Program.systemDialogue("YOU COMPLETED THE QUEST!");
            }    
                break;
            
            case 2:
            if (currentNumDetail1 >= numDetail1 && currentNumDetail2 >= numDetail2){
                completed = true;
                Program.systemDialogue("YOU COMPLETED THE QUEST!");
                
            }
                break;
            default:
                break;
        }
        return completed;
    }
    //returns true or false based on completion of the quest
    public void questCheckCompletionVoid(){
        //qType used for distinguish between quest with 1 objective or 2 objective
        switch (qType) {
            case 1:
            if (currentNumDetail1 >= numDetail1){
                Program.systemDialogue("YOU COMPLETED THE QUEST!");
            }    
                break;
            
            case 2:
            if (currentNumDetail1 >= numDetail1 && currentNumDetail2 >= numDetail2){
                Program.systemDialogue("YOU COMPLETED THE QUEST!");
                
            }
                break;
            default:
                break;
        }
    }
    //get reward
    public void getReward(){
        MainCharacter.coin += rewardM;
        MainCharacter.currentExp += rewardEXP;
        Program.systemDialogue("You received " + rewardM + " coins and " + rewardEXP + " exp!");
    }
    //increase the progress of the quest for 1st category
    public void incQuestProgress1(int progress){
        currentNumDetail1 += progress;
    }
    //increase the progress of the quest for 2nd category
    public void incQuestProgress2(int progress){
        currentNumDetail2 += progress;
    }
    //sync the progress of quest with item for 1st requirement
    public void syncQuestWithItem1(){
        int itemID = questSyncItemID1;
        if(Inventory.haveItem(itemID)){
            currentNumDetail1 = Inventory.getOtherItemQuantity(Inventory.haveItemNum(itemID));
        }
        else{
            currentNumDetail1 = 0;
        }
    }
    //sync the progress of quest with item for 1st requirement
    public void syncQuestWithItem2(){
        int itemID = questSyncItemID2;
        if(Inventory.haveItem(itemID)){
            currentNumDetail2 = Inventory.getOtherItemQuantity(Inventory.haveItemNum(itemID));
        }
        else{
            currentNumDetail2 = 0;
        }
    }
}
