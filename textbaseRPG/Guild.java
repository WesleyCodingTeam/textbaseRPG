import java.util.HashMap;

public class Guild {
    //first time message
    public static boolean introMessage = true;
    public static HashMap<Integer, Quests> questList = new HashMap<Integer, Quests>();
    public static void guildPage(){
        if(Part1.found == true){
                
        }
        Program.npcDialogue("Hello! What do you want me to do?");
        Program.dialogue("1. Check and Receive reward.");
        Program.dialogue("2. Look for new quest.");
        Program.dialogue("3. Exit");
        boolean done = false;
        while(!done){
            int ans = Program.askInt();
            if(ans == 1){
                checkAndGetReward();
                done = true;
            }
            else if(ans == 2){
                availableQuests();
                done = true;
                if(introMessage){
                    Program.npcDialogue("Hey, " + MainCharacter.name + "! Going gathering again laddie?");
                    Program.dialogue("Haha... yeah...");
                    Program.npcDialogue("Ya remember how to gather 'em right?'");
                    Program.dialogue("Uh...");
                    Program.npcDialogue("No wonder yer sister calls you hopeless, arighty...");
                    Action.help();
                    introMessage = false;
                }
            }
            else if(ans == 3){
                break;
            }
            else{
                Program.systemDialogue("It seems like you chose the wrong choice.");
            }
        }
        if(done){
            guildPage();
        }
    }
    public static void questIntitialization(){
        questList.put(1001, new Quests('F', "Get woods", 0, 50, "Get stones" , 0, 30, 100, 5, 2,1,1001));
    }
    //check for quest comepletion and get reward
    public static void checkAndGetReward(){
        Quests temp;
        int counter = 0;
        for(Integer key:questList.keySet()){
            temp = questList.get(key);
            if(temp.questCompletion == false && temp.qAccepted == true && temp.questCheckCompletion() == true){
                counter++;
                temp.questCompletion = true;
                temp.getReward();
            }
        }
        if(counter == 0)
        Program.npcDialogue("It seems like you have no quest remaining or you haven't finished the quest yet.");
    }
    //print available quest
    public static void availableQuests(){
        Quests temp;
        int counter = 0;
        for(Integer key:questList.keySet()){
            temp = questList.get(key);
            //if it is not completed and in the same part, then it will be available
            if(temp.questCompletion == false && temp.questPart == MainCharacter.currentPart && temp.qAccepted == false){
                counter++;
                Program.systemDialogue("ID: " + key);
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
        if(counter == 0){
            Program.npcDialogue("It seems like you do not have any quest that you can accept.");
        }
        else{
            questAskPage();
        }
        
    }
    //ask for what quest to accept
    public static void questAskPage(){
        Program.systemDialogue("What quest are you going to accept?");
        Program.systemDialogue("Type the ID number of the quest you want to accept.");
        Program.systemDialogue("Type 1 to exit.");
        boolean accepted = false;
        while(!accepted){
            int questAcceptedKey = Program.askInt();
            if (questAcceptedKey == 1) break;
            if(questList.containsKey(questAcceptedKey)){
            Quests temps = questList.get(questAcceptedKey);
            //if accepted and available
                if(temps.questCompletion == false && temps.questPart == MainCharacter.currentPart && temps.qAccepted == false){
                    temps.qAccepted = true;
                    Program.systemDialogue("You accepted quest " + questAcceptedKey + ".");
                    break;
                }
                else {
                    Program.systemDialogue("Unavailable quest. Try again.");
                }
            }
            else{
                Program.systemDialogue("Wrong ID. Try again.");
            }
        }
    }
}
