# Introduction #

On this page, we provide some links, data and instructions for our submitted
paper **Metamodel Constraint Validation in Software Product Lines**


# OWLizer #

The OWLizer transforms Ecore-based metamodels and their conforming models
into an ontology TBox (Terminological Box) and ABox (Assertional Box).
The metamodels is represented in the TBox, describing classes and relations
between classes. Models are represented in the ABox. The ABox contains
individuals (instances of classes from the TBox) and relations between these
individuals by using the properties which are defined in the TBox.

The transformatoin is based on a mapping from Ecore to OWL.
This (structural) mapping form Ecore-based metamodels and models to OWL
is general. In our approach, we transform the following metamodels and
models to OWL (TBox and ABox):

  * BPMN model with the corresponding metamodel
  * Feature model and metamodel
  * Mapping model and mapping metamodel

Afterwards, we combine these three ontologies to one ontology in order to allow
a joint reasoning and validation.

OWLizer is part of the TwoUse Toolkit:

  * Install the TwoUse Toolkit: http://code.google.com/p/twouse/wiki/InstallationTwoUse
  * Use the OWLizer Plug-In to transform the model and metamodel to OWL

# Feature Mapper #

The Feature Mapper is a tool to combine Software Product Line Engineering and
Model Driven Engineering:
  * http://featuremapper.org/

The Feature Mapper is available as Eclipse Plug-in.


# Evaluation #


## Proof-Of-Concept - Validation Requirements (VR1 - VR3) ##

The solution space model (BPMN Model), the feature model and the mapping model
for the Travel-Agency example are available in the following SVN repository:
http://twouse.googlecode.com/svn/trunk/west.twouse.mcv.models2010
The feature model and the mapping model is created with the Feature Mapper.

The ontology for the Travel-Agency, containing feature, mapping and solution models
is available in the following repository. In this example, the individuals are
renamed with meaningful names like the activity or feature name for an easier
understanding.

  * Travel-Agency Ontology - valid: all activities and features are valid mapped
> > http://twouse.googlecode.com/svn/trunk/west.twouse.mcv.models2010/ontologies/Merged_valid.owl

  * Travel-Agency Ontology - invalid: Invalid-Reference (invalid mapped activity in the solution space): Activity Notification is not mapped. Hence, the mapped activity Insurance is invalid mapped (Invalid-Reference) due to the missing predecessor.
> > http://twouse.googlecode.com/svn/trunk/west.twouse.mcv.models2010/ontologies/Merged_InvalidReference.owl

  * Travel-Agency Ontology - invalid: Invalid-Containment (invalid mapped activity in the solution space) Activity Delivery (subprocess) is not mapped, hence all activities in the subprocess are invalid (Invalid-Containment)
> > http://twouse.googlecode.com/svn/trunk/west.twouse.mcv.models2010/ontologies/Merged_InvalidContainment.owl

  * Travel-Agency Ontology - invalid: Invalid-Feature (invalid mapped feature in the problem space/feature model) The feature Notification is modelled as mandatory but not    mapped. Hence, its mapped parent feature Delivery is invalid mapped (Invalid-Feature)
> > http://twouse.googlecode.com/svn/trunk/west.twouse.mcv.models2010/ontologies/Merged_InvalidFeature.owl


For the model validation, we use the open-source reasoners Pellet and FACT++ that can be
used either via an API or as plug-in for Ontology Editors like Protege.

  * Pellet Reasoner: http://clarkparsia.com/pellet/
  * FACT++ Reasoner: http://owl.man.ac.uk/factplusplus/
  * Protege OWL-Ontology Editor: http://protege.stanford.edu/


## Basic Functional Requirements (BR1 - BR5) Evaluation ##

For the second part of the evaluation (functional requirements), we used a questionnaire
and asked experts about the usability of our approach.
  * The questionnaire can be found here: http://userpages.uni-koblenz.de/~parreiras/research/