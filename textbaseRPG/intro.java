public  class intro {
    public static void introduction(){
        //intro statements
        System.out.println("| The game is starting");
        //prints "." out 5 times
        for (int i = 0; i <5; i++){
            System.out.print(".");
            program.waitingTime(500);
        }
        System.out.println();
        System.out.println();
        System.out.println("| What is your name?");
        //program folder has scan method which will allow scanning of command. Look at program.java 
        program sc = new program();
        String ans = sc.scanString();
        System.out.println();
        //assign value to name field in character.java
        character.name = ans;
        System.out.println("| What is your age?");
        int answ = sc.scanInt();
        System.out.println();
        //same method as above comment
        character.age = answ;
        System.out.println("| You can roll the dice to set your stat. You can roll up to 10 times.");
        System.out.println();
        System.out.println("| The stat is random from 5 ~ 15.");
        System.out.println();
        program.waitingTime(2000);
        //roll is counter
        int roll = 0;
        boolean stop = false;
        while(stop == false && roll < 10){
            System.out.println("| Rolling the dice....");
            System.out.println();
            program.waitingTime(1500);
            roll++;
            //assigning stat from randumNum method in program.java. Look more at program.java
            character.str = program.randomNum(5, 15);
            character.wis = program.randomNum(5, 15);
            character.agi = program.randomNum(5, 15);
            //creating stat/character initialization
            character.makeStats(character.name, "None", 1, character.age, character.str, character.wis, character.agi, 100, 100, 100, 100, 10, 10);
            //use statPage method to print out stats
            character.statPage();
            System.out.println();
            program.waitingTime(500);
            System.out.println("| Roll again? y/n");
            char i = sc.scanChar();
            //allows the loop to be stopped or continued
            if (i == 'n'){
                stop = true;
            }
        }
        for (int i = 0; i < 6; i++){
            System.out.print(".");
            program.waitingTime(500);
        }
        //just some dialogues
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Part 0: The Beginning of The Legend");
        System.out.println("-----------------------------------");
        System.out.println();
        program.waitingTime(2000);
        System.out.println("- Hey!!!");
        System.out.println();
        //repeating
        for (int i = 0; i <4; i++){
            System.out.print("Zz... ");
            program.waitingTime(700);
        }
        System.out.println();
        program.waitingTime(1000);
        System.out.println();
        System.out.println("- (Screams) Ahhhhhhhhh!!!");
        program.waitingTime(2000);
        System.out.println();
        System.out.print("(Waking up) ");
        //repeating
        for (int i = 0; i <3; i++){
            System.out.print("! ");
            program.waitingTime(200);
        }
        System.out.println();
        System.out.println();
        //calling variable from character.java to include name in the dialogue
        System.out.println("- Ok! Now you woke up. " + character.name + ", aren't you going gathering again?");
        System.out.println();
        program.waitingTime(4000);
        System.out.println("(Looking at the clock) Wait, what? Noooooo. I will be late again. (Runs out of the house)");
        System.out.println();
        program.waitingTime(4000);
        System.out.println("- (Looking at running " + character.name +") Haaah. How old is he? He is " + character.age + " and I have to wake him up every day.");
        System.out.println();
        program.waitingTime(4000);
        System.out.println("- I hope that he would bring enough money to last a week...");
        System.out.println();
        program.waitingTime(4000);
        //runs part1.java with questFGame method
        part1.questFGame();
    }
}
