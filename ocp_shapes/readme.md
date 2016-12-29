# Open/Closed Principle

- *Answer following question:*
  - *How does the code violate the OCP?*
  - *What would you have to do in order to implement the new requirement stated above the problem?*
- *Draw a class diagram of the current implementation.*
- *Draw a class diagram of the solution using an established design pattern.*

## OCP Violations

* The `AreaCalculator` supports circles and rectangles. According to a new requirement the `AreaCalculator` should also support `EquilateralTriangle`s.

## TODO

Refactor the code to be compliant with the OCP principle and get the tests to pass (avoiding an upcast).