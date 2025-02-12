package kz.aitu.restpro2421.restpro.controller;

import kz.aitu.restpro2421.restpro.dbconnection.DbConnection;
import kz.aitu.restpro2421.restpro.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class MyController {

    private final DbConnection dbConnection = new DbConnection();

    @GetMapping
    public List<Customer> getAllCustomers() {
        try (Connection con = dbConnection.connect()) {
            return dbConnection.getAllCustomers();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        try (Connection con = dbConnection.connect()) {
            dbConnection.createCustomer(customer);
            return customer;
        } catch (Exception e) {
            throw new RuntimeException("Error creating customer", e);
        }
    }
}
