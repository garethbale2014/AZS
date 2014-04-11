package de.rs.test.prototype.mail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observer;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.IHandlerService;

import de.ralfebert.rcputils.concurrent.UIProcess;
import de.ralfebert.rcputils.menus.ContextMenu;
import de.ralfebert.rcputils.wired.WiredViewPart;
import de.rs.firdaous.model.PresentationWorkOrder;
import de.rs.firdaous.model.WorkOrder;
import de.rs.firdaous.services.IAddressChangeListener;
import de.rs.firdaous.services.IDocumentService;
import de.rs.firdaous.services.IWorkOrderService;
import de.rs.prototype.firdaous.editor.BrowserComponent;
import de.rs.prototype.firdaous.handler.CallEditor;
import de.rs.prototype.utils.AddressBookMessages;
import de.rs.prototype.utils.ColumnConstants;
import de.rs.prototype.utils.ColumnCreator;

public class RowsView extends WiredViewPart {

	public static final String ID = "de.rs.test.prototype.mail.RowsView";

	private WritableList input;

	private TableViewer tableViewer;

	private DataBindingContext bindingContext;
	
	private IWorkOrderService addressService;
	
	private IDocumentService documentService;

  private IAddressChangeListener addressChangeListener  = new IAddressChangeListener() {

    public void addressesChanged() {
      refresh();
    }

  };
  
  private TableViewObservable tableViewerObservable;
	
	public class LoadAddressesJob extends UIProcess {

  private List<WorkOrder> orders;
  
  

  

    public LoadAddressesJob(Display display) {
      super(display, AddressBookMessages.LoadAddresses);
    }

    @Override
    protected void runInBackground(IProgressMonitor monitor) {
      orders = (addressService != null) ? addressService.getAllWorkOrder() : Collections.<WorkOrder> emptyList();
    }

    @Override
    protected void runInUIThread() {
      if (tableViewer != null && !tableViewer.getTable().isDisposed()) {
        
        tableViewer.setInput(orders);
        PresentationWorkOrder.getInstance().addOrders(orders);
        // WORKAROUND: Unnecessary horizontal scrollbar
        // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=304128
        tableViewer.getTable().getParent().layout();
      }
    }
  }

	

	

	@Override
	public void createPartControl(Composite parent) {
	  
	  tableViewerObservable = new TableViewObservable();
	  tableViewerObservable.createTableViewer(parent);
	  PresentationWorkOrder.getInstance().addObserver(tableViewerObservable);

		tableViewer = tableViewerObservable.getTableViewer();
		//tableViewerObservable.addSelectionListener();
		new LoadAddressesJob(tableViewer.getTable().getDisplay()).schedule();
		
//		ViewerSupport.bind(tableViewer, input,
//				PojoProperties.values(new String[] { "projectId", "workOrderDate", "person.firstname", "person.lastname", "person.birthday", "person.decedDay",
//						"person.birthCity", "person.nationality.name", "person.addresse" }));

		

		
		
		getSite().setSelectionProvider(tableViewer);
		hookDoubleClickCommand();
		//BrowserComponent.getInstance().setRowView(this);
		
		ContextMenu menu = new ContextMenu(tableViewer, getSite());
		menu.setDefaultItemHandling(true);
		refresh();


	}

	private void hookDoubleClickCommand() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				String commandID = CallEditor.id;
				IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
				try {
					handlerService.executeCommand(commandID, null);
					;
					//WorkOrder obj = (WorkOrder)((IStructuredSelection) event.getSelection()).getFirstElement();
					//tableViewerObservable.selectionChanged();
				} catch (Exception ex) {
					throw new RuntimeException(commandID + " not found");
				}
			}
		});
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
	  // TODO Auto-generated method stub
	  super.init(site);
	}

	@InjectService
  public void bindAddressService(IWorkOrderService addressService) {
    this.addressService = addressService;
    // Register for update events to refresh the view contents automatically
    addressService.addAddressChangeListener(addressChangeListener);
    refresh();
  }
	
//	@InjectService
//	public void bindDocumentService(IDocumentService documentService){
//	  this.documentService = documentService;
//	}
	
	
	public void unbindAddressService(IDocumentService documentService) {
    this.documentService = null;
    // Remove the change listener because otherwise the address service
    // would call the view object even when this view is already gone
    //addressService.removeAddressChangeListener(addressChangeListener);
   // refresh();
  }
	

  public void unbindAddressService(IWorkOrderService addressService) {
    this.addressService = null;
    // Remove the change listener because otherwise the address service
    // would call the view object even when this view is already gone
    addressService.removeAddressChangeListener(addressChangeListener);
    refresh();
  }
	
	
	@Override
	public void setFocus() {

	}

	public void setBinding() {

	}
	
	public TableViewer getTableViewer() {
		return tableViewer;
	}
	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}
	
	public void refresh() {
    if (tableViewer != null && !tableViewer.getTable().isDisposed()) {
      new LoadAddressesJob(tableViewer.getTable().getDisplay()).schedule();
    }
  }
	
	
	
	public void addObserver(Observer observer){
	  tableViewerObservable.addObserver(observer);
	}

  public void setChanged(WorkOrder order) {    
    tableViewerObservable.selectionChanged();
    tableViewerObservable.notifyObservers(order);
    
  }
	

}
