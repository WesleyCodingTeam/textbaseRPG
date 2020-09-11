public class part1 {
    static questGenerator quest1 = new questGenerator();
    public static void questFGame(){
        System.out.println();
        System.out.println("Part 1: All the Heroes do not go to Battle in the Beginning");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| You are now at the staircase of the guild building where the quest board stands.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| Do you want to see the quest? (y/n)");
        program read = new program();
        char ans = read.scanChar();
        while (ans == 'n'){
            System.out.println();
            System.out.println("Hey! You need to earn money");
            System.out.println();
            program.waitingTime(2000);
            System.out.println("| Do you want to see the quest? (y/n)");
            ans = read.scanChar();
        }
        System.out.println();
        quest1.questGen('F', "Get woods", 0, 50, "Get stones" , 0, 30, 100);
        System.out.println();
        program.waitingTime(4000);
        System.out.println("- (Shouting) Hey, " + character.name + "! Going gathering? I will teach you how to do it.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| You can gather woods and stones if you type 'gather'.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| You also can sell stone and wood in the shop. Type 'shop' to go the the shop.");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("| If you want to check your progress, type 'quest'.");
        System.out.println();
        program.waitingTime(2000);
        action.charAction();
    }
}
