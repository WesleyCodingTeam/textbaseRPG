public class Class{
        static String classesType;
        static String strength;
        static String wisdom;
        static String agility;
        static String high = "High";
        static String avg = "Average";
        static String low = "Low";
        //does this work?


    public String[] classes(){
        String[] classes = {"Knight", "Wizard", "Rogue", "Swordsman"};
        return classes;
        //not sure what to do here yet
    }

    public static void knight(){
        strength = high;
        wisdom = avg;
        agility = low;
    }
    public static void wizard(){
        strength = low;
        wisdom = "Very High";
        agility = low;
    }
    public static void rogue(){
        strength = avg;
        wisdom = low;
        agility = high;
    }
    public static void swordsman(){
        strength = avg;
        wisdom = avg;
        agility = avg;
    }


    //list of class stuff
    public static void classPage(){
        System.out.println();
        System.out.println("            CLASS TYPES");
        System.out.println("______________________________________");
        System.out.println("|Class    |Strength|Wisdom   |Agility|");
        System.out.println("|Knight   |High    |Average  |Low    |");
        System.out.println("|Wizard   |Low     |Very High|Low    |");
        System.out.println("|Rogue    |Average |Low      |High   |");
        System.out.println("|Swordsman|Average |Average  |Average|");
        System.out.println("--------------------------------------");
        System.out.println();

    }

    //for declaring class
    //also when using set Class, we should ask user to input it
    public static void setClass(String classType, String strengthType, String wisdomType, String agilityType){
        classesType = classType;
        strength = strengthType;
        wisdom = wisdomType;
        agility = agilityType;
    }

    //player's class
    public static void playerClass(){
        System.out.println();
        System.out.println("             CLASS");
        System.out.println("________________________________");
        System.out.println("Class:          " + classesType);
        System.out.println("Strength:       " + strength);
        System.out.println("Wisdom:         " + wisdom);
        System.out.println("Agility:        " + agility);
        System.out.println();
    }




}