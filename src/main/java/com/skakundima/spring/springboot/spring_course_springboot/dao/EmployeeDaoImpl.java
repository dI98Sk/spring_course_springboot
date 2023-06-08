package com.skakundima.spring.springboot.spring_course_springboot.dao;




import com.skakundima.spring.springboot.spring_course_springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    //@Transactional
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);


        //Вариант с разделение выражения на 2 действия
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }
/*
    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();



        session.saveOrUpdate(employee); // метод производящий абдейт если работник уже существует

    }

    @Override
    public Employee getEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;

    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee"+
                "where id =:employeeId");

        query.setParameter("employeeId",id);
        query.executeUpdate();

    }*/
}
