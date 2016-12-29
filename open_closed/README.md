# Open/Closed Principle

- *Choose one of the three provided problems (OCP Violations).*
- *Answer following question:*
  - *How does the code violate the OCP?*
  - *What would you have to do in order to implement the new requirement stated above the problem?*
- *Draw a class diagram of the current implementation.*
- *Draw a class diagram of the solution using an established design pattern.*
- *Name the chosen design pattern.*
- *Solve the chosen problem using TDD and Bypass Surgery Refactoring.*

## OCP Violations

### a) Promotions

*The `Customer` in a pub supports being charged half the price during Happy Hour.
According to a new requirement the `Customer` should also support an `Order Three, Get One Free` promotion.*

Package: `com.galvanize.ocp.pub`

### b) Shapes

*The `Printer` supports drawing circles and rectangles. According to a new requirement the `Printer` should also support drawing squares.*

Package: `com.galvanize.ocp.shapes`

### c) Bubble Sort

*The current implementation of `BubbleSort` supports ordering students ascending and descending by score. According to a new requirement `BubbleSort` should also support ordering students ascending and descending by last name. Ordering by other (not yet existing) student properties in the future is likely.*

Package: `com.galvanize.ocp.sort`
