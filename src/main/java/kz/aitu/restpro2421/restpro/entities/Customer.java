package kz.aitu.restpro2421.restpro.entities;

public class Customer extends RentalEntity {
    public Customer() {
    }
    private String name;
    private String phone;

    public Customer(String name, String phone) {
        super(0);
        this.name = name;
        this.phone = phone;
    }

    public Customer(long id, String name, String phone) {
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
