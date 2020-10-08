import java.util.ArrayList;

public class Battle {
    static int monsterID;
    static int turn;
    static final int MONSTERID = 0;
    static final int MONSTERNAME = 1;
    static final int MONSTERTYPE = 2;
    static final int MONSTERHP = 3;
    static final int MONSTERCURRENTHP = 4;
    static final int MONSTERDEFENSE = 5;
    static final int MONSTERDAMAGE = 6;
    static final int MONSTERDESCRIPTION = 7;
    private static ArrayList<String> currentMonster;
    public static void battleNow(int monsterIDs) {
        monsterID = monsterIDs;
        turn = 1;
        Character.currentState = "Fighting";
        currentMonster = Monster.monsterList.get(monsterID);
        String name = getFightingMonsterName();
        System.out.println("");
        System.out.println("| Fighting with " + name);
        System.out.println();
        battleStatus();
        
    }
    //prints out current status of battle
    public static void battleStatus(){
        System.out.println("________________TURN "+ turn +"________________");
        System.out.println("");
        System.out.println("                +-------------------- ");
        System.out.println("                |Name:"+ getFightingMonsterName());
        System.out.println("                |HP:  " + getFightingMonsterCurrentHP()+"/"+getFightingMonsterHP());
        System.out.println("                +-------------------- ");
        System.out.println("");
        System.out.println("My HP:" + Character.hpNow +"/"+ Character.hpMax);
        System.out.println("My MP:" + Character.mpNow +"/"+ Character.mpMax);
        System.out.println("");
        askAction();
    }
    //user action
    public static void askAction(){
        System.out.println("");
        System.out.println("| What are you going to do?");
        System.out.println("1. Fight  2.Potion  3.Run");
        System.out.print("> ");
        int answ = Program.scanInt();
        switch (answ) {
            case 1:
                dealDamage();
                receiveDamage();
                turn++;
                battleStatus();
                break;
            case 2:
                Inventory.usePotion();
                receiveDamage();
                turn++;
                battleStatus();
                break;
            case 3:
                
            break;
            default:
                System.out.println("Wrong command try again!");
                askAction();
                break;
        }

    }
    //deal damage
    public static void dealDamage(){
        int damageDealt = Character.normalAttackDamageCounter() - getFightingMonsterDefense();
        if (damageDealt < 0) {
            damageDealt = 0;
        }
        setFightingMonsterCurrentHP(getFightingMonsterCurrentHP() - damageDealt);
        System.out.println("");
        System.out.println("| You dealt " + damageDealt + " damage to the monster!");
        System.out.println("");
        Program.waitingTime(1000);
        if (monsterDeathCheck()){
            System.out.println("| You slain "+ getFightingMonsterName() + "!");
            System.out.println("");
            //some code to proceed to next
        }        
    }
    //receive damage
    private static void receiveDamage() {
        int damageReceived = getFightingMMonsterDamage();
        Program.waitingTime(1000);
        System.out.println("| You received " + damageReceived + " damage from the monster!");
        System.out.println("");
        Program.waitingTime(1000);
        Character.hpNow -= damageReceived;
        if (characterDeathCheck()){
            System.out.println("| You died...");
            System.out.println("");
            //some code to go back home
        }
    }
    //check if character is dead or not
    public static boolean characterDeathCheck(){
        if (Character.hpNow <= 0){
            return true;
        }
        else{
            return false;
        }
    }
    //check if monster is dead or not
    public static boolean monsterDeathCheck(){
        if (getFightingMonsterCurrentHP() <= 0){
            return true;
        }
        else{
            return false;
        }
    }
    //gets fighting monster name
    public static String getFightingMonsterName(){
        String i = currentMonster.get(MONSTERNAME);
        return i;
    }
    //gets fighting monster HP
    public static int getFightingMonsterHP(){
        String i = currentMonster.get(MONSTERHP);
        int j = Integer.parseInt(i);  
        return j;
    }
    //gets fighting monster current HP
    public static int getFightingMonsterCurrentHP(){
        String i = currentMonster.get(MONSTERCURRENTHP);
        int j = Integer.parseInt(i);  
        return j;
    }
    //sets fighting monster current HP
    public static void setFightingMonsterCurrentHP(int changedHP){
        String i = Integer.toString(changedHP); 
        currentMonster.set(MONSTERCURRENTHP, i);
    }
    
    //gets fighting monster defense
    public static int getFightingMonsterDefense(){
        String i = currentMonster.get(MONSTERDEFENSE);
        int j = Integer.parseInt(i);  
        return j;
    }
    //sets fighting monster Defense
    public static void setFightingWeaponDefense(int changedDefense){
        String i = Integer.toString(changedDefense); 
        currentMonster.set(MONSTERDEFENSE, i);
    }
    //gets fighting monster damage
    public static int getFightingMMonsterDamage(){
        String i = currentMonster.get(MONSTERDAMAGE);
        int j = Integer.parseInt(i);  
        return j;
    }
    //sets fighting monster damage
    public static void setFightingMonsterDamage(int changedDamage){
        String i = Integer.toString(changedDamage); 
        currentMonster.set(MONSTERDAMAGE, i);
    }

