package WesleyCodingTeam;

public class Battle {
    static int turn;
    private static Monster currentMonster;
    public static void battleNow(int monsterIDs) {
        turn = 1;
        MainCharacter.currentState = "Fighting";
        currentMonster = Data.monsterList.get(monsterIDs).clone();
        System.out.println("");
        Program.narrationDialogue("You encountered with " + currentMonster.name+"!");
        battleStatus();

    }
    //prints out current status of battle
    public static void battleStatus(){
        System.out.println("________________TURN "+ turn +"________________");
        System.out.println("");
        System.out.println("                +-------------------- ");
        System.out.println("                |Name:"+ currentMonster.name);
        System.out.println("                |HP:  " + currentMonster.currentHp+"/"+currentMonster.hp);
        System.out.println("                |" + barGauge(1));
        System.out.println("                +-------------------- ");
        System.out.println("");
        System.out.println("My HP:" + MainCharacter.hpNow +"/"+ MainCharacter.hpMax + " " + barGauge(2));
        System.out.println("My MP:" + MainCharacter.mpNow +"/"+ MainCharacter.mpMax + " " + barGauge(3));
        System.out.println("");
        askAction();
    }
    //user action
    public static void askAction(){
        Program.narrationDialogue("What are you going to do?");
        Program.dialogue("1. Fight  2.Potion  3.Run");
        int answ = Program.askInt();
        switch (answ) {
            case 1:
                boolean killed = dealDamage();
                boolean died = receiveDamage();
                turn++;
                if(!died && !killed){
                    battleStatus();
                }
                if(!killed){

                }
                break;
            case 2:
                Inventory.getPotions();
                receiveDamage();
                turn++;
                if(MainCharacter.hpNow>0){
                    battleStatus();
                }
                break;
            case 3:

            break;
            default:
                Program.systemDialogue("Wrong command try again!");
                askAction();
                break;
        }

    }
    //hp display gauge
    public static String barGauge(int type){
        int divideLife = 0;
        int life_Remaining = 0;
        int numOfHashtag = 0;
        if(type == 1){
            numOfHashtag = 20;
            divideLife = currentMonster.hp/numOfHashtag;
            life_Remaining = currentMonster.currentHp/divideLife;
        }
        else if (type == 2){
            numOfHashtag = 10;
            divideLife = MainCharacter.hpMax/numOfHashtag;
            life_Remaining = MainCharacter.hpNow/divideLife;
        }
        else if (type == 3){
            numOfHashtag = 10;
            divideLife = MainCharacter.mpMax/numOfHashtag;
            life_Remaining = MainCharacter.mpNow/divideLife;
        }
        else{
            System.out.println("Error on bar gauge");
        }
        String lifeBar = "[";
        int i;
        for (i = 1;i<=life_Remaining;i++){
            lifeBar += "#";
        }
        for (int j = 0; j<numOfHashtag-i;j++){
            lifeBar += " ";
        }
        lifeBar += "]";
        return lifeBar;

    }
    //deal damage
    public static boolean dealDamage(){
        boolean killed = false;
        int damageDealt = MainCharacter.normalAttackDamageCounter() - currentMonster.defense;
        if (damageDealt < 0) {
            damageDealt = 0;
        }
        currentMonster.currentHp = (currentMonster.currentHp - damageDealt);
        Program.systemDialogue("You dealt " + damageDealt + " damage to the monster!");
        if (monsterDeathCheck()){
            MainCharacter.currentState = "Idle";
            Program.systemDialogue("You slain "+ currentMonster.name + "!");
            killed = true;
        }
        return killed;
    }
    //receive damage
    private static boolean receiveDamage() {
        boolean died = false;
        int damageReceived = currentMonster.damage;
        Program.systemDialogue("You received " + damageReceived + " damage from the monster!");
        MainCharacter.hpNow -= damageReceived;
        if (characterDeathCheck()){
            MainCharacter.currentState = "Idle";
            Program.systemDialogue("You died......");
            died = true;
        }
        return died;
    }
    //check if character is dead or not
    public static boolean characterDeathCheck(){
        if (MainCharacter.hpNow <= 0){
            return true;
        }
            return false;
    }
    //check if monster is dead or not
    public static boolean monsterDeathCheck(){
        if (currentMonster.currentHp <= 0){
            return true;
        }
            return false;
    }

