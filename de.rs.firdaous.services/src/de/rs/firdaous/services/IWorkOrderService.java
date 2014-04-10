package de.rs.firdaous.services;

import java.util.List;



import de.rs.firdaous.model.WorkOrder;








public interface IWorkOrderService {
  
  List<WorkOrder> getAllWorkOrder();
  
  void deleteWorkOrder(Long projectId);
  
  void addAddressChangeListener(IAddressChangeListener addressChangeListener);
  
  public void removeAddressChangeListener(IAddressChangeListener listener);

}
