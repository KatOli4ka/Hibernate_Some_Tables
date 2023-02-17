package dao;

import entity.City;
import entity.Employee;

import java.util.List;

public interface CityDao {
    City add(City city);
    City readById(long cityId);
    List<City> findAll();
    void updateCityById(long cityId);
    void deleteById(long cityId);
}
