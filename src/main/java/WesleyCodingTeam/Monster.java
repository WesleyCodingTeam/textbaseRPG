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
        Program.terminal.println("");
        Program.terminal.println("__________Monster info_________");
        Program.terminal.println("ID:          " + id);
        Program.terminal.println("Name:        " + name);
        Program.terminal.println("Type:        " + type);
        Program.terminal.println("HP:          " + hp);
        Program.terminal.println("Defense:     " + defense);
        Program.terminal.println("Damage:      " + damage);
        Program.terminal.println("Description: " + description);
        Program.terminal.println("Exp given:   " + expAmount);
        Program.terminal.println("_______________________________");
        Program.terminal.println("");
    }
    public Monster clone(){
        return new Monster(this.id,this.name,this.type,this.hp,this.defense,this.damage,this.description,this.expAmount);
    }
}
