package WesleyCodingTeam;
class Item {
    String itemType;
    int id;
    int price;
    String name;
    String type;
    String description;
    int quantity;
    public Item(String itemType,int id, int price, String name, String type, String description,int quantity) {
        this.itemType = itemType;
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
        this.description = description;
        this.quantity = quantity;
    }
    public void printInfo(){
        System.out.println("___________Item info___________");
        System.out.println("ID:          " + id);
        System.out.println("Name:        " + name);
        System.out.println("Type:        " + type);
        System.out.println("Description: " + description);
        System.out.println("_______________________________");
        System.out.println("");
    }
    public Item clone(){
        return new Item(itemType,id,price,name,type,description,quantity);
    }
}
class Weapon extends Item{
    int damage;
    boolean hasSpecial;
    String specialType;
    int specialStat;
    boolean equipped;
    public Weapon(String itemType,int id, int price, String name, String type, String description, int damage,boolean hasSpecial, String specialType,  int specialStat, boolean equipped,int quantity) {
        super(itemType,id, price, name, type, description,quantity);
        this.damage = damage;
        this.equipped = equipped;
        this.hasSpecial = hasSpecial;
        if(hasSpecial){
            this.specialType = specialType;
            this.specialStat = specialStat;
        }
    }
    @Override
    public void printInfo() {
        System.out.println("___________Item info___________");
        System.out.println("ID:          " + id);
        System.out.println("Name:        " + name);
        System.out.println("Type:        " + type);
        System.out.println("Damage:      " + damage);
        if(hasSpecial){
            System.out.println("Special:     " + specialType +" +"+ specialStat);
        }
        System.out.println("Description: " + description);
        System.out.println("Equipped:    " + equipped);
        System.out.println("_______________________________");
        System.out.println("");
    }
    @Override
    public Item clone() {
        return new Weapon(itemType,id,price,name,type,description,damage,hasSpecial,specialType,specialStat,equipped,quantity);
    }
}
class Potion extends Item{
    int hp;
    int mp;
    boolean hasSpecial;
    String specialType;
    int specialStat;
    public Potion(String itemType,int id, int price, String name, String type, String description, int hp, int mp, boolean hasSpecial, String specialType, int specialStat,int quantity) {
        super(itemType,id, price, name, type, description,quantity);
        this.hp = hp;
        this.mp = mp;
        this.hasSpecial = hasSpecial;
        if(hasSpecial){
            this.specialType = specialType;
            this.specialStat = specialStat;
        }
    }
    @Override
    public void printInfo() {
        System.out.println("___________Item info___________");
        System.out.println("ID:          " + id);
        System.out.println("Name:        " + name);
        System.out.println("Type:        " + type);
        System.out.println("+ HP:        " + hp);
        System.out.println("+ MP:        " + mp);
        if(hasSpecial){
            System.out.println("Special:     " + specialType+ " +" + specialStat);
        }
        System.out.println("Description: " + description);
        System.out.println("Quantity:    " + quantity);
        System.out.println("_______________________________");
        System.out.println("");
    }
    @Override
    public Item clone() {
        return new Potion(itemType,id,price,name,type,description,hp,mp,hasSpecial,specialType,specialStat,quantity);
    }
}
class OtherItem extends Item {
    boolean sellable;
    public OtherItem(String itemType, int id, int price, String name, String type, String description, boolean sellable, int quantity) {
        super(itemType,id, price, name, type, description,quantity);
        this.sellable = sellable;
    }

    @Override
    public void printInfo() {
        System.out.println("___________Item info___________");
        System.out.println("ID:          " + id);
        System.out.println("Name:        " + name);
        System.out.println("Type:        " + type);
        System.out.println("Description: " + description);
        System.out.println("Can be sold: " + sellable);
        System.out.println("Quantity:    " + quantity);
        System.out.println("_______________________________");
    }

    @Override
    public Item clone() {
        return new OtherItem(itemType,id,price,name,type,description,sellable,quantity);
    }
}
