package dao.impl;

import dao.CityDao;
import entity.City;
import entity.Employee;
import hebirnate.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {

    @Override
    public City add(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(city);
            transaction.commit();
            return city;
        }
    }

    @Override
    public City readById(long cityId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, cityId);
    }

    @Override
    public List<City> findAll() {
        List<City> cityList;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            cityList = new ArrayList<>(session.createQuery("From City", City.class).list());
            transaction.commit();
        }
        return cityList;
    }

    @Override
    public void updateCityById(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(long cityId) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(cityId);
            transaction.commit();
        }
    }
}
