public class QuestGenerator {
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
    boolean questState; //true or false based on completion of the quest
    int qType; //1 for quest with 1 objective, 2 for quest with 2 objective
    
    //declaring field method
    public void questGen(char qRank, String questDetail1, int currentNumDetail1, int numDetail1, String questDetail2, int currentNumDetail2, int numDetail2, int rewardM, int rewardEXP, int qType){
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
        this.questState = false;
        switch (qType) {
            
            case 1:
                System.out.println("************************************** QUEST BOARD **************************************");
                System.out.println();
                System.out.println(" Quest(Rank " + this.qRank + ") : " + this.questDetail1 + " (" + this.currentNumDetail1 + "/" + this.numDetail1 + ").");
                System.out.println();
                System.out.println("                                                            Reward: " + this.rewardM + " coins");
                System.out.println();
                System.out.println("*****************************************************************************************");
                break;
        
            case 2:
            System.out.println("************************************** QUEST BOARD **************************************");
            System.out.println();
            System.out.println(" Quest(Rank " + this.qRank + ") : " + this.questDetail1 + " (" + this.currentNumDetail1 + "/" + this.numDetail1 + ") and " + this.questDetail2 + " (" + this.currentNumDetail2 + "/" + this.numDetail2 + ").");
            System.out.println();
            System.out.println("                                                            Reward: " + this.rewardM + " coins");
            System.out.println();
            System.out.println("*****************************************************************************************");
                break;

            default:
                break;
        }
        
    }

    //method to check the progress of the quest
    public void questCheck(){

        switch (qType) {
            case 1:
                System.out.println("_____________________________________ CURRENT QUEST _____________________________________");
                System.out.println();
                System.out.println(" Quest(Rank " + qRank + ") : " + questDetail1 + " (" + currentNumDetail1 + "/" + numDetail1 + ").");
                System.out.println();
                System.out.println("                                                            Reward: " + this.rewardM + " coins");
                System.out.println("_________________________________________________________________________________________");
                System.out.println();
                break;
            case 2:
                System.out.println("_____________________________________ CURRENT QUEST _____________________________________");
                System.out.println();
                System.out.println(" Quest(Rank " + qRank + ") : " + questDetail1 + " (" + currentNumDetail1 + "/" + numDetail1 + ") and " + questDetail2 + " (" + currentNumDetail2 + "/" + numDetail2 + ").");
                System.out.println();
                System.out.println("                                                            Reward: " + this.rewardM + " coins");
                System.out.println("_________________________________________________________________________________________");
                System.out.println();
                break;
        
            default:
                break;
        }
    }

    //returns true or false based on completion of the quest
    public boolean questCheckCompletion(){
        boolean completed = false;
        //qType used for distinguish between quest with 1 objective or 2 objective
        switch (qType) {
            case 1:
            if (currentNumDetail1 >= numDetail1){
                questState = true;
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
                questState = true;
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
