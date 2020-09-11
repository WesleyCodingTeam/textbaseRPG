public class character {
        static String name;
        static String classType;
        static int lv;
        static int age;
        static int str;
        static int wis;
        static int agi;
        static int hpMax;
        static int hpNow;
        static int mpMax;
        static int mpNow;
        static int atk;
        static int coin;
        static int currentPart;
        static String currentState;

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
}
