/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp;

// A CodeCompletionHelper can be used to derive completion proposals for partial
// documents. It runs the parser generated by EMFText in a special mode (i.e., the
// rememberExpectedElements mode). Based on the elements that are expected by the
// parser for different regions in the document, valid proposals are computed.
public class SparqlasCodeCompletionHelper {
	
	// Computes a set of proposals for the given document assuming the cursor is
	// at 'cursorOffset'. The proposals are derived using the meta information, i.e.,
	// the generated language plug-in.
	//
	// @param metaInformation
	// @param content the documents content
	// @param cursorOffset
	// @return
	public de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal[] computeCompletionProposals(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextResource originalResource, String content, int cursorOffset) {
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		// the shadow resource needs the same URI because reference resolvers may use the URI to resolve external references
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextResource resource = (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextResource) resourceSet.createResource(originalResource.getURI());
		java.io.ByteArrayInputStream inputStream = new java.io.ByteArrayInputStream(content.getBytes());
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasMetaInformation metaInformation = resource.getMetaInformation();
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextParser parser = metaInformation.createParser(inputStream, null);
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[] expectedElements = parseToExpectedElements(parser, resource);
		if (expectedElements == null) {
			return new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal[0];
		}
		if (expectedElements.length == 0) {
			return new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal[0];
		}
		java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedAfterCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset));
		java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedBeforeCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));
		System.out.println("parseToCursor(" + cursorOffset + ") BEFORE CURSOR " + expectedBeforeCursor);
		System.out.println("parseToCursor(" + cursorOffset + ") AFTER CURSOR  " + expectedAfterCursor);
		setPrefixes(expectedAfterCursor, content, cursorOffset);
		setPrefixes(expectedBeforeCursor, content, cursorOffset);
		// first we derive all possible proposals from the set of elements that are expected at the cursor position
		java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> allProposals = new java.util.LinkedHashSet<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal>();
		java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);
		java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset);
		// second, the set of left proposals (i.e., the ones before the cursor) is
		// checked for emptiness. if the set is empty, the right proposals (i.e., 
		// the ones after the cursor are removed, because it does not make sense to
		// propose them until the element before the cursor was completed
		allProposals.addAll(leftProposals);
		if (leftProposals.isEmpty()) {
			allProposals.addAll(rightProposals);
		}
		// third, the proposals are sorted according to their relevance
		// proposals that matched the prefix are preferred over ones that did not
		// afterward proposals are sorted alphabetically
		final java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> sortedProposals = new java.util.ArrayList<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal>(allProposals);
		java.util.Collections.sort(sortedProposals);
		return sortedProposals.toArray(new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal[sortedProposals.size()]);
	}
	
	public de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[] parseToExpectedElements(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextParser parser, de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextResource resource) {
		final java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedElements = parser.parseToExpectedElements(null, resource);
		if (expectedElements == null) {
			return new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[0];
		}
		removeDuplicateEntries(expectedElements);
		removeInvalidEntriesAtEnd(expectedElements);
		return expectedElements.toArray(new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[expectedElements.size()]);
	}
	
	private void removeDuplicateEntries(java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1; i++) {
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal elementAtIndex = expectedElements.get(i);
			for (int j = i + 1; j < expectedElements.size();) {
				de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal elementAtNext = expectedElements.get(j);
				if (elementAtIndex.equals(elementAtNext) && elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens()) {
					expectedElements.remove(j);
				} else {
					j++;
				}
			}
		}
	}
	
	private void removeInvalidEntriesAtEnd(java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1;) {
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal elementAtIndex = expectedElements.get(i);
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal elementAtNext = expectedElements.get(i + 1);
			if (elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens() && shouldRemove(elementAtIndex.getFollowSetID(), elementAtNext.getFollowSetID())) {
				expectedElements.remove(i + 1);
			} else {
				i++;
			}
		}
	}
	
	public boolean shouldRemove(int followSetID1, int followSetID2) {
		return followSetID1 != followSetID2;
	}
	
	private String findPrefix(java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedElements, de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal expectedAtCursor, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return "";
		}
		int end = 0;
		for (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal expectedElement : expectedElements) {
			if (expectedElement == expectedAtCursor) {
				final int start = expectedElement.getStartExcludingHiddenTokens();
				if (start >= 0  && start < Integer.MAX_VALUE) {
					end = start;
				}
				break;
			}
		}
		end = Math.min(end, cursorOffset);
		final String prefix = content.substring(end, Math.min(content.length(), cursorOffset));
		System.out.println("Found prefix '" + prefix + "'");
		return prefix;
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> deriveProposals(java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedElements, String content, de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextResource resource, int cursorOffset) {
		java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> resultSet = new java.util.HashSet<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal>();
		for (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal expectedElement : expectedElements) {
			resultSet.addAll(deriveProposals(expectedElement, content, resource, cursorOffset));
		}
		return resultSet;
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> deriveProposals(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal expectedTerminal, String content, de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTextResource resource, int cursorOffset) {
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasMetaInformation metaInformation = resource.getMetaInformation();
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasLocationMap locationMap = resource.getLocationMap();
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasExpectedElement expectedElement = (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasExpectedElement) expectedTerminal.getTerminal();
		if (expectedElement instanceof de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedCsString) {
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedCsString csString = (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedCsString) expectedElement;
			return deriveProposal(csString, content, expectedTerminal.getPrefix(), cursorOffset);
		} else if (expectedElement instanceof de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedStructuralFeature) {
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedStructuralFeature expectedFeature = (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedStructuralFeature) expectedElement;
			org.eclipse.emf.ecore.EStructuralFeature feature = expectedFeature.getFeature();
			org.eclipse.emf.ecore.EClassifier featureType = feature.getEType();
			java.util.List<org.eclipse.emf.ecore.EObject> elementsAtCursor = locationMap.getElementsAt(cursorOffset);
			org.eclipse.emf.ecore.EObject container = null;
			// we need to skip the proxy elements at the cursor, because they are not the container for the reference we try to complete
			for (int i = 0; i < elementsAtCursor.size(); i++) {
				container = elementsAtCursor.get(i);
				if (!container.eIsProxy()) {
					break;
				}
			}
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				org.eclipse.emf.ecore.EReference reference = (org.eclipse.emf.ecore.EReference) feature;
				if (featureType instanceof org.eclipse.emf.ecore.EClass) {
					if (reference.isContainment()) {
						// the FOLLOW set should contain only non-containment references
						assert false;
					} else {
						return handleNCReference(metaInformation, container, reference, expectedTerminal.getPrefix());
					}
				}
			} else if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
				org.eclipse.emf.ecore.EAttribute attribute = (org.eclipse.emf.ecore.EAttribute) feature;
				if (featureType instanceof org.eclipse.emf.ecore.EEnum) {
					org.eclipse.emf.ecore.EEnum enumType = (org.eclipse.emf.ecore.EEnum) featureType;
					return deriveProposals(expectedTerminal, enumType, content, cursorOffset);
				} else {
					// handle EAttributes (derive default value depending on
					// the type of the attribute, figure out token resolver, and
					// call deResolve())
					return handleAttribute(metaInformation, expectedFeature, container, attribute, expectedTerminal.getPrefix());
				}
			} else {
				// there should be no other subclass of EStructuralFeature
				assert false;
			}
		} else {
			// there should be no other class implementing IExpectedElement
			assert false;
		}
		return java.util.Collections.emptyList();
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> deriveProposals(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal expectedElement, org.eclipse.emf.ecore.EEnum enumType, String content, int cursorOffset) {
		java.util.Collection<org.eclipse.emf.ecore.EEnumLiteral> enumLiterals = enumType.getELiterals();
		java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> result = new java.util.HashSet<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal>();
		for (org.eclipse.emf.ecore.EEnumLiteral literal : enumLiterals) {
			String proposal = literal.getLiteral();
			String prefix = expectedElement.getPrefix();
			if (matches(proposal, prefix)) {
				result.add(new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal(proposal, prefix, !"".equals(prefix), true));
			}
		}
		return result;
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> handleNCReference(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasMetaInformation metaInformation, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, java.lang.String prefix) {
		// proposals for non-containment references are derived by calling the
		// reference resolver switch in fuzzy mode.
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasReferenceResolverSwitch resolverSwitch = metaInformation.getReferenceResolverSwitch();
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasReferenceResolveResult<org.eclipse.emf.ecore.EObject> result = new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasReferenceResolveResult<org.eclipse.emf.ecore.EObject>(true);
		resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);
		java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasReferenceMapping<org.eclipse.emf.ecore.EObject>> mappings = result.getMappings();
		if (mappings != null) {
			java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> resultSet = new java.util.HashSet<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal>();
			for (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasReferenceMapping<org.eclipse.emf.ecore.EObject> mapping : mappings) {
				final String identifier = mapping.getIdentifier();
				// the proposal can be added without checking the prefix because this is
				// performed by the reference resolvers
				resultSet.add(new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal(identifier, prefix, true, true));
			}
			return resultSet;
		}
		return java.util.Collections.emptyList();
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> handleAttribute(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasMetaInformation metaInformation, de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedStructuralFeature expectedFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EAttribute attribute, java.lang.String prefix) {
		java.lang.Object defaultValue = getDefaultValue(attribute);
		if (defaultValue != null) {
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
			String tokenName = expectedFeature.getTokenName();
			if (tokenName != null) {
				de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.ISparqlasTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
				if (tokenResolver != null) {
					String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);
					java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> resultSet = new java.util.HashSet<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal>();
					if (matches(defaultValueAsString, prefix)) {
						resultSet.add(new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal(defaultValueAsString, prefix, !"".equals(prefix), true));
					}
					return resultSet;
				}
			}
		}
		return java.util.Collections.emptyList();
	}
	
	private java.lang.Object getDefaultValue(org.eclipse.emf.ecore.EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return "some" + de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.util.SparqlasStringUtil.capitalize(attribute.getName());
		}
		System.out.println("CodeCompletionHelper.getDefaultValue() unknown type " + typeName);
		return attribute.getDefaultValue();
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> deriveProposal(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedCsString csString, String content, String prefix, int cursorOffset) {
		String proposal = csString.getValue();
		java.util.Collection<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal> result = new java.util.HashSet<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal>();
		if (matches(proposal, prefix)) {
			result.add(new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasCompletionProposal(proposal, prefix, !"".equals(prefix), false));
		}
		return result;
	}
	
	// for each given expected elements the prefix is calculated
	// the prefix depends on the current document content, the cursor position, and
	// the position where the element is expected
	private void setPrefixes(java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedElements, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return;
		}
		for (de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal expectedElement : expectedElements) {
			java.lang.String prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);
			expectedElement.setPrefix(prefix);
		}
	}
	
	public de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[] getElementsExpectedAt(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[] allExpectedElements, int cursorOffset) {
		java.util.List<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal> expectedAtCursor = new java.util.ArrayList<de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal>();
		for (int i = 0; i < allExpectedElements.length; i++) {
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal expectedElement = allExpectedElements[i];
			int startIncludingHidden = expectedElement.getStartIncludingHiddenTokens();
			int end = getEnd(allExpectedElements, i);
			if (cursorOffset >= startIncludingHidden && cursorOffset <= end) {
				expectedAtCursor.add(expectedElement);
			}
		}
		return expectedAtCursor.toArray(new de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[expectedAtCursor.size()]);
	}
	
	private int getEnd(de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal[] allExpectedElements, int indexInList) {
		de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal elementAtIndex = allExpectedElements[indexInList];
		int startIncludingHidden = elementAtIndex.getStartIncludingHiddenTokens();
		int startExcludingHidden = elementAtIndex.getStartExcludingHiddenTokens();
		for (int i = indexInList + 1; i < allExpectedElements.length; i++) {
			de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.mopp.SparqlasExpectedTerminal elementAtI = allExpectedElements[i];
			int startIncludingHiddenForI = elementAtI.getStartIncludingHiddenTokens();
			int startExcludingHiddenForI = elementAtI.getStartExcludingHiddenTokens();
			if (startIncludingHidden != startIncludingHiddenForI || startExcludingHidden != startExcludingHiddenForI) {
				return startIncludingHiddenForI - 1;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private boolean matches(java.lang.String proposal, java.lang.String prefix) {
		return (proposal.startsWith(prefix) || de.uniko.isweb.emftext.sparqlas.SPARQLAS.resource.sparqlas.util.SparqlasStringUtil.matchCamelCase(prefix, proposal) != null) && !proposal.equals(prefix);
	}
	
}
