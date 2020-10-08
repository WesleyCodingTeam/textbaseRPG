public class Shop {

    //page print for list of items
    public static void weaponPage(){
        System.out.println();
        System.out.println("                                   Weapons");
        System.out.println("________________________________________________________________________________");
        System.out.println("|Items                |Price       |Description                                 |");
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("|Basic Sword x 1      |350g        |Can't even touch a goblin with this!        |");
        System.out.println("|Basic Wand x 1       |350g        |Abra Kadabra! Wait... Nothing happened?     |");
        System.out.println("|Basic Knife x 1      |359g        |Good for tickling monsters... Not really.   |");
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println();
    }

    public static void weponAsk(){
        System.out.println("Which item would you like to buy?");
        String askedWeapon = Program.scanString();
        setInventoryItem(int, int quantity);
        //I need to figure out this part later
    }



    public static void potionPage(){
        System.out.println("                                   Potions");
        System.out.println("________________________________________________________________________________");
        System.out.println("|Items                |Price       |Description                                 |");
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("|HP Potion (S) x 1    |50g         |+35 HP (Only consumable onece every round)  |");
        System.out.println("|HP Potion (L) x 1    |359g        |                                            |");
        System.out.println("|Mana Potion (S) x 1  |50g         |+35 Man (Only consumable onece every round) |");
        System.out.println("|Mana Potion (L) x 1  |359g        |                                            |");
        System.out.println("|Cookies x 5          |10g         |+10 HP (Only consumable onece every round)  |");
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println();
    }



    public static void buyItem(){
        System.out.println("What would you like to buy? Type \"w\" for weapons, \"p\" for potions, or \"O\" for others.");
        char type = Program.scanChar();
        if (type =='w'){
            weaponPage();
            
        }
        else if (type == 'p'){
            potionPage();
        }
        else{

        }




    }












}