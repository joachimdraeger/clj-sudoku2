(ns clj-sudoku2.core)
(require '[clj-sudoku2.sudoku :as sudoku] 
         '[clj-sudoku2.format :as format])

(def start [
        [0 9 7  0 4 0  6 0 8],
        [0 0 0  7 0 0  0 1 0],
        [6 0 0  5 0 0  0 0 0],
        
        [7 3 0  0 1 2  5 0 0],
        [1 0 8  6 0 4  3 0 7],
        [0 0 6  3 7 0  0 8 1],
        
        [0 0 0  0 0 5  0 0 2],
        [0 6 0  0 0 7  0 0 0],
        [3 0 5  0 8 0  9 7 0]])


(defn solve-start []
  (format/print-grid (sudoku/solve start)))

