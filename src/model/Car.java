package model;


public class Car {
    private String idcar;
    private String model;
    private int capacity;
    private Driver driver;

    public Car(String idcar, String model, int capacity, Driver driver) {
        this.idcar = idcar;
        this.model = model;
        this.capacity = capacity;
        this.driver = driver;
    }

    public Car() {
    }
    
    public String getIdcar() {
        return idcar;
    }

    public void setIdcar(String idcar) {
        this.idcar = idcar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" + "idcar=" + idcar + ", model=" + model + ", capacity=" + capacity + ", driver=" + driver + '}';
    }
    
    
}
