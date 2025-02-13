package kz.aitu.restpro2421.restpro.controller;

import kz.aitu.restpro2421.restpro.dbconnection.DbConnection;
import kz.aitu.restpro2421.restpro.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/Customer")
public class MyController {

    private final DbConnection dbConnection = new DbConnection();
    @GetMapping("/getCustomer")
    public List<Customer> getAllCustomers() {
        try (Connection con = dbConnection.connect()) {
            return dbConnection.getAllCustomers();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }

    @PostMapping("/create")
    public String createCustomer(@RequestBody Customer customer) {
        try {
            dbConnection.createCustomer(customer);
            return "Customer created successfully with ID: " + customer.getId();
        } catch (Exception e) {
            return "Error creating customer: " + e.getMessage();
        }
    }



    public MyController() {
        try {
            dbConnection.createTables();
        } catch (Exception e) {
            throw new RuntimeException("Error creating tables", e);
        }
    }

}