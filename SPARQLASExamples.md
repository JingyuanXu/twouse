# Examples #

```
Namespace ( = <http://www.co-ode.org/ontologies/pizza/pizza.owl#> ) 

Query ( EquivalentTo ( ?x Some ( hasTopping Some (hasSpiciness Hot) ) ) ) 
```

```
Namespace ( = <http://www.co-ode.org/ontologies/pizza/pizza.owl#> ) 

Query ( EquivalentTo ( ?x Some ( hasTopping SpicyTopping ) ) ) 
```

```
Namespace (p= <http://www.example.org/customer>)
Query ( EquivalentTo (?x Has( ?y p:USA) )) 
```

```
Namespace(=<http://www.co-ode.org/ontologies/pizza/pizza.owl#>)
Query (
	SubClassOf(?s Some(hasTopping Hot))
) 
```

```
Namespace(p=<http://www.co-ode.org/ontologies/pizza/pizza.owl#>)
Query (
	SubClassOf(?s Min(3 p:hasTopping p:Thing))
) 
```

```
Namespace (p = <http://www.co-ode.org/ontologies/pizza/pizza.owl#> ) 

Query ( SubClassOf ( ?x Some ( p:hasTopping Some ( p:hasSpiciness p:Hot ) ) ) ) 
```

```
Namespace(=<http://www.co-ode.org/ontologies/pizza/pizza.owl#>)
Query (
	SubClassOf(?s And(Hot Mild Medium))
) 
```

```
Namespace(=<http://www.co-ode.org/ontologies/pizza/pizza.owl#>)
Query (
	SubClassOf(?s Or(Hot Mild Medium))
) 
```

```
Namespace(=<http://www.co-ode.org/ontologies/pizza/pizza.owl#>)
Query (
	SubClassOf(?s And(Pizza Min(3 hasTopping PizzaTopping)))
) 
```

```
Namespace(=<http://www.co-ode.org/ontologies/pizza/pizza.owl#>)
Query (
	SubClassOf(?s And(Pizza Min(3 hasTopping)))
) 
```

```
Namespace(=<http://www.co-ode.org/ontologies/pizza/pizza.owl#>)
Query (
	SubClassOf(?s And(Pizza Not(VegetarianPizza)))
) 
```

```
Namespace ( = <http://www.example.org/customer#> ) 
Query ( Type ( ?self ?c ) 
SubClassOf ( ?c Customer ) ) 
```