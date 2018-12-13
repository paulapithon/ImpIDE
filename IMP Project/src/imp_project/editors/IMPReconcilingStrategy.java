package imp_project.editors;


import java.util.ArrayList;
import java.util.Stack;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.swt.widgets.Display;

public class IMPReconcilingStrategy implements IReconcilingStrategy,
               IReconcilingStrategyExtension {

       private IMPEditor editor;

       private IDocument fDocument;

       /** holds the calculated positions */
       protected final ArrayList fPositions = new ArrayList();

       /** The offset of the next character to be read */
       protected int fOffset;

       /** The end offset of the range to be scanned */
       protected int fRangeEnd;

       /**
        * @return Returns the editor.
        */
       public IMPEditor getEditor() {
               return editor;
       }

       public void setEditor(IMPEditor editor) {
               this.editor = editor;
       }

       /*
        * (non-Javadoc)
        *
        * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#setDocument(org.eclipse.jface.text.IDocument)
        */
       public void setDocument(IDocument document) {
               this.fDocument = document;

       }

       /*
        * (non-Javadoc)
        *
        * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.reconciler.DirtyRegion,
        *      org.eclipse.jface.text.IRegion)
        */
       public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
               initialReconcile();
       }

       /*
        * (non-Javadoc)
        *
        * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.IRegion)
        */
       public void reconcile(IRegion partition) {
               initialReconcile();
       }

       /*
        * (non-Javadoc)
        *
        * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#setProgressMonitor(org.eclipse.core.runtime.IProgressMonitor)
        */
       public void setProgressMonitor(IProgressMonitor monitor) {
               // TODO Auto-generated method stub

       }

       /*
        * (non-Javadoc)
        *
        * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#initialReconcile()
        */
       public void initialReconcile() {
               fOffset = 0;
               fRangeEnd = fDocument.getLength();
               calculatePositions();

       }

       /**
        * next character position - used locally and only valid while
        * {@link #calculatePositions()} is in progress.
        */
       protected int cNextPos = 0;

       /** number of newLines found by {@link #classifyTag()} */
       protected int cNewLines = 0;

       protected char cLastNLChar = ' ';

       protected static final int START_TAG = 1;

       protected static final int LEAF_TAG = 2;

       protected static final int END_TAG = 3;

       protected static final int EOR_TAG = 4;

       protected static final int COMMENT_TAG = 5;

       protected static final int PI_TAG = 6;
   	/**
   	 * uses {@link #fDocument}, {@link #fOffset} and {@link #fRangeEnd} to calculate
   	 * {@link #fPositions}. About syntax errors: this method is not a validator, it
   	 * is useful.
   	 */
   	protected void calculatePositions() {
   		fPositions.clear();
   		stackBrackets();
   		Display.getDefault().asyncExec(new Runnable() {
   			public void run() {
   				editor.updateFoldingStructure(fPositions);
   			}

   		});
   	}
   	
   	private void stackBrackets() {
   		Stack<Integer> stack = new Stack<Integer>(); 
   		for (int i = 0; i < fDocument.getLength(); i++) {
   			try {
   				if (fDocument.getChar(i) == '{') {
   					stack.push(i);
   				} else if (fDocument.getChar(i) == '}') {
   					int position = stack.pop();
   					emitPosition(position, i - position);
   				}
   			} catch (BadLocationException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   	}

       protected void emitPosition(int startOffset, int length) {
               fPositions.add(new Position(startOffset, length));
       }

}

