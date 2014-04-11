package de.rs.prototype.firdaous.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.rs.firdaous.model.PresentationWorkOrder;
import de.rs.firdaous.model.WorkOrder;
import de.rs.prototype.firdaous.editor.WorkOrderEditor;
import de.rs.prototype.firdaous.editor.WorkOrderEditorInput;
import de.rs.test.prototype.mail.RowsView;

public class CallEditor extends AbstractHandler {

  public static final String id = "de.vogella.rcp.editor.example.openEditor";

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    ISelection selection = HandlerUtil.getCurrentSelection(event);
    IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
    RowsView view = (RowsView) activePage.findView(RowsView.ID);
    if (selection != null && selection instanceof IStructuredSelection) {
      Object obj = ((IStructuredSelection) selection).getFirstElement();
      PresentationWorkOrder presentationModel = PresentationWorkOrder.getInstance();
      WorkOrder order = (WorkOrder) obj;
      order = (WorkOrder) (order != null ? (WorkOrder) order : new WorkOrder());
      presentationModel.getOrders().put(order.projectId, order);
      presentationModel.getOrders();
      WorkOrderEditorInput input = new WorkOrderEditorInput(order.getProjectId());
      try {
        //activePage.openEditor(input, WorkOrderEditor.ID);
        view.addObserver((WorkOrderEditor) activePage.openEditor(input, WorkOrderEditor.ID));
        view.setChanged(order);
      } catch (PartInitException e) {
        throw new RuntimeException(e);
      }
    }
    return null;
  }

}