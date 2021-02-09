public class Shop {

    //page print for list of items
    public static void weaponPage(){
        //System.out.println();
        //System.out.println("                                   Weapons");
        //System.out.println("________________________________________________________________________________");
        //System.out.println("|Items                |Price       |Description                                 |");
        //System.out.println("|-------------------------------------------------------------------------------|");
        //System.out.println("|Basic Sword x 1      |350g        |Can't even tickle a goblin with this!       |");
        //System.out.println("|Basic Wand x 1       |350g        |Abra Kadabra! Wait... Nothing happened?     |");
        //System.out.println("|Basic Knife x 1      |359g        |Good for tickling monsters... Not really.   |");
        //System.out.println("|-------------------------------------------------------------------------------|");
        //System.out.println();
        System.out.println("Item ID: 1\nName: " + Items.getWeaponName(1001) + " x " + "1\nPrice: 350g\nDesc: Just a normal sword.\n" );
        System.out.println("Item ID: 2\nName: " + Items.getWeaponName(1002) + " x " + "1\nPrice: 350g\nDesc: Just a normal wand.\n" );
        System.out.println("Item ID: 3\nName: " + Items.getWeaponName(1003) + " x " + "1\nPrice: 350g\nDesc: Just a normal knife.\n" );
    }

    public static void weponAsk(){
        System.out.println("Which item would you like to buy? (Say the item ID!)");
        int askedWeapon = Program.scanInt();
        if (not integer){
            System.out.println("Put in the item ID dummy!");
            weaponAsk();
        }
        if (user doesnt have enough gold of selected item){
            System.out.println("Come back when you have enough gold!");
            weaponAsk()
        }
        Items.setInventoryItem(askedWeapon, 1);
        //minusGold(cost of that item);
    }



    public static void potionPage(){
        //System.out.println("                                   Potions");
        //System.out.println("________________________________________________________________________________");
        //System.out.println("|Items                |Price       |Description                                 |");
        //System.out.println("|-------------------------------------------------------------------------------|");
        //System.out.println("|HP Potion (S) x 1    |50g         |+35 HP (Only consumable onece every round)  |");
        //System.out.println("|HP Potion (L) x 1    |359g        |                                            |");
        //System.out.println("|Mana Potion (S) x 1  |50g         |+35 Man (Only consumable onece every round) |");
        //System.out.println("|Mana Potion (L) x 1  |359g        |                                            |");
        //System.out.println("|Cookies x 5          |10g         |+10 HP (Only consumable onece every round)  |");
        //System.out.println("|-------------------------------------------------------------------------------|");
        //System.out.println();
        System.out.println("Item ID: 1\nName: " + Items.getPotionName(3001) + " x " + "5\nPrice: 10g\nDesc: Nice chocolate chip cookie. Increases your hp and mp by 10.\n" );
        System.out.println("Item ID: 2\nName: " + Items.getPotionName(3002) + " x " + "1\nPrice: 100g\nDesc: Looks nice(?)...\n" );
    }

    public static void potionAsk(){
        System.out.println("Which item would you like to buy? (Say the item ID!)");
        int askedPotion = Program.scanInt();
        if (not integer){
            System.out.println("Put in the item ID, dummy!");
            potionAsk();
        }
        if (user doesnt have enough gold of selected item){
            System.out.println("Come back when you have enough gold!");
            potionAsk()
        }
        Items.setInventoryItem(askedPotion, 1);
        //minusGold(cost of that item);
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
        //else 
        //    "other" method
        //}




    }












}