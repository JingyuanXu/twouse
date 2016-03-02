# OWLizer: a generic transformation to OWL for ecore-based software languages #

Software development consists of multiple phases, from inception to production. During each software development phase, developers and other actors generate many artifacts, eg. documents, models, diagrams, code, tests and bug reports. Although some of these artifacts are integrated, they are usually handled as islands inside the software development process.


Many of these artifacts (graphical or textual) are written using a structured language, which has a defined grammar. In a model-driven environment, concepts of software languages are represented by metamodels, whereas the artifacts written in those software languages are represented by models, which are described by the language metamodel. Thus, by transforming software metamodels and models into OWL and by aligning the OWL ontologies corresponding to software languages, we are able to link multiple data sources of a software development process, creating a linked-data repository for software development.

![http://2.bp.blogspot.com/_8UbSC4I4jL8/S6_0tyNF2qI/AAAAAAAABGc/-AOc3Frz0rU/s1600/owlizer-example.png](http://2.bp.blogspot.com/_8UbSC4I4jL8/S6_0tyNF2qI/AAAAAAAABGc/-AOc3Frz0rU/s1600/owlizer-example.png)

Let us consider an example of integrating two data sources: UML diagrams and Java Code. Regardless of generating Java code from UML diagrams, developers would like to have a consistent view of corresponding classes and methods in UML and Java, i.e., developers might want to consult UML diagrams looking for a corresponding Java class. In this scenario, OWL and ontology technologies play an important role.


Fig. 1 depicts the usage of M3 transformations together with ontology technologies [1](1.md). UML metamodel and model as well as Java grammar (metamodel) and java code (model) are transformed into OWL ontologies. Ontology alignment techniques [.md](.md) might identify some concepts in common between the two ontologies (UML and Java), e.g., package, class, method. Moreover, individuals with the same name in these two ontologies are likely the same.


Once the two ontologies are aligned, queries against the Java ontology also retrieve elements defined in UML diagrams. Now it is possible to retrieve sequence diagrams including a given Java class, since the two artifacts (UML diagrams and Java code) are now linked. This is only one example of the great potential provided by linking software engineering artifacts using OWL technologies.


[1](1.md) Gröner, G., Silva Parreiras, F., Staab, S., Walter, T.: Software Modeling Using Ontology Technologies. In: Rudi Studer - A Review on Semantic Web Research. Springer Verlag (2011)