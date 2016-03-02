# SPARQL-DL with OWL Functional Syntax #

SPARQLAS is our implementation of the SPARQL-DL abstract syntax for writing OWL queries. With SPARQLAS, users write queries for OWL ontologies faster than using SPARQL, since they do not have to care about mapping OWL to RDF graphs.

# Details #

SPARQLAS queries are automatically translated into SPARQL queries that can be executed using an OWL reasoner and a SPARQL engine with support to OWL entailment regime, like [pellet](http://clarkparsia.com/pellet/).

## Try it! ##

  * Online: [Try it online now](http://twouse.west.uni-koblenz.de/services/sparqlas2sparql.php).

  * TwoUse Toolkit: SPARQLAS is part of the [TwoUse Toolkit installation](InstallationTwoUse.md). [See how to execute SPARQL queries using the twouse toolkit](SPARQLQuery.md).

## Integrate it in your application ##

  * Web Service: Translating SPARQLAS into SPARQL is available as web service under http://twouse.west.uni-koblenz.de:8080/services/sparqlas2sparql?wsdl .

  * Standalone: The standalone bundle for java is available on

## Examples ##

  * [A catalogue with examples of SPARQLAS queries using the pizza ontology](SPARQLASExamples.md).

  * [complete SPARQLAS grammar](SPARQLASGrammar.md).

## Using SPARQLAS in TwoUse Toolkit ##

![http://twouse.googlecode.com/svn/wiki/images/sparqlas.png](http://twouse.googlecode.com/svn/wiki/images/sparqlas.png)

![http://twouse.googlecode.com/svn/wiki/images/sparqlas1.png](http://twouse.googlecode.com/svn/wiki/images/sparqlas1.png)