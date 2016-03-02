# OWL to yUML Syntax Reference #


## Class Expressions ##

### Declarations ###

`Declaration(Class(Person))`

<img src='http://yuml.me/diagram/class/[● Person {bg:goldenrod}].png'></img>


`Declaration(NamedIndividual(Peter))`

<img src='http://yuml.me/diagram/class/[♦ Peter {bg:darkorchid}].png'></img>


`Declaration(ObjectProperty(hasFather))`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-hasFather>[(⊤) owl:Thing {bg:goldenrod}].png'></img>



### Propositional Connectives and Enumeration of Individuals ###

`ObjectIntersectionOf(Dog CanTalk)`

<img src='http://yuml.me/diagram/class/[(∩) Dog and CanTalk {bg:goldenrod}].png'></img>


`ObjectUnionOf(Man Woman)`

<img src='http://yuml.me/diagram/class/[(∪) Man or Woman {bg:goldenrod}].png'></img>


`ObjectComplementOf(Man)`

<img src='http://yuml.me/diagram/class/[(￢) not Man {bg:goldenrod}].png'></img>


`EquivalentClasses(GriffinFamilyMember ObjectOneOf(Peter Lois Stewie Meg Chris Brian))`

<img src='http://yuml.me/diagram/plain;dir:TB;/class/[(≡) GriffinFamilyMember {bg:goldenrod}]^-^[(≡) ｛♦Peter‚ ♦Lois‚ ♦Stewie‚ ♦Meg‚ ♦Chris‚ ♦Brian｝ {bg:goldenrod}].png'></img>



### Object Property Restrictions ###

`ObjectSomeValuesFrom(hasWheels Wheels)`

<img src='http://yuml.me/diagram/class/[(Ǝ) hasWheels some Wheels {bg:goldenrod}].png'></img>


`ObjectAllValuesFrom(hasWheels Wheels)`

<img src='http://yuml.me/diagram/class/[(∀) hasWheels only Wheels {bg:goldenrod}].png'></img>


`ObjectHasValue(fatherOf Stewie)`

<img src='http://yuml.me/diagram/class/[(∋) fatherOf value Stewie {bg:goldenrod}].png'></img>


`ObjectHasSelf(likes)`

<img src='http://yuml.me/diagram/class/[(Self) likes {bg:goldenrod}].png'></img>



### Object Property Cardinality Restrictions ###

`ObjectMaxCardinality(parent 2)`

<img src='http://yuml.me/diagram/class/[(≤) parent max 2 {bg:goldenrod}].png'></img>


`ObjectMinCardinality(hasFather 2)`

<img src='http://yuml.me/diagram/class/[(≥) hasFather min 1 {bg:goldenrod}].png'></img>


`ObjectExactCardinality(parent 2)`

<img src='http://yuml.me/diagram/class/[(=) parent exact 2 {bg:goldenrod}].png'></img>



### Data Property Restrictions ###

`DataSomeValuesFrom(hasAge xsd:integer)`

<img src='http://yuml.me/diagram/class/[(Ǝ) |hasAge some xsd:integer {bg:goldenrod}].png'></img>


`DataAllValuesFrom(hasZIP xsd:integer)`

<img src='http://yuml.me/diagram/class/[(∀) |hasZIP only xsd:integer {bg:goldenrod}].png'></img>


`DataHasValue(hasAge "17"^^xsd:integer)`

<img src="http://yuml.me/diagram/class/[(∋) |hasAge '17'^^xsd:integer {bg:goldenrod}].png"></img>




### Data Property Cardinality Restrictions ###

`DataMaxCardinality(2 hasName xsd:string)`

<img src='http://yuml.me/diagram/class/[(≤) |hasName max 2 xsd:string {bg:goldenrod}].png'></img>


`DataMinCardinality(2 hasName)`

<img src='http://yuml.me/diagram/class/[(≥) |hasName min 2  {bg:goldenrod}].png'></img>


`ObjectExactCardinality(parent 2)`

<img src='http://yuml.me/diagram/class/[(=) |parent exact 2 {bg:goldenrod}].png'></img>



## Axioms ##


### Class Expression Axioms ###

`SubClassOf(Child Person)`

<img src='http://yuml.me/diagram/class/[● Person {bg:goldenrod}]^-[● Child {bg:goldenrod}].png'></img>


`EquivalentClasses(Boy ObjectIntersectionOf(Child Man))`

<img src='http://yuml.me/diagram/class/[(≡) Boy {bg:goldenrod}]^-^[(≡) Child and Man {bg:goldenrod}].png'></img>


`DisjointClasses(Man Woman)`

<img src='http://yuml.me/diagram/class/[● Man {bg:goldenrod}]-[note: DisjointClasses{bg:cornsilk}], [● Woman {bg:goldenrod}]-[note: DisjointClasses{bg:cornsilk}].png'></img>


`DisjointUnion(Child Boy Girl)`

<img src='http://yuml.me/diagram/class/[(≡) Child {bg:goldenrod}]^«disjointUnion»-[● Boy {bg:goldenrod}], [(≡) Child {bg:goldenrod}]^«disjointUnion»-[● Girl {bg:goldenrod}].png'></img>




### Object Property Axioms ###

