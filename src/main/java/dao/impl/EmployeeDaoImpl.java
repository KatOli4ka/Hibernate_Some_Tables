package dao.impl;

import dao.CityDao;
import dao.EmployeeDao;
import entity.City;
import hebirnate.HibernateSessionFactoryUtil;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {
    private final CityDao cityDao = new CityDaoImpl();

    @Override
    public Employee add(Employee employee) {
        if (employee.getCity() != null && cityDao.readById(employee.getCity().getCityId()).isEmpty()) {
            employee.setCity(null);
        }

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable createdId = session.save(employee);
            Employee createdEmployee = session.get(Employee.class, createdId);
            transaction.commit();
            return createdEmployee;
        }
    }

    @Override
    public Optional<Employee> readById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Employee.class, id));
        }
    }

    @Override
    public List<Employee> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Employee", Employee.class).list();
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee.getCity() != null && cityDao.readById(employee.getCity().getCityId()).isEmpty()) {
            employee.setCity(null);
        }
        EntityManager entityManager = HibernateSessionFactoryUtil.getSessionFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Employee updated = entityManager.merge(employee);
        entityTransaction.commit();
        return updated;
    }

    @Override
    public Optional<Employee> delete(Employee employee) {
        Optional<Employee> optionalEmployee = readById(employee.getId());
        if (optionalEmployee.isPresent()) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(optionalEmployee.get());
                transaction.commit();
                return optionalEmployee;
            }
        }
        return Optional.empty();
    }
}

