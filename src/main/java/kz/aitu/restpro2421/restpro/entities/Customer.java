package kz.aitu.restpro2421.restpro.entities;

import kz.aitu.restpro2421.restpro.entities.RentalEntity;

public class Customer extends RentalEntity {
    private String name;
    private String phone;

    public Customer(String id, String name, String phone) {
        super(id);
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return super.toString() + ", Name: " + name + ", Phone: " + phone;
    }
}