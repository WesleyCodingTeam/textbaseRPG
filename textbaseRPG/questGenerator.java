public class questGenerator {
    char qRank;
    String questDetail1;
    int currentNumDetail1;;
    int numDetail1;
    String questDetail2;
    int currentNumDetail2;
    int numDetail2;
    int reward;
    boolean questState;
    int qType;

    public void questGen(char qRank, String questDetail1, int currentNumDetail1, int numDetail1, String questDetail2, int currentNumDetail2, int numDetail2, int reward, int qType){
        this.qRank = qRank;
        this.questDetail1 = questDetail1;
        this.currentNumDetail1 = currentNumDetail1;
        this.numDetail1 = numDetail1;
        this.questDetail2 = questDetail2;
        this.currentNumDetail2 = currentNumDetail2;
        this.numDetail2 = numDetail2;
        this.reward = reward;
        this.qType = qType;
        questState = false;
        switch (qType) {
            
            case 1:
                System.out.println("************************************** QUEST BOARD **************************************");
                System.out.println();
                System.out.println(" Quest(Rank " + this.qRank + ") : " + this.questDetail1 + " (" + this.currentNumDetail1 + "/" + this.numDetail1 + ").");
                System.out.println();
                System.out.println("                                                            Reward: " + reward + " coins");
                System.out.println();
                System.out.println("*****************************************************************************************");
                break;
        
            case 2:
            System.out.println("************************************** QUEST BOARD **************************************");
            System.out.println();
            System.out.println(" Quest(Rank " + this.qRank + ") : " + this.questDetail1 + " (" + this.currentNumDetail1 + "/" + this.numDetail1 + ") and " + this.questDetail2 + " (" + this.currentNumDetail2 + "/" + this.numDetail2 + ").");
            System.out.println();
            System.out.println("                                                            Reward: " + this.reward + " coins");
            System.out.println();
            System.out.println("*****************************************************************************************");
                break;

            default:
                break;
        }
        
    }

    public void questCheck(){
        if (qType == 1){
            System.out.println("_____________________________________ CURRENT QUEST _____________________________________");
            System.out.println();
            System.out.println(" Quest(Rank " + qRank + ") : " + questDetail1 + " (" + currentNumDetail1 + "/" + numDetail1 + ").");
            System.out.println();
            System.out.println("                                                            Reward: " + reward + " coins");
            System.out.println("_________________________________________________________________________________________");
            System.out.println();
        }
        else if (qType == 2){
            System.out.println("_____________________________________ CURRENT QUEST _____________________________________");
            System.out.println();
            System.out.println(" Quest(Rank " + qRank + ") : " + questDetail1 + " (" + currentNumDetail1 + "/" + numDetail1 + ") and " + questDetail2 + " (" + currentNumDetail2 + "/" + numDetail2 + ").");
            System.out.println();
            System.out.println("                                                            Reward: " + reward + " coins");
            System.out.println("_________________________________________________________________________________________");
            System.out.println();
        }
    }

    public boolean questCheckCompletion(){
        boolean completed = false;
        switch (qType) {
            case 1:
            if (currentNumDetail1 >= numDetail1){
                questState = true;
                completed = true;
                System.out.println("| YOU COMPLETED THE QUEST!");
                System.out.println();
                program.waitingTime(2000);
                System.out.println("| Get back to the guild to receive reward!");
                System.out.println();
                program.waitingTime(2000);
            }    
                break;
            
            case 2:
            if (currentNumDetail1 >= numDetail1 && currentNumDetail2 >= numDetail2){
                questState = true;
                completed = true;
                System.out.println("| YOU COMPLETED THE QUEST!");
                System.out.println();
                program.waitingTime(2000);
                System.out.println("| Get back to the guild to receive reward!");
                System.out.println();
                program.waitingTime(2000);
                
            }
                break;
            default:
                break;
        }
        return completed;
    }
}
