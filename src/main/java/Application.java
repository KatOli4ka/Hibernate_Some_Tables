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
        int n = 3;
        City city = new City("Riga");
        List<Employee> employees = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            employees.add(new Employee
                    ("qwerty" + (i + 1), "QWERTY" + (i + 1), "x", 45 - i, city));
        }
        city.setEmployees(employees);

        cityDao.add(city);

        employeeDao.findAll().forEach(System.out::println);
        cityDao.delete(city);
        employeeDao.findAll().forEach(System.out::println);


//        City spb=new City(1,"СПб");
//        City riga=new City(2,"Рига");
//        City paris=new City(3,"Париж");
//
//        Employee vanya=employeeDao.add(new Employee("Ваня","Иванов","m",45,spb));
//        System.out.println("Сотрудник "+vanya+" добавлен");
//        Employee jora=employeeDao.add(new Employee("Жора","Крылов","m",25,spb));
//        System.out.println("Сотрудник "+jora+" добавлен");
//        Employee masha=employeeDao.add(new Employee("Маша","Иванченко","f",34,paris));
//        System.out.println("Сотрудник "+masha+" добавлен");
//        Employee galya=employeeDao.add(new Employee("Галя","Петрова","f",51));
//        System.out.println("Сотрудник "+galya+" добавлен");
//
//        System.out.println("Все сотрудники добавлены");
//        employeeDao.findAll().forEach(System.out::println);
//
//        employeeDao.readById(masha.getId())
//                .ifPresent(emp -> System.out.println("Найден сотрудник: "+emp));
//
//        jora.setAge(76);
//        jora.setCity(riga);
//        jora.setLastName("Крыжовников");
//        jora=employeeDao.updateEmployee(jora);
//        System.out.println("Сотрудник "+jora+" обновлен");
//
//        employeeDao.delete(jora)
//                .ifPresent(emp -> System.out.println("Удален сотрудник: "+emp));
//
//        System.out.println("Все сотрудники");
//        employeeDao.findAll().forEach(System.out::println);
    }
}




