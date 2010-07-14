/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package west.twouse.language.sparqlas.resource.sparqlas.ui;

public class SparqlasCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private west.twouse.language.sparqlas.resource.sparqlas.ui.SparqlasEditor editor;
	
	public SparqlasCompletionProcessor(west.twouse.language.sparqlas.resource.sparqlas.ui.SparqlasEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		west.twouse.language.sparqlas.resource.sparqlas.ISparqlasTextResource textResource = (west.twouse.language.sparqlas.resource.sparqlas.ISparqlasTextResource) resource;
		java.lang.String content = viewer.getDocument().get();
		west.twouse.language.sparqlas.resource.sparqlas.ui.SparqlasCodeCompletionHelper helper = new west.twouse.language.sparqlas.resource.sparqlas.ui.SparqlasCodeCompletionHelper();
		west.twouse.language.sparqlas.resource.sparqlas.ui.SparqlasCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, content, offset);
		
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[proposals.length];
		int i = 0;
		for (west.twouse.language.sparqlas.resource.sparqlas.ui.SparqlasCompletionProposal proposal : proposals) {
			java.lang.String proposalString = proposal.getInsertString();
			java.lang.String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			west.twouse.language.sparqlas.resource.sparqlas.ui.ISparqlasBracketHandler bracketHandler = editor.getBracketHandler();
			java.lang.String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, proposalString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
