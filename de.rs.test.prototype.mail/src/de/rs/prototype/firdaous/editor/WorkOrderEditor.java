package de.rs.prototype.firdaous.editor;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import de.rs.firdaous.model.WorkOrder;

public class WorkOrderEditor extends EditorPart implements Observer{

	public static String ID = "de.vogella.rcp.editor.example.workorder";	

	private WorkOrderEditorInput input;
	
	ProjectEditor projectEditor;

	public WorkOrderEditor() {
		
	}

	

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof WorkOrderEditorInput)) {
			throw new RuntimeException("Wrong input");
		}
		this.input = (WorkOrderEditorInput) input;

		setSite(site);
		setInput(input);
		setPartName("Anlage zum Sterbefall.pdf");

	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		long workOrderId = this.input.getId();		
		projectEditor = new ProjectEditor(parent, workOrderId);
	}



	@Override
	public void setFocus() {	

	}

  @Override
  public void update(Observable o, Object arg) {    
    WorkOrder selection = (WorkOrder)arg;
    projectEditor.setWorkOrder(selection);
    System.out.println(selection);    
  }
  
  
  @Override
  public void doSave(IProgressMonitor monitor) {    

  }

  @Override
  public void doSaveAs() {    

  }
 


	
	

}
