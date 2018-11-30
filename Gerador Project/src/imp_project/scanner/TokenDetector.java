package imp_project.scanner;

import org.eclipse.jface.text.rules.IWordDetector;

public class TokenDetector implements IWordDetector {

	@Override
	public boolean isWordPart(char c) {
		
		if (!Character.isLetter(c) && !Character.isDigit(c)) {
			return false;
		}else {
			
			return true;
		}
		
	}

	@Override
	public boolean isWordStart(char arg0) {
		
		if (Character.isLetter(arg0)) {
			return true;
			
		}else {
			return false;
		}
	}

}
