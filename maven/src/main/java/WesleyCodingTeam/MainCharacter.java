package WesleyCodingTeam;

public class MainCharacter {
        static String name; //MainCharacter name
        static String classType; //MainCharacter class
        static int lv; //level
        static int age; // age
        static int str; //strength
        static int wis; //wisdom
        static int agi; //agility
        static int hpMax; //maximum HP
        static int hpNow; //current HP
        static int mpMax; //maximum MP
        static int mpNow; //current MP
        static int coin; //money
        static int expRequired = 10;
        static int currentExp = 0;
        static int extraStat = 0;
        static int currentPart = 0; //current part in the story
        static String occupation = "villager";
        static String currentState = "Idle"; //tells what the charcter is doing idle, fighting, shoping etc.
        static double normalDamageMultiplier = 1.0;
        static String currentLocation = "Your House";
    //declaring field
    public static void makeStats(String nameChoice, String classTypeChoice, int lvChoice, int ageChoice, int strChoice, int wisChoice, int agiChoice, int hpMaxChoice, int hpNowChoice, int mpMaxChoice, int mpNowChoice, int coinChoice){
        name = nameChoice;
        classType = classTypeChoice;
        lv = lvChoice;
        age = ageChoice;
        str = strChoice;
        wis = wisChoice;
        agi = agiChoice;
        hpMax = hpMaxChoice;
        hpNow = hpNowChoice;
        mpMax = mpMaxChoice;
        mpNow = mpNowChoice;
        coin = coinChoice;
        }
    
    //printing out stat
    public static void statPage(){
        System.out.println();
        System.out.println("             STATS");
        System.out.println("________________________________");
        System.out.println("Name:           " + name);
        System.out.println("Age:            " + age);
        System.out.println("Job:            " + occupation);
        System.out.println("Class:          " + classType);
        System.out.println("Lv:             " + lv + " ("+currentExp+"/"+expRequired+")");
        System.out.println("HP:             " + hpNow + "/" + hpMax);
        System.out.println("MP:             " + mpNow + "/" + mpMax);
        System.out.println("Strength:       " + str);
        System.out.println("Wisdom:         " + wis);
        System.out.println("Agility:        " + agi);
        System.out.println("Coin:           " + coin + " coins");
        System.out.println("________________________________");
        System.out.println();
        if(extraStat > 0){
            statChangeAsk();
        }
    }
    public static void statChangeAsk() {
        Program.systemDialogue("You have " +extraStat+" extra stat you can use. Would you like to use it now?(y/n)");
        char ans = Program.askChar();
        if(ans == 'y'){
            Program.systemDialogue("Tell what stat you want to increase.");
            Program.systemDialogue("'s' for strength, 'w' for wisdom, and 'a' for agility.");
            char response = Program.askChar();
            Program.systemDialogue("How much do you want to increase? Your extra stat: " + extraStat);
            int response2 = Program.askInt();
            if(response2 > extraStat){
                Program.systemDialogue("Can't be greater than the stat you can use.");
                statChangeAsk();
            }
            switch (response){
                case 's':
                    str +=response2;
                    Program.systemDialogue("Your strength stat is now " + str +".");
                    break;
                case 'w':
                    wis +=response2;
                    Program.systemDialogue("Your wisdom stat is now " + wis +".");
                    break;
                case 'a':
                    agi +=response2;
                    Program.systemDialogue("Your agility stat is now " + agi +".");
                    break;
                default:
                    statChangeAsk();
                    break;
            }
            extraStat -= response2;
            Program.systemDialogue("Do you have more stat you want to increase?(y/n)");
            char res = Program.askChar();
            if(res == 'y'){
                statChangeAsk();
            }
        }
        else if (ans != 'n'){
            Program.systemDialogue("Wrong response.");
            statChangeAsk();
        }
    }
    //healing HP using potion,skill etc
    public static void healHP(int healAmount) {
        if(healAmount + hpNow >= hpMax){
            hpNow = hpMax;
        }
        else{
            hpNow += healAmount;
        }
    }
    //healing MP using potion,skill etc
    public static void healMP(int healAmount) {
        if(healAmount + mpNow >= mpMax){
            mpNow = mpMax;
        }
        else{
            mpNow += healAmount;
        }
    }

    //damage counter
    public static int normalAttackDamageCounter(){
        int damage = 0;
        Inventory.updateEquiped();
        damage = (int) (str * normalDamageMultiplier + Inventory.getWeaponDamage(Inventory.currentEquipedWeapon));
        return damage;
    }
    public static void checkLevelUp() {
        if(currentExp>=expRequired){
            levelUp();
        }
    }
    public static void levelUp(){
        lv++;
        hpMax += 10;
        mpMax += 10;
        extraStat += 2;
        currentExp -= expRequired;
        if(lv<10){
            expRequired *= 1.5;
        }
        else{
            expRequired *= 1.2;
        }
        Program.systemDialogue("YOU LEVELED UP!!! YOU ARE NOW Lv. " + lv+"!");
        Program.systemDialogue("You currently have " + extraStat +" stats you can use.");
        //some code for stat change

    }
    public static void myQuests(){
        Quests temp;
        for(Integer key:Guild.questList.keySet()){
            temp = Guild.questList.get(key);
            //if it is not completed and in the same part, then it will be available
            if(temp.qAccepted == true && temp.questCompletion == false){
                System.out.println("__________________________________ QUESTS________________________________________");
                switch (temp.qType){
                    case 1:
                        System.out.println();
                        System.out.println(" Quest(Rank " + temp.qRank + ") : " + temp.questDetail1 + " (" + temp.currentNumDetail1 + "/" + temp.numDetail1 + ").");
                        System.out.println();
                        System.out.println("                                                            Reward: " + temp.rewardM + " coins");
                        System.out.println();
                        System.out.println("_________________________________________________________________________________");
                        System.out.println();
                        break;
                
                    case 2:
                        System.out.println();
                        System.out.println(" Quest(Rank " + temp.qRank + ") : " + temp.questDetail1 + " (" + temp.currentNumDetail1 + "/" + temp.numDetail1 + ") and " + temp.questDetail2 + " (" + temp.currentNumDetail2 + "/" + temp.numDetail2 + ").");
                        System.out.println();
                        System.out.println("                                                            Reward: " + temp.rewardM + " coins");
                        System.out.println();
                        System.out.println("_________________________________________________________________________________");
                        System.out.println();
                        break;
                    default:
                        break;
                }
            }
        }
    }    
    //gold minus
    public static void minusGold(int coins){
        coin -= coins;
    }
}
