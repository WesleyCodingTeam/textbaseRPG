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
    
    //declaring field method
    public Quests(char qRank, String questDetail1, int currentNumDetail1, int numDetail1, String questDetail2, int currentNumDetail2, int numDetail2, int rewardM, int rewardEXP, int qType, int questPart,int questID){
        this.qRank = qRank;
        this.questDetail1 = questDetail1;
        this.currentNumDetail1 = currentNumDetail1;
        this.numDetail1 = numDetail1;
        this.questDetail2 = questDetail2;
        this.currentNumDetail2 = currentNumDetail2;
        this.numDetail2 = numDetail2;
        this.rewardM = rewardM;
        this.rewardEXP = rewardEXP;
        this.qType = qType;
        this.questID = questID;
        this.questCompletion = false;
        this.questPart = questPart;
        this.qAccepted = false;
        
    }



    //returns true or false based on completion of the quest
    public boolean questCheckCompletion(){
        boolean completed = false;
        //qType used for distinguish between quest with 1 objective or 2 objective
        switch (qType) {
            case 1:
            if (currentNumDetail1 >= numDetail1){
                questCompletion = true;
                completed = true;
                System.out.println("| YOU COMPLETED THE QUEST!");
                System.out.println();
                Program.waitingTime(2000);
                System.out.println("| Get back to the guild to receive reward!");
                System.out.println();
                Program.waitingTime(2000);
            }    
                break;
            
            case 2:
            if (currentNumDetail1 >= numDetail1 && currentNumDetail2 >= numDetail2){
                questCompletion = true;
                completed = true;
                System.out.println("| YOU COMPLETED THE QUEST!");
                System.out.println();
                Program.waitingTime(2000);
                System.out.println("| Get back to the guild to receive reward!");
                System.out.println();
                Program.waitingTime(2000);
                
            }
                break;
            default:
                break;
        }
        return completed;
    }
}
