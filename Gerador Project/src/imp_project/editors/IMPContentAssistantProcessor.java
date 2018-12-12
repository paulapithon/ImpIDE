package imp_project.editors;


import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class IMPContentAssistantProcessor implements IContentAssistProcessor
{

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
     */
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
            int offset)
    {
    	//`language`, `class`, `compile`, `extends`, `syntax`, `this`, `val`, `eval`, `asm`, `print`, `forEach`,
    	//`nextLabel`, `opCodeOf`, `toString`, `lexical`, `whitespace` e `start`
        ICompletionProposal[] completionProposals = new ICompletionProposal[17];
        
        completionProposals[0]=new CompletionProposal("language",0,1,5);
        completionProposals[1]=new CompletionProposal("class",0,1,5);
        completionProposals[2]=new CompletionProposal("compile",0,1,5);
        completionProposals[3]=new CompletionProposal("extends",0,1,5);
        completionProposals[4]=new CompletionProposal("syntax",0,1,5);
        completionProposals[5]=new CompletionProposal("this",0,1,5);
        completionProposals[6]=new CompletionProposal("val",0,1,5);
        completionProposals[7]=new CompletionProposal("eval",0,1,5);
        completionProposals[8]=new CompletionProposal("print",0,1,5);
        completionProposals[9]=new CompletionProposal("asm",0,1,5);
        completionProposals[10]=new CompletionProposal("forEach",0,1,5);
        completionProposals[11]=new CompletionProposal("nextLabel",0,1,5);
        completionProposals[12]=new CompletionProposal("opCodeOf",0,1,5);
        completionProposals[13]=new CompletionProposal("toString",0,1,5);
        completionProposals[14]=new CompletionProposal("lexical",0,1,5);
        completionProposals[15]=new CompletionProposal("whitespace",0,1,5);
        completionProposals[16]=new CompletionProposal("start",0,1,5);
        return completionProposals;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
     */
    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
     */
    public char[] getCompletionProposalAutoActivationCharacters()
    {
        return new char[] {'a'};
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
     */
    public char[] getContextInformationAutoActivationCharacters()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
     */
    public String getErrorMessage()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
     */
    public IContextInformationValidator getContextInformationValidator()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
