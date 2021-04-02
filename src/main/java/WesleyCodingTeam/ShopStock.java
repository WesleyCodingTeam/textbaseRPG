package WesleyCodingTeam;

import java.util.ArrayList;

public class ShopStock{

    public Item item;
    public int price;
    public int quantity;

    public ShopStock(Item item, int quantity){
        this.item = item;
        this.price = item.price*quantity;
        this.quantity = quantity;
    }
}
