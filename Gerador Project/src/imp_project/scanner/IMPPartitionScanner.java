package imp_project.scanner;

import org.eclipse.jface.text.rules.*;

public class IMPPartitionScanner extends RuleBasedPartitionScanner {
	public final static String IMP_COMMENT = "__imp_comment";
	public final static String IMP_BRACKETS = "__imp_brackets";

	public IMPPartitionScanner() {

		IToken impComment = new Token(IMP_COMMENT);

		IPredicateRule[] rules = new IPredicateRule[1];

		rules[0] = new MultiLineRule("/*", "*/", impComment);


		setPredicateRules(rules);
	}
}
