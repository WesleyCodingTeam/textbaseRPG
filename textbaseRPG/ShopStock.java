import java.util.ArrayList;

public class ShopStock{

    public ArrayList<String> item;
    public int price;
    public int quantity;

    public ShopStock(int price, ArrayList<String> item, int quantity){
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }
}