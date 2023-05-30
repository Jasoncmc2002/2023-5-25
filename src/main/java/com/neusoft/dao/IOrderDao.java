package com.neusoft.dao;

import com.neusoft.entity.Order;

import java.util.List;

public interface IOrderDao {
    List<Order> queryOrderByUid(int id);
    void insertOrder(Order order);
}
