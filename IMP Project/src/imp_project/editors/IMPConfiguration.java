package imp_project.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import imp_project.scanner.IMPBracketScanner;
import imp_project.scanner.IMPPartitionScanner;

public class IMPConfiguration extends SourceViewerConfiguration {
	private IMPDoubleClickStrategy doubleClickStrategy;
	private IMPBracketScanner bracketScanner;
	private ColorManager colorManager;

	public IMPConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}

	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
			IMPPartitionScanner.IMP_BRACKETS };
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new IMPDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected IMPBracketScanner getIMPBracketsScanner() {
		if (bracketScanner == null) {
			bracketScanner = new IMPBracketScanner(colorManager);
			bracketScanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(IIMPColorConstants.BRACKET))));
		}
		return bracketScanner;
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getIMPBracketsScanner());
		reconciler.setDamager(dr, IMPPartitionScanner.IMP_BRACKETS);
		reconciler.setRepairer(dr, IMPPartitionScanner.IMP_BRACKETS);

		dr = new DefaultDamagerRepairer(getIMPBracketsScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(
				new TextAttribute(colorManager.getColor(IIMPColorConstants.IMP_COMMENT)));
		reconciler.setDamager(ndr, IMPPartitionScanner.IMP_COMMENT);
		reconciler.setRepairer(ndr, IMPPartitionScanner.IMP_COMMENT);

		return reconciler;
	}

}