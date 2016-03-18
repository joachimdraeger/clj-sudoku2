(ns clj-sudoku2.sudoku)
(require '[clj-sudoku2.util :as util]
         '[clj-sudoku2.validate :as validate])

; checks if a given cell contains a fixed value
(defn potential-values [grid x y]
  (let [value (util/cell grid x y)]
    (if (= value 0) 
      ; cell is empty, we can try to insert 1 to 9 
      (range 1 10) 
      ; cell already contains a fixed value
      [value])))

; we are going to call iterate-cells recursivly from iterate-cells-try-values
(declare iterate-cells)

; creates a new grid with all potential values at the given coordinate and recurses into iterate-cells 
(defn iterate-cells-try-values [grid x y]
  (util/try-values #(iterate-cells (util/replace-cell grid x y %) 
                                   x y) 
                   (potential-values grid x y)))

(defn next-x [x]
  (if (< x 8) (+ x 1) 0))

(defn next-y [x y]
  (if (< x 8) y (+ y 1)))

; stop criterion 
(defn last-coordinate? [x y]
  (and (>= x 8) (>= y 8)))

; recursively tries to fill all cells in the grid
(defn iterate-cells [grid x y]
  (if (not (validate/valid-grid? grid x y))
    nil
    (if (last-coordinate? x y)
      grid
      (iterate-cells-try-values grid (next-x x) (next-y x y)))))

(defn solve [grid]
  (iterate-cells-try-values grid 0 0 ))
