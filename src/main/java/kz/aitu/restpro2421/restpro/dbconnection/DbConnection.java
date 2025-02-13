package kz.aitu.restpro2421.restpro.dbconnection;

import kz.aitu.restpro2421.restpro.entities.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    private String URL = "jdbc:postgresql://localhost:5432/Rental";
    private String USER = "postgres";
    private String PASSWORD = "7518lan";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void createTables() throws SQLException {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
    CREATE TABLE IF NOT EXISTS customers (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255),
        phone VARCHAR(255)
    )
""");
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customers")) {

            while (rs.next()) {
                customers.add(new Customer(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("phone")
                ));
            }
        }
        return customers;
    }


    public void createCustomer(Customer customer) throws SQLException {
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO customers (name, phone) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getLong(1));
                }
            }
        }
    }

}
