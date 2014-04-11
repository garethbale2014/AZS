package de.rs.firdaous.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class PresentationWorkOrder extends Observable implements IPresentationModel {

  private static PresentationWorkOrder order = new PresentationWorkOrder();

  private Map<Long, WorkOrder> orders = new HashMap<Long, WorkOrder>();

  private PresentationWorkOrder() {

  }

  public void put(Long timeStamp, WorkOrder order) {
    orders.put(timeStamp, order);
  }

  public Map<Long, WorkOrder> getOrders() {
    return orders;
  }

  public static PresentationWorkOrder getInstance() {
    return order;
  }

  @Override
  public synchronized void addObserver(Observer o) {
    // TODO Auto-generated method stub
    super.addObserver(o);
  }

  public void addOrders(List<WorkOrder> ordersList) {
    for (WorkOrder o : ordersList) {
      orders.put(o.projectId, o);
    }
    setChanged();
    notifyObservers(orders);

  }

  public void addOrder(WorkOrder workOrder) {
    orders.put(workOrder.getProjectId(), workOrder);
    setChanged();
    notifyObservers(orders);

  }

  public void removeOrder(WorkOrder workOrder) {
    for(WorkOrder o : orders.values()){
      if(o.getProjectId().equals(workOrder.getProjectId())){
        System.out.println(o.getPair().getPerson().getFirstname());
        orders.remove(o);
        setChanged();
        notifyObservers(orders);
        break;
      }
    }    
  }

 
  
  

}
