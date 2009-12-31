/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp;

// A CodeCompletionHelper can be used to derive completion proposals for partial
// documents. It runs the parser generated by EMFText in a special mode (i.e., the
// rememberExpectedElements mode). Based on the elements that are expected by the
// parser for different regions in the document, valid proposals are computed.
public class Owl2fsCodeCompletionHelper {
	
	// Computes a set of proposals for the given document assuming the cursor is
	// at 'cursorOffset'. The proposals are derived using the meta information, i.e.,
	// the generated language plug-in.
	//
	// @param metaInformation
	// @param content the documents content
	// @param cursorOffset
	// @return
	public de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal[] computeCompletionProposals(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextResource originalResource, String content, int cursorOffset) {
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		// the shadow resource needs the same URI because reference resolvers may use the URI to resolve external references
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextResource resource = (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextResource) resourceSet.createResource(originalResource.getURI());
		java.io.ByteArrayInputStream inputStream = new java.io.ByteArrayInputStream(content.getBytes());
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsMetaInformation metaInformation = resource.getMetaInformation();
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextParser parser = metaInformation.createParser(inputStream, null);
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[] expectedElements = parseToExpectedElements(parser, resource);
		if (expectedElements == null) {
			return new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal[0];
		}
		if (expectedElements.length == 0) {
			return new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal[0];
		}
		java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedAfterCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset));
		java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedBeforeCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));
		System.out.println("parseToCursor(" + cursorOffset + ") BEFORE CURSOR " + expectedBeforeCursor);
		System.out.println("parseToCursor(" + cursorOffset + ") AFTER CURSOR  " + expectedAfterCursor);
		setPrefixes(expectedAfterCursor, content, cursorOffset);
		setPrefixes(expectedBeforeCursor, content, cursorOffset);
		// first we derive all possible proposals from the set of elements that are expected at the cursor position
		java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> allProposals = new java.util.LinkedHashSet<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal>();
		java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);
		java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset);
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
		final java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> sortedProposals = new java.util.ArrayList<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal>(allProposals);
		java.util.Collections.sort(sortedProposals);
		return sortedProposals.toArray(new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal[sortedProposals.size()]);
	}
	
	public de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[] parseToExpectedElements(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextParser parser, de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextResource resource) {
		final java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedElements = parser.parseToExpectedElements(null, resource);
		if (expectedElements == null) {
			return new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[0];
		}
		removeDuplicateEntries(expectedElements);
		removeInvalidEntriesAtEnd(expectedElements);
		return expectedElements.toArray(new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[expectedElements.size()]);
	}
	
	private void removeDuplicateEntries(java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1; i++) {
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal elementAtIndex = expectedElements.get(i);
			for (int j = i + 1; j < expectedElements.size();) {
				de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal elementAtNext = expectedElements.get(j);
				if (elementAtIndex.equals(elementAtNext) && elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens()) {
					expectedElements.remove(j);
				} else {
					j++;
				}
			}
		}
	}
	
	private void removeInvalidEntriesAtEnd(java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1;) {
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal elementAtIndex = expectedElements.get(i);
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal elementAtNext = expectedElements.get(i + 1);
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
	
	private String findPrefix(java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedElements, de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal expectedAtCursor, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return "";
		}
		int end = 0;
		for (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal expectedElement : expectedElements) {
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
	
	private java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> deriveProposals(java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedElements, String content, de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextResource resource, int cursorOffset) {
		java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> resultSet = new java.util.HashSet<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal>();
		for (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal expectedElement : expectedElements) {
			resultSet.addAll(deriveProposals(expectedElement, content, resource, cursorOffset));
		}
		return resultSet;
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> deriveProposals(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal expectedTerminal, String content, de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTextResource resource, int cursorOffset) {
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsMetaInformation metaInformation = resource.getMetaInformation();
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsLocationMap locationMap = resource.getLocationMap();
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsExpectedElement expectedElement = (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsExpectedElement) expectedTerminal.getTerminal();
		if (expectedElement instanceof de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedCsString) {
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedCsString csString = (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedCsString) expectedElement;
			return deriveProposal(csString, content, expectedTerminal.getPrefix(), cursorOffset);
		} else if (expectedElement instanceof de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedStructuralFeature) {
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedStructuralFeature expectedFeature = (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedStructuralFeature) expectedElement;
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
	
	private java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> deriveProposals(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal expectedElement, org.eclipse.emf.ecore.EEnum enumType, String content, int cursorOffset) {
		java.util.Collection<org.eclipse.emf.ecore.EEnumLiteral> enumLiterals = enumType.getELiterals();
		java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> result = new java.util.HashSet<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal>();
		for (org.eclipse.emf.ecore.EEnumLiteral literal : enumLiterals) {
			String proposal = literal.getLiteral();
			String prefix = expectedElement.getPrefix();
			if (matches(proposal, prefix)) {
				result.add(new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal(proposal, prefix, !"".equals(prefix), true));
			}
		}
		return result;
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> handleNCReference(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsMetaInformation metaInformation, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, java.lang.String prefix) {
		// proposals for non-containment references are derived by calling the
		// reference resolver switch in fuzzy mode.
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsReferenceResolverSwitch resolverSwitch = metaInformation.getReferenceResolverSwitch();
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsReferenceResolveResult<org.eclipse.emf.ecore.EObject> result = new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsReferenceResolveResult<org.eclipse.emf.ecore.EObject>(true);
		resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);
		java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsReferenceMapping<org.eclipse.emf.ecore.EObject>> mappings = result.getMappings();
		if (mappings != null) {
			java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> resultSet = new java.util.HashSet<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal>();
			for (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsReferenceMapping<org.eclipse.emf.ecore.EObject> mapping : mappings) {
				final String identifier = mapping.getIdentifier();
				// the proposal can be added without checking the prefix because this is
				// performed by the reference resolvers
				resultSet.add(new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal(identifier, prefix, true, true));
			}
			return resultSet;
		}
		return java.util.Collections.emptyList();
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> handleAttribute(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsMetaInformation metaInformation, de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedStructuralFeature expectedFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EAttribute attribute, java.lang.String prefix) {
		java.lang.Object defaultValue = getDefaultValue(attribute);
		if (defaultValue != null) {
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
			String tokenName = expectedFeature.getTokenName();
			if (tokenName != null) {
				de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.IOwl2fsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
				if (tokenResolver != null) {
					String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);
					java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> resultSet = new java.util.HashSet<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal>();
					if (matches(defaultValueAsString, prefix)) {
						resultSet.add(new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal(defaultValueAsString, prefix, !"".equals(prefix), true));
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
			return "some" + de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.util.Owl2fsStringUtil.capitalize(attribute.getName());
		}
		System.out.println("CodeCompletionHelper.getDefaultValue() unknown type " + typeName);
		return attribute.getDefaultValue();
	}
	
	private java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> deriveProposal(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedCsString csString, String content, String prefix, int cursorOffset) {
		String proposal = csString.getValue();
		java.util.Collection<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal> result = new java.util.HashSet<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal>();
		if (matches(proposal, prefix)) {
			result.add(new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsCompletionProposal(proposal, prefix, !"".equals(prefix), false));
		}
		return result;
	}
	
	// for each given expected elements the prefix is calculated
	// the prefix depends on the current document content, the cursor position, and
	// the position where the element is expected
	private void setPrefixes(java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedElements, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return;
		}
		for (de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal expectedElement : expectedElements) {
			java.lang.String prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);
			expectedElement.setPrefix(prefix);
		}
	}
	
	public de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[] getElementsExpectedAt(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[] allExpectedElements, int cursorOffset) {
		java.util.List<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal> expectedAtCursor = new java.util.ArrayList<de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal>();
		for (int i = 0; i < allExpectedElements.length; i++) {
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal expectedElement = allExpectedElements[i];
			int startIncludingHidden = expectedElement.getStartIncludingHiddenTokens();
			int end = getEnd(allExpectedElements, i);
			if (cursorOffset >= startIncludingHidden && cursorOffset <= end) {
				expectedAtCursor.add(expectedElement);
			}
		}
		return expectedAtCursor.toArray(new de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[expectedAtCursor.size()]);
	}
	
	private int getEnd(de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal[] allExpectedElements, int indexInList) {
		de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal elementAtIndex = allExpectedElements[indexInList];
		int startIncludingHidden = elementAtIndex.getStartIncludingHiddenTokens();
		int startExcludingHidden = elementAtIndex.getStartExcludingHiddenTokens();
		for (int i = indexInList + 1; i < allExpectedElements.length; i++) {
			de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.mopp.Owl2fsExpectedTerminal elementAtI = allExpectedElements[i];
			int startIncludingHiddenForI = elementAtI.getStartIncludingHiddenTokens();
			int startExcludingHiddenForI = elementAtI.getStartExcludingHiddenTokens();
			if (startIncludingHidden != startIncludingHiddenForI || startExcludingHidden != startExcludingHiddenForI) {
				return startIncludingHiddenForI - 1;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private boolean matches(java.lang.String proposal, java.lang.String prefix) {
		return (proposal.startsWith(prefix) || de.uniko.isweb.emftext.owl2fs.owl2fs.resource.owl2fs.util.Owl2fsStringUtil.matchCamelCase(prefix, proposal) != null) && !proposal.equals(prefix);
	}
	
}
