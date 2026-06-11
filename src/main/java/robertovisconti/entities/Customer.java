package robertovisconti.entities;

public class Customer {
    
    //metodo per generazione id
    private static long nextId = 1;


    // attributi
    private Long id;
    private String name;
    private Integer tier;

    // costruttore
    public Customer(String name, Integer tier) {
        this.id = nextId++;
        this.name = name;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
