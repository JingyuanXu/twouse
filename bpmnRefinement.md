# BPMN Process Refinement #

An abstract BPMN process is refined into a more specific process which
is a more fine-grained representation of the process.
There are different kinds of refinement like horizontal or vertical refinements.
A specific process model is a valid refinement of the abstract model
if no refinement condition is violated.

The refinement is validated using ontologies and DL reasoning.
The abstract and specific process is transformed to an OWL DL ontology
which is called the refinement ontology.
Reasoning service indicates whether the specific process
is an valid or invalid refinement of the abstract process.


# Valid Process Refinement #

As a first example, we demonstrate the validation of a valid process refinement.
In the BPMN Model, the refinement relation is represented by the group assignment
of the activities in the spcific process.

## Abstract BPMN Process Model ##

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/abs.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/abs.jpg)

## Specific BPMN Process Model ##

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/spc_c.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/spc_c.jpg)

## Select Abstract and Specific Model ##

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/load_abs.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/load_abs.jpg)

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/load_spec.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/load_spec.jpg)

## Resulting Ontology ##

In the resulting ontology, there are no invalid activities.

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/ont_correct.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/ont_correct.jpg)


# Invalid Process Refinement #

The following process is an invalid refinement of the abstract process.

## Specific Incorrect BPMN Process Model ##

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/spc_inc.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/spc_inc.jpg)

## Resulting Status Message ##

A status message displays which activities are invalid refined, i.e. they
have either a predecessor or a successor activity that is not allowed by the
restrictions given by the abstract process.

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/msg_incorrect.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/msg_incorrect.jpg)

## Resulting Ontology ##

There are activities in the ontology, that are classified as invalid.

![http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/ont_incorrect.jpg](http://twouse.googlecode.com/svn/wiki/images/bpmn2owl/ont_incorrect.jpg)

