# Introduction #

This page shows the complete grammar for SPARQLAS.


# Grammar #

**cardinality** := _a nonempty finite sequence of digits between 0 and 9_

**lexical** := _a nonempty finite sequence of alphanumeric characters enclosed in a pair of ` (U+22) characters_

**variable** := _a nonempty finite sequence of alphanumeric characters starting with either a ? (U+3F) character or a $ (U+24) character_

**nodeID** := _a finite sequence of characters matching the BLANK\_NODE\_LABEL production of [SPARQL](http://www.w3.org/TR/2008/REC-rdf-sparql-query-20080115/)_

**prefix** := _a finite sequence of characters matching the PNAME\_NS production of [SPARQL](http://www.w3.org/TR/2008/REC-rdf-sparql-query-20080115/)_

**fullIRI** := _an IRI as defined in [RFC3987](http://www.ietf.org/rfc/rfc3987.txt), enclosed in a pair of < (U+3C) and > (U+3E) characters_

**abbreviatedIRI** := _a finite sequence of characters matching the PNAME\_LN production of [SPARQL](http://www.w3.org/TR/2008/REC-rdf-sparql-query-20080115/)_


<br />

**IRI** := **fullIRI** | **abbreviatedIRI**


<br />

**OntologyDocument** := `[` **QueryIRI** `]` `{` **Import** `}` `{` **PrefixDefinition** `}` **Query**

**QueryIRI** := 'IRI' '(' **fullIRI** ')'

**Import** := 'Import' '(' **fullIRI** ')'

**PrefixDefinition** := 'Namespace' '(' `[` **prefix** `]` '=' **fullIRI** ')'


<br />

**Query** := **SelectQuery** | **ConstructQuery** | **AskQuery** | **DescribeQuery**


<br />

**SelectQuery** := 'Select' `[` **variable** `{` **variable** `}` | '`*`' `]` 'Where' '(' `{` **Atom** `}` ')'

**ConstructQuery** := 'Construct' '(' `{` **ConstructAtom** `}` ')' 'Where' '(' `{` **WhereAtom** `}` ')'

**AskQuery** := 'Ask' 'Where' '(' `{` **Atom** `}` ')'

**DescribeQuery** := 'Describe' **DescribeIRI** | 'Describe' 'Where' '(' `{` **Atom** `}` ')'

**ConstructAtom** := **Atom**

**WhereAtom** := **Atom**

**DescribeIRI** := **fullIRI**


<br />

**ClassVariable** :=  **variable**

**ObjectPropertyVariable** := **variable**

**DataPropertyVariable** := **variable**

**IndividualVariable** :=  **variable**

**LiteralVariable** := **variable**


<br />

**Class** := **IRI**

**Datatype** := **IRI**

**ObjectProperty** := **IRI**

**DataProperty** := **IRI**

**NamedIndividual** := **IRI**

**ConstrainingFacet** := **IRI**

**AnonymousIndividual** := **nodeID**

**NamedLiteral** := **lexical** '^^' **Datatype**


<br />

**Atom** := **Assertion** | **ClassAtom** | **ObjectPropertyAtom** | **DataPropertyAtom** | **HasKey** | **Declaration**


<br />

**Assertion** := **ClassAssertion** | **DirectType** | **ObjectPropertyAssertion** | **DataPropertyAssertion** | **NegativeObjectPropertyAssertion** | **NegativeDataPropertyAssertion** | **SameIndividual** | **DifferentIndividuals**

<br />

**ClassAssertion** := `(` 'ClassAssertion' | 'Type' `)` '(' **Individual** **ClassExpression** ')'

**DirectType** := 'DirectType' '(' **Individual** **ClassExpression** ')'

**ObjectPropertyAssertion** := `(` 'ObjectPropertyAssertion' | 'PropertyValue' `)` '(' **SourceIndividual** **ObjectPropertyExpression** **TargetIndividual** ')'

**DataPropertyAssertion** :=  `(` 'DataPropertyAssertion' | 'PropertyValue' `)` '(' **SourceIndividual** **DataPropertyExpression** **TargetValue** ')'

**NegativeObjectPropertyAssertion** := `(` 'NegativeObjectPropertyAssertion' | 'NegativePropertyValue' `)` '(' **SourceIndividual** **ObjectPropertyExpression** **TargetIndividual** ')'

**NegativeDataPropertyAssertion** := `(` 'NegativeDataPropertyAssertion' | 'NegativePropertyValue' `)` '(' **SourceIndividual** **DataPropertyExpression** **TargetValue** ')'

**SameIndividual** := `(` 'SameIndividual' | 'SameAs' `)` '(' **Individual** **Individual** `{` **Individual** `}` ')'

**DifferentIndividuals** := `(` 'DifferentIndividuals' | 'DifferentFrom' `)` '(' **Individual** **Individual** `{` **Individual** `}` ')'

**SourceIndividual** := **Individual**

**TargetIndividual** := **Individual**

**Individual** := **NamedIndividual** | **IndividualVariable** | **AnonymousIndividual**

**TargetValue** := **Literal**

**Literal** := **LiteralVariable** | **NamedLiteral**


<br />

**ClassAtom** := **SubClassOf** | **DirectSubClassOf** | **StrictSubClassOf** | **EquivalentClasses** | **DisjointClasses** | **DisjointUnion**

<br />

**SubClassOf** := 'SubClassOf' '(' **SubClassExpression** **SuperClassExpression** ')'

**DirectSubClassOf** := 'DirectSubClassOf' '(' **SubClassExpression** **SuperClassExpression** ')'

**StrictSubClassOf** := 'StrictSubClassOf' '(' **SubClassExpression** **SuperClassExpression** ')'

**EquivalentClasses** := `(` 'EquivalentClasses' | 'EquivalentTo' `)` '(' **ClassExpression** **ClassExpression** `{` **ClassExpression** `}` ')'

**DisjointClasses** := `(` 'DisjointClasses' | 'DisjointWith' `)` '(' **ClassExpression** **ClassExpression** `{` **ClassExpression** `}` ')'

**DisjointUnion** := 'DisjointUnion' '(' **DisjointClass** **DisjointClassExpression** **DisjointClassExpression** `{` **DisjointClassExpression** `}` ')'

**SubClassExpression** := **ClassExpression**

**SuperClassExpression** := **ClassExpression**

**DisjointClass** := **ClassVariable** | **Class**

**DisjointClassExpression** := **ClassExpression**


<br />

**ClassExpression** := **ClassVariable** | **Class** | **ObjectUnionOf** | **ObjectComplementOf** | **ObjectOneOf** | **ObjectIntersectionOf** | **ObjectAllValuesFrom** | **ObjectSomeValuesFrom** | **ObjectHasValue** | **ObjectMinCardinality** | **ObjectMaxCardinality** | **ObjectExactCardinality** | **DataAllValuesFrom** | **DataSomeValuesFrom** | **DataHasValue** | **DataMinCardinality** | **DataMaxCardinality** | **DataExactCardinality**

<br />

**ObjectUnionOf** := `(` 'ObjectUnionOf' | 'Or' `)` '(' **ClassExpression** **ClassExpression** `{` **ClassExpression** `}` ')'

**ObjectComplementOf** := `(` 'ObjectComplementOf' | 'Not' `)` '(' **ClassExpression** ')'

**ObjectOneOf** := `(` 'ObjectOneOf' | 'One' `)` '(' **Individual** `{` **Individual** `}` ')'

**ObjectIntersectionOf** := `(` 'ObjectIntersectionOf' | 'And' `)` '(' **ClassExpression** **ClassExpression** `{` **ClassExpression** `}`')'

**ObjectAllValuesFrom** := `(` 'ObjectAllValuesFrom' | 'All' `)` '(' **ObjectPropertyExpression** **ClassExpression** ')'

**ObjectSomeValuesFrom** := `(` 'ObjectSomeValuesFrom' | 'Some' `)` '(' **ObjectPropertyExpression** **ClassExpression** ')'

**ObjectHasValue** := `(` 'ObjectHasValue' | 'Has' `)` '(' **ObjectPropertyExpression** **Individual** ')'

**ObjectMinCardinality** := `(` 'ObjectMinCardinality' | 'Min' `)` '(' **cardinality** **ObjectPropertyExpression** `[` **ClassExpression** `]` ')'

**ObjectMaxCardinality** := `(` 'ObjectMaxCardinality' | 'Max' `)` '(' **cardinality** **ObjectPropertyExpression** `[` **ClassExpression** `]` ')'

**ObjectExactCardinality** := `(` 'ObjectExactCardinality' | 'Exact' `)` '(' **cardinality** **ObjectPropertyExpression** `[` **ClassExpression** `]` ')'

**DataAllValuesFrom** := `(` 'DataAllValuesFrom' | 'All' `)` '(' **DataPropertyExpression** **DataRange** ')'

**DataSomeValuesFrom** := `(` 'DataSomeValuesFrom' | 'Some' `)` '(' **DataPropertyExpression** **DataRange** ')'

**DataHasValue** := `(` 'DataHasValue' | 'Has' `)` '(' **DataPropertyExpression** **Literal** ')'

**DataMinCardinality** := `(` 'DataMinCardinality' | 'Min' `)` '(' **cardinality** **DataPropertyExpression** `[` **DataRange** `]` ')'

**DataMaxCardinality** := `(` 'DataMaxCardinality' | 'Max' `)` '(' **cardinality** **DataPropertyExpression** `[` **DataRange** `]` ')'

**DataExactCardinality** := `(` 'DataExactCardinality' | 'Exact' `)` '(' **cardinality** **DataPropertyExpression** `[` **DataRange** `]` ')'


<br />

**DataRange** := **!Datatype** | **DataUnionOf** | **DataComplementOf** | **DataOneOf** | **DataIntersectionOf** | **DatatypeRestriction**

<br />

**DataUnionOf** := `(` 'DataUnionOf' | 'Or' `)` '(' **DataRange** **DataRange** `{` **DataRange** `}` ')'

**DataComplementOf** := `(` 'DataComplementOf' | 'Not' `)` '(' **DataRange** ')'

**DataOneOf** := `(` 'DataOneOf' | 'One' `)` '(' **Literal** `{` **Literal** `}` ')'

**DataIntersectionOf** := `(` 'DataIntersectionOf' | 'And' `)` '(' **DataRange** **DataRange** `{` **DataRange** `}` ')'

**DatatypeRestriction** := 'DatatypeRestriction' '(' **Datatype** **FacetRestriction** `{` **FacetRestriction** `}` ')'

**FacetRestriction** :=  **ConstrainingFacet** **Literal**


<br />

**ObjectPropertyAtom** := **SubObjectPropertyOf** | **EquivalentObjectProperties** | **DisjointObjectProperties** | **ObjectPropertyDomain** | **ObjectPropertyRange** | **InverseObjectPropertyAtom** | **FunctionalObjectProperty** | **InverseFunctionalObjectProperty** | **ReflexiveObjectProperty** | **IrreflexiveObjectProperty** | **SymmetricObjectProperty** | **AsymmetricObjectProperty** | **TransitiveObjectProperty**

<br />

**SubObjectPropertyOf** := `(` 'SubObjectPropertyOf' | 'SubPropertyOf' `)` '(' **SubObjectPropertyExpression** **SuperObjectPropertyExpression** ')'

**EquivalentObjectProperties** := `(` 'EquivalentObjectProperties' | 'EquivalentProperty' `)` '(' **ObjectPropertyExpression** **ObjectPropertyExpression** `{` **ObjectPropertyExpression** `}` ')'

**DisjointObjectProperties** := `(` 'DisjointObjectProperties' | 'DisjointProperty' `)` '(' **ObjectPropertyExpression** **ObjectPropertyExpression** `{` **ObjectPropertyExpression** `}` ')'

**ObjectPropertyDomain** := `(` 'ObjectPropertyDomain' | 'Domain' `)` '(' **ObjectPropertyExpression** **ClassExpression** ')'

**ObjectPropertyRange** := `(` 'ObjectPropertyRange' | 'Range' `)` '(' **ObjectPropertyExpression** **ClassExpression** ')'

**InverseObjectPropertyAtom** := `(` 'InverseObjectProperties' | 'InverseOf' `)` '(' **ObjectPropertyExpression** **ObjectPropertyExpression** ')'

**FunctionalObjectProperty** := 'FunctionalObjectProperty' '(' **ObjectPropertyExpression** ')'

**InverseFunctionalObjectProperty** := `(` 'InverseFunctionalObjectProperty' | 'InverseFunctional' `)` '(' **ObjectPropertyExpression** ')'

**ReflexiveObjectProperty** := `(` 'ReflexiveObjectProperty' | 'Reflexive' `)` '(' **ObjectPropertyExpression** ')'

**IrreflexiveObjectProperty** := `(` 'IrreflexiveObjectProperty' | 'Irreflexive' `)` '(' **ObjectPropertyExpression** ')'

**SymmetricObjectProperty** := `(` 'SymmetricObjectProperty' | 'Symmetric' `)` '(' **ObjectPropertyExpression** ')'

**AsymmetricObjectProperty** := `(` 'AsymmetricObjectProperty' | 'Asymmetric' `)` '(' **ObjectPropertyExpression** ')'

**TransitiveObjectProperty** := `(` 'TransitiveObjectProperty' | 'Transitive' `)` '(' **ObjectPropertyExpression** ')'

**SubObjectPropertyExpression** := **ObjectPropertyExpression** | **ObjectPropertyChain**

**SuperObjectPropertyExpression** := **ObjectPropertyExpression**

**ObjectPropertyChain** := `(` 'ObjectPropertyChain' | 'Chain' `)` '(' **ObjectPropertyExpression** **ObjectPropertyExpression** `{` **ObjectPropertyExpression** `}` ')'


<br />

**ObjectPropertyExpression** := **ObjectPropertyVariable** | **ObjectProperty** | **InverseObjectProperty**

<br />

**InverseObjectProperty** := `(` 'ObjectInverseOf' | 'InverseOf' `)` '(' **ObjectPropertyExpression** ')'


<br />

**DataPropertyAtom** := **SubDataPropertyOf** | **EquivalentDataProperties** | **DisjointDataProperties** | **DataPropertyDomain** | **DataPropertyRange** | **FunctionalDataProperty**

<br />

**SubDataPropertyOf** := `(` 'SubDataPropertyOf' | 'SubPropertyOf' `)` '(' **SubDataPropertyExpression** **SuperDataPropertyExpression** ')'

**EquivalentDataProperties** := `(` 'EquivalentDataProperties' | 'EquivalentProperty' `)` '(' **DataPropertyExpression** **DataPropertyExpression** `{` **DataPropertyExpression** `}` ')'

**DisjointDataProperties** := `(` 'DisjointDataProperties' | 'DisjointProperty' `)` '(' **DataPropertyExpression** **DataPropertyExpression** `{` **DataPropertyExpression** `}` ')'

**DataPropertyDomain** := `(` 'DataPropertyDomain' | 'Domain' `)` '(' **DataPropertyExpression** **ClassExpression** ')'

**DataPropertyRange** := `(` 'DataPropertyRange' | 'Range' `)` '(' **DataPropertyExpression** **DataRange** ')'

**FunctionalDataProperty** := 'FunctionalDataProperty' '(' **DataPropertyExpression** ')'

**SubDataPropertyExpression** := **DataPropertyExpression**

**SuperDataPropertyExpression** := **DataPropertyExpression**


<br />

**DataPropertyExpression** := **DataPropertyVariable** | **DataProperty**


<br />

**HasKey** := 'HasKey' '(' **ClassExpression** '(' `{` **ObjectPropertyExpression** `}` ')' '(' `{` **DataPropertyExpression** `}` ')' ')'


<br />

**Declaration** := **ObjectPropertyDeclaration** | **DataPropertyDeclaration** | **NamedIndividualDeclaration** | **ClassDeclaration**

<br />

**ObjectPropertyDeclaration** := 'ObjectProperty' '(' **ObjectProperty** | **ObjectPropertyVariable** ')'

**DataPropertyDeclaration** := 'DataProperty' '(' **DataProperty** | **DataPropertyVariable** ')'

**NamedIndividualDeclaration** := 'NamedIndividual' '(' **NamedIndividual** | **IndividualVariable** ')'

**ClassDeclaration** := 'Class' '(' **Class** | **ClassVariable** ')'