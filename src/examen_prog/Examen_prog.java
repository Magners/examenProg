//git
package examen_prog;

import model.Car;
import model.Driver;
import model.Rental;
import model.City;
import persistence.RentingJDBC;

import java.sql.SQLException;

public class Examen_prog {

    public static void main(String[] args) {
        
        RentingJDBC conexion = new RentingJDBC();
        try{
        // Conectamos con la bbdd
            System.out.println("Conectando base de datos...");
            conexion.connect();
            System.out.println("Conexión establecida.");
            //conexion.reset(); 
        //4) Insertar un alquiler
            Driver driver = new Driver("123456789","driver1","111111111",1000);
            Car car = new Car("car1","model1",5,driver);
            City city = new City ("12345","city1");
            Rental rental = new Rental(134,"pepito",car,city);
            System.out.println("Test metodo insertar un alquiler: ");
            conexion.insertRental(rental);
            System.out.println("Insertar un alquiler realizado correctamente.");
        //5) modificar salario
            System.out.println("Test metodo modificar sueldo: ");
            conexion.updateDriverSalary(driver, 2000);
            System.out.println("Modificar sueldo realizado correctamente.");
        //6 lista de coches por conductor
            System.out.println("Testeando coches por conductor...");
        for (Car cars: conexion.selectCarsByDriver(driver.getName())){
                        System.out.println(cars.toString());
            }
            System.out.println("Seleccionar coches por conductor realizado correctamente.");
        //7 lista de rentals por ciudad
        System.out.println("Testeando Rentals por City...");
        for (Rental rentals: conexion.selectRentalsByCity("city1")){
            System.out.println(" Idrental: " +rentals.getIdrental() +" Customer: "+rentals.getCustomer()+" Car: " +rentals.getCar().getIdcar() +" City: "+rentals.getCity().getPostalcode());
        }
        System.out.println("Rentals por City realizado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        } finally {
            try {
                conexion.desconectar();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar "+ex.getMessage());
            }
        }
    }
    
}