`SubObjectPropertyOf(ObjectPropertyChain(hasMother hasSister) hasAunt)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-hasMother>[(⊤) owl:Thing {bg:goldenrod}], [(⊤) owl:Thing {bg:goldenrod}]-hasSister>[(⊤) owl:Thing {bg:goldenrod}], [(⊤) owl:Thing {bg:goldenrod}]-hasAunt\n{hasMother o hasSister}>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`EquivalentObjectProperties(hasBrother hasMaleSibling)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-hasBrother{≡ hasMaleSibling}>[(⊤) owl:Thing {bg:goldenrod}],[(⊤) owl:Thing {bg:goldenrod}]-hasMaleSibling{≡ hasBrother}>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`DisjointObjectProperties(hasFather hasMother)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-hasFather{«disjointOf» hasMother}>[(⊤) owl:Thing {bg:goldenrod}],[(⊤) owl:Thing {bg:goldenrod}]-hasMother{«disjointOf» hasFather}>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`InverseObjectProperties(hasFather fatherOf)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]<fatherOf-hasFather>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`ObjectPropertyDomain(hasDog Person)`

<img src='http://yuml.me/diagram/class/[● Person {bg:goldenrod}]-hasDog>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`ObjectPropertyRange(hasDog Dog)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-hasDog>[● Dog {bg:goldenrod}].png'></img>


`ObjectPropertyDomain(hasDog Person) ObjectPropertyRange(hasDog Dog) ObjectPropertyDomain(hasPet Person) ObjectPropertyRange(hasPet Dog) SubObjectPropertyOf(hasDog hasPet)`

<img src='http://yuml.me/diagram/class/[● Person {bg:goldenrod}]-hasDog\n{SubPropertyOf hasPet}>[● Dog {bg:goldenrod}], [● Dog {bg:goldenrod}]-^[● Pet {bg:goldenrod}], [● Person {bg:goldenrod}]-hasPet>[● Pet {bg:goldenrod}].png'></img>


`FunctionalObjectProperty(hasFather)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-hasFather 1->[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`InverseFunctionalObjectProperty(fatherOf)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]1-fatherOf->[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`ReflexiveObjectProperty(knows)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-«reflexive» knows>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`IrreflexiveObjectProperty(marriedTo)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-«ireflexive» marriedTo>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`SymmetricObjectProperty(friend)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-«symmetric» friend[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`AsymmetricObjectProperty(parentOf)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-«asymmetric» parentOf>[(⊤) owl:Thing {bg:goldenrod}].png'></img>


`TransitiveObjectProperty(ancestorOf)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing {bg:goldenrod}]-«transitive» ancestorOf>[(⊤) owl:Thing {bg:goldenrod}].png'></img>




### Data Property Axioms ###

`SubDataPropertyOf(hasLastName hasName)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing|hasLastName «subPropertyOf» hasName {bg:goldenrod}].png'></img>


`EquivalentDataProperties(hasName seLlama)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing|hasName ≡ seLlama {bg:goldenrod}].png'></img>


`DisjointDataProperties(hasName hasAddress)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing|hasName «disjointOf» hasAddress {bg:goldenrod}].png'></img>


`DataPropertyDomain(hasName Person)`

<img src='http://yuml.me/diagram/class/[● Person|hasName {bg:goldenrod}].png'></img>


`DataPropertyRange(hasName xsd:string)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing|hasName xsd:string {bg:goldenrod}].png'></img>


`FunctionalDataProperty(hasAge)`

<img src='http://yuml.me/diagram/class/[(⊤) owl:Thing|hasAge «functional» {bg:goldenrod}].png'></img>



### Individual Equality ###

` SameIndividual(Meg Megan)`

<img src='http://yuml.me/diagram/class/[♦ Meg {bg:darkorchid}]-[note: SameIndividual{bg:cornsilk}], [♦ Megan {bg:darkorchid}]-[note: SameIndividual{bg:cornsilk}].png'></img>



### Individual Inequality ###

` DifferentIndividuals(Peter Meg Chris Stewie)`

<img src='http://yuml.me/diagram/class/[♦ Peter {bg:darkorchid}]-[note: DifferentIndividuals{bg:cornsilk}], [♦ Meg {bg:darkorchid}]-[note: DifferentIndividuals{bg:cornsilk}], [♦ Chris {bg:darkorchid}]-[note: DifferentIndividuals{bg:cornsilk}].png'></img>



### Class Assertions ###

` ClassAssertion(Dog Brian)`

<img src='http://yuml.me/diagram/class/[♦ Brian: Dog {bg:darkorchid}].png'></img>



### Positive Object Property Assertions ###

` ObjectPropertyAssertion(hasDog Peter Brian)`

<img src='http://yuml.me/diagram/class/[♦ Peter{bg:darkorchid}]-hasDog>[♦ Brian{bg:darkorchid}].png'></img>




### Negative Object Property Assertions ###

` NegativeObjectPropertyAssertion(hasSon Peter Meg)`

<img src='http://yuml.me/diagram/class/[♦ Peter{bg:darkorchid}]-hasSon not>[♦ Meg{bg:darkorchid}].png'></img>



### Positive Object Property Assertions ###

` DataPropertyAssertion(hasAge Meg "17"^^xsd:integer)`

<img src="http://yuml.me/diagram/class/[♦ Meg|hasAge '17'^^xsd:integer{bg:darkorchid}].png"></img>



### Negative Data Property Assertions ###

` NegativeDataPropertyAssertion(hasAge Meg "5"^^xsd:integer)`

<img src="http://yuml.me/diagram/class/[♦ Meg|hasAge not '5'^^xsd:integer{bg:darkorchid}].png"></img>



## Annotations ##