    public static void battleNowTutorial(int monsterIDs) {
        monsterID = monsterIDs;
        turn = 1;
        Character.currentState = "Fighting";
        currentMonster = Monster.monsterList.get(monsterID);
        String name = getFightingMonsterName();
        System.out.println("");
        System.out.println("| Fighting with " + name+"!!!");
        System.out.println();
        System.out.println("________________TURN "+ turn +"________________");
        System.out.println("");
        System.out.println("                +-------------------- ");
        System.out.println("                |Name:"+ getFightingMonsterName());
        System.out.println("                |HP:  " + getFightingMonsterCurrentHP()+"/"+getFightingMonsterHP());
        System.out.println("                +-------------------- ");
        System.out.println("");
        System.out.println("My HP:" + Character.hpNow +"/"+ Character.hpMax);
        System.out.println("My MP:" + Character.mpNow +"/"+ Character.mpMax);
        System.out.println("");
        boolean pass = false;
        while (!pass) {
            System.out.println("");
            System.out.println("| What are you going to do?");
            Program.waitingTime(1000);
            System.out.println("1.Run");
            System.out.print("> ");
            int answ = Program.scanInt();
            if (answ == 1){
                pass = true;
                turn++;
            }
            else{
                System.out.println("| You couldn't escape!");//@jun something that says you only can run
            }
        }
        System.out.println("| You couldn't escape!");//@jun some thing that says you didn't make it\
        receiveDamage();
        System.out.println("________________TURN "+ turn +"________________");
        System.out.println("");
        System.out.println("                +-------------------- ");
        System.out.println("                |Name:"+ getFightingMonsterName());
        System.out.println("                |HP:  " + getFightingMonsterCurrentHP()+"/"+getFightingMonsterHP());
        System.out.println("                +-------------------- ");
        System.out.println("");
        System.out.println("My HP:" + Character.hpNow +"/"+ Character.hpMax);
        System.out.println("My MP:" + Character.mpNow +"/"+ Character.mpMax);
        System.out.println("");
        Program.waitingTime(2000);
        System.out.println("| I won't go down without a fight");//@jun some talking and determines to fight
        askActionTutorial();
        System.out.println("________________TURN "+ turn +"________________");
        System.out.println("");
        System.out.println("                +-------------------- ");
        System.out.println("                |Name:"+ getFightingMonsterName());
        System.out.println("                |HP:  " + getFightingMonsterCurrentHP()+"/"+getFightingMonsterHP());
        System.out.println("                +-------------------- ");
        System.out.println("");
        System.out.println("My HP:" + Character.hpNow +"/"+ Character.hpMax);
        System.out.println("My MP:" + Character.mpNow +"/"+ Character.mpMax);
        System.out.println("");
        Program.waitingTime(2000);
        System.out.println("| Is... is this the end?");
        askActionTutorial();
        System.out.println("________________TURN "+ turn +"________________");
        System.out.println("");
        System.out.println("                +-------------------- ");
        System.out.println("                |Name:"+ getFightingMonsterName());
        System.out.println("                |HP:  " + getFightingMonsterCurrentHP()+"/"+getFightingMonsterHP());
        System.out.println("                +-------------------- ");
        System.out.println("");
        System.out.println("My HP:" + Character.hpNow +"/"+ Character.hpMax);
        System.out.println("My MP:" + Character.mpNow +"/"+ Character.mpMax);
        System.out.println("");
        Program.waitingTime(2000);
        System.out.println("| __A voice whispers to you from above__");
        System.out.println("");
        Program.waitingTime(2000);
        System.out.println("| " + Character.name + "  ...Don't give up yet...Live for them... ");
        int answ = 0;
        while(answ != 1){
            System.out.println("");
            Program.waitingTime(2000);
            System.out.println("| What are you going to do?");
            Program.waitingTime(1000);
            System.out.println("1. Fight 2.Run");
            System.out.print("> ");
            answ = Program.scanInt();
            switch (answ) {
                case 1:
                     Program.waitingTime(2000);
                    System.out.println("| __You feel your body lose all its weight__");
                    System.out.println("");
                    Program.waitingTime(2000);
                    System.out.println("| You dealt 999999999 damage to the monster!");
                    System.out.println("");
                    Program.waitingTime(1000);
                    System.out.println("| You slain "+ getFightingMonsterName() + "!");
                    System.out.println("");
                    break;
                case 2:
                Program.waitingTime(2000);
                    System.out.println("| I can take him down");//@jun some talking that he will not run
                break;
                default:
                Program.waitingTime(2000);
                    System.out.println("Wrong command try again!");
                    break;
            }
        }   
        System.out.println("| __You faint from the exhaustion__");

    }


    //user action
    public static void askActionTutorial(){
        System.out.println("");
        System.out.println("| What are you going to do?");
        Program.waitingTime(1000);
        System.out.println("1. Fight  2.Run");
        System.out.print("> ");
        int answ = Program.scanInt();
        switch (answ) {
            case 1:
                dealDamage();
                receiveDamage();
                turn++;
                break;
            case 2:
                System.out.println("| I can take him down");
                askActionTutorial();
            break;
            default:
                System.out.println("Wrong command try again!");
                askAction();
                break;
        }

    }
}
