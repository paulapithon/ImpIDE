package imp_project.scanner;

import org.eclipse.jface.text.rules.IWordDetector;

public class IdDetector implements IWordDetector {

	@Override
	public boolean isWordPart(char arg0) {
		
		if (Character.isAlphabetic(arg0) && !Character.isDigit(arg0)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isWordStart(char arg0) {
		
		if (Character.isAlphabetic(arg0) && !Character.isDigit(arg0)) {
			return true;
		}else {
			return false;
		}
	}

}
