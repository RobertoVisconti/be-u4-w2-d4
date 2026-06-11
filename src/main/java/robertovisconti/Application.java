package robertovisconti;

import robertovisconti.entities.Customer;
import robertovisconti.entities.Order;
import robertovisconti.entities.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>(List.of(
                new Product("Ingegneria del Software", "Books", 54.00),
                new Product("Kagurabachi", "Books", 5.50),
                new Product("Death Note AllVol", "Books", 162.00),
                new Product("One Piece", "Books", 7.60),
                new Product("Mushishi 10vol", "Books", 140.00),
                new Product("Super Conductive Brains Parataxis", "Books", 300.00),
                new Product("Leredità dei sogni", "Books", 50.00),
                new Product("Jujutsu Kaisen AllVol", "Books", 165.00),
                new Product("ASUS ROG Harpe Ace", "Boys", 119.90),
                new Product("Logitech G PRO X2 SUPERSTRIKE LIGHTSPEED", "Boys", 179.99),
                new Product("Fnatic Lamzu MAYA X", "Boys", 170.30),
                new Product("Lamzu Maya Control - Tappetino", "Gaming", 198.49),
                new Product("Artisan Hien - Tappetino", "Boys", 77.78),
                new Product("LEGO City Treno Passeggeri Espresso", "Baby", 138.29),
                new Product("Pokemon - Orologio Ragazzi", "Baby", 13.00),
                new Product("Pokémon: Collezione Ultra Premium Mega Charizard X-ex del GCC Pokémon", "Baby", 149.99),
                new Product("Pokémon Pokopia Standard | Nintendo Switch 2", "Baby", 59.90),
                new Product("Nintendo Switch 2 Console", "Baby", 433.40)
        ));

        List<Order> ordiniClienti = List.of(
                new Order("In spedizione", LocalDate.now(), LocalDate.now().plusDays(2), List.of(products.get(1), (products.get(3)), (products.get(4)), (products.get(7)), (products.get(15))), new Customer("Alessia", 1)),
                new Order("In spedizione", LocalDate.now(), LocalDate.now().plusDays(3), List.of(products.get(1), (products.get(3)), (products.get(4)), (products.get(7)), (products.get(7))), new Customer("Antonio", 2)),
                new Order("In spedizione", LocalDate.now(), LocalDate.now().plusDays(5), List.of(products.get(1), (products.get(3)), (products.get(17)), (products.get(7)), (products.get(12))), new Customer("Roberto", 1)),
                new Order("Consegnato", LocalDate.of(2021, 2, 3), LocalDate.of(2021, 2, 5), List.of(products.get(8), (products.get(17))), new Customer("Valeria", 2)),
                new Order("Consegnato", LocalDate.of(2021, 3, 1), LocalDate.of(2021, 1, 3), List.of(products.get(5), (products.get(11))), new Customer("Niccolò S.", 2))
        );

        System.out.println("************************** ESERCIZIO 1 **************************");

        Map<Customer, List<Order>> orderCustomer = ordiniClienti.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer()));

        orderCustomer.forEach((customer, orderList) -> System.out.println("Customer: " + customer.getName() + " Lista ordine: " + orderList));


        System.out.println("************************** ESERCIZIO 2 **************************");

        Map<Customer, Double> totalePerCustomer = ordiniClienti.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer(), Collectors.summingDouble((product -> product.calculateTotal()))));

        totalePerCustomer.forEach((customer, totaleSpeso) -> System.out.println("Cliente: " + customer.getName() + " Totale speso: " + totaleSpeso + "€"));


        System.out.println("************************** ESERCIZIO 3 **************************");

        List<Product> topPrice = products.stream()
                .sorted(Comparator.comparingDouble((Product product) -> product.getPrice()).reversed())
                .limit(5)
                .toList();

        topPrice.forEach(product -> System.out.println("- " + product.getName() + ": " + product.getPrice() + "€"));


        System.out.println("************************** ESERCIZIO 4 **************************");

        OptionalDouble mediaPrezzo = ordiniClienti.stream()
                .mapToDouble(order -> order.calculateTotal())
                .average();

        if (mediaPrezzo.isPresent()) {
            System.out.println("La media degli importi degli ordini è: " + mediaPrezzo.getAsDouble() + "€");
        } else {
            System.out.println("Non ci sono ordini.");
        }


        System.out.println("************************** ESERCIZIO 5 **************************");

        Map<String, Double> totalePerCategoria = products.stream()
                .collect(Collectors.groupingBy(product -> product.getCategory(), Collectors.summingDouble(product -> product.getPrice())));

        totalePerCategoria.forEach((categoria, totale) -> System.out.println("Categoria: " + categoria + " Totale prezzo prodotti: " + totale));
        

    }
}
