# clj-sudoku2

A brute-force Sudoku solver written in Clojure.

## Package

### Core

Contains:
* a sample start configuration of a 9x9 grid 
* a function to solve and print the solution

### Sudoku

* Contains a recursive, brute force solving algorithm.

### Validate

* Contains function to partially validate a Sudoku grid at the given coordinate.
* Only the column/row/box where the new value has been inserted gets checked.

### Util

* Util functions to deal with the grid and to check for duplicates.
 
### Format

* Formats a Sudoku field.

## License

Public Domain
