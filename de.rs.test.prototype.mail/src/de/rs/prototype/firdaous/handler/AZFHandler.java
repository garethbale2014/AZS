package de.rs.prototype.firdaous.handler;

import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.service.log.LogService;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import de.ralfebert.rcputils.selection.SelectionUtils;
import de.ralfebert.rcputils.wired.WiredHandler;
import de.rs.auxiliary.FormularName;
import de.rs.firdaous.model.WorkOrder;
import de.rs.firdaous.services.IDocumentService;
import de.rs.utils.RSConstant;

public class AZFHandler extends WiredHandler {
  
  IDocumentService documnentService;
  
  private LogService log;

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException   {
    ISelection selection = HandlerUtil.getCurrentSelection(event);
    for (WorkOrder order : SelectionUtils.getIterable(selection, WorkOrder.class)) {
      log.log(LogService.LOG_INFO, "Deleting address: " + order); //$NON-NLS-1$
      try {
        FormularName f = FormularName.AZF;
        String filename = FormularName.getValueFromName(f.name());
        documnentService.setFieldToPDF(order, filename);
       
      } catch (IOException e) {
        log.log(LogService.LOG_ERROR, e.getLocalizedMessage());
      } catch (ParserConfigurationException e) {
        log.log(LogService.LOG_ERROR, e.getLocalizedMessage());
      } catch (SAXException e) {
        log.log(LogService.LOG_ERROR, e.getLocalizedMessage());
      } catch (DocumentException e) {
        log.log(LogService.LOG_ERROR, e.getLocalizedMessage());
      }
    }
    return null;
   
  }
  
  @Override
  public boolean isEnabled() {
    return super.isEnabled() && documnentService != null;
  }

  @InjectService
  public void bindAddressService(IDocumentService documnentService) {
    this.documnentService = documnentService;
  }

  public void unbindAddressService(IDocumentService documnentService) {
    this.documnentService = null;
  }

  @InjectService
  public void bindLog(LogService log) {
    this.log = log;
  }

  public void unbindLog(LogService log) {
    this.log = null;
  }

}
