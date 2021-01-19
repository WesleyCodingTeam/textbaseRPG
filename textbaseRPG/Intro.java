public class Intro {
    public static void introduction(){
        //intro statements
        Program.systemDialogue("The Game is Loading...");
        //prints "..." out 3 times
        for (int i = 0; i <5; i++){
            System.out.print(".");
            Program.waitingTime(500);
        }
        System.out.println();
        Program.systemDialogue("Connected!");
        Program.systemDialogue("Welcome. Player.");
        Program.systemDialogue("What is your name?");
        //assign value to name field in MainCharacter.java
        MainCharacter.name = Program.askString();
        Program.systemDialogue("What is your age?");
        MainCharacter.age = Program.askInt();
        Program.systemDialogue("You can roll the dice to set your stat. You can roll up to 10 times.");
        Program.systemDialogue("The strength, wisdom, agility stat is random from 5 ~ 15.");
        //roll is counter
        int roll = 0;
        boolean stop = false;
        while(stop == false && roll < 10){
            Program.systemDialogue("Rolling the dice....");
            roll++;
            //creating stat/MainCharacter initialization
            MainCharacter.makeStats(MainCharacter.name, "None", 0, MainCharacter.age, Program.randomNum(5, 15), Program.randomNum(5, 15), Program.randomNum(5, 15), 100, 100, 100, 100, 0);
            //use statPage method to print out stats
            MainCharacter.statPage();
            System.out.println();
            Program.waitingTime(500);
            Program.systemDialogue("Roll again? (y/n)");
            char i = Program.askChar();
            //allows the loop to be stopped or continued
            if (i == 'n'){
                stop = true;
            }
        }
        for (int i = 0; i < 6; i++){
            System.out.print(".");
            Program.waitingTime(500);
        }
        //just some dialogues
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Part 0: The Beginning");
        System.out.println("-----------------------------------");
        System.out.println();
        Program.waitingTime(2000);
        Program.npcDialogue(MainCharacter.name + "?");
        //repeating
        for (int i = 0; i < 2; i++){
            System.out.print("Zzz... ");
            Program.waitingTime(700);
        }
        Program.dialogue("Mmmph..");
        Program.narrationDialogue("You feel a soft hand touch your face");
        Program.npcDialogue("(Screams) OIIIIII!!!  " + MainCharacter.name + "!!");
        Program.narrationDialogue("You get thrown out of bed from a slap to the face");
        Program.dialogue("Wh- Wha!?!");
        Program.narrationDialogue("You see your gorilla of an older sister, towering over you");
        Program.npcDialogue("Ha... Why are you sleeping in again?. " + MainCharacter.name + ", aren't you going to the guild today?");
        //calling variable from MainCharacter.java to include name in the dialogue
        Program.dialogue("Eh!? You're right!");
        Program.narrationDialogue("You quickly gather your lousy gear and run out of the house");
        Program.npcDialogue("Haaah. " + MainCharacter.name +" is " + MainCharacter.age + " and I still have to wake him up everyday.");
        Program.npcDialogue("I hope he brings back a few gold at least...");
        //runs part1.java with questFGame method
        Part1.questFGame();
    }
}
