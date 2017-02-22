package model;

public class Rental {
    private int idrental;
    private String customer;
    private Car car;
    private City city;

    public Rental(int idrental, String customer, Car car, City city) {
        this.idrental = idrental;
        this.customer = customer;
        this.car = car;
        this.city = city;
    }

    public Rental() {
    }

    public Rental(int idrental, String customer, Car car) {
        this.idrental = idrental;
        this.customer = customer;
        this.car = car;
    }
    
    public int getIdrental() {
        return idrental;
    }

    public void setIdrental(int idrental) {
        this.idrental = idrental;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    
}
