public class Character {
        static String name; //Character name
        static String classType; //Character class
        static int lv; //level
        static int age; // age
        static int str; //strength
        static int wis; //wisdom
        static int agi; //agility
        static int hpMax; //maximum HP
        static int hpNow; //current HP
        static int mpMax; //maximum MP
        static int mpNow; //current MP
        static int atk; //attack damage, this must be calulated in regard to other effects(weapon damage etc.)
        static int coin; //money
        static int currentPart; //current part in the story
        static String currentState; //tells what the charcter is doing idle, fighting, shoping etc.

    //declaring field
    public static void makeStats(String nameChoice, String classTypeChoice, int lvChoice, int ageChoice, int strChoice, int wisChoice, int agiChoice, int hpMaxChoice, int hpNowChoice, int mpMaxChoice, int mpNowChoice, int atkChoice, int coinChoice){
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
        atk = atkChoice;
        coin = coinChoice;
        }
    
    //printing out stat
    public static void statPage(){
        System.out.println();
        System.out.println("             STATS");
        System.out.println("________________________________");
        System.out.println("Name:           " + name);
        System.out.println("Age:            " + age);
        System.out.println("Class:          " + classType);
        System.out.println("Lv:             "+ lv);
        System.out.println("HP:             " + hpNow + "/" + hpMax);
        System.out.println("MP:             " + mpNow + "/" + mpMax);
        System.out.println("Attack:         " + atk);
        System.out.println("Strength:       " + str);
        System.out.println("Wisdom:         " + wis);
        System.out.println("Agility:        " + agi);
        System.out.println("Coin:           " + coin + " coins");
        System.out.println("________________________________");
        System.out.println();
    }

    //damage counter
    public static int damageCounter(){
        return 9;
    }
}
