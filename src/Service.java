/**
 * UC7 - Add-On Service
 */
public class Service {

    String name;
    double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println(name + " - ₹" + price);
    }
}