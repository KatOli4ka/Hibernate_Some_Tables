import dao.CityDao;
import dao.EmployeeDao;
import dao.impl.CityDaoImpl;
import dao.impl.EmployeeDaoImpl;
import entity.City;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao cityDao = new CityDaoImpl();
//        int n = 3;

//        City city= new City("Moscow");
//        List<Employee> employees = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            employees.add(new Employee
//                    ("qwerty" + (i + 1), "QWERTY" + (i + 1), "x", 45 - i, city));
//        }
//        city.setEmployees(employees);

//        cityDao.add(city);
//        cityDao.updateCity(new City("Hong Kong"));
//
//        System.out.println(cityDao.readById(8));
//
//        employeeDao.findAll().forEach(System.out::println);
//        System.out.println(cityDao.delete(city));
//        employeeDao.findAll().forEach(System.out::println);

        City spb=new City(1,"СПб");
        City paris=new City(2,"Париж");
        City moscow=new City(3,"Москва");
        cityDao.add(spb);
        cityDao.add(paris);
        cityDao.add(moscow);

        Employee vanya=employeeDao.add(new Employee("Ваня","Иванов","m",45,spb));
        System.out.println("Сотрудник "+vanya+" добавлен");
        Employee masha=employeeDao.add(new Employee("Маша","Иванченко","f",34,paris));
        System.out.println("Сотрудник "+masha+" добавлен");
        Employee galya=employeeDao.add(new Employee("Галя","Петрова","f",51));
        System.out.println("Сотрудник "+galya+" добавлен");

        System.out.println("Все сотрудники добавлены");
        employeeDao.findAll().forEach(System.out::println);

        employeeDao.readById(masha.getId())
                .ifPresent(emp -> System.out.println("Найден сотрудник: "+emp));

        vanya.setAge(76);
        vanya.setCity(paris);
        vanya.setLastName("Крыжовников");
        vanya=employeeDao.updateEmployee(masha);
        System.out.println("Сотрудник "+vanya+" обновлен");
        paris=cityDao.updateCity(moscow);
        System.out.println(cityDao.readById(34));

        System.out.println(cityDao.delete(paris));

        System.out.println(cityDao.readById(8));
        employeeDao.findAll().forEach(System.out::println);


        employeeDao.delete(masha)
                .ifPresent(emp -> System.out.println("Удален сотрудник: "+emp));

        System.out.println("Все сотрудники");
        employeeDao.findAll().forEach(System.out::println);

    }
}




