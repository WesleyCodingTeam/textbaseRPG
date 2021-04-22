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
        Program.terminal.println();
        Program.terminal.println("                CLASS TYPES");
        Program.terminal.println("_____________________________________________");
        Program.terminal.println("|Class      |Strength  |Wisdom     |Agility  |");
        Program.terminal.println("|--------------------------------------------|");
        Program.terminal.println("|Knight     |High      |Average    |Low      |");
        Program.terminal.println("|Wizard     |Low       |Very High  |Low      |");
        Program.terminal.println("|Rogue      |Average   |Low        |High     |");
        Program.terminal.println("|Swordsman  |Average   |Average    |Average  |");
        Program.terminal.println("|--------------------------------------------|");
        Program.terminal.println();

    }


// this should theoretically work... right?? or does the ifandelse() not work since im using it before it is made?
    public static void selection(){
        Program.terminal.println("You can now choose which class to master!");
        classPage();
        Program.terminal.println("Type \"k\" for Knight, \"w\" for Wizard, \"r\" for Rogue, and \"s\" for Swordsman!");
        ifandelse();
    }
    public static void ifandelse(){
        char type = Program.askChar();
        Program.terminal.print("> ");
        if (type == 'k') {
            knight();
            Program.terminal.println("You are now a Knight!");
        } else if (type == 'w') {
            wizard();
            Program.terminal.println("You are now a Wizard!");
        } else if (type == 'r') {
            rogue();
            Program.terminal.println("You are now a Rogue!");
        } else if (type == 's') {
            swordsman();
            Program.terminal.println("You are now a Swordsman!");
        } else {
            Program.terminal.println("That's not a valid class! Try again!");
            selection();
        }
    }
}