    public static void battleNowTutorial(int monsterIDs) {
        turn = 1;
        MainCharacter.currentState = "Fighting";
        currentMonster = Data.monsterList.get(monsterIDs).clone();
        Program.systemDialogue("Fighting with " + currentMonster.name+"!!!");
        battleStatusTutorial();
        boolean pass = false;
        while (!pass) {
            Program.systemDialogue("What are you going to do?");

            Program.dialogue("1.Run");
            int answ = Program.askInt();
            if (answ == 1){
                pass = true;
                turn++;
            }
            else{
                Program.systemDialogue("You have nothing else to do!");
            }
        }
        Program.systemDialogue("You couldn't escape!");
        receiveDamage();
        battleStatusTutorial();
        Program.dialogue("I won't go down without a fight!");
        askActionTutorial();
        battleStatusTutorial();
        Program.dialogue("It is too strong. Is... is this the end?");
        askActionTutorial();
        battleStatusTutorial();
        Program.waitingTime(2000);
        Program.narrationDialogue("A voice whispers to you from above and you feel a beam of light shining upon you");
        Program.npcDialogue(MainCharacter.name + "  ...Don't give up yet...Live for them... ");
        Program.dialogue("Wha.. What is this? Am I hearing things because I am going to die? ");
        int answ = 0;
        while(answ != 1){
            Program.systemDialogue("What are you going to do?");
            Program.dialogue("1. Fight 2.Run");
            answ = Program.askInt();
            switch (answ) {
                case 1:
                    Program.narrationDialogue("A mystical power runs through your veins");
                    Program.dialogue("!$%$^%@!&##!(#(!#&*#!(!*^#&!#");
                    Program.narrationDialogue("You feel your body lose all its weight");
                    Program.systemDialogue("You dealt 99999 damage to the monster!");
                    Program.systemDialogue("You slain "+ currentMonster.name + "!");
                    break;
                case 2:
                    Program.dialogue("There is no way. It is either me or the wolf that will die.");
                break;
                default:
                    Program.systemDialogue("Wrong command try again!");
                    break;
            }
        }
        MainCharacter.lv = 1;
        Program.narrationDialogue("You faint from the exhaustion");
        MainCharacter.currentState = "Idle";
        MainCharacter.occupation = "Hero";
    }

    //display tutorial
    public static void battleStatusTutorial(){
        System.out.println("");
        System.out.println("________________TURN "+ turn +"________________");
        System.out.println("");
        System.out.println("                +-------------------- ");
        System.out.println("                |Name:"+ currentMonster.name);
        System.out.println("                |HP:  " + currentMonster.currentHp+"/"+currentMonster.hp);
        System.out.println("                |" + barGauge(1));
        System.out.println("                +-------------------- ");
        System.out.println("");
        System.out.println("My HP:" + MainCharacter.hpNow +"/"+ MainCharacter.hpMax + " " + barGauge(2));
        System.out.println("My MP:" + MainCharacter.mpNow +"/"+ MainCharacter.mpMax + " " + barGauge(3));
        System.out.println("");
    }
    //user action
    public static void askActionTutorial(){
        Program.systemDialogue("What are you going to do?");
        Program.dialogue("1. Fight  2.Run");
        int answ = Program.askInt();
        switch (answ) {
            case 1:
                dealDamage();
                receiveDamage();
                turn++;
                break;
            case 2:
                Program.dialogue("I don't think I can run.");
                askActionTutorial();
            break;
            default:
            Program.systemDialogue("Wrong command try again!");
                askActionTutorial();
                break;
        }

    }
}
