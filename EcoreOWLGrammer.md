# Introduction #

This page shows the complete grammar for EcoreOWL.


# Grammer #

**package** := "package" name "{" classifiers "}";


<br />

**classifiers** := (classifier);

**classifier** := class | datatype | enumeration;

**class** := ["abstract"] "class" name `[`supertypes`]` `[`classaxioms`]` "{"features"}";


<br />

**supertypes** := "extends" typelist;

**typelist** := {typeref", "} typeref;


<br />

**features** := {feature};

**feature** := attribute | reference;


<br />

**attribute** := `[`frontDataPropertyAxioms`]` "attribute" name multiplicity ":" typeref `[`endDataPropertyAxioms`]` ";";

**reference** := `[`frontObjectPropertyAxioms`]` "reference" name multiplicity
iscontainer ":" typeref "oppositeOf" name `[`endObjectPropertyAxioms`]` ";";

**multiplicity** := bounds ("ordered");

**bounds** := "[" integer "-" integer "]" | "[" integer "- `*` ]" | "`[` `*` `]`";

**iscontainer** := ("container");


<br />

**datatype** := "datatype" name ;

**enumeration** := "enumeration" name "{" literals "}";


<br />

**literals** := literal { ";" literal };

**literal** := "literal" name ;

**typeref** := name;


<br />

# KM3 Grammar Extension



<br />

**classaxioms** :=  classAxiom {"," classAxiom} ;

**classAxiom** := ("equivalentTo" CE | "disjointWith" CE | "subClassOf" CE | "disjointUnionOf" CE CE {CE} ) ;

**CE** := ( name | "not" CE | "(" CE "and" CE { "and" CE } ")" | "(" CE "or" CE {"or" CE} ")" | "(" OPE ("some" | "only") CE ")" | "(" OPE "Self" ")" | "(" OPE ("min" | "max" | "exactly") integer CE ")" | DPE ("some" | "only") dataRange |  DPE ("min" | "max" | "exactly") integer dataRange ) ;


<br />

**frontObjectPropertyAxioms** :=  frontObjectPropertyAxiom {","
frontObjectPropertyAxiom} ;

**endObjectPropertyAxioms** :=  endObjectPropertyAxiom {","
endObjectPropertyAxiom} ;

**frontObjectPropertyAxiom** := ("functional" | "inversefunctional" | "symmetric" | "asymmetric" | "reflexive" | "irreflexive" | "transitive" ) ;

**endObjectPropertyAxiom** := ( "equivalentTo" OPE | "subPropertyOf" OPE |
"domain" CE | "range" CE | "disjointWith" OPE | "inverseOf" name |
"subPropertyChain" OPE "o" OPE {"o" OPE} ) ;

**OPE** := name | "inv(" name ")" ;


<br />

**frontDataPropertyAxioms** :=  frontDataPropertyAxiom {","
frontDataPropertyAxiom} ;

**endDataPropertyAxioms** :=  endDataPropertyAxiom {"," endDataPropertyAxiom} ;

**frontDataPropertyAxiom** := "functional" ;

**endDataPropertyAxiom** := ( "equivalentTo" DPE | "subPropertyOf" DPE | "domain" CE | "range" dataRange | "disjointWith" DPE );

**DPE** := name ;


<br />

**dataRange** := (dataConjunction "or" dataConjunction { "or" dataConjunction }) | dataConjunction;

**dataConjunction** := (dataPrimary "and" dataPrimary { "and" dataPrimary }) | dataPrimary ;

**dataPrimary** := `["not"`] dataAtomic;

**dataAtomic** := Datatype | "{" literalList "}" | "(" dataRange ")";

**Datatype** := name;

**literalList** := name { ";" name };


<br />


**digit** := "0".."9";

**integer** := digit {digit};

**name** := ( letter | "_" ) { letter | digit | "_" } ;

**letter** = "a".."z" | "A".."Z" ;