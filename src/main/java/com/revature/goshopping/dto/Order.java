package com.revature.goshopping.dto;

import com.revature.goshopping.entity.ItemOrderEntity;
import com.revature.goshopping.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class Order {
  private int id;

  /**
   * millis since epoch
   */
  private Long date;

  private int userID;

  private List<OrderItem> items = new ArrayList<>();

  // for jackson
  private Order() {

  }

  public Order(int id, Long date, int userID, List<OrderItem> items) {
    this.id = id;
    this.date = date;
    this.userID = userID;
    this.items = items;
  }

  public Order(OrderEntity order) {
    for (ItemOrderEntity ioe : order.getItemOrders()) {
      this.items.add(new OrderItem(ioe));
    }
    setId(order.getId());
    setDate(order.getDate().getTime());
    setUserID(order.getUser().getId());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }
}
