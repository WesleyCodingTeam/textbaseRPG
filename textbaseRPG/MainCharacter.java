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
        System.out.println("Lv:             "+ lv);
        System.out.println("HP:             " + hpNow + "/" + hpMax);
        System.out.println("MP:             " + mpNow + "/" + mpMax);
        System.out.println("Strength:       " + str);
        System.out.println("Wisdom:         " + wis);
        System.out.println("Agility:        " + agi);
        System.out.println("Coin:           " + coin + " coins");
        System.out.println("________________________________");
        System.out.println();
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

    public static void levelUp(){
        lv++;
        Program.systemDialogue("YOU LEVELED UP!!! YOU ARE NOW Lv. " + lv+"!");
    }
    //checking guest based on parts
    public static void currentQuestCheck(){
        switch (MainCharacter.currentPart){
            case 1:
                Part1.quest1.questCheck();
                break;
        
            default:
                Program.systemDialogue("Code error questCheck default");
                break;
        }
    }
}
