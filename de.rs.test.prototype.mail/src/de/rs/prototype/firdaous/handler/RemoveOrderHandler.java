package de.rs.prototype.firdaous.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.service.log.LogService;

import de.ralfebert.rcputils.selection.SelectionUtils;
import de.ralfebert.rcputils.wired.WiredHandler;
import de.rs.firdaous.model.PresentationWorkOrder;
import de.rs.firdaous.model.WorkOrder;
import de.rs.firdaous.services.IWorkOrderService;

/**
 * Handler to delete selected addresses.
 */
public class RemoveOrderHandler extends WiredHandler {

  private IWorkOrderService workOrderService;
  
  private LogService log;

  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection = HandlerUtil.getCurrentSelection(event);
    for (WorkOrder order : SelectionUtils.getIterable(selection, WorkOrder.class)) {
      log.log(LogService.LOG_INFO, "Removing address: " + order); //$NON-NLS-1$
      PresentationWorkOrder.getInstance().removeOrder(order);
      //workOrderService.deleteWorkOrder(order.getProjectId());
    }
    return null;
  }

  @Override
  public boolean isEnabled() {
    return super.isEnabled() && workOrderService != null;
  }

  @InjectService
  public void bindAddressService(IWorkOrderService addressService) {
    this.workOrderService = addressService;
  }

  public void unbindAddressService(IWorkOrderService addressService) {
    this.workOrderService = null;
  }

  @InjectService
  public void bindLog(LogService log) {
    this.log = log;
  }

  public void unbindLog(LogService log) {
    this.log = null;
  }

}