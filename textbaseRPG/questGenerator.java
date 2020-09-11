public class questGenerator {
    char qRank;
    String questDetail1;
    int currentNumDetail1;;
    int numDetail1;
    String questDetail2;
    int currentNumDetail2;
    int numDetail2;
    int reward;

    public void questGen(char qRank, String questDetail1, int currentNumDetail1, int numDetail1, int reward){
        this.qRank = qRank;
        this.questDetail1 = questDetail1;
        this.currentNumDetail1 = currentNumDetail1;
        this.numDetail1 = numDetail1;
        this.reward = reward;
        System.out.println("************************************** QUEST BOARD **************************************");
        System.out.println();
        System.out.println(" Quest(Rank " + this.qRank + ") : " + this.questDetail1 + " (" + this.currentNumDetail1 + "/" + this.numDetail1 + ").");
        System.out.println();
        System.out.println("                                                            Reward: " + reward + " coins");
        System.out.println();
        System.out.println("*****************************************************************************************");
    }

    public void questGen(char qRank, String questDetail1, int currentNumDetail1, int numDetail1, String questDetail2, int currentNumDetail2, int numDetail2, int reward){
        this.qRank = qRank;
        this.questDetail1 = questDetail1;
        this.currentNumDetail1 = currentNumDetail1;
        this.numDetail1 = numDetail1;
        this.questDetail2 = questDetail2;
        this.currentNumDetail2 = currentNumDetail2;
        this.numDetail2 = numDetail2;
        this.reward = reward;
        System.out.println("************************************** QUEST BOARD **************************************");
        System.out.println();
        System.out.println(" Quest(Rank " + this.qRank + ") : " + this.questDetail1 + " (" + this.currentNumDetail1 + "/" + this.numDetail1 + ") and " + this.questDetail2 + " (" + this.currentNumDetail2 + "/" + this.numDetail2 + ").");
        System.out.println();
        System.out.println("                                                            Reward: " + this.reward + " coins");
        System.out.println();
        System.out.println("*****************************************************************************************");
    }

    public void questCheck(int qType){
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
}
