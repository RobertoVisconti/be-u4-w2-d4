package robertovisconti.entities;

public class Product {

    //metodo per generazione id
    private static long nextId = 1;

    //attributi
    private Long id;
    private String name;
    private String category;

    // costruttore
    private Double price;


    public Product(String name, String category, double price) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", category= '" + category + '\'' +
                ", price= " + price +
                " €" +
                '}';
    }
}
