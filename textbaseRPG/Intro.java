public class Intro {
    public static void introduction(){
        //intro statements
        System.out.println("| The Game is Loading...");
        //prints "..." out 3 times
        for (int i = 0; i <5; i++){
            System.out.print("...");
            Program.waitingTime(500);
            System.out.println();
        }
        System.out.println("| Connected!");
        //prints "..." out 3 times

            Program.waitingTime(500);
        System.out.println();
        System.out.println();
        System.out.println("| Welcome. Player.");
        System.out.println();
        Program.waitingTime(1000);
        System.out.println();
        System.out.println("| What is your name?");
        System.out.print("> ");
        String ans = Program.scanString();
        System.out.println();
        //assign value to name field in Character.java
        Character.name = ans;
        System.out.println("| What is your age?");
        System.out.print("> ");
        int answ = Program.scanInt();
        System.out.println();
        //same method as above comment
        Character.age = answ;
        System.out.println("| You can roll the dice to set your stat. You can roll up to 10 times.");
        System.out.println();
        System.out.println("| The strength, wisdom, agility stat is random from 5 ~ 15.");
        System.out.println();
        Program.waitingTime(2000);
        //roll is counter
        int roll = 0;
        boolean stop = false;
        while(stop == false && roll < 10){
            System.out.println("| Rolling the dice....");
            System.out.println();
            Program.waitingTime(1500);
            roll++;
            //assigning stat from randumNum method in Program.java. Look more at Program.java
            Character.str = Program.randomNum(5, 15);
            Character.wis = Program.randomNum(5, 15);
            Character.agi = Program.randomNum(5, 15);
            //creating stat/Character initialization
            Character.makeStats(Character.name, "None", 1, Character.age, Character.str, Character.wis, Character.agi, 100, 100, 100, 100, 10);
            //use statPage method to print out stats
            Character.statPage();
            System.out.println();
            Program.waitingTime(500);
            System.out.println("| Roll again? y/n");
            System.out.print("> ");
            char i = Program.scanChar();
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
        System.out.println("- " + Character.name + "?");
        System.out.println();
        //repeating
        for (int i = 0; i < 2; i++){
            System.out.print("Zzz... ");
            Program.waitingTime(700);
        }
        System.out.print("Mmmph..");
        Program.waitingTime(2500);
        System.out.println();
        System.out.println();
        System.out.println("-- You feel a soft hand touch your face --");
        Program.waitingTime(2500);
        System.out.println();
        System.out.println("- (Screams) OIIIIII!!!  " + Character.name + "!!");
        Program.waitingTime(2500);
        System.out.println();
        System.out.println("-- You get thrown out of bed from a slap to the face --");
        Program.waitingTime(3000);
        System.out.println();
        System.out.println(" Wh- Wha!?!");
        Program.waitingTime(2000);
        System.out.println();
        System.out.println("-- You see your gorilla of an older sister, towering over you --");
        Program.waitingTime(3000);
        System.out.println();
        //calling variable from Character.java to include name in the dialogue
        System.out.println("- Ha... Why are you sleeping in again?. " + Character.name + ", aren't you going to the guild today?");
        Program.waitingTime(3000);
        System.out.println();
        System.out.println(" Eh!? You're right!");
        Program.waitingTime(2000);
        System.out.println();
        System.out.println("-- You quickly gather your lousy gear and run out of the house --");
        Program.waitingTime(3000);
        System.out.println();
        System.out.println("- Haaah. " + Character.name +" is almost " + Character.age + " and I still have to wake him up everyday.");
        Program.waitingTime(3000);
        System.out.println();
        System.out.println("- I hope he brings back a few gold at least...");
        Program.waitingTime(4000);
        System.out.println();
        //runs part1.java with questFGame method
        Part1.questFGame();
    }
}
