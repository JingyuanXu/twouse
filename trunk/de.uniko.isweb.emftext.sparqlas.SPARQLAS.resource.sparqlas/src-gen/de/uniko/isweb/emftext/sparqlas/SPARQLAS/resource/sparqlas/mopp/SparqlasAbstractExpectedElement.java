/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp;


// Abstract super class for all expected elements. Provides methods to
// set and retrieve the document range, where the element is expected.
// This range is expressed using four integers - two denoting the range
// including hidden tokens (e.g., whitespace) and two denoting the range
// excluding those token (i.e., the part of the document containing the
// relevant characters).
public abstract class SparqlasAbstractExpectedElement implements de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasExpectedElement {
	
	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private String prefix;
	private String scopeID;
	private boolean discardFollowingExpectations;
	
	public SparqlasAbstractExpectedElement(String scopeID, boolean discardFollowingExpectations) {
		this.scopeID = scopeID;
		this.discardFollowingExpectations = discardFollowingExpectations;
	}
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		
		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
	}
	
	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}
	
	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}
	
	public String getScopeID() {
		return scopeID;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	// Checks whether the cursor index is inside the range of
	// relevant characters, not considering hidden tokens
	// (e.g., whitespace).
	public boolean isAt(int cursorIndex) {
		if (startExcludingHiddenTokens <= cursorIndex && true) {
			return true;
		}
		return false;
	}
	
	public boolean isAfter(int cursorIndex) {
		return startIncludingHiddenTokens > cursorIndex;
	}
	
	public boolean isUnknown(int cursorIndex) {
		return startIncludingHiddenTokens > cursorIndex && true;
	}
	
	public boolean discardFollowingExpectations() {
		return discardFollowingExpectations;
	}
	
	public String toString() {
		return		toString(startIncludingHiddenTokens) + "(" + toString(startExcludingHiddenTokens) + ")" +		" scope = " + scopeID + "" +		" discardFollowing = " + discardFollowingExpectations;
	}
	
	private String toString(int index) {
		if (index == -1) {
			return "MIN";
		} else if (index == Integer.MAX_VALUE) {
			return "*";
		} else {
			return "" + index;
		}
	}
}