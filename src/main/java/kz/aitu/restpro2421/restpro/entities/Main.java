package kz.aitu.restpro2421.restpro.entities;
import kz.aitu.restpro2421.restpro.entities.RentalService;
import kz.aitu.restpro2421.restpro.entities.Vehicle;
import kz.aitu.restpro2421.restpro.entities.Customer;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Vehicle(1001L, "Toyota Corolla", 50.0);
        Vehicle bike = new Vehicle(1002L, "Yamaha R15", 20.0);

        Customer customer1 = new Customer(1L, "Emma Solis", "1234567890");
        Customer customer2 = new Customer(2L, "Jane Smith", "0987654321");

        RentalService rentalService = new RentalService();
        rentalService.addRental(car, customer1, 5);
        rentalService.addRental(bike, customer2, 3);

//        System.out.println(car);

        System.out.println("All Rentals:");
        System.out.println(rentalService);

        System.out.println("\nFiltered Rentals (Price <= 30):");
        rentalService.filterByPrice(30).forEach(System.out::println);

        rentalService.sortRentalsByCustomerName();
        System.out.println("\nSorted Rentals by Customer Name:");
        System.out.println(rentalService);
    }
}
