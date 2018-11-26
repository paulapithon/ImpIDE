package imp_project.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class IMPEditor extends TextEditor {

	private ColorManager colorManager;

	public IMPEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new IMPConfiguration(colorManager));
		setDocumentProvider(new IMPDocumentProvider());
	}
	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
	
//    protected void createActions() {
//        
//     }

}
