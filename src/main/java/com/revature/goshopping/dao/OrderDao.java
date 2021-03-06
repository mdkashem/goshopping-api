package com.revature.goshopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.goshopping.entity.OrderEntity;

@Repository
@Transactional
public class OrderDao {
	@Autowired
    SessionFactory sessionFactory;
    
    public void addOrder(OrderEntity order) throws Exception {
        sessionFactory.getCurrentSession().persist(order);
    }

    public OrderEntity getOrder(int id) throws Exception {
        return sessionFactory.getCurrentSession().get(OrderEntity.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<OrderEntity> getOrdersForUser(int id) throws Exception {
        String queryString = "select o from UserEntity u " +
            "inner join u.orders o where u.id = :id";
        return sessionFactory
            .getCurrentSession()
            .createQuery(queryString)
            .setParameter("id", id)
            .list();
    }

    @SuppressWarnings("unchecked")
    public List<OrderEntity> getAllOrders() throws Exception {
        return sessionFactory
            .getCurrentSession()
            .createQuery("from OrderEntity")
            .list();
    }
}
