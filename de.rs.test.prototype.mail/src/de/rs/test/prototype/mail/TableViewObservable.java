package de.rs.test.prototype.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.rs.firdaous.model.WorkOrder;
import de.rs.prototype.utils.ColumnConstants;
import de.rs.prototype.utils.ColumnCreator;

public class TableViewObservable extends Observable implements Observer {

  private TableViewer tableViewer;

  public TableViewObservable() {

  }

  public void createTableViewer(Composite parent) {
    tableViewer = new TableViewer(parent, SWT.VIRTUAL | SWT.FULL_SELECTION | SWT.MULTI);
    // bindingContext = Activator.getDefault().getBindingContext();
    for (String headerText : ColumnConstants.RowViewerColumns) {
      ColumnCreator.createColumn(tableViewer, headerText);
    }

    tableViewer.getTable().setHeaderVisible(true);

    List<WorkOrder> ordersList = new ArrayList<WorkOrder>();
    // for (Entry<Long, WorkOrder> entry :
    // PresentationWorkOrder.getInstance().getOrders().entrySet()) {
    // ordersList.add(entry.getValue());
    // }

    // "Nationalität", "Adresse", "Adresse"

    // input = new WritableList(ordersList, Address.class);
    tableViewer.setContentProvider(new ArrayContentProvider());
  }

  @Override
  public synchronized void addObserver(Observer o) {
    // TODO Auto-generated method stub
    super.addObserver(o);
    
  }
  
  public TableViewer getTableViewer() {
    return tableViewer;
  }
  
  public void selectionChanged(){
    this.setChanged();
  }

  public void addSelectionListener() {
    this.tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      
      @Override
      public void selectionChanged(SelectionChangedEvent event) {
       
        
      }
    });
    
  }

  @Override
  public void update(Observable o, Object arg) {
    Map<Long, WorkOrder> ordersMap = (Map<Long, WorkOrder>)arg;
    tableViewer.setInput(ordersMap.values());
    
  }

}
