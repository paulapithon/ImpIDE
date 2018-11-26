package imp_project.scanner;

import org.eclipse.jface.text.rules.*;

public class BracketsRule extends MultiLineRule {

	public BracketsRule(IToken token) {
		super("{", "}", token);
	}
	
	@Override
	protected boolean sequenceDetected(ICharacterScanner scanner, char[] sequence, boolean eofAllowed) {
		int c = scanner.read();
		
		if (sequence[0] == '{') {
			if (c == '?') {
				// processing instruction - abort
				scanner.unread();
				return false;
			}
			if (c == '!') {
				scanner.unread();
				// comment - abort
				return false;
			}
		} else if (sequence[0] == '}') {
			scanner.unread();
		}
		
		
		
		return super.sequenceDetected(scanner, sequence, eofAllowed);
	}
}
