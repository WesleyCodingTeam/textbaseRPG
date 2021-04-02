package WesleyCodingTeam;


public class Monster {
    public final int id;
    public final String name;
    public final String type;
    public final int hp;
    public int currentHp;
    public final int defense;
    public final int damage;
    public final String description;
    public final int expAmount;

    public Monster(int id,String name,String type, int hp,int defense,int damage,String description,int expAmount){
        this.id =  id;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.currentHp = hp;
        this.defense = defense;
        this.damage = damage;
        this.description = description;
        this.expAmount = expAmount;

    }

    public void printMonster(){
        System.out.println("");
        System.out.println("__________Monster info_________");
        System.out.println("ID:          " + id);
        System.out.println("Name:        " + name);
        System.out.println("Type:        " + type);
        System.out.println("HP:          " + hp);
        System.out.println("Defense:     " + defense);
        System.out.println("Damage:      " + damage);
        System.out.println("Description: " + description);
        System.out.println("Exp given:   " + expAmount);
        System.out.println("_______________________________");
        System.out.println("");
    }
    public Monster clone(){
        return new Monster(this.id,this.name,this.type,this.hp,this.defense,this.damage,this.description,this.expAmount);
    }
}
