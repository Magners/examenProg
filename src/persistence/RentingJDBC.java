package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Car;
import model.Driver;
import model.Rental;
import model.City;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
public class RentingJDBC {
    
    private Connection conexion;

    public RentingJDBC() {

    }
    
    public void reset() throws SQLException {
        PreparedStatement resetCar = conexion.prepareStatement("DELETE FROM car");
        PreparedStatement resetDriver = conexion.prepareStatement("DELETE FROM driver");
        PreparedStatement resetRental = conexion.prepareStatement("DELETE FROM rental");
        PreparedStatement resetCity = conexion.prepareStatement("DELETE FROM city");
        resetCar.execute();
        resetDriver.execute();
        resetRental.execute();
        resetCity.execute();
        //resetPlayer.close();
    }

    public void connect() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/renting", "root", "");
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    public void insertRental(Rental rental) throws SQLException {
        String insert = "insert into rental values (?, ?, ?, ?);";
        PreparedStatement pst = conexion.prepareStatement(insert);
        pst.setInt(1, rental.getIdrental());
        pst.setString(2, rental.getCustomer());
        pst.setString(3, rental.getCar().getIdcar());
        pst.setString(4, rental.getCity().getPostalcode());
        pst.executeUpdate();
        pst.close();
    }
    public void updateDriverSalary(Driver driver, double salary) throws SQLException {
        PreparedStatement psu = conexion.prepareStatement("UPDATE driver set salary = ? WHERE name = ?");
        psu.setDouble(1, salary);
        psu.setString(2, driver.getName());
        psu.executeUpdate();
        psu.close();
    }
    public List<Car> selectCarsByDriver(String driver) throws SQLException {
        String query = "select * from car WHERE driver='" + driver +"'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery(query);
        List<Car> cars = new ArrayList<>();
        if (resultset.next()) {
            Car car = new Car();
            car.setIdcar(resultset.getString("idcar"));
            car.setModel(resultset.getString("model"));
            car.setCapacity(resultset.getInt("capacity"));
            car.setDriver(selectDriverByName(resultset.getString("driver")));
            cars.add(car);
        }
        resultset.close();
        preparedStatement.close();
        return cars;
    }
    public Driver selectDriverByName(String dni) throws SQLException {
        PreparedStatement selectTable = conexion.prepareStatement("SELECT * FROM driver WHERE dni = ?");
        selectTable.setString(1, dni);
        ResultSet result = selectTable.executeQuery();
        Driver driver = new Driver();
        if (result.next()) {
            driver.setDni(result.getString("dni"));
            driver.setName(result.getString("name"));
            driver.setPhone(result.getString("phone"));
            driver.setSalary(result.getDouble("salary"));
        }
        result.close();
        selectTable.close();
        return driver;

    }
    public Car selectCarByName(String idcar) throws SQLException {
        PreparedStatement selectTable = conexion.prepareStatement("SELECT * FROM car WHERE idcar = ?");
        selectTable.setString(1, idcar);
        ResultSet result = selectTable.executeQuery();
        Car car = new Car();
        if (result.next()) {
            car.setIdcar(result.getString("dni"));
            car.setModel(result.getString("model"));
            car.setCapacity(result.getInt("capacity"));
            car.setDriver(selectDriverByName(result.getString("driver")));
        }
        result.close();
        selectTable.close();
        return car;

    }
    public List<Rental> selectRentalsByCity(String city) throws SQLException {
        String query = "select * from rental WHERE city='" + city +"'";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery(query);
        List<Rental> rentals = new ArrayList<>();
        if (resultset.next()) {
            Rental rental = new Rental();
            rental.setIdrental(resultset.getInt("idrental"));
            rental.setCustomer(resultset.getString("model"));
            rental.setCar(selectCarByName(resultset.getString("car")));
            rentals.add(rental);
        }
        resultset.close();
        preparedStatement.close();
        return rentals;
    }
    
    
}

