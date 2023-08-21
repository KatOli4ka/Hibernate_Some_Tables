package dao;

import entity.City;


import java.util.List;
import java.util.Optional;

public interface CityDao {
  City add(City city);
    Optional<City> readById(long id);
    List<City> findAll();
    City updateCity(City city);
    Optional<City> delete(City city);
}
