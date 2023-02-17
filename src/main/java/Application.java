import dao.CityDao;
import dao.EmployeeDao;
import dao.impl.CityDaoImpl;
import dao.impl.EmployeeDaoImpl;
import entity.City;
import entity.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        employeeDao.findAll().forEach(System.out::println);
//        System.out.println();
//        Employee e1= new Employee(1,"Ann","Oh","f",73,4);
//        employeeDao.add(e1);
//        employeeDao.findAll().forEach(System.out::println);
//        System.out.println();
//        System.out.println(employeeDao.readById(2));
//        System.out.println();
//        employeeDao.deleteById(e1);
//        employeeDao.findAll().forEach(System.out::println);
//        System.out.println();

        CityDao cityDao = new CityDaoImpl();
        cityDao.findAll().forEach(System.out::println);
        City c1 = new City(7, "Riga");
        cityDao.add(c1);
        cityDao.findAll().forEach(System.out::println);
        System.out.println(cityDao.readById(2));
        cityDao.deleteById(4);
        cityDao.findAll().forEach(System.out::println);
        cityDao.updateCityById(new City(3, "WWWWWWWWWWWWWWW"));

    }
}




