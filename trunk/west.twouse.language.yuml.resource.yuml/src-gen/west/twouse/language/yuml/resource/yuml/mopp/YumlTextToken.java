/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package west.twouse.language.yuml.resource.yuml.mopp;
public class YumlTextToken implements west.twouse.language.yuml.resource.yuml.IYumlTextToken {
	
	private final west.twouse.language.yuml.resource.yuml.IYumlMetaInformation metaInformation = new west.twouse.language.yuml.resource.yuml.mopp.YumlMetaInformation();
	private final org.antlr.runtime3_2_0.Token antlrToken;
	
	public YumlTextToken(org.antlr.runtime3_2_0.Token antlrToken) {
		super();
		this.antlrToken = antlrToken;
	}
	
	public String getName() {
		return getTokenName(metaInformation.getTokenNames(), antlrToken.getType());
	}
	
	public int getOffset() {
		return ((org.antlr.runtime3_2_0.CommonToken) antlrToken).getStartIndex();
	}
	
	public int getLength() {
		return ((org.antlr.runtime3_2_0.CommonToken) antlrToken).getStopIndex() - ((org.antlr.runtime3_2_0.CommonToken) antlrToken).getStartIndex() + 1;
	}
	
	public int getLine() {
		return antlrToken.getLine();
	}
	
	public int getColumn() {
		return antlrToken.getCharPositionInLine();
	}
	
	public boolean canBeUsedForSyntaxHighlighting() {
		int tokenType = antlrToken.getType();
		if (tokenType == org.antlr.runtime3_2_0.Token.EOF) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.UP) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.DOWN) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}
	
	public String getText() {
		return antlrToken.getText();
	}
	
	public String getTokenName(String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
	
}
