public class Class{
        static String classesType = Character.classType;
        static int veryhigh = 15;
        static int high = 9;
        static int avg = 6;
        static int low = 3;
        //does this work?


    public static String[] classes(){
        String[] classes = {"Knight", "Wizard", "Rogue", "Swordsman"};
        return classes;
        //not sure what to do here yet
    }


    public static void knight(){
        Character.str += high;
        Character.wis += avg;
        Character.agi += low;
    }
    public static void wizard(){
        Character.str += low;
        Character.wis += veryhigh;
        Character.agi += low;
    }
    public static void rogue(){
        Character.str += avg;
        Character.wis += low;
        Character.agi += high;
    }
    public static void swordsman(){
        Character.str += avg;
        Character.wis += avg;
        Character.agi += avg;
    }


    //list of class stuff
    public static void classPage(){
        System.out.println();
        System.out.println("                CLASS TYPES");
        System.out.println("_____________________________________________");
        System.out.println("|Class      |Strength  |Wisdom     |Agility  |");
        System.out.println("|--------------------------------------------|");
        System.out.println("|Knight     |High      |Average    |Low      |");
        System.out.println("|Wizard     |Low       |Very High  |Low      |");
        System.out.println("|Rogue      |Average   |Low        |High     |");
        System.out.println("|Swordsman  |Average   |Average    |Average  |");
        System.out.println("|--------------------------------------------|");
        System.out.println();

    }



    public static void selection(){
        System.out.println("You can now choose which class to master!");
        classPage();
        Program.scanString();

    }

    //player's class
    public static void playerClass(){
        System.out.println();
        System.out.println("             CLASS");
        System.out.println("________________________________");
        System.out.println("Class:          " + classesType);
        System.out.println("Strength:       " + Character.str);
        System.out.println("Wisdom:         " + Character.wis);
        System.out.println("Agility:        " + Character.agi);
        System.out.println();
    }




}