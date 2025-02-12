package kz.aitu.restpro2421.restpro.entities;

import kz.aitu.restpro2421.restpro.entities.Vehicle;
import kz.aitu.restpro2421.restpro.entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalService {
    private List<Rental> rentals;

    public RentalService() {
        rentals = new ArrayList<>();
    }

    public void addRental(Vehicle vehicle, Customer customer, int rentalDays) {
        rentals.add(new Rental(vehicle, customer, rentalDays));
    }

    public List<Rental> filterByPrice(double maxPrice) {
        return rentals.stream()
                .filter(rental -> rental.getVehicle().getPricePerDay() <= maxPrice)
                .collect(Collectors.toList());
    }

    public void sortRentalsByCustomerName() {
        rentals.sort((r1, r2) -> r1.getCustomer().getName().compareTo(r2.getCustomer().getName()));
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    @Override
    public String toString() {
        return rentals.stream().map(Rental::toString).collect(Collectors.joining("\n"));
    }

    public static class Rental {
        private Vehicle vehicle;
        private Customer customer;
        private int rentalDays;

        public Rental(Vehicle vehicle, Customer customer, int rentalDays) {
            this.vehicle = vehicle;
            this.customer = customer;
            this.rentalDays = rentalDays;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public Customer getCustomer() {
            return customer;
        }

        public int getRentalDays() {
            return rentalDays;
        }

        @Override
        public String toString() {
            return "Rental: " + customer + " | " + vehicle + " | Days: " + rentalDays;
        }
    }
}