package imp_project.scanner;

import org.eclipse.jface.text.rules.IWordDetector;

public class NumberDetector implements IWordDetector {

	@Override
	public boolean isWordPart(char arg0) {
		
		if (Character.isDigit(arg0)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isWordStart(char arg0) {
		
		if (Character.isDigit(arg0)) {
			return true;
		}else {
			return false;
		}
	}

}