# Introduction #

UML class-based modeling and OWL comprise some constituents that are similar in
many respects like classes, associations, properties, packages, types,
generalization and instances. Despite of the
similarities, both approaches present restrictions that may be overcome by an
integration.

On the one hand, a key limitation of UML class-based modeling is that it allows
only static specification of specialization and generalization of classes and
relationships, whereas OWL provides mechanisms to define these as dynamic. In
other words, OWL allows for recognition of generalization and specialization
between classes as well as class membership of objects based on conditions
imposed on properties of class definitions.

On the other hand, UML provides means to specify dynamic behavior whereas OWL
does not. The Object Constraint Language (OCL) complements UML by allowing the
specification of query operations, derived values, constraints, pre and post
conditions.

Since both approaches provide complementary benefits, contemporary software
development should make use of both. The benefits of an integration are
twofold. Firstly, it provides software developers with more modeling power.
Secondly, it enables semantic software developers to use object-oriented
concepts like inheritance, operation and polymorphism together with ontologies
in a platform independent way. These considerations lead us to the following
challenge: How can we develop and denote models that benefit from advantages of
the two modeling paradigms?

TwoUse (Transforming and Weaving Ontologies and UML in Software Engineering) is
an approach combining UML class-based models with OWL ontologies to leverage
the unique and potentially complementary strengths of the two. TwoUse's
building blocks are: (i) an integration of the MOF-based metamodels for
UML and OWL, (ii) the specification of operation queries referring to
OWL reasoning (using OCL-like expressions), (iii) the definition of a
joint profile for denoting hybrid models as well as other concrete syntaxes.

# Building Blocks #

TwoUse approach is built based on four core ideas:

  * As abstract syntax, it provides an integrated MOF based metamodel as a common backbone for UML (including OCL) and OWL modeling.

  * As concrete syntaxes, it uses pure UML, an UML profile supporting standard UML2 extension mechanisms, a weaving metamodel for integrating existing UML and OWL models, and a textual concrete syntax to write UML-based class and OWL descriptions.

  * It provides a canonical set of transformation rules in order to deal with integration at the semantic level.

  * It provides a novel OCL-like language to write queries and constraints over OWL ontologies, OCL-DL.

# Applications #

TwoUse allows developers to reuse available domain knowledge already encoded in
ontologies independently of platform or programming language. Moreover,
developers may use class descriptions to semantically query the domain.
Semantic query plays an important role in large domains (more than 700
classes).

TwoUse has been applied not only in ontology-based systems but also to
development of non-logical systems as follows:

  * Improving General Purpose Software Design Patterns. We have explored how to improve the Strategy Pattern and Abstract Factory with ontologies and we are able to provide
improvements to the Visitor Pattern and to the Bridge Pattern as well.

  * Metamodeling. We have analyzed the OCL constraints specified in the UML2 Specification and identified 6 out of 90 complex constraints that could benefit from TwoUse. Moreover, where property transitivity is required, e.g., in specifying constructs like Activity, State, StateMachine and Transition, TwoUse allows for defining additional operations that are not expressible in OCL.

  * Automatically generation of ontology APIs. The task of programming ontology APIs is not trivial, since ontologies usually rely on ontology design patterns (e.g. semantic annotation in the running example) that are difficult to map onto Java objects. TwoUse allows for specifying these mappings as well as queries using OCL-DL.

  * Ontology based domain specific languages. Domain specific languages (DSL) may apply dynamic classification to recommend domain concepts to novice DSL users (who may not be aware of suitable domain classes). TwoUse enables DSL users to execute OCL-DL queries that, based on OWL classes, dynamically classify content.

  * Using ontologies with variability management at runtime. In software product line engineering, ontologies can describe variants and variant constraints and OCL-DL expressions specify the decision of which variant to employ at runtime. We currently investigate this and other application scenarios under the EU project MOST (http://www.most-project.eu).