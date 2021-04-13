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
        Program.terminal.println("___________Item info___________");
        Program.terminal.println("ID:          " + id);
        Program.terminal.println("Name:        " + name);
        Program.terminal.println("Type:        " + type);
        Program.terminal.println("Description: " + description);
        Program.terminal.println("_______________________________");
        Program.terminal.println("");
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
        Program.terminal.println("___________Item info___________");
        Program.terminal.println("ID:          " + id);
        Program.terminal.println("Name:        " + name);
        Program.terminal.println("Type:        " + type);
        Program.terminal.println("Damage:      " + damage);
        if(hasSpecial){
            Program.terminal.println("Special:     " + specialType +" +"+ specialStat);
        }
        Program.terminal.println("Description: " + description);
        Program.terminal.println("Equipped:    " + equipped);
        Program.terminal.println("_______________________________");
        Program.terminal.println("");
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
        Program.terminal.println("___________Item info___________");
        Program.terminal.println("ID:          " + id);
        Program.terminal.println("Name:        " + name);
        Program.terminal.println("Type:        " + type);
        Program.terminal.println("+ HP:        " + hp);
        Program.terminal.println("+ MP:        " + mp);
        if(hasSpecial){
            Program.terminal.println("Special:     " + specialType+ " +" + specialStat);
        }
        Program.terminal.println("Description: " + description);
        Program.terminal.println("Quantity:    " + quantity);
        Program.terminal.println("_______________________________");
        Program.terminal.println("");
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
        Program.terminal.println("___________Item info___________");
        Program.terminal.println("ID:          " + id);
        Program.terminal.println("Name:        " + name);
        Program.terminal.println("Type:        " + type);
        Program.terminal.println("Description: " + description);
        Program.terminal.println("Can be sold: " + sellable);
        Program.terminal.println("Quantity:    " + quantity);
        Program.terminal.println("_______________________________");
    }

    @Override
    public Item clone() {
        return new OtherItem(itemType,id,price,name,type,description,sellable,quantity);
    }
}
