package de.rs.prototype.firdaous.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.rs.test.prototype.mail.RowsView;

public class DataLoaderHandler extends AbstractHandler {

  private int instanceNum = 1;

  public static final String id = "de.rs.prototype.firdaous.handler.openDatarows";

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    try {
      IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
      window.getActivePage().showView(RowsView.ID, Integer.toString(instanceNum++), IWorkbenchPage.VIEW_ACTIVATE);
    } catch (PartInitException e) {
     
      e.printStackTrace();
    }
    return null;
  }

}
