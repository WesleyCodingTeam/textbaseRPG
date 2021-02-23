package WesleyCodingTeam;

public class Class{
        static int veryhigh = 15;
        static int high = 9;
        static int avg = 6;
        static int low = 3;


    public static void knight(){
        MainCharacter.classType = "Knight";
        MainCharacter.str += high;
        MainCharacter.wis += avg;
        MainCharacter.agi += low;
        MainCharacter.normalDamageMultiplier = 1.5;
    }
    public static void wizard(){
        MainCharacter.classType = "Wizard";
        MainCharacter.str += low;
        MainCharacter.wis += veryhigh;
        MainCharacter.agi += low;
        MainCharacter.normalDamageMultiplier = 0.5;
    }
    public static void rogue(){
        MainCharacter.classType = "Rogue";
        MainCharacter.str += avg;
        MainCharacter.wis += low;
        MainCharacter.agi += high;
        MainCharacter.normalDamageMultiplier = 1.2;
    }
    public static void swordsman(){
        MainCharacter.classType = "Swordsman";
        MainCharacter.str += avg;
        MainCharacter.wis += avg;
        MainCharacter.agi += avg;
        MainCharacter.normalDamageMultiplier = 1.3;
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


// this should theoretically work... right?? or does the ifandelse() not work since im using it before it is made?
    public static void selection(){
        System.out.println("You can now choose which class to master!");
        classPage();
        System.out.println("Type \"k\" for Knight, \"w\" for Wizard, \"r\" for Rogue, and \"s\" for Swordsman!");
        ifandelse();
    }
    public static void ifandelse(){
        char type = Program.scanChar();
        System.out.print("> ");
        if (type == 'k') {
            knight();
            System.out.println("You are now a Knight!");
        } else if (type == 'w') {
            wizard();
            System.out.println("You are now a Wizard!");
        } else if (type == 'r') {
            rogue();
            System.out.println("You are now a Rogue!");
        } else if (type == 's') {
            swordsman();
            System.out.println("You are now a Swordsman!");
        } else {
            System.out.println("That's not a valid class! Try again!");
            selection();
        }
    }
}