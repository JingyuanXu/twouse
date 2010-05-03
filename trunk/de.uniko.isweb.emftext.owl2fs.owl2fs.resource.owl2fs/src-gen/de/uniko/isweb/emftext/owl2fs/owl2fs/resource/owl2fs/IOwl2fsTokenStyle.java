/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs;

// A common interface for token styles. Text resources must
// return style information using object implementing this
// interface.
public interface IOwl2fsTokenStyle {
	
	// Returns the color of the token as array of length 3.
	public int[] getColorAsRGB();
	
	// Returns true if the token must be displayed in bold face.
	public boolean isBold();
	
	// Returns true if the token must be displayed in italic face.
	public boolean isItalic();
	
	// Returns true if the token must be displayed in strike through style.
	public boolean isStrikethrough();
	
	// Returns true if the token must be displayed underline.
	public boolean isUnderline();
}